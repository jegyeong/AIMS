package kr.or.ddit.dao.InformationUse;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FAQVO;



public interface IFAQDao {
	
	/**
	 * 모든 FAQ�? �??��?��?�� 반환?��?�� 메서?��
	 * @return �??��?�� FAQ리스?��!
	 */
	public List<FAQVO> getAllFAQList();
	
	/**
	 * FAQ_Num?�� 매개�??���? 받아 ?��?��?��?�� FAQ�? 반환?��?�� 메서?��
	 * @param faqNum �??��번호
	 * @return �??��?�� FAQ리스?��
	 */
	public List<FAQVO> getDetailsList(String faqNum);
	
	
	public List<FAQVO> getPagingFAQList(Map<String, Integer> paraMap);
}
