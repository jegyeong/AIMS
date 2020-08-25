package kr.or.ddit.controller.knowledge.user;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.main.search.FXMLSearchMain;
import kr.or.ddit.service.knowledge.IKnowledgeService;

public class KnowledgeMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStep;

    @FXML
    private Button btnTerms;

    @FXML
    private Button btnFormat;

    @FXML
    private Button btnGuide;

    @FXML
    private Button btnLaw;

    @FXML
    private AnchorPane subAnchor;

    @FXML
    private Button btnHome;

    @FXML
    void btnBackClick(ActionEvent event) {
    	Stage stage = (Stage)btnHome.getScene().getWindow();
    	
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

    @FXML
    void btnFormatClick(ActionEvent event) throws IOException {
    	setAADialog("../../../fxml/knowledge/user/auctionFormat.fxml");
    }

    @FXML
    void btnGuideClick(ActionEvent event) throws IOException {
    	setAADialog("../../../fxml/knowledge/user/guide.fxml");
    }

    @FXML
    void btnLawClick(ActionEvent event) throws IOException {
    	setAADialog("../../../fxml/law/fxmlLaw.fxml");
    }

    @FXML
    void btnStepClick(ActionEvent event) throws IOException {
    	setAADialog("../../../fxml/knowledge/user/auctionStep.fxml");
    }

    @FXML
    void btnTermsClick(ActionEvent event) throws IOException {
    	setAADialog("../../../fxml/knowledge/user/auctionTerms.fxml");
    }
    
    public void setAADialog(String path) {
		try {
			Parent root = FXMLLoader.load(KnowledgeMainController.class.getResource(path));
		
			if (subAnchor.getChildren().size() != 0) {
				for (int i = 0; i < subAnchor.getChildren().size(); i++) {
					subAnchor.getChildren().remove(i);
				}
			}
			subAnchor.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    private IKnowledgeService service;
    @FXML
    void initialize() {
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			
			service = (IKnowledgeService) reg.lookup("knowledge");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	try {
			
    	Parent step = FXMLLoader.load(KnowledgeMainController.class.getResource("../../../fxml/knowledge/user/auctionStep.fxml"));
    	
    	for(int i = 0; i < subAnchor.getChildren().size(); i++) {
    		subAnchor.getChildren().remove(i);
    	}
    	subAnchor.getChildren().addAll(step);
    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    }
}