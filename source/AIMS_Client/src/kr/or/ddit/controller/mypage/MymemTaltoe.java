package kr.or.ddit.controller.mypage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.MemberVO;


public class MymemTaltoe {
	
	private IMymemberService service;
	private ObservableList<MemberVO> memberInfoList;
	private MemberVO memInfoVO;
	
	private MymemTaltoe mymemTaltoe;
	
	public MymemTaltoe getMymemberTaltoe() {
		return mymemTaltoe;
	}
	
	public void setMymemTaltoe(MymemTaltoe mymemTaltoeCont) {
		this.mymemTaltoe = mymemTaltoeCont;
	}
	
	
	@FXML
	private AnchorPane taltoeView;
	  
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField input;

    @FXML
    private Button confirm;
    
    @FXML
    void taltoeView(MouseEvent event) {

    }
    // 회원탈퇴 화면에서 확인 버튼 
    @FXML
    void btnCon(ActionEvent event) throws IOException {
  
    		
    	// 회원 탈퇴 버튼에서 확인을 눌렀을떄  비밀번호가 확인여부 alert창 띄우기
//    	memInfoVO = service.getMyInfoList(Session.loginUser.getMem_id());
//    	String  pass = input.getText();
//    	
    	
    	
    	if(input.getText().equals(Session.loginUser.getMem_pass())){
    		
    		Stage stage = (Stage) taltoeView.getScene().getWindow();
    		
    		if(AlertUtil.showAlert(stage, "탈퇴  ", "하시겠습니까?", "예", "아니오")) {
    			int cnt = service.updateActive(Session.loginUser.getMem_id());
    			Session.loginUser = null;
    			FXMLLoader loader = new FXMLLoader (MymemberController.class.getResource("../../fxml/main/MainPage.fxml")); // 홈으로 이동하는곳 나중에
    			Parent root = loader.load();
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.show();
    		}

		

		}else{
    		
			Stage currentStage = (Stage) taltoeView.getScene().getWindow();
			AlertUtil.showAlertOnlyConfirm(currentStage, "비밀번호가 다릅니다.", "확인");

//			FXMLLoader loader = new FXMLLoader(
//					MymemberController.class.getResource("../../fxml/mypage/MySchedual.fxml")); // 홈으로 이동하는곳 나중에
//																								// fxml바꾸기
//			Parent root = loader.load();
//
//			for (int i = 0; i < taltoeView.getChildren().size(); i++) {
//					taltoeView.getChildren().remove(i);
//				}
//			taltoeView.getChildren().addAll(root);
			
    	}
    	
  
    	
    	
    }

    @FXML
    void inputpass(ActionEvent event) {

    }

    @FXML
    void initialize() {
     
    	try {
    		
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
    	  
    	  service = (IMymemberService) reg.lookup("IMymemberService");
    	  
    	} catch (RemoteException e) {
    		e.printStackTrace();
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
      
    }
}
