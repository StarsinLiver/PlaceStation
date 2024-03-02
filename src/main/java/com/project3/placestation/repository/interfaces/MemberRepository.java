package com.project3.placestation.repository.interfaces;

import java.util.List;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project3.placestation.admin.dto.Criteria;
import com.project3.placestation.biz.model.dto.ReqBizAccountDto;
import com.project3.placestation.biz.model.dto.ResPassword;

import com.project3.placestation.payment.model.dto.PaymentMemberDto;
import com.project3.placestation.member.dto.bizJoinDTO;
import com.project3.placestation.member.dto.memberDTO;
import com.project3.placestation.repository.entity.BizJoin;
import com.project3.placestation.repository.entity.Member;

@Mapper
public interface MemberRepository {

	// 회원명단출력 (페이징처리)
	public List<Member> listAll(Criteria cri) throws Exception;

	// 회원숫자세기 (페이징처리)
	public int countMember() throws Exception;
	
	//회원명단출력 (검색,페이징처리)
	public List<Member> searchMemberlist(Criteria cri) throws Exception;
	
	//회원숫자세기 (검색,페이징처리)
	public int countSearchMemberlist(Criteria cri) throws Exception;
	
	//관리자회원정보수정
	public Integer AdminUpdateMember(Member member);
	
	//관리자회원사진수정
	public Integer AdminPhotoUpdate(Member member);
	
	

	//판매자와 유저 테이블 join데이터
	public BizJoin SelectJoinBiz(BizJoin biz); 	

	//관리자회원정보삭제처리
	//public Integer AdminDeleteMember(Member member);
	
	

	//관리자회원정보삭제처리
	public Integer AdminDeleteMember(Member member);

	// 판매자와 유저 테이블 join데이터
	public BizJoin SelectJoinBiz(int bizId);

	// 사업자 유저 정보 변경
	public int BizUpdateMember(@Param("accountDto") ReqBizAccountDto accountDto, @Param("userNo") int userNo);

	// 유저의 패스워드 가져오기
	public ResPassword findPasswordById(int userNo);
	
	
	//관리자 유저ID 중복체크
	public Integer AdminCheckID(String userid);
	
	


	// payment 유저 정보
	public  PaymentMemberDto findMemberById(int userNo);
	
	// 유저 포인트 업데이트
	public  int updateMemberPoint(@Param("userPoint") int userPoint ,@Param("grade") String grade , @Param("buyerId") int buyerId);

	//회원 단건 정보 검색(로그인 처리)
	public memberDTO selectUser(String userId);

	//일반 회원 가입(회원 가입 처리)
	public int insertUser(Member member);
	
	//회원 단건 정보 검색(로그인 처리)
	public memberDTO selecByUserId(String username);
	
	//회원 단건 정보 검색
	public Member selectByIsUserId(String uid);

	public Member selecyByUserEmail(String email);
	
	
}
