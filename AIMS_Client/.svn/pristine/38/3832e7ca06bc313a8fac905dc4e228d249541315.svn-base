package kr.or.ddit.service.adminmypage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.vo.MemberInfoVO;


public interface ImemberInfoService extends Remote {
	
	// 검색 버튼을 누르면 정보가  나오는거
		public List <MemberInfoVO> getSearchMember(String mem_id) throws RemoteException;
		
		// 회원 수정
		public int  updateMember (MemberInfoVO memVO) throws RemoteException;
		
		// 블랙리스트
		public int insertMember(MemberInfoVO memVO) throws RemoteException;
		
		// 삭제
		public int deleteMember(String memId) throws RemoteException;
		
		// 테이블에 정보 쀼려주는거 
		public List <MemberInfoVO> tableview(String mem_id) throws RemoteException;
		
		// 테이블에서 하나 선택 후  회원 수정 버튼 누르면 회원 정보 가져오는거 
		public List <MemberInfoVO> getMymember() throws RemoteException;
}
