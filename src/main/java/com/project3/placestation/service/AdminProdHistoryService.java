package com.project3.placestation.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project3.placestation.biz.model.dto.BizHistoryDto;
import com.project3.placestation.biz.model.dto.BizMonthlyFeeDto;
import com.project3.placestation.biz.model.dto.DbToken;
import com.project3.placestation.biz.model.dto.MemberToptenDto;
import com.project3.placestation.biz.model.dto.ResScheduleDto;
import com.project3.placestation.biz.model.dto.ScheduleDto;
import com.project3.placestation.biz.model.dto.StatisticDto;
import com.project3.placestation.biz.model.util.PageReq;
import com.project3.placestation.biz.model.util.PageRes;
import com.project3.placestation.biz.model.util.StatisticKind;
import com.project3.placestation.payment.model.dto.AdminHisPointDto;
import com.project3.placestation.product.dto.ProductInvalidDateDto;
import com.project3.placestation.repository.entity.AdminProdHistory;
import com.project3.placestation.repository.interfaces.AdminProdHistoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminProdHistoryService {

	@Autowired
	AdminProdHistoryRepository adminProdHistoryRepository;

	/**
	 * 사업자의 거래 내역 전체 조회
	 * 
	 * @param bizId
	 * @return BizHistoryDto
	 */
	public PageRes<BizHistoryDto> findByBizId(int bizId, PageReq pageReq , String text) {
		List<BizHistoryDto> list = adminProdHistoryRepository.findAllByBizId(bizId, pageReq , text);
		int totalCount = adminProdHistoryRepository.countFindAllByBizId(bizId , text);

		PageRes<BizHistoryDto> pageRes = new PageRes<>(list, pageReq.getPage(), totalCount, pageReq.getSize());
		return pageRes;
	}

	/**
	 * 스케쥴 관리
	 * 
	 * @param bizId
	 * @return
	 */
	public List<ScheduleDto> findScheduleByBizId(int bizId) {
		List<ResScheduleDto> dtos = adminProdHistoryRepository.findScheduleByBizId(bizId);
		log.info(dtos.toString());

		List<ScheduleDto> scheduleDtos = new ArrayList<>();
		for (ResScheduleDto dto : dtos) {
			scheduleDtos.add(
					new ScheduleDto(dto.getProdTitle(), dto.getStartTime(), dto.getEndTime(), dto.getPurchaseDate(),
					dto.getAdminHisNo() , dto.getAdminHisProdNo() , dto.getAdminHisCreatedAt() , dto.getAdminHisBuyerId() , dto.getCancelYn(),
					dto.getCancelAt() , dto.getCancelAmount()));
		}
		log.info(scheduleDtos.toString());
		return scheduleDtos;
	}

	/**
	 * 사업자 통계 - 매출
	 */
	public List<StatisticDto> findStatisticSales(int bizId, StatisticKind kind) {
		log.info("들어옵니다.");
		System.out.println(bizId);
		System.out.println(kind.toString());
		List<StatisticDto> list = adminProdHistoryRepository.findStatisticSales(bizId, kind.toString());
		return list;
	}

	/**
	 * 사업자 통계 - 판매량
	 */
	public int findStatisticSalesVolumes(int bizId, StatisticKind kind) {
		int result = adminProdHistoryRepository.findStatisticSalesVolumes(bizId, kind.toString());
		return result;
	}

	/**
	 * 상품 유효하지 않은 날짜 확인
	 * 
	 * @param prodNo
	 * @return
	 */
	public List<ProductInvalidDateDto> findProductInvalidByProdNo(int prodNo, String date) {
		List<ProductInvalidDateDto> list = adminProdHistoryRepository.findProductInvalidByProdNo(prodNo, date);
		return list;
	}

	/**
	 * 구매일의 모든 시간 값 배열 반환
	 * 
	 * @param onclickDate
	 * @param list
	 * @return
	 */
	public int[] conversionTime(String onclickDate, List<ProductInvalidDateDto> list) {
		// 구매일과 일치하는 요소만 필터링하여 리스트로 반환
		List<ProductInvalidDateDto> conversionList = list.stream().filter(e -> e.getPurchaseDate().equals(onclickDate))
				.collect(Collectors.toList());

		// 일치 확인 또는 리턴
		if (conversionList.isEmpty()) {
			return null;
		}

		String strTime = "";

		// 시간 뽑아내기
		for (ProductInvalidDateDto dto : conversionList) {
			for (int i = dto.getStartTime(); i <= dto.getEndTime(); i++) {
				strTime += i + ",";
			}
		}

		// 배열로 교체
		String[] strArrayTime = strTime.split(",");

		// String 배열을 int 배열로 변환하여 반환
		int[] timeArray = new int[strArrayTime.length];
		for (int i = 0; i < strArrayTime.length; i++) {
			// strArrayTime 의 주소값을 복사(얇은 복사)
			timeArray[i] = Integer.parseInt(strArrayTime[i]);
		}

		Arrays.sort(timeArray);

		log.info(Arrays.toString(timeArray));
		// 리턴
		return timeArray;
	}

	/**
	 * 현재 예약 시간이 있는지 확인 있으면 true , 없으면 false
	 * 
	 * @param order
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public boolean validTime(int[] order, int startTime, int endTime) {
		// 애초에 아니라면
		if(order == null) {
			return false;
		}
		
		// 있다면 확인
		for(int i : order) {
			if(i == startTime || i == endTime) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 결제 내역 저장하기
	 * @param merchantUid
	 * @param prodNo
	 * @param amount
	 * @param afterAmount
	 * @param usePoint
	 * @param savePoint
	 * @param discount
	 * @param charge
	 * @param prodName
	 * @param sellerId
	 * @param buyerId
	 * @param bank
	 * @param startTime
	 * @param endTime
	 * @param peopleCount
	 * @param purchaseDate
	 * @param token
	 * @return int
	 */
	@Transactional
	public int save(String merchantUid, int prodNo, int amount, int afterAmount, int usePoint, int savePoint, int discount, int charge,
			String prodName, int sellerId, int buyerId, String bank , int startTime, int endTime, int peopleCount,
			String purchaseDate , String token) {
		
		// 계산기 뚜들기자
		
		AdminProdHistory adminProdHistory = AdminProdHistory
				.builder().adminHisNo(merchantUid).adminHisProdNo(prodNo).adminHisPrice(afterAmount)
				.adminHisUsePoint(usePoint).adminHisSavePoint(savePoint).adminHisDiscount(discount)
				.adminHisCharge(charge).adminHisSellerId(sellerId).adminHisConfirm(true).adminHisBuyerId(buyerId)
				.bank(bank).startTime(startTime).endTime(endTime).peopleCount(peopleCount).purchaseDate(purchaseDate)
				.token(token).adminHisProdName(prodName).build();
		
		log.info(adminProdHistory.toString());
		int result = adminProdHistoryRepository.save(adminProdHistory);

		return result;
	}

	/**
	 * 퍼센테이지 계산기
	 * 
	 * @param amount
	 * @return
	 */
	public int calPercentage(int amount, int percent , int floor) {
		return (int) (amount * ((double) percent / 100)) / floor * floor;
	}
	
	/**
	 * 총합 계산기
	 */
	public int calAmount(int prodPrice , int people , int startTime , int endTime) {
		return prodPrice * people * (endTime - startTime);
	}
	
	
	/**
	 * 유저의 지끔까지 적립된 포인트 금액
	 * @param buyrId
	 * @return
	 */
	public AdminHisPointDto findUserPointByBuyerId(int buyrId) {
		return adminProdHistoryRepository.findUserPointByBuyerId(buyrId);
	}
	
	/**
	 * 토큰 정보 가져오기
	 * @param merchantUid
	 * @return
	 */
	public DbToken getToken(String merchantUid) {
		return adminProdHistoryRepository.getToken(merchantUid);
	}
	
	/**
	 * 환불 내역 업데이트
	 * @param merchantUid
	 * @return
	 */
	public int updateCancel(String merchantUid , double cancelAmount) {
		return adminProdHistoryRepository.updateCancel(merchantUid , cancelAmount);
	}
	
	/**
	 *  해당 사업자의 상품을 가장 많이 산 유저 탑 5
	 * @param bizId
	 * @return
	 */
	public List<MemberToptenDto> findMemberTopFive(int bizId) {
		return adminProdHistoryRepository.findMemberTopFive(bizId);
	}
	
	/**
	 *  월 수수료 통계
	 * @param bizId
	 * @return
	 */
	public List<BizMonthlyFeeDto> findMonthlyFee(int bizId) {
		return adminProdHistoryRepository.findMonthlyFee(bizId);
	}
}
