package kr.or.ddit.controller.knowledge.admin;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.A_TerminologyVO;

public class TermsAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField termsTf;

    @FXML
    private TextArea exTxtArea;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnHome;

    private IKnowledgeService service;
    
    @FXML
    void btnAddClick(ActionEvent event) throws IOException {
    	try {
			
		Parent alert = FXMLLoader.load(TermsAddController.class.getResource("../../../AlertDialog/AlertDialog2.fxml"));
		Stage add = (Stage) btnAdd.getScene().getWindow();
		String yes = "예";
		String no = "아니오";
		boolean a = AlertUtil.showAlert(add, "등록 하시겠습니까?", "", yes, no);
		int cnt = 0;
		if(a == false) {
			return;
		}else {
			A_TerminologyVO term = new A_TerminologyVO();
			term.setA_ter_name(termsTf.getText());
			term.setA_ter_content(exTxtArea.getText());
			
			cnt = service.insertTerms(term);
			
			termsTf.clear();
			exTxtArea.clear();
		}
		
		if(cnt > 0) {
			AlertUtil.showAlert(add, "등록하였습니다.");
		}else {
			AlertUtil.showAlert(add, "등록 작업 실패!!");
		}
		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnHome.getScene().getWindow();
    	Parent terms = FXMLLoader.load(TermsAddController.class.getResource("../../../fxml/knowledge/admin/adminKnowledgeTerms.fxml"));
    	
    	Scene scene = new Scene(terms);
    	stage.setScene(scene);
    	stage.show();
    }

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

    }
}
