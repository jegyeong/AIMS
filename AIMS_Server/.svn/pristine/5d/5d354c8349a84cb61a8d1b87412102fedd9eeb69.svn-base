package kr.or.ddit.service.law;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.law.ILawDao;
import kr.or.ddit.dao.law.LawDao;
import kr.or.ddit.dao.stuff.AdminDao;
import kr.or.ddit.dao.stuff.IAdminDao;
import kr.or.ddit.service.stuff.AdminService;
import kr.or.ddit.vo.Law_CategoryVO;
import kr.or.ddit.vo.Related_LawVO;

public class LawService extends UnicastRemoteObject implements ILawService{
//-------------------------------------------------------------------------------------------
	private ILawDao dao;
	
	private static LawService service;
	
	private LawService() throws RemoteException {
		dao = LawDao.getInstance();
	}
	
	public static LawService getInstance() {
		if(service == null)
			try {
				service = new LawService();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		
		return service;
	}
//-------------------------------------------------------------------------------------------
	@Override
	public List<Law_CategoryVO> getAllLawCategory() throws RemoteException {
		return dao.getAllLawCategory();
	}

	@Override
	public List<Related_LawVO> getAllRelated_Law(String cat_law_no) throws RemoteException {
		return dao.getAllRelated_Law(cat_law_no);
	}

	@Override
	public List<Related_LawVO> getAllShowRelated_Law(Map<String, String> no) throws RemoteException {
		return dao.getAllShowRelated_Law(no);
	}

	@Override
	public int insertLaw(Related_LawVO RlawVo) throws RemoteException {
		return dao.insertLaw(RlawVo);
	}

	@Override
	public int updateLaw(Related_LawVO RlawVo) throws RemoteException {
		return dao.updateLaw(RlawVo);
	}

}
