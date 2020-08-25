package kr.or.ddit.service.stuff;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.stuff.AdminDao;
import kr.or.ddit.dao.stuff.IAdminDao;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.Answer_FileVO;
import kr.or.ddit.vo.CategoryAVO;
import kr.or.ddit.vo.CategoryBVO;
import kr.or.ddit.vo.CategoryCVO;
import kr.or.ddit.vo.CourtVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.ImageVO;
import kr.or.ddit.vo.NoticeVO;




public class AdminService extends UnicastRemoteObject implements IAdminService {
//-------------------------------------------------------------------------------------------
	private IAdminDao dao;
	
	private static AdminService service;
	
	private AdminService() throws RemoteException {
		dao = AdminDao.getInstance();
	}
	
	public static AdminService getInstance() {
		if(service == null)
			try {
				service = new AdminService();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return service;
	}
//-------------------------------------------------------------------------------------------
	@Override
	public int insertStuff(A_articleVO articleVo) {
		return dao.insertStuff(articleVo);
	}

	@Override
	public int deleteStuff(String a_art_no) {
		return dao.deleteStuff(a_art_no);
	}

	@Override
	public int updateStuff(A_articleVO articleVo) {
		return dao.updateStuff(articleVo);
	}

	@Override
	public List<A_articleVO> NumSearch(String a_art_no) {
		return dao.NumSearch(a_art_no);
	}

	@Override
	public List<A_articleVO> getAllStuff() {
		return dao.getAllStuff();
	}

	@Override
	public List<CategoryAVO> getAllACategory() {
		return dao.getAllACategory();
	}

	@Override
	public List<CategoryBVO> getAllBCategory(String cat_a_no) {
		return dao.getAllBCategory(cat_a_no);
	}

	@Override
	public List<CategoryCVO> getAllCCategory(String cat_b_no) {
		return dao.getAllCCategory(cat_b_no);
	}

	@Override
	public List<CourtVO> getAllCourt(String add) {
		return dao.getAllCourt(add);
	}
	

	@Override
	public List<String> courtAdd() throws RemoteException {
		return dao.courtAdd();
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
	
	@Override
	public FileInfoVO ServerToClient(A_articleVO articleVO) throws RemoteException {	
		FileInfoVO filedate = new FileInfoVO();
			File file = new File(articleVO.getA_art_appr());
			try {
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[(int) file.length()];
				fis.read(buffer);
				filedate.setFileData(buffer);
				filedate.setFileName(file.getName());
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return filedate;
	}

	@Override
	public List<FileInfoVO> ImgServerToClient(A_articleVO articleVO) throws RemoteException {	
		
		List<FileInfoVO> fileList = new ArrayList<FileInfoVO>();
		List<ImageVO> imgList = dao.getArticleImageList(articleVO.getA_art_no());
		
		for(ImageVO imageVO : imgList) {
			FileInfoVO filedate = new FileInfoVO();
			File file = new File(imageVO.getImg_addr());
			System.out.println(imageVO.getImg_addr());
			try {
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[(int) file.length()];
				fis.read(buffer);
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
	public int insertImageFile(ImageVO imageVO) throws RemoteException {
		return dao.insertImageFile(imageVO);
	}

	@Override
	public int insertImageFile1(ImageVO imageVO) throws RemoteException {
		return dao.insertImageFile1(imageVO);
	}

	
	@Override
	public int deleteImg_File(Map<String,String> map) throws RemoteException {
		return  dao.deleteImg_File(map);
	}

	@Override
	public String getcourtAdd(String add) throws RemoteException {
		return dao.getcourtAdd(add);
	}

	
}
