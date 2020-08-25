package kr.or.ddit.controller.adminmain;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import kr.or.ddit.controller.stuff.AdminMainController;
import kr.or.ddit.service.InoticeServer;
import kr.or.ddit.service.main.ImainService;
import kr.or.ddit.service.stuff.IAdminService;
import kr.or.ddit.session.Session;

public class AdminMain {
	private InoticeServer service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnMember;

    @FXML
    private Button btnStuff;

    @FXML
    private Button btnNotice;

    @FXML
    private Button btnInfo;

    @FXML
    private Button btnKnow;

    @FXML
    private Label adminId;

    @FXML
    private Label lblAdminId;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnHome;

    @FXML
    private ListView<?> listView;

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException {// 홈으로 버튼
    	FXMLLoader loader = new FXMLLoader(AdminMain.class.getResource("../../fxml/main/MainPage.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("메인 페이지");
    	stage.show();
    }

    @FXML
    void btnInfoClick(ActionEvent event) throws IOException { //이용안내 관리
    	FXMLLoader loader = new FXMLLoader(AdminMain.class.getResource("../../fxml/InformationUse/ManegerMainTemplate.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("이용안내관리페이지");
    	stage.show();
    }

    @FXML
    void btnKnowClick(ActionEvent event) throws IOException { // 경매 지식 관리
    	FXMLLoader loader = new FXMLLoader(AdminMain.class.getResource("../../fxml/knowledge/admin/adminKnowledgeMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("경매지식관리페이지");
    	stage.show();
    }

    @FXML
    void btnLogoutClick(ActionEvent event) {// 로그아웃
    	Session.loginUser = null;
    	
    	try {
    	FXMLLoader loader = new FXMLLoader(AdminMain.class.getResource("../../fxml/main/MainPage.fxml"));
    	Parent root = loader.load();
			
		
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.show();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnMemberClick(ActionEvent event) throws IOException { //회원정보 관리 클릭
    	FXMLLoader loader = new FXMLLoader(AdminMain.class.getResource("../../fxml/adminmypage/MemberInfo.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("회원정보관리페이지");
    	stage.show();
    }

    @FXML
    void btnNoticeClick(ActionEvent event) throws IOException {//공지사항관리
    	FXMLLoader loader = new FXMLLoader(AdminMain.class.getResource("../../fxml/notice/admin/NoticeAdminMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("공지사항관리페이지");
    	stage.show();
    }

    @FXML
    void btnStuffClick(ActionEvent event) throws IOException {// 물건정보 관리
    	FXMLLoader loader = new FXMLLoader(AdminMain.class.getResource("../../fxml/stuff/fxmlAdminMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("물건관리페이지");
    	stage.show();
    }

    @FXML
    void initialize() {
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118", 8888);
			service = (InoticeServer) reg.lookup("notice");

		} catch (RemoteException e) {
			e.printStackTrace();

		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	adminId.setText(Session.loginUser.getMem_id());
    	lblAdminId.setText(Session.loginUser.getMem_id());
    	
    	
    }
}
