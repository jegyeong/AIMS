package kr.or.ddit.service.statistics;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.dao.statistics.StatisticsDaoImpl;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.ResultVO;

public class StatisticsServiceImpl extends UnicastRemoteObject implements IStatisticsService {

	private static StatisticsServiceImpl service;
	
	private static StatisticsDaoImpl dao;
	
	private StatisticsServiceImpl() throws RemoteException{
		dao = StatisticsDaoImpl.getInstance();
	}
	
	public static StatisticsServiceImpl getInstance() {
		try {
			if(service == null) service = new StatisticsServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
	
//	@Override
//	public List<A_articleJoinArticle_resutVO> getLocation(String sido) throws RemoteException {
//		return dao.getLocation(sido);
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getAuctionNum(String sido) throws RemoteException {
//		return dao.getAuctionNum(sido);
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getAllResultCount(String sido) throws RemoteException {
//		return dao.getAllResultCount(sido);
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getConnoisseur(String sido) throws RemoteException {
//		return dao.getConnoisseur(sido);
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getSeller(String sido) throws RemoteException {
//		return dao.getSeller(sido);
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getSalerate(String sido) throws RemoteException {
//		return dao.getSalerate(sido);
//	}
//
//	@Override
//	public List<A_articleJoinArticle_resutVO> getSellerrate(String sido) throws RemoteException {
//		return dao.getSellerrate(sido);
//	}

	@Override
	public List<ResultVO> getAllResult(String sido) throws RemoteException {
		return dao.getAllResult(sido);
	}

	
}
