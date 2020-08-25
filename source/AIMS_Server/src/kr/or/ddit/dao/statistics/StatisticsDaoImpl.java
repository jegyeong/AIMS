package kr.or.ddit.dao.statistics;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.ResultVO;

public class StatisticsDaoImpl implements IStatisticsDao{

	private static StatisticsDaoImpl dao;
	
	private SqlMapClient smc;
	
	private StatisticsDaoImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static StatisticsDaoImpl getInstance() {
		if(dao == null) dao = new StatisticsDaoImpl();
		return dao;
	}
	
//	@Override
//	public List<A_articleJoinArticle_resutVO> getLocation(String sido) {
//		List<A_articleJoinArticle_resutVO> joinList = null;
//		try {
//			joinList = smc.queryForList("statistics.getLocation", sido);
//		} catch (SQLException e) {
//			joinList = null;
//		}
//		return joinList;
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getAuctionNum(String sido) {
//		List<A_articleJoinArticle_resutVO> joinList = null;
//		try {
//			joinList = smc.queryForList("statistics.getAuctionNum", sido);
//		} catch (SQLException e) {
//			joinList = null;
//		}
//		return joinList;
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getAllResultCount(String sido) {
//		List<A_articleJoinArticle_resutVO> joinList = null;
//		try {
//			joinList = smc.queryForList("statistics.getAllResultCount", sido);
//		} catch (SQLException e) {
//			joinList = null;
//		}
//		return joinList;
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getConnoisseur(String sido) {
//		List<A_articleJoinArticle_resutVO> joinList = null;
//		try {
//			joinList = smc.queryForList("statistics.getConnoisseur", sido);
//		} catch (SQLException e) {
//			joinList = null;
//		}
//		return joinList;
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getSeller(String sido) {
//		List<A_articleJoinArticle_resutVO> joinList = null;
//		try {
//			joinList = smc.queryForList("statistics.getSeller", sido);
//		} catch (SQLException e) {
//			joinList = null;
//		}
//		return joinList;
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getSalerate(String sido) {
//		List<A_articleJoinArticle_resutVO> joinList = null;
//		try {
//			joinList = smc.queryForList("statistics.getSalerate", sido);
//		} catch (SQLException e) {
//			joinList = null;
//		}
//		return joinList;
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getSellerrate(String sido) {
//		List<A_articleJoinArticle_resutVO> joinList = null;
//		try {
//			joinList = smc.queryForList("statistics.getSellerrate", sido);
//		} catch (SQLException e) {
//			joinList = null;
//		}
//		return joinList;
//	}

	@Override
	public List<ResultVO> getAllResult(String sido) {
		List<ResultVO> resList = null;
		try {
			resList = smc.queryForList("statistics.getAllResult", sido);
		} catch (SQLException e) {
			resList = null;
		}
		return resList;
	}
	
}
