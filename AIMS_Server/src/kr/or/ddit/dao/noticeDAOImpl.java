package kr.or.ddit.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import javafx.collections.ObservableList;
import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.Answer_FileVO;
import kr.or.ddit.vo.Category_AVO;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.Notice_FileVO;
import kr.or.ddit.vo.Question_FileVO;

public class noticeDAOImpl implements InoticeDAO {
	private SqlMapClient smc;
	private static noticeDAOImpl instance;

	private Map<String,Socket> userSocket;
	
	private noticeDAOImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static noticeDAOImpl getInstance() {
		
		if(instance==null) {
			instance = new noticeDAOImpl();
		}
		return instance;
	}
	
	
	@Override
	public int getNoticTotalCount() throws RemoteException{
		int num = 0 ;
		try {
			 num = (int) smc.queryForObject("notice.getNoticeTotalcount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<NoticeVO> getPaginNoticeList(Map<String, Integer> pageMap)throws RemoteException {
		List<NoticeVO> list = null;
		
		try {
			list = smc.queryForList("notice.getPaginNoticeList",pageMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Com_AnswerVO> getPaginAnswerList(Map<String, Integer> pageMap)throws RemoteException {
		List<Com_AnswerVO> list = null;
		
		try {
			list = smc.queryForList("notice.getPaginAnswerList",pageMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Com_QuestionVO> getPaginQuestionList(Map<String, Integer> pageMap)throws RemoteException {
		List<Com_QuestionVO> list = null;
		
		try {
			list = smc.queryForList("notice.getPaginQuestionList",pageMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public List<Notice_FileVO> getNoticeFileList(String notice_no)throws RemoteException {
		List<Notice_FileVO> list = null;
		try {
			list = smc.queryForList("notice.getNoticeFileList",notice_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	@Override
	public List<Answer_FileVO> getAnswerFileList(String com_ans_no)throws RemoteException {
		List<Answer_FileVO> list = null;
		try {
			list = smc.queryForList("notice.getAnswerFileList", com_ans_no);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Question_FileVO> getQuestionFileList(String com_que_no)throws RemoteException {
		List<Question_FileVO> list = null;
		try {
			list = smc.queryForList("notice.getQuestionFileList", com_que_no);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	


	@Override
	public List<Com_AnswerVO> getMyAnswerList(String mem_id)throws RemoteException {
		List<Com_AnswerVO> list = null;
		try {
			list = smc.queryForList("notice.getMyAnswerList", mem_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Com_QuestionVO> getMyQuestionList(String mem_id)throws RemoteException {
		List<Com_QuestionVO> list = null;
		try {
			list = smc.queryForList("notice.getMyQuestionList", mem_id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public boolean insertCom_Answer(Com_AnswerVO com_AnswerVO) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.insertCom_Answer",com_AnswerVO)==null) 
				state = true;
			
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean insertCom_Question(Com_QuestionVO com_QuestionVO) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.insertCom_Question",com_QuestionVO)==null)
				state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean insertNotice(NoticeVO noticeVO) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.insertNotice",noticeVO)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean insertAnswer_file(Answer_FileVO answer_FileVO) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.insertAnswer_file",answer_FileVO)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean insertQuestion_file(Question_FileVO question_FileVO) throws RemoteException {
		boolean state = false;
		try {
			 if(smc.insert("notice.insertQuestion_file",question_FileVO)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean insertNotice_file(Notice_FileVO fileVO) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.insertNotice_file",fileVO)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public List<Category_AVO> getCategory_AList() throws RemoteException {
		List<Category_AVO> list = null;
		try {
			list = smc.queryForList("notice.getCategory_AList");			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getNoiceSameFile(Map<String, String> map) throws RemoteException {
		int cnt = -1;
		
		try {
			cnt = (int) smc.queryForObject("notice.getNoiceSameFile", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return cnt;
	}

	@Override
	public boolean insertNotice_file2(Notice_FileVO fileVO) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.insertNotice_file2",fileVO)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean deleteNotice_File(Map<String, String> map) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.deleteNotice_File",map)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean deleteNotice(String notice_no) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.deleteNotice",notice_no)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean deleteAllNotice_File(String notice_no) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.deleteAllNotice_File",notice_no)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public boolean updataNotice(NoticeVO noticeVO) throws RemoteException {
		boolean state = false;
		try {
			if(smc.insert("notice.updataNotice",noticeVO)==null)
			 state = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public Category_AVO getCategoryInfo(String cat_a_no) throws RemoteException {
		Category_AVO info = null;
		try {
			info = (Category_AVO)smc.queryForObject("notice.getCategoryInfo",cat_a_no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public List<Com_QuestionVO> getCom_QuestionList() throws RemoteException {
		List<Com_QuestionVO> list = null;
		try {
			list = smc.queryForList("notice.getCom_QuestionList");			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getQuestionTotalcount() throws RemoteException {
		int cnt = -1;
		try {
			cnt = (int) smc.queryForObject("notice.getQuestionTotalcount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public void noticeUpCnt(String notice_no) throws RemoteException {
	
			try {
				smc.update("notice.noticeUpCnt",notice_no);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}


}