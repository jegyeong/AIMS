package kr.or.ddit.dao.stuff;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CategoryAVO;
import kr.or.ddit.vo.CategoryBVO;
import kr.or.ddit.vo.CategoryCVO;
import kr.or.ddit.vo.CourtVO;
import kr.or.ddit.vo.ImageVO;




public interface IAdminDao {
	/**
	 * A_articleVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param articleVo DB에 insert할 자료가 저장된 A_articleVO객체
	 * @return DB작업 성공 : 1, 실패 : 0 반환
	 */
	public int insertStuff(A_articleVO articleVo);
	
	/**
	 * 물건 번호를 매개변수로 받아서 해당 물건 정보를 삭제하는 메서드
	 * @param a_art_no 삭제 할 물건 번호
	 * @return DB작업 성공 : 1, 실패 : 0 반환
	 */
	public int deleteStuff(String a_art_no);
	
	/**
	 * 하나의 A_articleVO자료를 이용하여 물건 정보를 update하는 메서드
	 * @param articleVo 수정 할 정보가 저장된 A_articleVO객체
	 * @return DB작업 성공 : 1, 실패 : 0 반환
	 */
	public int updateStuff(A_articleVO articleVo);
	
	/**
	 * 검색할 컬럼명과 검색할 물건 번호가 저장된 Map을 매개변수로 받아서 해당 데이터를 검색해 List로 반환하는 메서드
	 * @param searchMap 검색할 컬럼명과 검색할 단어가 저장된 Map객체
	 * @return 검색 결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> NumSearch(String a_art_no);
	
	/**
	 * 전체 물건 정보를 DB에서 가져와 각각의 정보는 A_articleVO에 담고, 이 A_articleVO객체를 List에 넣어서 반환하는 메서드
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<A_articleVO> getAllStuff();
	
	/**
	 * 전체 카테고리 정보를  DB에서 가져와 각각의 정보는 CategoryAVO에 담고, 이 CategoryAVO객체를 list에 넣어서 반환하는 메서드
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<CategoryAVO> getAllACategory();
	
	/**
	 * 전체 카테고리 정보를  DB에서 가져와 각각의 정보는 CategoryBVO에 담고, 이 CategoryBVO객체를 list에 넣어서 반환하는 메서드
	 * @param Cat_a_no
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<CategoryBVO> getAllBCategory(String cat_a_no);
	
	/**
	 * 전체 카테고리 정보를  DB에서 가져와 각각의 정보는 CategoryCVO에 담고, 이 CategoryCVO객체를 list에 넣어서 반환하는 메서드
	 * @param Cat_b_no
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<CategoryCVO> getAllCCategory(String cat_b_no);
	
	/**
	 * 전체 법원 정보를 DB에서 가져와 각각의 정보는 CourtVO에 담고, 이 CourtVO객체를 list에 넣어서 반환하는 메서드
	 * @return 검색결과를 List에 담아서 반환한다.
	 */
	public List<CourtVO> getAllCourt(String add);
	
	public List<String> courtAdd() throws RemoteException;
	
	public int insertImageFile(ImageVO imageVO);
	public int insertImageFile1(ImageVO imageVO);
	
	public List<ImageVO> getArticleImageList (String a_art_no);
	public int deleteImg_File(Map<String,String> map);
	
	public String getcourtAdd(String add);
	
}