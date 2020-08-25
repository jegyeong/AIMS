package kr.or.ddit.service.InformationUse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.dao.InformationUse.IManagerFAQDao;
import kr.or.ddit.dao.InformationUse.ManagerFAQDaoImpl;
import kr.or.ddit.vo.FAQVO;



public class ManagerFAQServiceImpl extends UnicastRemoteObject implements IManagerFAQService {
	private IManagerFAQDao dao;
	private static ManagerFAQServiceImpl instance;
	private ManagerFAQServiceImpl() throws RemoteException {
		dao = ManagerFAQDaoImpl.getInstance();
	}
	
	public static ManagerFAQServiceImpl getInstance() {
		if(instance == null){
			try {
				instance = new ManagerFAQServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	@Override
	public List<FAQVO> getAllFAQList() throws RemoteException {
		return dao.getAllFAQList();
	}

	@Override
	public List<FAQVO> getDetailsList(String faqNum)throws RemoteException {
		return dao.getDetailsList(faqNum);
	}

	@Override
	public int insertFAQ(FAQVO faqVo) throws RemoteException {
		return dao.insertFAQ(faqVo);
	}

	@Override
	public int updateFAQ(FAQVO faqVo)throws RemoteException {
		return dao.updateFAQ(faqVo);
	}

	@Override
	public int deleteFAQ(String faqNo) throws RemoteException {
		return dao.deleteFAQ(faqNo);
	}

	
}
