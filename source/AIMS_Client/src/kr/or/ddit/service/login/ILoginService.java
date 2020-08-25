package kr.or.ddit.service.login;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface ILoginService extends Remote {
	
	/**
	 * 아이디를 키값으로해서  DB에서 해당하는 사용자 정보가 담긴 정보를 반환하는 메서드
	 * @param memId 회원이 입력한 id
	 * @return mem_id와 mem_pass가 담긴 memberVo객체를 반환
	 */
	public MemberVO getmemUser(MemberVO memberVo)  throws RemoteException;
	
	public MemberVO findIdUser(MemberVO memberVo) throws RemoteException; 
	
	public MemberVO findPassUser(MemberVO memberVo) throws RemoteException;
	
	public int updateTemporaryPass(MemberVO memberVo) throws RemoteException; 
	
}
