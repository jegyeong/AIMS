package kr.or.ddit.service.auction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.Auctioning_RecordVO;

public interface IauctionServer extends Remote {
	public List<A_articleVO> getMyArticleList(String mem_id) throws RemoteException;//dao
	public List<A_articleVO> getTotalArticleList()throws RemoteException; // dao
	public A_articleVO getArticleInfo(String a_art_no)throws RemoteException; //dao
	public int insertArticleResult(Map<String,String> info)throws RemoteException; //dao
	public void insertRecording(Auctioning_RecordVO recordVO)throws RemoteException; //dao
}	
