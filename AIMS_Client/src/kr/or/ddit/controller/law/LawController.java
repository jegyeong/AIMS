package kr.or.ddit.controller.law;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;
import kr.or.ddit.service.law.ILawService;
import kr.or.ddit.vo.Law_CategoryVO;
import kr.or.ddit.vo.Related_LawVO;

public class LawController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Law_CategoryVO> categoryCom;

    @FXML
    private ComboBox<Related_LawVO> titleCom;

    
    @FXML
    private TextArea qArea;

    @FXML
    private TextArea aArea;

    @FXML
    void btnBackClick(ActionEvent event) {
    	
    
    	
    	
    }

    @FXML
    void titleCom(ActionEvent event) {
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("cat_law_no", categoryCom.getValue().getCat_law_no());
    	map.put("rel_l_title", titleCom.getValue().getRel_l_title());
    	
    	try {
			lawList = service.getAllShowRelated_Law(map);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	data = FXCollections.observableArrayList(lawList);
    	
    	qArea.setText(data.get(0).getRel_l_question());
    	aArea.setText(data.get(0).getRel_l_answer());
    	
    	
    	
    	
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
    //---------------------------------------------------------------------------------------------------------
    	// 카테고리 설정
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
    	
    	
    	// 법률 타이틀 설정
    	List<Related_LawVO> RlawList = null;
    	
    	try {
			RlawList = service.getAllRelated_Law(categoryCom.getItems().get(0).getCat_law_no());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	ObservableList<Related_LawVO> Rdata = FXCollections.observableArrayList(RlawList);
    	
    	titleCom.setItems(Rdata);
    	
    	titleCom.setCellFactory(new Callback<ListView<Related_LawVO>, ListCell<Related_LawVO>>() {
			@Override
			public ListCell<Related_LawVO> call(ListView<Related_LawVO> param) {
				return new ListCell<Related_LawVO>(){
					@Override
					protected void updateItem(Related_LawVO item, boolean empty) {
						super.updateItem(item, empty);
						if(item == null || empty) {
							setText(null);
						}else {
							setText(item.getRel_l_title());
						}
					}
				};
			}
		});
    	titleCom.setButtonCell(new ListCell<Related_LawVO>() {
    		@Override
    		protected void updateItem(Related_LawVO item, boolean empty) {
    			super.updateItem(item, empty);
    			if(item == null || empty) {
    				setText(null);
    			}else {
    				setText(item.getRel_l_title());
    			}
    			
    		}
    	});
    	titleCom.setValue(titleCom.getItems().get(0));
    	
    	//카테고리 클릭 이벤트
    	categoryCom.valueProperty().addListener(new ChangeListener<Law_CategoryVO>() {
			@Override
			public void changed(ObservableValue<? extends Law_CategoryVO> observable, Law_CategoryVO oldValue,
					Law_CategoryVO newValue) {
				List<Related_LawVO> Rlist = null;
				try {
					Rlist = service.getAllRelated_Law(newValue.getCat_law_no());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ObservableList<Related_LawVO> Rdata = FXCollections.observableArrayList(Rlist);
				
				titleCom.setItems(Rdata);
			}
		});
    	
    	
    	
    	
    	
    }
}
