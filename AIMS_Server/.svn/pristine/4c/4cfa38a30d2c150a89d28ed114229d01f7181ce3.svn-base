package kr.or.ddit.service.login;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.dao.login.ILoginDao;
import kr.or.ddit.dao.login.LoginDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class LoginServiceImpl extends UnicastRemoteObject implements ILoginService {
	private ILoginDao dao;
	private static LoginServiceImpl service;
	private LoginServiceImpl() throws RemoteException{
		dao = LoginDaoImpl.getInstance();
	}
	
	public static LoginServiceImpl getInstance() {
		try {
			if(service==null) service = new LoginServiceImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return service;
	}

	@Override
	public MemberVO getmemUser(MemberVO memberVo) throws RemoteException {
		return dao.getmemUser(memberVo);
	}

	@Override
	public MemberVO findIdUser(MemberVO memberVo) throws RemoteException {
		return dao.findIdUser(memberVo);
	}

	@Override
	public MemberVO findPassUser(MemberVO memberVo) throws RemoteException {
		return dao.findPassUser(memberVo);
	}

	@Override
	public int updateTemporaryPass(MemberVO memberVo) throws RemoteException {
		return dao.updateTemporaryPass(memberVo);
	}

	



	
	
	
	
}
