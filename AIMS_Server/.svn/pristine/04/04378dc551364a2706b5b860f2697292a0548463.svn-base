package kr.or.ddit.dao.InformationUse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.AgencyVO;




public class ManagerAgencyDaoImpl implements IManagerAgencyDao {
	
	private SqlMapClient smc;
	private static ManagerAgencyDaoImpl dao;
	
	private ManagerAgencyDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static ManagerAgencyDaoImpl getInstance() {
		if(dao==null) dao = new ManagerAgencyDaoImpl();
		return dao;
	}
	//?���??��
	

	@Override
	public List<AgencyVO> getAllCourt() {
		List<AgencyVO> courtList = null;
		try {
			courtList = smc.queryForList("manageragency.getAllCourt");
		} catch (SQLException e) {
			courtList = null;
			e.printStackTrace();
		}
		
		return courtList;
	}

	@Override
	public List<AgencyVO> getCourtAddr(String addr) {
		
		List<AgencyVO> courtList = null;
		try {
			courtList = smc.queryForList("manageragency.getCourtAddr", addr);
		} catch (SQLException e) {
			courtList = null;
			e.printStackTrace();
		}
		return courtList;
	}

	@Override
	public List<AgencyVO> getCourtName(String name) {
		List<AgencyVO> courList = null;
		try {
			courList = smc.queryForList("manageragency.getCourtName" , name);
		} catch (SQLException e) {
			courList = null;
			e.printStackTrace();
		}
		
		return courList;
	}

	@Override
	public List<AgencyVO> getCourtSum(Map<String, String> searchMap) {
		List<AgencyVO> courList = null;
		try {
			courList = smc.queryForList("manageragency.getCourtSum", searchMap);
		} catch (SQLException e) {
			courList = null;
			e.printStackTrace();
		}
		
		return courList;
	}
	

	@Override
	public int insertCourt(AgencyVO agencyVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("manageragency.insertCourt", agencyVo);
			if(obj==null) {
				cnt =1;
			}else {
				cnt=0;
			}
			
		} catch (SQLException e) {
			
		}
		return cnt;
	}
	
	@Override
	public int updateCourt(AgencyVO agencyVo) {
		int cnt = 0;
		try {
			cnt = smc.update("manageragency.updateCourt", agencyVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int getAllAgencyCount() {
		int cnt  = 0;
		try {
			cnt = (int) smc.queryForObject("manageragency.getAllAgencyCount");
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<AgencyVO> getAreaSearch(String comboAddr) {
		List<AgencyVO> courList = null;
		try {
			courList = smc.queryForList("Agency.getAreaSearch", comboAddr);
		} catch (SQLException e) {
			courList = null;
			e.printStackTrace();
		}
		
		return courList;
	}
	
	@Override
	public List<String> getCourtSi(String comboAddr) {
		List<String> courList = null;
		try {
			courList = smc.queryForList("Agency.getCourtSi", comboAddr);
		} catch (SQLException e) {
			courList = null;
			e.printStackTrace();
		}
		
		return courList;
	}

	@Override
	public List<AgencyVO> getCourtBoth(Map<String, String> paraMap) {
		List<AgencyVO> courList = null;
		try {
			courList = smc.queryForList("Agency.getCourtBoth", paraMap);
		} catch (SQLException e) {
			courList = null;
			e.printStackTrace();
		}
		
		return courList;
	}



}
