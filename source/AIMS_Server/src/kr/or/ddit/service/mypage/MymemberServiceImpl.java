package kr.or.ddit.service.mypage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.mypage.IMymemberDao;
import kr.or.ddit.dao.mypage.MymemberDaoImpl;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.Answer_FileVO;
import kr.or.ddit.vo.Article_ResultVO;
import kr.or.ddit.vo.Auction_RecordVO;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.InterestVO;
import kr.or.ddit.vo.MemberVO;


public class MymemberServiceImpl extends UnicastRemoteObject implements IMymemberService {

	private static MymemberServiceImpl service;
	
	private IMymemberDao dao;
	
	public  MymemberServiceImpl() throws RemoteException {
		dao = MymemberDaoImpl.getInstance();
	}
	public static IMymemberService getInstance() {
			try {
				if(service == null)
				service = new MymemberServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		return service;
	}
	@Override
	public List<InterestVO> getAllInterstProd(String mem_id) throws RemoteException
	{
		return dao.getAllInterstProd(mem_id);
	}

	@Override
	public int updataMyInfo(MemberVO memVO) throws RemoteException{
		return dao.updataMyInfo(memVO);
	}

	@Override
	public MemberVO getMyInfoList(String mem_id) throws RemoteException{
		return dao.getMyInfoList(mem_id);
	}

	
	@Override
	public List<Auction_RecordVO> getMyArticle(String mem_id) throws RemoteException{
		return dao.getMyArticle(mem_id);
	}
	
	
	@Override
	public List<Com_QuestionVO> getMyQuestion(String mem_id) throws RemoteException {
		return dao.getMyQuestion(mem_id);
	}
	
	@Override
	public Com_AnswerVO getMyAnswer(Map<String,String> data)throws RemoteException{
		return dao.getMyAnswer(data);
	}
	
	@Override
	public int delInterstProd(InterestVO intArtiVO) {
		return dao.delInterstProd(intArtiVO);
	}
	
	@Override
	public int delAresult(Article_ResultVO aresult) throws RemoteException {
		
		return dao.delAresult(aresult);
	}
	@Override
	public List<A_articleVO> getMydetailSH(Map<String,String> info) throws RemoteException {
		return dao.getMydetailSH(info);
	}
	// 회원 탈퇴 관리하는거 
	@Override
	public int updateActive(String mem_id) throws RemoteException {
		return dao.updateActive(mem_id);
	}
	
	public List<FileInfoVO> AnsFileServerToClient(String COM_ANS_NO){
		List<FileInfoVO> fileList = new ArrayList<FileInfoVO>();
		try {
			for(Answer_FileVO fileVO : dao.getAnswerFileList(COM_ANS_NO)) {
				
				File file = new File(fileVO.getAns_f_addr());
				FileOutputStream fos = new FileOutputStream(file);
				byte[] buffer = new byte[(int) file.length()];
				fos.write(buffer);
				fos.flush();
				
				FileInfoVO fileInfoVO = new FileInfoVO();
				fileInfoVO.setFileData(buffer);
				fileInfoVO.setFileName(file.getName());
				fileList.add(fileInfoVO);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileList;
	}
	

}
