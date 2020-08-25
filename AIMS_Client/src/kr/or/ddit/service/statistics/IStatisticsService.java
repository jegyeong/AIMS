package kr.or.ddit.service.statistics;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.ResultVO;

public interface IStatisticsService extends Remote {

//public List<A_articleJoinArticle_resutVO> getLocation(String sido) throws RemoteException; //위치
//	
//	public List<A_articleJoinArticle_resutVO> getAuctionNum(String sido) throws RemoteException; //경매건수
//	
//	public List<A_articleJoinArticle_resutVO> getAllResultCount(String sido) throws RemoteException; //매각건수
//	
//	public List<A_articleJoinArticle_resutVO> getConnoisseur(String sido) throws RemoteException; //감정가
//	
//	public List<A_articleJoinArticle_resutVO> getSeller(String sido) throws RemoteException; //매각가
//	
//	public List<A_articleJoinArticle_resutVO> getSalerate(String sido) throws RemoteException; //매각율
//
//	public List<A_articleJoinArticle_resutVO> getSellerrate(String sido) throws RemoteException; //매각가율
	
	public List<ResultVO> getAllResult(String sido) throws RemoteException;
}
