package kr.or.ddit.dao.InformationUse;

import java.util.List;

import kr.or.ddit.vo.FAQVO;



public interface IManagerFAQDao {
	
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
	
	/**
	 * faqVo?�� ?��겨진 ?��료�?? DB?�� insert?��?�� 메서?��
	 * @param faqVo DB?�� insert?�� ?��료�? ???��?�� FAQVO 객체
	 * @return DB?��?�� ?���? : 1, ?��?�� : 0
	 */ 
	public int insertFAQ(FAQVO faqVo);
	
	/**
	 * faqVo?�� ?��겨진 ?��료�?? ?��?��?��?�� DB?�� FAQ?�� ?��보�??  update?��?�� 메서?��
	 * @param faqVo ?��?��?�� ?��보�? ???��?�� vo객체
	 * @return ?��?��?���? : 1, ?��?�� : 0
	 */
	public int updateFAQ(FAQVO faqVo);
	
	public int deleteFAQ(String faqNo);

}
