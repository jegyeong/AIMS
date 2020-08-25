package kr.or.ddit.service.main;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CourtVO;
import kr.or.ddit.vo.NoticeVO;

public interface ImainService extends Remote{
	public List<String> getLocalList() throws RemoteException;
	public List<CourtVO> getCourtList(String local) throws RemoteException;
	public A_articleVO getBestArticleInfo() throws RemoteException;
	public List<NoticeVO> getNoticeList() throws RemoteException;
	public List<A_articleVO> getTodyAuctionList() throws RemoteException;
	public NoticeVO getNoticeInfo(String notice_no);
}
