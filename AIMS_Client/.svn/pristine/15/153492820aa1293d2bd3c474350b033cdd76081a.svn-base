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

public class TermsEditController {

	private AdminKnowledgeTermsController termController;

    public AdminKnowledgeTermsController getMainController() {
		return termController;
	}

	public void setMainController(AdminKnowledgeTermsController termController) {
		this.termController = termController;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField termsTf;

    @FXML
    private TextArea exTxtArea;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnEdit;
    
    private A_TerminologyVO termVo;

    private IKnowledgeService service;
    
    @FXML
    void btnDelClick(ActionEvent event) {
    	try {
    		Parent alert = FXMLLoader.load(TermsEditController.class.getResource("../../AlertDialog/AlertDialog2.fxml"));
    		Stage del = (Stage) btnDel.getScene().getWindow();
    		String yes = "예";
    		String no = "아니오";
    		boolean a = AlertUtil.showAlert(del, "삭제하시겠습니까?", "", yes, no);
    		int cnt = 0;
    		if(a == false) {
    			return;
    		}else {
    			termVo.setA_ter_name(termsTf.getText());
//    			termVo.setA_ter_content(exTxtArea.getText());
    			
    			cnt = service.deleteTerms(termVo);
    		}
			
    		if(cnt > 0) {
    			AlertUtil.showAlert(del, "삭제하였습니다.");
    		}else {
    			AlertUtil.showAlert(del, "삭제 작업 실패!!");
    		}
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

    @FXML
    void btnEditClick(ActionEvent event) {
    	try {
    		Parent alert = FXMLLoader.load(TermsEditController.class.getResource("../../../AlertDialog/AlertDialog2.fxml"));
    		Stage edit = (Stage) btnEdit.getScene().getWindow();
    		String yes = "예";
    		String no = "아니오";
    		boolean a = AlertUtil.showAlert(edit, "수정하시겠습니까?", "", yes, no);
    		int cnt = 0;
    		if(a == false) {
    			return;
    		}else {
    			termVo.setA_ter_name(termsTf.getText());
    			termVo.setA_ter_content(exTxtArea.getText());
    			
    			cnt = service.updateTerms(termVo);
    			
//    			AlertUtil.showAlert(edit, "수정 완료");
    		}
    		
    		if(cnt > 0) {
    			AlertUtil.showAlert(edit, "수정하였습니다.");
    		}else {
    			AlertUtil.showAlert(edit, "수정 작업 실패!!");
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnHome.getScene().getWindow();
    	Parent main = FXMLLoader.load(TermsEditController.class.getResource("../../../fxml/knowledge/admin/adminKnowledgeTerms.fxml"));
    	
    	Scene scene = new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }

    public void show(A_TerminologyVO termVo) {
    	this.termVo = termVo;
    	termsTf.setText(termVo.getA_ter_name());
    	exTxtArea.setText(termVo.getA_ter_content());
    }
    
    @FXML
    void initialize() {
    	try {
			Registry reg = LocateRegistry.getRegistry(8888);
			
			service = (IKnowledgeService) reg.lookup("knowledge");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

    }
}
