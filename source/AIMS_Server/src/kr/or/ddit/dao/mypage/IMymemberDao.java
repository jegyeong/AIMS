package kr.or.ddit.dao.mypage;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

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


public interface IMymemberDao {
	
	
	// 관심물건 다 들고오는거 물건번호,물건명,경매날짜
	public List <InterestVO> getAllInterstProd(String mem_id);
	
	//  관심물건 삭제 
	public int delInterstProd(InterestVO intArtiVO);
	
	// 내 정보 수정  ==> 아이디는 수정이 안되는거 
	public int  updataMyInfo(MemberVO memVO);
	
	// 내 정보 가져오는 거
	public MemberVO getMyInfoList (String mem_id);
	
	
	
	// 내 질문 목록 가져오는거 
	public List<Com_QuestionVO> getMyQuestion(String mem_id);
	
	
	// 질문에 대한 답변 가져오는거 
	public Com_AnswerVO getMyAnswer(Map<String,String> data);
	
	
	
	// 내 경매 내역 가져오는거 (물건번호, 물건이름, 경매결과)
	public List<Auction_RecordVO> getMyArticle(String mem_id);
	
	
	
	// 회원탈퇴--> 회원 활동을 하고 있다 없다로 표시 하는거 
	public int updateActive(String  mem_id);
	
	// 경매 결과 
	public int delAresult(Article_ResultVO aresult) throws RemoteException;	
	
	// 상세 나의 경매 일정 
	public List<A_articleVO> getMydetailSH(Map<String,String> info) throws RemoteException;
	
	public List<Answer_FileVO> getAnswerFileList(String COM_ANS_NO)throws RemoteException;
	
}
