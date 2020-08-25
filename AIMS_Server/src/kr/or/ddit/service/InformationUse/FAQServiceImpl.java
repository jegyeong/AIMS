package kr.or.ddit.service.InformationUse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.InformationUse.FAQDaoImpl;
import kr.or.ddit.dao.InformationUse.IFAQDao;
import kr.or.ddit.vo.FAQVO;



public class FAQServiceImpl extends UnicastRemoteObject implements IFAQService {
	
	private IFAQDao dao;
	private static FAQServiceImpl instance;
	private FAQServiceImpl() throws RemoteException {
		dao = FAQDaoImpl.getInstance();
	}
	
	public static FAQServiceImpl getInstance() {
		try {
			if(instance == null) instance = new FAQServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		return instance;
	}
	
	@Override
	public List<FAQVO> getAllFAQList() throws RemoteException {
		return dao.getAllFAQList();
	}
	@Override
	public List<FAQVO> getDetailsList(String faqNum) throws RemoteException {
		return dao.getDetailsList(faqNum);
	}

	@Override
	public List<FAQVO> getPagingFAQList(Map<String, Integer> paraMap) throws RemoteException {
		return dao.getPagingFAQList(paraMap);
	}
	

}
