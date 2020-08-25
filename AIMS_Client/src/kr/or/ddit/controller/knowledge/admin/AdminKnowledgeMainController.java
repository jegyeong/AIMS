package kr.or.ddit.controller.knowledge.admin;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import kr.or.ddit.controller.stuff.AdminMainController;
import kr.or.ddit.service.knowledge.IKnowledgeService;

public class AdminKnowledgeMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainAnchor;
    
    @FXML
    private Button btnTerms;

    @FXML
    private Button btnLaw;

    @FXML
    private Button btnFormat;
    
    @FXML
    private Button btnHome;

    @FXML
    void btnFormatClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	Parent format = FXMLLoader.load(Class.forName("kr.or.ddit.controller.knowledge.admin.AdminKnowledgeMainController").getResource("../../../fxml/knowledge/admin/adminKnowledgeFormat.fxml"));
    	
    	for(int i = 0; i < mainAnchor.getChildren().size(); i++) {
    		mainAnchor.getChildren().remove(i);
    	}
    	mainAnchor.getChildren().addAll(format);
    }

    @FXML
    void btnLawClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	Parent law = FXMLLoader.load(Class.forName("kr.or.ddit.controller.knowledge.admin.AdminKnowledgeMainController").getResource("../../../fxml/knowledge/admin/adminKnowledgeLaw.fxml"));
    	
    	for(int i = 0; i < mainAnchor.getChildren().size(); i++) {
    		mainAnchor.getChildren().remove(i);
    	}
    	mainAnchor.getChildren().addAll(law);
    }

    @FXML
    void btnTermsClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	Parent terms = FXMLLoader.load(Class.forName("kr.or.ddit.controller.knowledge.admin.AdminKnowledgeMainController").getResource("../../../fxml/knowledge/admin/adminKnowledgeTerms.fxml"));
    	
    	for(int i = 0; i < mainAnchor.getChildren().size(); i++) {
    		mainAnchor.getChildren().remove(i);
    	}
    	mainAnchor.getChildren().addAll(terms);
    }
    
    @FXML
    void btnHomeClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.knowledge.admin.AdminKnowledgeMainController").getResource("../../../fxml/adminmain/AdminMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnHome.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("관리자 메인 페이지");
    	stage.show();
    }

    private IKnowledgeService service;
    @FXML
    void initialize() {
//    	Font.loadFont(getClass().getResourceAsStream("/DoHyeon-Regular.ttf"), 20);
    }
}
