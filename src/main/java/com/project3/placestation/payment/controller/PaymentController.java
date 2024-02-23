package com.project3.placestation.payment.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project3.placestation.biz.model.dto.ResProductDto;
import com.project3.placestation.payment.handler.exception.CustomPaymentRestfulException;
import com.project3.placestation.payment.model.dto.PaymentMemberDto;
import com.project3.placestation.payment.model.dto.ReqPaymentPageDto;
import com.project3.placestation.product.dto.ProductInvalidDateDto;
import com.project3.placestation.service.AdminProdHistoryService;
import com.project3.placestation.service.MemberService;
import com.project3.placestation.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	AdminProdHistoryService adminProdHistoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	MemberService memberService;
	/**
	 * payment 메인 폼 넘어가기
	 * @param dto
	 * @return
	 */
	@PostMapping("/main")
	public String paymentForm(ReqPaymentPageDto dto , Model model) {
		// 1. 유효성 검사
		if(dto.getProdNo() < 0) {
			throw new CustomPaymentRestfulException("잘못된 요청입니다." , HttpStatus.BAD_REQUEST);
		}
		
		ResProductDto product =  productService.findById(dto.getProdNo());
		if(product == null) {
			throw new CustomPaymentRestfulException("상품 정보가 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(dto.getPeople() < 0 || dto.getPeople() > product.getProdMaximumPeople()) {
			throw new CustomPaymentRestfulException("잘못된 요청입니다." , HttpStatus.BAD_REQUEST);
		}
		if(dto.getStartTime() < product.getProdStartTime() || dto.getEndTime() > product.getProdEndTime()) {
			throw new CustomPaymentRestfulException("잘못된 요청입니다." , HttpStatus.BAD_REQUEST);
		}
		if(dto.getDate() == null || dto.getDate().isEmpty()) {
			throw new CustomPaymentRestfulException("잘못된 요청입니다." , HttpStatus.BAD_REQUEST);
		}
		if(dto.getStartTime() < product.getProdStartTime() || dto.getEndTime() > product.getProdEndTime()) {
			throw new CustomPaymentRestfulException("입력하신 시작시간 또는 종료 시간이 잘못되었습니다.", HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		// date 값과 같은 날짜인 start_time 과 end_time을 받아옵니다.
		List<ProductInvalidDateDto> list = adminProdHistoryService.findProductInvalidByProdNo(dto.getProdNo() , dto.getDate());
		log.info(list.toString());
		
		// 시간 배열으로 변환합니다.
		int[] resArray = adminProdHistoryService.conversionTime(dto.getDate(), list);
		log.info(Arrays.toString(resArray));
		
		// 시간이 중복되었는지 확인
		if(Arrays.asList(resArray).contains(dto.getStartTime()) || Arrays.asList(resArray).contains(dto.getEndTime())) {
			throw new CustomPaymentRestfulException("시작시간 또는 종료 시간이 중복되었습니다.", HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		// 수정 부분
		int userNo = 1;
		PaymentMemberDto member = memberService.findMemberById(userNo);
		// 검사??
		
		// 2. 데이터 넘겨주기
		model.addAttribute("product" , product);
		model.addAttribute("dto" , dto);
		model.addAttribute("member" , member);
		
		return "payment/paymentMain";
	}
}
