package kr.or.ddit.controller.knowledge.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.A_FormVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.Form_FileVO;

public class FormatAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField titleTf;

    @FXML
    private ListView<File> fileList;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnHome;

    private IKnowledgeService service;
    
    @FXML
    void btnAddClick(ActionEvent event) {
    	try {
    		Parent alert = FXMLLoader.load(FormatAddController.class.getResource("../../../AlertDialog/AlertDialog2.fxml"));
    		Stage add = (Stage) btnAdd.getScene().getWindow();
    		String yes = "예";
    		String no = "아니오";
    		
    		
    		if(AlertUtil.showAlert(add, "등록하시겠습니까?", "", yes, no)) {
    			A_FormVO form = new A_FormVO();
    			form.setA_form_name(titleTf.getText());
    			
    			String a_form_no = service.insertForm(form);
    			
    			
    			for(File file : fileList.getItems()) {
    				FileInputStream fis = new FileInputStream(file);
    				System.out.println((int) file.length());
    				byte[] buffer = new byte[(int) file.length()] ;
    				fis.read(buffer);
    				
    				FileInfoVO infoVO = new FileInfoVO();
    				infoVO.setFileData(buffer);
    				infoVO.setFileName(file.getName());
    				
        			Form_FileVO form_FileVO = new Form_FileVO();
        			form_FileVO.setA_form_no(a_form_no);
        			form_FileVO.setForm_f_addr(service.clientToServer("FormFile", infoVO));
        			
        			service.insertFile(form_FileVO);
    			}
    			
    			
    		}
    	
    		Stage stage = (Stage) btnHome.getScene().getWindow();
        	Parent main = FXMLLoader.load(FormatAddController.class.getResource("../../../fxml/knowledge/admin/adminKnowledgeFormat.fxml"));
        	
        	Scene scene = new Scene(main);
        	stage.setScene(scene);
        	stage.show();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnHome.getScene().getWindow();
    	Parent main = FXMLLoader.load(FormatAddController.class.getResource("../../../fxml/knowledge/admin/adminKnowledgeMain.fxml"));
    	
    	Scene scene = new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void btnSearchClick(ActionEvent event) {
    	Stage search = (Stage) btnSearch.getScene().getWindow();
    	
    	FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
			new ExtensionFilter("All File", "*.*"),
			new ExtensionFilter("Text File", "*.txt"),
			new ExtensionFilter("Image File", "*.png", "*.jpg", "*,gif")
		);
		
		File showDir = new File("d:/");
		fileChooser.setInitialDirectory(showDir);
		
		List<File> selectedFile = fileChooser.showOpenMultipleDialog(search);
		if(selectedFile != null) {
			for(int i = 0; i < selectedFile.size(); i++) {
				fileList.getItems().add(selectedFile.get(i));
			}
		}
    	
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
    	
    	fileList.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				File file = fileList.getSelectionModel().getSelectedItem();
				if(file == null) return;
				
				fileList.getItems().remove(file);
				
			}
		});
    }
}
