package kr.or.ddit.dao.adminmypage;

import java.util.List;

import kr.or.ddit.vo.MemberInfoVO;


public interface ImemberInfodao {
	
	// 회원 id 검색 버튼을 누르면 정보가  나오는거
	public List <MemberInfoVO> getSearchMember(String mem_id);
	
	// 테이블에서 하나 선택 후  회원 수정 버튼 누르면 회원 정보 가져오는거 
	public List <MemberInfoVO>  getMymember();
	
	
	// 회원 수정
	public int  updateMember (MemberInfoVO memVO);
	
	// 블랙리스트
	public int insertMember(MemberInfoVO memVO);
	
	// 삭제
	public int deleteMember(String memId);
	
	// 테이블에 정보 쀼려주는거 
	public List <MemberInfoVO> tableview(String mem_id);
	
	
	
}
