package kr.or.ddit.dao.mypage;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.calDateVO;



public class CalendarDao implements ICalendarDao {
	static Logger logger = Logger.getLogger(CalendarDao.class);
	private static CalendarDao caldao;
	private SqlMapClient smc;
	public CalendarDao() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	public static CalendarDao getInstance() {
		if(caldao==null)
			caldao = new CalendarDao();
		return caldao;
	}
	@Override
	public List<CalendarVO> getAllCal(Map<String, Integer> calMap) {
		List<CalendarVO> calList = null;
		try {
			calList = smc.queryForList("calendar.selectCal", calMap);
//			logger.info("calendar정보 가져오기 성공");
		} catch (SQLException e) {
			logger.error("calendar정보 가져오기 실패");
			e.printStackTrace();
		}
		return calList;
	}
	@Override
	public void insertCal(CalendarVO calVo) {
		try {
			smc.insert("calendar.insertCal",calVo);
			logger.info("달력 정보 입력 성공");
		} catch (SQLException e) {
			logger.error("달력 정보 입력 실패");
			e.printStackTrace();
		}
	}
	@Override
	public List<calDateVO> getDetail(Map<String, Integer> calMap) {
		List<calDateVO> getDetail = null;
		try {
			getDetail=smc.queryForList("calendar.selectdetail",calMap);
			logger.info("detail성공");
		} catch (SQLException e) {
			logger.error("detail실패");
			e.printStackTrace();
		}
		return getDetail;
	}
	@Override
	public void deleteCal(int cal_num) {
		try {
			smc.delete("calendar.delDetail", cal_num);
			logger.info("detail삭제 성공");
		} catch (SQLException e) {
			logger.error("detail 삭제 실패");
			e.printStackTrace();
		}
	}
	@Override
	public void updateDetail(CalendarVO calVo) {
		try {
			smc.update("calendar.updateDetail", calVo);
			logger.info("detail수정 성공");
		} catch (SQLException e) {
			logger.error("detail수정 실패");
			e.printStackTrace();
		}
	}
	
	// 날짜에 일정 넣는거 
	@Override
	public List<A_articleVO> getMYAUCDAY(String mem_id) {
		List<A_articleVO> getMYAUCDAY = null;
		try {
			getMYAUCDAY = smc.queryForList("calendar.getMYAUCDAY",mem_id);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return getMYAUCDAY;
	}
	
	
	
	
}
