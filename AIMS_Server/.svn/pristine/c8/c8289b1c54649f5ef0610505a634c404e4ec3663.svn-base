package kr.or.ddit.dao.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CourtVO;
import kr.or.ddit.vo.NoticeVO;

public class mainDAOImpl implements ImainDAO {
	private SqlMapClient smc;
	private static mainDAOImpl instance;
	
	private mainDAOImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static mainDAOImpl getInstance() {
		
		if(instance==null) {
			instance = new mainDAOImpl();
		}
		return instance;
	}
	
	
	@Override
	public List<String> getLocalList() {
		List<String> datalist = new ArrayList<String>();
		try {
			datalist = smc.queryForList("main.getLocalList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datalist;
	}

	@Override
	public List<CourtVO> getCourtList(String local) {
		List<CourtVO> datalist = new ArrayList<CourtVO>();
		try {
			datalist = smc.queryForList("main.getCourtList",local);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datalist;
	}

	@Override
	public A_articleVO getBestArticleInfo() {
		A_articleVO data = null;
		try {
			data = (A_articleVO) smc.queryForObject("main.getBestArticleInfo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> datalist = new ArrayList<NoticeVO>();
		try {
			datalist = smc.queryForList("main.getNoticeList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datalist;
	}

	@Override
	public List<A_articleVO> getTodyAuctionList() {
		List<A_articleVO> datalist = new ArrayList<A_articleVO>();
		try {
			datalist = smc.queryForList("main.getTodyAuctionList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datalist;
	}

	@Override
	public NoticeVO getNoticeInfo(String notice_no) {
		NoticeVO data = null;
		try {
			data = (NoticeVO) smc.queryForObject("main.getNoticeInfo",notice_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

}
