package kr.or.ddit.controller.law;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.law.ILawService;
import kr.or.ddit.vo.Law_CategoryVO;
import kr.or.ddit.vo.Related_LawVO;

public class AdminLawAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnHome;

    @FXML
    private ComboBox<Law_CategoryVO> categoryCom;

    @FXML
    private TextField tfTitle;

    @FXML
    private HTMLEditor htmlA;

    @FXML
    private HTMLEditor htmlQ;

    @FXML
    void btnAddClick(ActionEvent event) {
    	if(AlertUtil.showAlert((Stage) btnAdd.getScene().getWindow(), "관련 법률을 등록 하시겠습니까?")) {
    		
    		Related_LawVO RlawVo = new Related_LawVO();
    		
    		RlawVo.setCat_law_no(categoryCom.getValue().getCat_law_no());
    		RlawVo.setRel_l_title(tfTitle.getText());
    		RlawVo.setRel_l_question(htmlQ.getHtmlText());
    		RlawVo.setRel_l_answer(htmlA.getHtmlText());
    		
    		try {
				service.insertLaw(RlawVo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnHome.getScene().getWindow();
    	Parent main = FXMLLoader.load(AdminLawAddController.class.getResource("../../fxml/knowledge/admin/adminKnowledgeMain.fxml"));
    	
    	Scene scene = new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }

    
    ILawService service;
    
    List<Related_LawVO> lawList;
    ObservableList<Related_LawVO> data;
    
    @FXML
    void initialize() {
    	//Service객체 생성
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			
			service =  (ILawService)reg.lookup("lawService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
//------------------------------------------------------------------------------------------------------------
    	// 관련 법률 카테고리 세팅
    	List<Law_CategoryVO> categoryList = null;
    	
    	try {
			categoryList = service.getAllLawCategory();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	ObservableList<Law_CategoryVO> categoryData = FXCollections.observableArrayList(categoryList);
    	
    	categoryCom.setItems(categoryData);
    	
    	categoryCom.setCellFactory(new Callback<ListView<Law_CategoryVO>, ListCell<Law_CategoryVO>>() {
			
			@Override
			public ListCell<Law_CategoryVO> call(ListView<Law_CategoryVO> param) {
				return new ListCell<Law_CategoryVO>() {
					@Override
					protected void updateItem(Law_CategoryVO item, boolean empty) {
						super.updateItem(item, empty);
						if(item == null || empty) {
							setText(null);
						}else {
							setText(item.getCat_law_name());
						}
					}
				};
			}
		});
    	categoryCom.setButtonCell(new ListCell<Law_CategoryVO>() {
    		@Override
    		protected void updateItem(Law_CategoryVO item, boolean empty) {
    			super.updateItem(item, empty);
    			if(item == null || empty) {
    				setText(null);
    			}else {
    				setText(item.getCat_law_name());
    			}
    		}
    	});
    	categoryCom.setValue(categoryCom.getItems().get(0));
    	
    	

    }
}
