package kr.or.ddit.dao.InformationUse;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AgencyVO;



public interface IAgencyDao {
	
	/**
	 * 모든 법웝?�� 출력?��주는 메서?��
	 * @return �??��?�� 법원 목록 List
	 */
	public List<AgencyVO> getAllCourt();
	
	/**
	 * 법원?�� ?��치한 �??��(?�� �??��광역?��,충청?��?��..)?�� 매개�??���? 받아?�� ?��?��?��?�� 법원?�� 목록?�� 출력?��?�� 메서?��
	 * @param addr 법원?��치한 �??�� 매개�??��
	 * @return �??��?�� 법원 목록 List
	 */
	public List<AgencyVO> getCourtAddr(String addr);
	
	/**
	 * 법원?�� ?��름을 매개�??���? 받아 ?��?�� 법원?�� 목록?�� 출력?��?�� 메서?��
	 * @param name 법원�? 매개�??��
	 * @return �??��?�� 법원?�� 목록 리스?��
	 */
	public List<AgencyVO> getCourtName(String name);
	
	/**
	 * �??��?�� �??���? 법원?�� ?��름이 ???��?�� Map객체�? ?��?��미터�? 받아 ?��?�� 법원List�? 반환?��?�� 메서?�� 
	 * @param searchMap �??��?�� 법언 �??���? 법원?��름이 ???��?�� Map객체
	 * @return �??��?�� 법원?�� 목록?�� List?�� ?��?��?�� 반환?��?��
	 */
	public List<AgencyVO> getCourtSum(Map<String, String> searchMap);
	
	/**
	 * 콤보박스?��?�� ?��?��?�� �??��명을 ?��?��미터�? 받아 ?��?�� 법원?�� List�? 반환?��?�� 메서?��
	 * @param comAddr 콤보박에 ?��?��?�� 법원 �??��
	 * @return �??��?�� 법원?�� 목록?�� List?�� ?��?��?�� 반환?��?��.
	 */
	public List<AgencyVO> getAreaSearch(String comboAddr);
	
	public int insertDataConnect(Map<String,String> info);
	public int deleteDataConnect();
	
	public List<String> getCourtSi(String comboAddr);
	
	public List<AgencyVO> getCourtBoth(Map<String, String> paraMap);

	public List<AgencyVO> getPagingCourtList(Map<String, Integer> paraMap);
	
}
