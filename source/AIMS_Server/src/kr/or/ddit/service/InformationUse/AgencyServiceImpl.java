package kr.or.ddit.service.InformationUse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.InformationUse.AgencyDaoImpl;
import kr.or.ddit.dao.InformationUse.IAgencyDao;
import kr.or.ddit.vo.AgencyVO;




public class AgencyServiceImpl extends UnicastRemoteObject implements IAgencyService {
	
	private IAgencyDao dao;
	private static AgencyServiceImpl instance;
	private AgencyServiceImpl() throws RemoteException {
		dao = AgencyDaoImpl.getInstance();
	}
	
	public static AgencyServiceImpl getInstance() {
		if(instance == null){
			try {
				instance = new AgencyServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	

	@Override
	public List<AgencyVO> getAllCourt() {
		return dao.getAllCourt();
	}

	@Override
	public List<AgencyVO> getCourtAddr(String addr) {
		return dao.getCourtAddr(addr);
	}

	@Override
	public List<AgencyVO> getCourtName(String name) {
		return dao.getCourtName(name);
	}

	@Override
	public List<AgencyVO> getCourtSum(Map<String, String> searchMap) {
		return dao.getCourtSum(searchMap);
	}

	@Override
	public List<AgencyVO> getAreaSearch(String comboAddr) {
		return dao.getAreaSearch(comboAddr);
	}

	@Override
	public int insertDataConnect(Map<String, String> info) {
		return dao.insertDataConnect(info);
	}

	@Override
	public int deleteDataConnect() {
		return dao.deleteDataConnect();
	}

	@Override
	public List<String> getCourtSi(String comboAddr) throws RemoteException {
		return dao.getCourtSi(comboAddr);
	}

	@Override
	public List<AgencyVO> getCourtBoth(Map<String, String> paraMap) throws RemoteException {
		return dao.getCourtBoth(paraMap);
	}

	@Override
	public List<AgencyVO> getPagingCourtList(Map<String, Integer> paraMap) throws RemoteException {
		return dao.getPagingCourtList(paraMap);
	}

	







	
	
	


}
