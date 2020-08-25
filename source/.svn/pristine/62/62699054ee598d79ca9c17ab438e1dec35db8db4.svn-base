package kr.or.ddit.controller.knowledge.user;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.Related_LawVO;

public class LawController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField searchTf;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<Related_LawVO> lawTable;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> exCol;

    @FXML
    void btnSearchClick(ActionEvent event) {
    	try {
    		String rel_l_name = searchTf.getText();
	    	
//    		if(a_ter_name.isEmpty()) {
//	    		return;
//	    	}
	    	List<Related_LawVO> lawList = null;
	    	lawList = service.searchLaw(rel_l_name);
	    	
	    	if(lawList == null) {
//	    		System.out.println("정보가 없습니다.");
	    	}else {
	    		lawTable.setItems(FXCollections.observableArrayList(lawList));
	    	}
	    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    private IKnowledgeService service;
    private ObservableList<Related_LawVO> data;
    
    private void setData() {
    	try {
	    	List<Related_LawVO> lawVo = service.getAllLaw();
	    	data = FXCollections.observableArrayList(lawVo);
	    	lawTable.setItems(data);
    	
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
    	
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("rel_l_name"));
    	exCol.setCellValueFactory(new PropertyValueFactory<>("rel_l_content"));

    	setData();
    	
    }
}
