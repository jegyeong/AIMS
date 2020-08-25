package kr.or.ddit.service.mypage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.mypage.CalendarDao;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.calDateVO;


public class CalendarService extends UnicastRemoteObject implements ICalendarService{
	private static CalendarService calService;
	private CalendarDao calDao;
	
	public static CalendarService getInstance() {
			try {
				if(calService == null)
				calService = new CalendarService();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return calService;
	}
	public CalendarService()  throws RemoteException {
		calDao = CalendarDao.getInstance();
	}
	@Override
	public void insertCal(CalendarVO calVo) throws RemoteException {
		calDao.insertCal(calVo);
	}
	@Override
	public List<CalendarVO> getAllCal(Map<String, Integer> calMap) throws RemoteException{
		return calDao.getAllCal(calMap);
	}
	@Override
	public List<calDateVO> getDetail(Map<String, Integer> calMap)throws RemoteException {
		return calDao.getDetail(calMap);
	}
	@Override
	public void deleteCal(int cal_num) throws RemoteException{
		calDao.deleteCal(cal_num);
	}
	@Override
	public void updateDetail(CalendarVO calVo) throws RemoteException{
		calDao.updateDetail(calVo);
	}
}
