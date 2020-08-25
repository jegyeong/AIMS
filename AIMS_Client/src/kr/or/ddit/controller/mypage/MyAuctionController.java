package kr.or.ddit.controller.mypage;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.A_articleJoinArticle_resutVO;
import kr.or.ddit.vo.ArticleInterestMemVO;
import kr.or.ddit.vo.AuctionVO;
import kr.or.ddit.vo.Auction_RecordVO;




// 내 경매 내역 화면

public class MyAuctionController {
	
	private IMymemberService service;
	private ObservableList<Auction_RecordVO> data;
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Auction_RecordVO> auctionResult;
    
    // 물건번호
    @FXML
    private TableColumn<?, ?> prodNum;

    // 물건 이름
    @FXML
    private TableColumn<?, ?> prodName;

    // 경매 결과 
    @FXML
    private TableColumn<?, ?> acResult;

    private void setArticleData() throws RemoteException {
    	
    	
			
    	List<Auction_RecordVO> articleList = service.getMyArticle(Session.loginUser.getMem_id());
    	data = FXCollections.observableArrayList(articleList);
    	auctionResult.setItems(data);
    	
    
    }
    
    @FXML
    void initialize() throws RemoteException{
       
    	try {
    		
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			
			service = (IMymemberService) reg.lookup("IMymemberService");
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}catch (NotBoundException e) {
			
			e.printStackTrace();
			
		}
    	
    	
    	
    	prodNum.setCellValueFactory(new PropertyValueFactory<>("a_art_no") );
    	prodName.setCellValueFactory(new PropertyValueFactory<>("a_art_name"));
    	acResult.setCellValueFactory(new PropertyValueFactory<>("a_result"));
    	
    	
    	
    	setArticleData();
    	
    	
    
    }
}
