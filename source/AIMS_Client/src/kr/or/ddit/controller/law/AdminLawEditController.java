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

public class AdminLawEditController {
	private Related_LawVO vo;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnUpdate;

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
    private Button btnDelete;
    
    @FXML
    private Button btnOk;

    @FXML
    void btnDeleteClick(ActionEvent event) {

    }

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnHome.getScene().getWindow();
    	Parent main = FXMLLoader.load(AdminLawEditController.class.getResource("../../fxml/knowledge/admin/adminKnowledgeMain.fxml"));
    	
    	Scene scene = new Scene(main);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void btnUpdateClick(ActionEvent event) {
    	categoryCom.setDisable(false);
    	tfTitle.setEditable(true);
    	htmlA.setDisable(false);
    	htmlQ.setDisable(false);
    	btnOk.setDisable(false);
    }
    
    @FXML
    void btnOkClick(ActionEvent event) {
    	
    	if(AlertUtil.showAlert((Stage) btnDelete.getScene().getWindow(), "법률 정보를 수정하시겠씁니까?")) {
    		Related_LawVO RlawVo = new Related_LawVO();
    		
    		RlawVo.setRel_l_no(vo.getRel_l_no());
    		RlawVo.setCat_law_no(categoryCom.getValue().getCat_law_no());
    		RlawVo.setRel_l_title(tfTitle.getText());
    		RlawVo.setRel_l_question(htmlQ.getHtmlText());
    		RlawVo.setRel_l_answer(htmlA.getHtmlText());
    		
    		try {
				service.updateLaw(RlawVo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    }
    
    public void setTextField(Related_LawVO RlawVo) {
    	vo = RlawVo;
    	for(Law_CategoryVO categoryVo : categoryCom.getItems()) {
    		if(categoryVo.getCat_law_no().equals(RlawVo.getCat_law_no())) {
    			categoryCom.setValue(categoryVo);
    			
    			break;
    		}
    	}
    	tfTitle.setText(RlawVo.getRel_l_title());
    	htmlQ.setHtmlText(RlawVo.getRel_l_question());
    	htmlA.setHtmlText(RlawVo.getRel_l_answer());
    	
    	
    	categoryCom.setDisable(true);
    	tfTitle.setEditable(false);
    	htmlA.setDisable(true);
    	htmlQ.setDisable(true);
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
    	
    	btnOk.setDisable(true);
    	
    	
    	
    	
    }
}
