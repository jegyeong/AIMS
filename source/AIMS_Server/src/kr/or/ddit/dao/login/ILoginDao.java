package kr.or.ddit.dao.login;

import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface ILoginDao {
	/**
	 * 아이디를 키값으로해서  DB에서 해당하는 사용자 정보가 담긴 정보를 반환하는 메서드
	 * @param memId 회원이 입력한 id
	 * @return mem_id와 mem_pass가 담긴 memberVo객체를 반환
	 */
	public MemberVO getmemUser(MemberVO memberVo);
	
	/**
	 * 이름을 키값으로 해서 해당하는 사용자 정보가 담긴 정보를 반환하는 메서드
	 * @param memVo 회원이 입력한 이름과 메일이 담긴 vo
	 * @return 회원의 정보가 담긴 memberVo객체를 반환
	 */
	public MemberVO findIdUser(MemberVO memberVo); 
	
	/**
	 * 이름을 키값으로 해서 해당하는 사용자 정보가 담긴 정보를 반환하는 메서드
	 * @param memVo 회원이 입력한 이름과 아이디 주민번호가 담긴 vo
	 * @return 회원의 정보가 담긴 memberVo객체를 반환
	 */
	public MemberVO findPassUser(MemberVO memberVo); 
	
	/**
	 * 
	 * @param memberVo
	 * @return
	 */
	public int updateTemporaryPass(MemberVO memberVo); 
	 
}