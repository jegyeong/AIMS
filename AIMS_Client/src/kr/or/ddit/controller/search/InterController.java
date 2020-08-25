package kr.or.ddit.controller.search;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kr.or.ddit.service.search.ISearchService;
import kr.or.ddit.vo.A_articleVO;

public class InterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<A_articleVO> table;

    @FXML
    private TableColumn<A_articleVO, String> numCol;

    @FXML
    private TableColumn<A_articleVO, String> nameCol;

    @FXML
    private TableColumn<A_articleVO, String> interCol;

    @FXML
    private Pagination page;
    @FXML
    private TextField tfMinInter;

    @FXML
    private TextField tfMaxInter;

    @FXML
    private Button btnSreach;

    @FXML
    void onClickedBtnSreach(ActionEvent event) {
    	Map<String, String> dateMap = new HashMap<String, String>();
    	if(!tfMinInter.getText().equals("")) {
    		dateMap.put("inter1",tfMinInter.getText());
    		
    	}
    	if(!tfMaxInter.getText().equals("")) {
    		dateMap.put("inter2",tfMaxInter.getText());
    	}
    	
    	try {
			table.setItems(FXCollections.observableArrayList(service.totalSearch(dateMap)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	
    	
    }
    @FXML
    void tableClick(MouseEvent event) throws ClassNotFoundException {
    	if(table.getSelectionModel().getSelectedItem()==null) return;
    	FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.search.NumController").getResource("../../fxml/search/fxmlDetail.fxml"));
    	Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	DetailController controller = loader.getController(); // 다른 컨트롤러를 미리 가져와
    	try {
			controller.setTextField(table.getSelectionModel().getSelectedItem());
			controller.setNextPage("../../fxml/search/fxmlInter.fxml");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 그 컨트롤러에 테이블에선택한애의 값을 넘겨줘
    	  	
    	Stage stage = (Stage) table.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("물건 상세정보 ");
    	stage.show();
    }

    List<A_articleVO> stuffList;
    ObservableList<A_articleVO> data;
    
    ISearchService service;
    
    @FXML
    void initialize() {
    	//Service객체 생성
     	try {
     		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
 			service =  (ISearchService)reg.lookup("searchService");
 		} catch (RemoteException e) {
 			e.printStackTrace();
 		} catch (NotBoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} 
     	
     	try {
			stuffList = service.interSearch();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
     	data = FXCollections.observableArrayList(stuffList);
     	
     	tfMinInter.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			tfMinInter.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					tfMinInter.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
     	tfMaxInter.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			tfMaxInter.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					tfMaxInter.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
     	
     	
     	table.setItems(data);
     	
     	numCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_no"));
     	nameCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_name"));
     	interCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_inter"));

    }
}
