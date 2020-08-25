package kr.or.ddit.service.adminmypage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.vo.MemberVO;


public interface ImemberInfoService extends Remote {
	
		// 검색 버튼을 누르면 정보가  나오는거
		public List <MemberVO> getSearchMember(String mem_id) throws RemoteException;
		
		// 회원 수정
		public int  updateMember (MemberVO memVO) throws RemoteException;
		
		// 블랙리스트
		public int insertBlackListMember(String mem_id) throws RemoteException;
		
		// 삭제
		public int updateActive(String  mem_id) throws RemoteException;
		
		// 테이블에 정보 쀼려주는거 
		public List <MemberVO> tableview(String mem_id) throws RemoteException;
		
		// 테이블에서 하나 선택 후  회원 수정 버튼 누르면 회원 정보 가져오는거 
		public List <MemberVO> getMymember() throws RemoteException;

		// 블랙리스트 해제
		public int deleteBlackListMember(String mem_id) throws RemoteException;

		
}
