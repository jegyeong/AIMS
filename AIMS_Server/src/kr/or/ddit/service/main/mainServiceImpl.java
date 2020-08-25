package kr.or.ddit.service.main;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.dao.main.ImainDAO;
import kr.or.ddit.dao.main.mainDAOImpl;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CourtVO;
import kr.or.ddit.vo.NoticeVO;

public class mainServiceImpl extends UnicastRemoteObject implements ImainService {
	private static mainServiceImpl instance;
	private ImainDAO dao;
	
	private mainServiceImpl() throws RemoteException{
		dao = mainDAOImpl.getInstance();
	}
	
	public static mainServiceImpl getInstance() {
		if(instance==null) {
			try {
				instance = new mainServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	@Override
	public List<String> getLocalList() throws RemoteException {
		return dao.getLocalList();
	}

	@Override
	public List<CourtVO> getCourtList(String local) throws RemoteException{
		return dao.getCourtList(local);
	}

	@Override
	public A_articleVO getBestArticleInfo() throws RemoteException{
		return dao.getBestArticleInfo();
	}

	@Override
	public List<NoticeVO> getNoticeList() throws RemoteException{
		return dao.getNoticeList();
	}

	@Override
	public List<A_articleVO> getTodyAuctionList() throws RemoteException{
		return dao.getTodyAuctionList();
	}

	@Override
	public NoticeVO getNoticeInfo(String notice_no) throws RemoteException {
		return dao.getNoticeInfo(notice_no);
	}

}
