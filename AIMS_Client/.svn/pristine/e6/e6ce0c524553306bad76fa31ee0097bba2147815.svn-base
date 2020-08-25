package kr.or.ddit.controller.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.controller.mypage.MymemberController;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.MemberVO;

public class MainPageLoginController {
	// 세션에 저장된값 가져옴
	private AnchorPane dialog;

	public AnchorPane getDialog() {
		return dialog;
	}

	public void setDialog(AnchorPane dialog) {
		this.dialog = dialog;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label label_id;

	@FXML
	private Button btn_myPage;

	@FXML
	private Button btn_logOut;

	@FXML
	void btn_logOut_clicked(MouseEvent event) {
		try {
			Session.loginUser = null;
			FXMLLoader loader = new FXMLLoader(
					MainPageController.class.getResource("../../fxml/main/MainPageYetLogin.fxml"));
			Parent root = loader.load();
			
			dialog.getChildren().clear();
			dialog.getChildren().add(root);

		} catch (IOException e) {
			e.printStackTrace();
		}
    	
	}

	@FXML
	void btn_myPage_clicked(MouseEvent event) {
		if(btn_myPage.getText().equals("관리 페이지")) {

			try {
				FXMLLoader loader = new FXMLLoader(MainPageLoginController.class.getResource("../../fxml/adminmain/AdminMain.fxml"));
				Parent root = loader.load();
				
				Scene scene = new Scene(root);
				Stage stage = (Stage) btn_logOut.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {

			try {
				FXMLLoader loader = new FXMLLoader(MainPageLoginController.class.getResource("../../fxml/mypage/Mymember.fxml"));
				Parent root = loader.load();
				MymemberController myMemCon = loader.getController();
				Scene scene = new Scene(root);
				Stage stage = (Stage) btn_logOut.getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}

	@FXML
	void initialize() {
		if(Session.loginUser.getMem_id().equals("admin")) {
			btn_myPage.setText("관리 페이지");
		}
		
		
		label_id.setText(Session.loginUser.getMem_name());
	}
}
