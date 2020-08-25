package kr.or.ddit.service.adminmypage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.dao.adminmypage.ImemberInfodao;
import kr.or.ddit.dao.adminmypage.MemberInfoDaoImpl;
import kr.or.ddit.vo.MemberVO;



public class MemberInfoServiceImpl extends UnicastRemoteObject implements ImemberInfoService {

	private static MemberInfoServiceImpl service;
	
	private ImemberInfodao dao;
	
	public MemberInfoServiceImpl()  throws RemoteException{
		dao = MemberInfoDaoImpl.getInstance();
	}
	
	public static ImemberInfoService getInstance() {
			try {
				if(service == null)
				service = new MemberInfoServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		return service;
	}

	@Override
	public List <MemberVO> getSearchMember(String mem_id) throws RemoteException {
		return dao.getSearchMember(mem_id);
	}

	@Override
	public int updateMember(MemberVO memVO) throws RemoteException {
		return dao.updateMember(memVO);
	}

	@Override
	public int insertBlackListMember(String mem_id) throws RemoteException{

		return dao.insertBlackListMember(mem_id);
	}

	@Override

	public int updateActive(String  mem_id) throws RemoteException{
		return dao.updateActive(mem_id);
	}

	@Override
	public List<MemberVO> tableview(String mem_id)throws RemoteException {
		return dao.tableview(mem_id);
	}

	@Override
	public List<MemberVO> getMymember()throws RemoteException {
		return dao.getMymember();
	}

	@Override
	public int deleteBlackListMember(String mem_id) throws RemoteException {
		return dao.deleteBlackListMember(mem_id);
	}

	
}
