package kr.or.ddit.controller.notice.admin;

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
import kr.or.ddit.controller.stuff.AdminMainController;

public class NoticeAdminMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox btnArea;

    @FXML
    private Button btn_notice;

    @FXML
    private Button btn_Com;

    @FXML
    private AnchorPane contentsArea;
    
    @FXML
    private Button btnHome;

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(NoticeAdminMainController.class.getResource("../../../fxml/adminmain/AdminMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("관리자 메인 페이지");
    	stage.show();
    }
    
    @FXML
    void onClickedeBtn_Com(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(NoticeAdminMainController.class.getResource("../../../fxml/notice/admin/NoticComplainListAdmin.fxml"));
    		Parent root = loader.load();
    	
    		NoticeComplainListController controller = loader.getController();
    		controller.setDialog(contentsArea);
    		contentsArea.getChildren().remove(0);
			contentsArea.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void onClickedeBtn_Notice(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(NoticeAdminMainController.class.getResource("../../../fxml/notice/admin/NoticeAdmin.fxml"));
    		Parent root = loader.load();
    	
    		NoticeAdminController controller = loader.getController();
    		controller.setDialog(contentsArea);
    		contentsArea.getChildren().remove(0);
			contentsArea.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	try {
//			Parent root = FXMLLoader.load(NoticeAdminMainController.class.getResource("../../../fxml/notice/admin/NoticeAdmin.fxml"));
    		FXMLLoader loader = new FXMLLoader(NoticeAdminMainController.class.getResource("../../../fxml/notice/admin/NoticeAdmin.fxml"));
    		Parent root = loader.load();
    	
    		NoticeAdminController controller = loader.getController();
    		controller.setDialog(contentsArea);
			contentsArea.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
