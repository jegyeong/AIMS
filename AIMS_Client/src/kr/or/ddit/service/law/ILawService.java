package kr.or.ddit.service.law;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.Law_CategoryVO;
import kr.or.ddit.vo.Related_LawVO;

public interface ILawService  extends Remote{
	/**
	 * 전체 법률의 카테고리 정보를 DB에서 가져와 각각의 정보는 Law_CategoryVO에 담고, 이 Law_CategoryVO객체를 list에 넣어서 반환하는 메서드
	 * @return 검색결과를 list에 담아서 반환한다.
	 */
	public List<Law_CategoryVO> getAllLawCategory() throws RemoteException;

	/**
	 * 전체 법률 정보를 DB에서 가져와 각각의 정보는 Related_LawVO에 담고, 이 Related_LawVO객체를 list에 넣어서 반환하는메서드
	 * @param cat_law_no
	 * @return 검색결과를 list에 담아서 반환한다.
	 */
	public List<Related_LawVO> getAllRelated_Law(String cat_law_no) throws RemoteException;
	
	public List<Related_LawVO> getAllShowRelated_Law(Map<String, String> no) throws RemoteException;
	
//------------------------------------------------------------------------------------------------------------
	// 관리자 
	
	/**
	 * Related_LawVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param RlawVo DB에 insert할 자료가 저장된 Related_LawVO객체
	 * @return DB작업 성공 : 1, 실패 : 0 반환
	 */
	public int insertLaw(Related_LawVO RlawVo)throws RemoteException;
	
	/**
	 * 하나의 Related_LawVO자료를 이용하여 법률 정보를 update하는 메서드
	 * @param RlawVo 수정할 정보가 저장된 Related_LawVO객체
	 * @return DB작업 성공 : 1, 실패 : 0
	 */
	public int updateLaw(Related_LawVO RlawVo)throws RemoteException;
}
