package kr.or.ddit.dao.adminmypage;

import java.util.List;

import javax.print.DocFlavor.STRING;

import kr.or.ddit.vo.MemberVO;




public interface ImemberInfodao {
	
	// 회원 id 검색 버튼을 누르면 정보가  나오는거
	public List <MemberVO> getSearchMember(String mem_id);
	
	// 테이블에서 하나 선택 후  회원 수정 버튼 누르면 회원 정보 가져오는거 
	public List <MemberVO>  getMymember();
	
	
	// 회원 수정
	public int  updateMember (MemberVO memVO);
	
	
	// 블랙리스트 추가 
	public int insertBlackListMember(String mem_id);
	
	
	// 블랙리스트 해제
	public int deleteBlackListMember(String mem_id);
	
	
	// 삭제
	public int updateActive(String  mem_id);
	
	
	// 테이블에 정보 쀼려주는거 
	public List <MemberVO> tableview(String mem_id);
	
	
}
