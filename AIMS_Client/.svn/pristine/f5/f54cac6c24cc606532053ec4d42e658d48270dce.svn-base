package kr.or.ddit.controller.AgreeView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.member.MemberController;

public class AgreeViewController {

	private MemberController membercontroller;
	
	public MemberController getMemberController() {
		return membercontroller;
	}
	
	public void setMemberController(MemberController membercontroller) {
		this.membercontroller = membercontroller;
	}
	private void setMemberController(AgreeViewController agreeViewController) {
		
	}
	
	
	
    public AnchorPane getViewAIMS() {
		return viewAIMS;
	}

	public void setViewAIMS(AnchorPane viewAIMS) {
		this.viewAIMS = viewAIMS;
	}



	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane viewAIMS;

    @FXML
    private CheckBox CKbox1;

    @FXML
    private CheckBox CKbox2;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

  
    
    
    // 취소 버튼을 눌렀을 떄
    @FXML
    void btnCancel(ActionEvent event) {	
		try {
			Stage currentStage = (Stage) cancel.getScene().getWindow();
			
			if(AlertUtil.showAlert(currentStage, "회원가입을 ","취소하시겠습니까?","확인","취소")) {
				FXMLLoader loader = new FXMLLoader(AgreeViewController.class.getResource("../../fxml/main/MainPage.fxml")); // 메인 화면으로 돌아가는거 경로 넣기
				Parent	root = loader.load();

			
				Scene scene = new Scene(root);
				currentStage.setScene(scene);
				currentStage.show();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    
    
    // 확인 버튼을 눌렀을 때
    @FXML
    void btnOk(ActionEvent event) {
    	
    	try {
			// 확인 버튼을 누르면  회원가입 창으로 이동하는거  화면 전환
    		
    		
    		FXMLLoader loader = new FXMLLoader(AgreeViewController.class.getResource("../../fxml/member/Member.fxml"));
    		Parent root = loader.load();
    		Stage currentStage = (Stage) ok.getScene().getWindow();
//    		AgreeViewController agree = loader.getController();
//    		agree.setMemberController(this);
    		
    		Scene scene = new Scene(root);
    		currentStage.setScene(scene);
    		currentStage.show();
    		
    		
    		
    		
		} catch (IOException e) {
			// TODO: handle exception
		}
    	
    	
    	
    	
    }

 


	@FXML
    void initialize() {
		
			ok.setDisable(true);
			CKbox1.selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if(newValue&&CKbox2.isSelected()) {
						ok.setDisable(false);
					}else {
						ok.setDisable(true);
					}
				}
			});
			
			CKbox2.selectedProperty().addListener(new ChangeListener<Boolean>() {
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					if(newValue&&CKbox1.isSelected()) {
						ok.setDisable(false);
					}else {
						ok.setDisable(true);
					}
				}
			});
		
    }
}
