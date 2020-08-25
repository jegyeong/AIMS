package kr.or.ddit.dao.law;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.Law_CategoryVO;
import kr.or.ddit.vo.Related_LawVO;

public class LawDao implements ILawDao{
//------------------------------------------------------------------------------------------
	private SqlMapClient smc;
	
	private static LawDao dao;
	
	private LawDao() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static LawDao getInstance() {
		if(dao == null) dao = new LawDao();
		return dao;
	}
//------------------------------------------------------------------------------------------
	@Override
	public List<Law_CategoryVO> getAllLawCategory() {
		List<Law_CategoryVO> categoryList = null;
		
		try {
			categoryList = smc.queryForList("law.getAllLawCategory");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categoryList;
	}

	@Override
	public List<Related_LawVO> getAllRelated_Law(String cat_law_no) {
		List<Related_LawVO> relatedList = null;
		
		try {
			relatedList = smc.queryForList("law.getAllRelated_Law", cat_law_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return relatedList;
	}

	@Override
	public List<Related_LawVO> getAllShowRelated_Law(Map<String, String> no) {
		List<Related_LawVO> Rlist = null;
		
		try {
			Rlist = smc.queryForList("law.getAllShowRelated_Law", no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Rlist;
	}

	@Override
	public int insertLaw(Related_LawVO RlawVo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("law.insertLaw", RlawVo);
			
			if(obj == null) {
				cnt = 1;
			}else {
				cnt = 0;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert작업 실패");
		}
		
		return cnt;
	}

	@Override
	public int updateLaw(Related_LawVO RlawVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("law.updateLaw", RlawVo);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("update실패");
		}
		
		return cnt;
	}

}
