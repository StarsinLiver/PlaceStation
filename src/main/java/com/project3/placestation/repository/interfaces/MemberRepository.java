package com.project3.placestation.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project3.placestation.admin.dto.Criteria;
import com.project3.placestation.member.dto.bizJoinDTO;
import com.project3.placestation.repository.entity.BizJoin;
import com.project3.placestation.repository.entity.Member;

@Mapper
public interface MemberRepository {
	
	
	//회원명단출력 (페이징처리)
	public List<Member> listAll(Criteria cri) throws Exception;
	
	//회원숫자세기 (페이징처리)
	public int countMember() throws Exception;
	
	//회원명단출력 (검색,페이징처리)
	public List<Member> searchMemberlist(Criteria cri) throws Exception;
	
	//회원숫자세기 (검색,페이징처리)
	public int countSearchMemberlist(Criteria cri) throws Exception;
	
	//관리자회원정보수정
	public Integer AdminUpdateMember(Member member);
	
	//판매자와 유저 테이블 join데이터
	public BizJoin SelectJoinBiz(BizJoin biz); 	

	//관리자회원정보삭제처리
	public Integer AdminDeleteMember(Member member);
	
	
}
