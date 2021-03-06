package kr.or.ddit.controller.InformationUse;

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
import kr.or.ddit.controller.login.loginController;
import kr.or.ddit.controller.main.MainPageController;
import kr.or.ddit.controller.stuff.AdminMainController;


public class ManagerMainTemplateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox btnArea;

    @FXML
    private Button btnFAQ;

    @FXML
    private Button btnAgency;

    @FXML
    private Button btnSiteMap;

    @FXML
    private AnchorPane contentsArea;

    @FXML
    private Button btnHome;

    @FXML
    void btnAgencyClicked(ActionEvent event) throws ClassNotFoundException {

    	try {
    		FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.InformationUse.ManagerMainTemplateController").getResource("../../fxml/InformationUse/ManagerAgency.fxml")); 
			Parent root = loader.load();
			ManagerAgencyController controller = loader.getController();
			controller.setDialog(contentsArea);
			//뭐가 있으면 지워주기
			if(contentsArea.getChildren().size()!=0) {
				for(int i=0; i<contentsArea.getChildren().size(); i++) {
					contentsArea.getChildren().remove(i);
				}
			}
			contentsArea.getChildren().add(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnFAQClicked(ActionEvent event) throws ClassNotFoundException {
    	try {
    		
    		FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.InformationUse.ManagerMainTemplateController").getResource("../../fxml/InformationUse/ManagerFAQ.fxml")); 
			Parent root = loader.load();
			ManagerFAQController mfaqCon = loader.getController();
			mfaqCon.setContentsArea(contentsArea);
			
//			Parent root = FXMLLoader.load(ManagerMainTemplateController.class.getResource("../fxml/ManagerFAQ.fxml"));
			if(contentsArea.getChildren().size()!=0) {
				for(int i=0; i<contentsArea.getChildren().size(); i++) {
					contentsArea.getChildren().remove(i);
				}
			}
			contentsArea.getChildren().add(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnHomeClicked(ActionEvent event) throws IOException, ClassNotFoundException { //홈으로
    	//if(AlertUtil.showAlert((Stage) btnFAQ.getScene().getWindow(), "메인페이지로  ", "이동하시겠습니까?", "이동", "취소")) {
			FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.InformationUse.ManagerMainTemplateController").getResource("../../fxml/adminmain/AdminMain.fxml"));
	    	Parent root = loader.load();
	    	  	
	    	Stage stage = (Stage) btnFAQ.getScene().getWindow(); 
	    	Scene scene = new Scene(root);
	    	
	    	stage.setScene(scene);
	    	stage.setTitle("관리자 메인 페이지");
	    	stage.show();
		};
    //}

    @FXML
    void btnSiteMapClicked(ActionEvent event) throws ClassNotFoundException {
    	try {
			Parent root = FXMLLoader.load(Class.forName("kr.or.ddit.controller.InformationUse.ManagerMainTemplateController").getResource("../../fxml/InformationUse/SiteMap.fxml"));
			if(contentsArea.getChildren().size()!=0) {
				for(int i=0; i<contentsArea.getChildren().size(); i++) {
					contentsArea.getChildren().remove(i);
				}
			}
			contentsArea.getChildren().add(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    

    @FXML
    void initialize() {
    	try {
    		
			FXMLLoader loader = new FXMLLoader(
					MainTemplateController.class.getResource("../../fxml/InformationUse/ManagerFAQ.fxml"));
			Parent root = loader.load();
			ManagerFAQController mfaqCon = loader.getController();
			mfaqCon.setContentsArea(contentsArea);
			contentsArea.getChildren().clear();
			contentsArea.getChildren().add(root);

		} catch (IOException e) {
			e.printStackTrace();

		}
    }
}
