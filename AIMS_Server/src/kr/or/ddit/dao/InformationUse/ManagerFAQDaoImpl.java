package kr.or.ddit.dao.InformationUse;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.FAQVO;



public class ManagerFAQDaoImpl implements IManagerFAQDao {

private SqlMapClient smc;
	
	private static ManagerFAQDaoImpl dao;
	
	//?��?��?��
	private ManagerFAQDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static ManagerFAQDaoImpl getInstance() {
		if(dao==null) dao = new ManagerFAQDaoImpl();
		return dao;
	}
	//?���??��
	
	
	@Override
	public List<FAQVO> getAllFAQList() {
		List<FAQVO> faqList = null;
		try {
			faqList = smc.queryForList("managerfaq.getAllFAQList");
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
			faqList = smc.queryForList("managerfaq.getDetailsList");
		} catch (SQLException e) {
			faqList = null;
			e.printStackTrace();
		}
		
		return faqList;
	}

	@Override
	public int insertFAQ(FAQVO faqVo) {
		int cnt = 0; 
		try { 
			Object obj = smc.insert("managerfaq.insertFAQ", faqVo);
			if(obj==null) { //insert?���?
				cnt = 1;
			}else {
				cnt = 0;
			}
			
		} catch (SQLException e) {
			
		}
		return cnt;
	}

	@Override
	public int updateFAQ(FAQVO faqVo) {
		int cnt =0;
		try {
			cnt = smc.update("managerfaq.updateFAQ", faqVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteFAQ(String faqNo) {
		int cnt = 0;
		try {
			cnt = smc.delete("managerfaq.deleteFAQ", faqNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
