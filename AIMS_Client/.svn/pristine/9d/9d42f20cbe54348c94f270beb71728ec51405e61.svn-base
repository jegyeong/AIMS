package kr.or.ddit.controller.knowledge.user;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.A_FormJoinForm_FileVO;
import kr.or.ddit.vo.A_TerminologyVO;

public class AuctionTermsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField searchTf;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<A_TerminologyVO> termsTable;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    void btnSearchClick(ActionEvent event) {
    	try {
    		String a_ter_name = searchTf.getText();
	    	
//    		if(a_ter_name.isEmpty()) {
//	    		return;
//	    	}
	    	List<A_TerminologyVO> termList = null;
	    	termList = service.searchTerms(a_ter_name);
	    	
	    	if(termList == null) {
//	    		System.out.println("정보가 없습니다.");
	    	}else {
	    		termsTable.setItems(FXCollections.observableArrayList(termList));
	    	}
	    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    private IKnowledgeService service;
    private ObservableList<A_TerminologyVO> data;
    private TermShowController showController;
    
    private void setData() {
    	try {
	    	List<A_TerminologyVO> termVo = service.getAllTerm();
	    	data = FXCollections.observableArrayList(termVo);
	    	termsTable.setItems(data);
    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
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
    	
        nameCol.setCellValueFactory(new PropertyValueFactory<>("a_ter_name"));
        
        termsTable.setOnMouseClicked(e -> {
        	try {
    	    	if(termsTable.getSelectionModel().isEmpty()) {
    	    		return;
    	    	}
    	    	try {
    	    		Stage mainStage = (Stage) termsTable.getScene().getWindow();
    	    		FXMLLoader loader = new FXMLLoader(AuctionTermsController.class.getResource("../../../fxml/knowledge/user/termShow.fxml"));
    	        	Parent root = loader.load();
    	        	showController = loader.getController();
    	        	
    	        	if(!termsTable.getSelectionModel().isEmpty()) {
    	        		A_TerminologyVO termVo = termsTable.getSelectionModel().getSelectedItem();
    	        		
    	        		showController.show(termVo);
    	        	}
    	        	
    	        	Stage stage = new Stage(StageStyle.DECORATED);
    	        	stage.initModality(Modality.APPLICATION_MODAL);
    	        	stage.initOwner(mainStage);
    	        	
    	        	Scene scene = new Scene(root);
    	        	stage.setScene(scene);
    	        	stage.show();
    	    		
    			} catch (IOException e2) {
    			  e2.printStackTrace();
    			}
    	    	} catch (Exception e3) {
    	    		e3.printStackTrace();
    	    	}
        });
        
        setData();
    }
}
