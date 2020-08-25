package kr.or.ddit.dao.mypage;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.BuildedSqlMapClient;
import kr.or.ddit.vo.A_articleJoinArticle_resutVO;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.Answer_FileVO;
import kr.or.ddit.vo.ArticleInterestMemVO;
import kr.or.ddit.vo.Article_ResultVO;
import kr.or.ddit.vo.Auction_RecordVO;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.InterestArticleVO;
import kr.or.ddit.vo.InterestVO;
import kr.or.ddit.vo.MemberVO;



public class MymemberDaoImpl implements IMymemberDao {

	private SqlMapClient smc;
	
	private static MymemberDaoImpl dao;
	
	public MymemberDaoImpl() {
		
		
		smc = BuildedSqlMapClient.getSqlMapClient();
		
	}
	
	public static MymemberDaoImpl getInstance() {
		if(dao == null) dao =new MymemberDaoImpl();
		
		return dao;
	}
	
	
	// 관심 물건 다 가지고 오는거 
	@Override
	public List<InterestVO> getAllInterstProd(String mem_id) {
		List<InterestVO> interestList = null;
		try {
			interestList = smc.queryForList("mymember.getAllInterstProd",mem_id);
		} catch (SQLException e) {
			interestList = null;
			e.printStackTrace();
		}
		return interestList;
	}
	
	// 내정보 수정  아이디는 수정 안됨
	@Override
	public int updataMyInfo(MemberVO memVO) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updataMyInfo", memVO);
			if(cnt >0 ) {
				System.out.println("update 작업성공!");
			}else {
				System.out.println("update 작업실패...");
			}
		} catch (Exception e) {
			memVO = null;
			e.printStackTrace();
		}
				
		return cnt;
	}
	
	// 내 정보 다 가져오는거 
	@Override
	public MemberVO getMyInfoList(String mem_id) {
		MemberVO myInfo = null;
		try {
			myInfo = (MemberVO) smc.queryForObject("mymember.getMyInfoList",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myInfo;
	}
	

		
	// 내 경매 내역 
	@Override
	public List<Auction_RecordVO> getMyArticle(String mem_id) {
		List<Auction_RecordVO> myAuctionList = null;
		try {
			myAuctionList = smc.queryForList("mymember.getMyArticle",mem_id);
		} catch (SQLException e) {
			myAuctionList = null;
			e.printStackTrace();
		} 
		return myAuctionList;
	}

	// 회원 탈퇴 
	@Override
	public int updateActive(String  mem_id) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updateActive", mem_id);
			if(cnt >0 ) {
				System.out.println("update 작업성공!");
			}else {
				System.out.println("update 작업실패...");
			}
		} catch (Exception e) {
			mem_id = null;
			e.printStackTrace();
		}
				
		return cnt;
		
		
		
		
		
		
	}

	// 내 질문 가져오기
	@Override
	public List<Com_QuestionVO> getMyQuestion(String mem_id) {
		List <Com_QuestionVO> myQyestion = null;
		try {
			myQyestion = smc.queryForList("mymember.getMyQuestion",mem_id);
		} catch (SQLException e) {
			myQyestion = null;
			e.printStackTrace();
		}
		
		return myQyestion;
	}
	
	
	
	
	// 내 질문에 대한 답변
	@Override
	public Com_AnswerVO getMyAnswer(Map<String,String> data) {
			Com_AnswerVO myAnswer = null;
		try {
			myAnswer = (Com_AnswerVO)smc.queryForObject("mymember.getMyAnswer",data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myAnswer;
	}
	
	
	// 내 관심 물건 삭제
	@Override
	public int delInterstProd(InterestVO intArtiVO) {
		int cnt = 0;
		try {
			cnt = smc.delete("mymember.deleteMySec",intArtiVO);
			if(cnt>0) {
				System.out.println("delete 작업성공!!");
			}else {
				System.out.println("delete 작없실패..");
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
			return cnt;
	}

	// 경매 결과 삭제
	@Override
	public int delAresult(Article_ResultVO aresult) throws RemoteException {
		int cnt = 0;
		try {
			cnt = smc.delete("mymember.delAresult",aresult);
			if(cnt>0) {
				System.out.println("delete 작업성공!!");
			}else {
				System.out.println("delete 작없실패..");
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
			return cnt;		
	}
	
	
	// 내 상세 경매일정 
	@Override
	public List<A_articleVO> getMydetailSH(Map<String,String> info) throws RemoteException {
		List <A_articleVO> getMydetail = null;
		try {
			getMydetail = smc.queryForList("detailMySH.getMydetailSH",info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return getMydetail;
	}

	@Override
	public List<Answer_FileVO> getAnswerFileList(String COM_ANS_NO) throws RemoteException {
		List <Answer_FileVO> getMydetail = null;
		try {
			getMydetail = smc.queryForList("mymember.getAnswerFileList",COM_ANS_NO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getMydetail;
	}
	
	
	

	
}
