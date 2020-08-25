package kr.or.ddit.dao.mypage;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.calDateVO;



public interface ICalendarDao {
	/**
	 * DB에 담겨있는 calendar객체들을 반환하는 메서드
	 * @param year, month, day가 들어있는 map을 넘겨주고 그에 맞는 값을 가져오는 메서드
	 * @return CalendarVO 객체를 담고있는 list
	 */
	public List<CalendarVO> getAllCal(Map<String, Integer> calMap);
	/**
	 * 
	 * @param calVo : insert할 정보가 담겨있는 CalendarVO객체를 넣어줌
	 */
	public void insertCal(CalendarVO calVo);
	/**
	 * title과 cont를 가져오는 메서드
	 * @param calMap 날짜를 Map에 넣어 보내준다
	 * @return 날짜에 맞는 타이틀과 cont를 가져온다
	 */
	public List<calDateVO> getDetail(Map<String, Integer> calMap);
	/**
	 * 제목을 넣어주면삭제되는 메서드
	 * @param title
	 */
	public void deleteCal(int cal_num);
	/**
	 * 
	 * 게시글을 수정해주는 메서드
	 * @param calVo
	 */
	public void updateDetail(CalendarVO calVo);
}
