package kr.or.ddit.service.InformationUse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AgencyVO;



public interface IManagerAgencyService extends Remote {
	
	/**
	 * 모든 법웝을 출력해주는 메서드
	 * @return 검색된 법원 목록 List
	 */
	public List<AgencyVO> getAllCourt()throws RemoteException ;
	
	/**
	 * 법원이 위치한 지역(예 부산광역시,충청남도..)을 매개변수로 받아서 해당하는 법원의 목록을 출력하는 메서드
	 * @param addr 법원위치한 지역 매개변수
	 * @return 검색된 법원 목록 List
	 */
	public List<AgencyVO> getCourtAddr(String addr)throws RemoteException ;
	
	/**
	 * 법원의 이름을 매개변수로 받아 해당 법원의 목록을 출력하는 메서드
	 * @param name 법원명 매개변수
	 * @return 검색된 법원의 목록 리스트
	 */
	public List<AgencyVO> getCourtName(String name)throws RemoteException ;
	
	/**
	 * 검색할 지역과 법원의 이름이 저장된 Map객체를 파라미터로 받아 해당 법원List를 반환하는 메서드 
	 * @param searchMap 검색할 법언 지역과 법원이름이 저장된 Map객체
	 * @return 검색된 법원의 목록을 List에 담아서 반환한다
	 */
	public List<AgencyVO> getCourtSum(Map<String, String> searchMap)throws RemoteException ;
	
	/**
	 * AgencyVO에 담긴 자료를 DB에 insert하는 메서드
	 * @param agencyVo DB에 insert할 자료가 저장된 AgencyVO 객체
	 * @return DB작업 성공 : 1, 실패 : 0
	 */
	public int insertCourt(AgencyVO agencyVo)throws RemoteException ;
	
	/**
	 * AgencyVO의 정보를 이용하여 법원 정보를 수정하는 메서드
	 * @param angencyVo 수정할 정보가 저장된 vo객체
	 * @return 작업성공 : 1, 실패 : 0
	 */
	public int updateCourt(AgencyVO agencyVo)throws RemoteException ;
	
	/**
	 * 전체 레코드 수를 반환하는 메서드
	 * @return 전체 레코드 수 
	 */
	public int getAllAgencyCount()throws RemoteException ;
	
	/**
	 * 콤보박스에서 선택한 지역명을 파라미터로 받아 해당 법원의 List를 반환하는 메서드
	 * @param comAddr 콤보박에 선택한 법원 지역
	 * @return 검색된 법원의 목록을 List에 담아서 반환한다.
	 */
	public List<AgencyVO> getAreaSearch(String comboAddr)throws RemoteException;

	public List<String> getCourtSi(String comboAddr) throws RemoteException;
	
	public List<AgencyVO> getCourtBoth(Map<String, String> paraMap) throws RemoteException;

}