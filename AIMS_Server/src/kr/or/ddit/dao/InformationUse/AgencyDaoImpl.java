package kr.or.ddit.dao.InformationUse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;


import kr.or.ddit.dao.InformationUse.IAgencyDao;
import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.AgencyVO;






public class AgencyDaoImpl implements IAgencyDao {
	
	private SqlMapClient smc;
	private static AgencyDaoImpl dao;
	
	private AgencyDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static AgencyDaoImpl getInstance() {
		if(dao==null) dao = new AgencyDaoImpl();
		return dao;
	}
	//?���??��
	

	@Override
	public List <AgencyVO> getAllCourt() {
		List<AgencyVO> courtList = null;
		try {
			courtList = smc.queryForList("Agency.getAllCourt");
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
			courtList = smc.queryForList("Agency.getCourtAddr");
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
			courList = smc.queryForList("Agency.getAreaSearch", name);
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
			courList = smc.queryForList("Agency.getCourtSum", searchMap);
		} catch (SQLException e) {
			courList = null;
			e.printStackTrace();
		}
		
		return courList;
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
		
		return null;
	}

	@Override
	public int insertDataConnect(Map<String, String> info) {
		int cnt = 0;
		try {
			Object obj = smc.insert("Agency.insertDataConnect", info);
			if(obj==null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteDataConnect() {
		int cnt = 0;
		try {
			cnt= smc.delete("Agency.deleteDataConnect");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
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

	@Override
	public List<AgencyVO> getPagingCourtList(Map<String, Integer> paraMap) {
		List<AgencyVO> ageList = null;
		try {
			ageList = smc.queryForList("Agency.getPagingCourtList", paraMap);
		} catch (SQLException e) {
			ageList = null;
			e.printStackTrace();
		}
		return ageList;
	}

	
}
