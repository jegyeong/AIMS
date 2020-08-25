package kr.or.ddit.service.search;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CategoryAVO;
import kr.or.ddit.vo.CategoryBVO;
import kr.or.ddit.vo.CategoryCVO;
import kr.or.ddit.vo.CourtVO;



public interface ISearchService extends Remote{
	/**
	 * 물건 번호를 매개변수로 받아 해당 물건을 반환하는 메서드
	 * @param a_art_no
	 * @return 검색결과를 List에 넣어서 반환한다.
	 */
	public List<A_articleVO> numSearch(String a_art_no)throws RemoteException; // 물건번호 검색
	
	/**
	 * 법원 이름을 매개변수로 받아 해당 물건을 반환하는 메서드
	 * @param cou_name
	 * @return 검색결과를 List에 넣어서 반환한다.
	 */
	public List<A_articleVO> courtSearch(String cou_no)throws RemoteException;
	
	
	/**
	 * Map에 설정된 start날짜 부터 end날짜 까지의 데이터를 가져오는 메서드
	 * @param a_art_day 시작과 끝이 지정된 Map객체
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> dateSearch(Map<String, String> a_art_day)throws RemoteException; // 기간으로 검색
	
	/**
	 * 검색할 컬럼명과 검색할 단어가 저장된 Map을 매개변수로 받아서 해당 데이터를 검색하여 List로 반환하는 메서드
	 * @param cat_a_name 검색할 컬럼명과 검색할 단어가 저장된 Map객체
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> categoryASearch(Map<String, String> cat_a_no)throws RemoteException; // 카테고리 검색
	

	/**
	 * Map에 설정된 최저 가격부터 최대가격까지의 데이터를 가져오는 메서드
	 * @param a_art_price 최저와 최대 가격이 지정된 Map객체
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> priceSearch(Map<String, String> a_art_price)throws RemoteException; // 감정평가액으로 검색
	
	/**
	 * 최저매각액을 매개변수로 받아 해당 물건을 반환하는 메서드
	 * @param a_art_low
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> lowSearch()throws RemoteException; // 최저 매각액
	
	
	/**
	 * Map에 설정된 최소면적부터 최대면적까지의 데이터를 가져오는 메서드
	 * @param a_art_area 최소와 최대면적이 지정된 Map객체
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> areaSearch(Map<String, String> a_art_area)throws RemoteException; // 면적으로 검색
	
	/**
	 * 유찰 횟수를 매개변수로 받아 해당 물건을 반환하는 메서드
	 * @param a_art_tour
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> tourSearch()throws RemoteException; // 유찰횟수 검색
	/**
	 * 관심도를 매개변수로 받아 해당 물건을 반환하는 메서드
	 * @param a_art_inter
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> interSearch()throws RemoteException; // 다수관심도 검색
	/**
	 * 조회수를 매개변수로 받아 해당 물건을 반환하는 메서드
	 * @param a_art_cnt
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> cntSearch()throws RemoteException; // 조회수 검색
	
	/**
	 * 경매 결과를 매개변수로 받아 해당 물건을 반환하는 메서드
	 * @param a_art_result
	 * @return
	 */
	public List<A_articleVO> resultSearch(String a_art_result)throws RemoteException; // 경매결과 검색
	
	/**
	 * 전체 물건의 정보를 DB에서 가져와 각각의 정보는 A_articleVO에 담고 이 VO객체를 List에 넣어서 반환하는 메서드
	 * @return 전체 물건의 정보(A_articleVO객체)가 저장된 List객체 
	 */
	public List<A_articleVO> getAllShow()throws RemoteException;
	
	/**
	 * 전체 카테고리 정보를  DB에서 가져와 각각의 정보는 CategoryAVO에 담고, 이 CategoryAVO객체를 list에 넣어서 반환하는 메서드
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<CategoryAVO> getAllACategory()throws RemoteException;
	
	/**
	 * 전체 카테고리 정보를  DB에서 가져와 각각의 정보는 CategoryBVO에 담고, 이 CategoryBVO객체를 list에 넣어서 반환하는 메서드
	 * @param Cat_a_no
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<CategoryBVO> getAllBCategory(String cat_a_no)throws RemoteException;
	
	/**
	 * 전체 카테고리 정보를  DB에서 가져와 각각의 정보는 CategoryCVO에 담고, 이 CategoryCVO객체를 list에 넣어서 반환하는 메서드
	 * @param Cat_b_no
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<CategoryCVO> getAllCCategory(String cat_b_no)throws RemoteException;
	
	/**
	 * 전체 법원 정보를 DB에서 가져와 각각의 정보는 CourtVO에 담고, 이 CourtVO객체를 list에 넣어서 반환하는 메서드
	 * @return 전체 법원의 정보가 저장된 list객체
	 */
	public List<CourtVO> getAllCourt(String courtAdd)throws RemoteException;
	
	public A_articleVO getInfo(String no)throws RemoteException;
	
	
	/**
	 * 하나의 물건번호를 이용하여 조회수를 update하는 메서드
	 * @param a_art_no 
	 * @return DB작업 성공 : 1, 실패 : 0 반환
	 */
	public int updateCnt(String a_art_no)throws RemoteException;
	
	public int insertInter(Map<String,String> map) throws RemoteException ;
	
	public List<A_articleVO> totalSearch(Map<String, String> search) throws RemoteException;
	
	public List<String> courtAdd() throws RemoteException;
	
	
	

	
}
