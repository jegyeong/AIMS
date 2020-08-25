package kr.or.ddit.controller.notice.user;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.main.MainPageController;
import kr.or.ddit.main.search.FXMLSearchMain;
import kr.or.ddit.session.Session;

public class NoticeMainController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox btnArea;

    @FXML
    private Button btn_notice;

    @FXML
    private Button btn_Answer;

    @FXML
    private AnchorPane contentsArea;
    
    @FXML
    private Button btn_Home;

    @FXML
    void onClickedBtn_Home(ActionEvent event) {
    	Stage stage = (Stage)btnArea.getScene().getWindow();
    	
		try {
			Parent root = FXMLLoader.load(FXMLSearchMain.class.getResource("../../fxml/main/MainPage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("검색");
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void setDialog(String name) {
    	if(name.equals("notice")) {
    		try {
        		Parent  root =FXMLLoader.load(NoticeMainController.class.getResource("../../../fxml/notice/user/Notice.fxml")); 	
        		contentsArea.getChildren().clear();
        		contentsArea.getChildren().addAll(root);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}else if(name.equals("answer")) {
    		
        		try {
            		FXMLLoader loader = new FXMLLoader(NoticeMainController.class.getResource("../../../fxml/notice/user/Qusetion.fxml"));
            		QuestionController controller = loader.getController();
            		Parent  root = loader.load();
        			contentsArea.getChildren().clear();
        			contentsArea.getChildren().addAll(root);
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	

    	}
    }
    
    @FXML
    void onClickedeBtn_Answer(ActionEvent event) {
    	Stage stage = (Stage)btn_Answer.getScene().getWindow();
    	
    	if(Session.loginUser==null) {
    		if(AlertUtil.showAlert(stage,"로그인이 필요합니다.", "민원접수는 회원만 가능합니다.", "로그인", "취소")) {
    			try {
    				FXMLLoader loader = new FXMLLoader(MainPageController.class.getResource("../../fxml/login/Login.fxml"));
    				Parent root =loader.load();			
    				Scene scene = new Scene(root);
    				stage.setScene(scene);
    				stage.setTitle("로그인");
    				stage.show();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}else {
    		try {
        		FXMLLoader loader = new FXMLLoader(NoticeMainController.class.getResource("../../../fxml/notice/user/Qusetion.fxml"));
        		QuestionController controller = loader.getController();
        		Parent  root = loader.load();
        		contentsArea.getChildren().clear();
    			contentsArea.getChildren().addAll(root);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	
    }

    @FXML
    void onClickedeBtn_Notice(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(NoticeMainController.class.getResource("../../../fxml/notice/user/Notice.fxml"));
    		Parent  root = loader.load();
    		NoticeController controller = loader.getController();
    		contentsArea.getChildren().clear();
			contentsArea.getChildren().addAll(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	setDialog("answer");

    	
    }
}
