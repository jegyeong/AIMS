package kr.or.ddit.service.knowledge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.dao.knowledge.IKnowledgeDao;
import kr.or.ddit.dao.knowledge.KnowledgeDaoImpl;
import kr.or.ddit.vo.A_FormJoinForm_FileVO;
import kr.or.ddit.vo.A_FormVO;
import kr.or.ddit.vo.A_TerminologyVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.Form_FileVO;
import kr.or.ddit.vo.Notice_FileVO;
import kr.or.ddit.vo.Related_LawVO;

public class KnowledgeServiceImpl extends UnicastRemoteObject implements IKnowledgeService {

	private IKnowledgeDao dao;
	
	private static KnowledgeServiceImpl service;
	
	private KnowledgeServiceImpl() throws RemoteException{
		dao = KnowledgeDaoImpl.getInstance();
	}
	
	public static KnowledgeServiceImpl getInstance() {
		try {
		if(service == null) service = new KnowledgeServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		return service;
	}

	@Override
	public List<A_TerminologyVO> searchTerms(String a_ter_name) throws RemoteException{
		return dao.searchTerms(a_ter_name);
	}

	@Override
	public List<Related_LawVO> searchLaw(String rel_l_name) throws RemoteException{
		return dao.searchLaw(rel_l_name);
	}

	@Override
	public List<A_TerminologyVO> getAllTerm() throws RemoteException {
		return dao.getAllTerm();
	}

	@Override
	public List<A_TerminologyVO> getTerms() throws RemoteException {
		return dao.getTerms();
	}

	@Override
	public int insertTerms(A_TerminologyVO termVo) throws RemoteException {
		return dao.insertTerms(termVo);
	}

	@Override
	public int updateTerms(A_TerminologyVO termVo) throws RemoteException {
		return dao.updateTerms(termVo);
	}

	@Override
	public int deleteTerms(A_TerminologyVO termVo) throws RemoteException {
		return dao.deleteTerms(termVo);
	}

	@Override
	public List<A_FormVO> getAllForm() throws RemoteException {
		return dao.getAllForm();
	}

	@Override
	public List<Form_FileVO> getAllFile() throws RemoteException {
		return dao.getAllFile();
	}

	@Override
	public String insertForm(A_FormVO formVo) throws RemoteException {
		return dao.insertForm(formVo);
	}

	@Override
	public int insertFile(Form_FileVO fileVo) throws RemoteException {
		return dao.insertFile(fileVo);
	}

	@Override
	public int updateForm(A_FormVO formVo) throws RemoteException {
		return dao.updateForm(formVo);
	}

	@Override
	public int updateFile(Form_FileVO fileVo) throws RemoteException {
		return dao.updateFile(fileVo);
	}

	@Override
	public int deleteForm(A_FormVO formVo) throws RemoteException {
		return dao.deleteForm(formVo);
	}

	@Override
	public int deleteFile(Form_FileVO fileVo) throws RemoteException {
		return dao.deleteFile(fileVo);
	}

	@Override
	public List<Related_LawVO> getAllLaw() throws RemoteException {
		return dao.getAllLaw();
	}

	@Override
	public int insertLaw(Related_LawVO lawVo) throws RemoteException {
		return dao.insertLaw(lawVo);
	}

	@Override
	public int updateLaw(Related_LawVO lawVo) throws RemoteException {
		return dao.updateLaw(lawVo);
	}

	@Override
	public int deleteLaw(Related_LawVO lawVO) throws RemoteException {
		return dao.deleteLaw(lawVO);
	}

	@Override
	public List<A_FormJoinForm_FileVO> joinForm() throws RemoteException {
		return dao.joinForm();
	}

	
	

	@Override
	public List<FileInfoVO> formServerToClient(String a_form_no) throws RemoteException {
		List<FileInfoVO> fileList = new ArrayList<FileInfoVO>();
		
		for (Form_FileVO fileInfo : dao.getFormList(a_form_no)) {
			File file = new File(fileInfo.getForm_f_addr());
			try {
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[(int) file.length()];
				fis.read(buffer);
				FileInfoVO filedate = new FileInfoVO();
				filedate.setFileData(buffer);
				filedate.setFileName(file.getName());
				fileList.add(filedate);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return fileList;
	}
	
	@Override
	public String clientToServer(String folderName, FileInfoVO fileData) throws RemoteException {
		
		File file = new File("D:/D_Other/dataStage/" + folderName + "/" + fileData.getFileName());
		byte[] data = fileData.getFileData();
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getPath();
	}
	
}
