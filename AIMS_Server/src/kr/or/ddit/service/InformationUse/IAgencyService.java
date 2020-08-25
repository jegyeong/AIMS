package kr.or.ddit.service.InformationUse;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AgencyVO;



public interface IAgencyService extends Remote {
	
	/**
	 * 모든 법웝을 출력해주는 메서드
	 * @return 검색된 법원 목록 List
	 */
	public List<AgencyVO> getAllCourt()throws RemoteException;
	
	/**
	 * 법원이 위치한 지역(예 부산광역시,충청남도..)을 매개변수로 받아서 해당하는 법원의 목록을 출력하는 메서드
	 * @param addr 법원위치한 지역 매개변수
	 * @return 검색된 법원 목록 List
	 */
	public List<AgencyVO> getCourtAddr(String addr)throws RemoteException;
	
	/**
	 * 법원의 이름을 매개변수로 받아 해당 법원의 목록을 출력하는 메서드
	 * @param name 법원명 매개변수
	 * @return 검색된 법원의 목록 리스트
	 */
	public List<AgencyVO> getCourtName(String name)throws RemoteException;
	
	/**
	 * 검색할 지역과 법원의 이름이 저장된 Map객체를 파라미터로 받아 해당 법원List를 반환하는 메서드 
	 * @param searchMap 검색할 법언 지역과 법원이름이 저장된 Map객체
	 * @return 검색된 법원의 목록을 List에 담아서 반환한다
	 */
	public List<AgencyVO> getCourtSum(Map<String, String> searchMap)throws RemoteException;
	
	/**
	 * 콤보박스에서 선택한 지역명을 파라미터로 받아 해당 법원의 List를 반환하는 메서드
	 * @param comAddr 콤보박에 선택한 법원 지역
	 * @return 검색된 법원의 목록을 List에 담아서 반환한다.
	 */
	public List<AgencyVO> getAreaSearch(String comboAddr)throws RemoteException;
	
	public int insertDataConnect(Map<String,String> info)throws RemoteException;
	public int deleteDataConnect()throws RemoteException;
	public List<String> getCourtSi(String comboAddr)throws RemoteException;
	public List<AgencyVO> getCourtBoth(Map<String, String> paraMap)throws RemoteException;

	public List<AgencyVO> getPagingCourtList(Map<String, Integer> paraMap) throws RemoteException;
}
