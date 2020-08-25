package kr.or.ddit.dao.InformationUse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.FAQVO;



public class FAQDaoImpl implements IFAQDao {
	
	private SqlMapClient smc;
	
	private static FAQDaoImpl dao;
	
	//?��?��?��
	private FAQDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static FAQDaoImpl getInstance() {
		if(dao==null) dao = new FAQDaoImpl();
		return dao;
	}
	
	@Override
	public List<FAQVO> getAllFAQList() {
		List<FAQVO> faqList = null;
		try {
			faqList = smc.queryForList("faq.getAllFAQList");
		} catch (SQLException e) {
			faqList = null;
			e.printStackTrace();
		}
		
		return faqList;
	}

	@Override
	public List<FAQVO> getDetailsList(String faqNum) {
		List<FAQVO> faqList = null;
		try {
			faqList = smc.queryForList("faq.getDetailsList",faqNum);
		} catch (SQLException e) {
			faqList = null;
			e.printStackTrace();
		}
		
		return faqList;
	}

	@Override
	public List<FAQVO> getPagingFAQList(Map<String, Integer> paraMap) {
		List<FAQVO> faqList = null;
		try {
			faqList = smc.queryForList("faq.getPagingFAQList", paraMap);
		} catch (SQLException e) {
			faqList = null;
			e.printStackTrace();
		}
		return faqList;
	}

	

	
}
