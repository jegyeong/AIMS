package kr.or.ddit.service.InformationUse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.InformationUse.IManagerAgencyDao;
import kr.or.ddit.dao.InformationUse.ManagerAgencyDaoImpl;
import kr.or.ddit.vo.AgencyVO;



public class ManagerAgencyServiceImpl extends UnicastRemoteObject implements IManagerAgencyService {
	
	private IManagerAgencyDao dao;
	private static ManagerAgencyServiceImpl instance;
	private ManagerAgencyServiceImpl() throws RemoteException {
		dao = ManagerAgencyDaoImpl.getInstance();
	}
	
	public static ManagerAgencyServiceImpl getInstance() {
		if(instance == null){
			try {
				instance = new ManagerAgencyServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	@Override
	public List<AgencyVO> getAllCourt() throws RemoteException{
		return dao.getAllCourt();
	}
	@Override
	public List<AgencyVO> getCourtAddr(String addr)throws RemoteException {
		return dao.getCourtAddr(addr);
	}
	@Override
	public List<AgencyVO> getCourtName(String name)throws RemoteException {
		return dao.getCourtName(name);
	}
	@Override
	public List<AgencyVO> getCourtSum(Map<String, String> searchMap)throws RemoteException {
		return dao.getCourtSum(searchMap);
	}
	@Override
	public int insertCourt(AgencyVO agencyVo)throws RemoteException {
		return dao.insertCourt(agencyVo);
	}
	@Override
	public int updateCourt(AgencyVO agencyVo)throws RemoteException {
		return dao.updateCourt(agencyVo);
	}
	@Override
	public int getAllAgencyCount()throws RemoteException {
		return dao.getAllAgencyCount();
	}
	
	@Override
	public List<AgencyVO> getAreaSearch(String comboAddr) throws RemoteException {
		return dao.getAreaSearch(comboAddr);
	}
	
	@Override
	public List<String> getCourtSi(String comboAddr)throws RemoteException  {
		return dao.getCourtSi(comboAddr);
	}

	@Override
	public List<AgencyVO> getCourtBoth(Map<String, String> paraMap) throws RemoteException{
		return dao.getCourtBoth(paraMap);
	}

	
}
