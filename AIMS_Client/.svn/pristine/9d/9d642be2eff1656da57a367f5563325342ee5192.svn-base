package kr.or.ddit.controller.search;

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
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kr.or.ddit.service.search.ISearchService;
import kr.or.ddit.vo.A_articleVO;

public class ResultController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> resultCombo;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<A_articleVO> table;

    @FXML
    private TableColumn<A_articleVO, String> numCol;

    @FXML
    private TableColumn<A_articleVO, String> nameCol;

    @FXML
    private TableColumn<A_articleVO, String> resultCol;


    @FXML
    void btnSearchClick(ActionEvent event) {
    	String txt = resultCombo.getValue();
    	
    	
    	try {
			stuffList = service.resultSearch(txt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	data = FXCollections.observableArrayList(stuffList);
    	
    	table.setItems(data);
    	
    }

    @FXML
    void tableClick(MouseEvent event) throws IOException {
    	if(table.getSelectionModel().getSelectedItem()==null) return;
    	FXMLLoader loader = new FXMLLoader(NumController.class.getResource("../../fxml/search/fxmlDetail.fxml"));
    	Parent root = loader.load();
    	
    	DetailController controller = loader.getController(); // 다른 컨트롤러를 미리 가져와
    	controller.setTextField(table.getSelectionModel().getSelectedItem()); // 그 컨트롤러에 테이블에선택한애의 값을 넘겨줘
    	//controller.setMainAP(mainAP);
    	Stage stage = (Stage) btnSearch.getScene().getWindow(); 
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
 			Registry reg = LocateRegistry.getRegistry("localhost",8888);
 			service =  (ISearchService)reg.lookup("searchService");
 		} catch (RemoteException e) {
 			e.printStackTrace();
 		} catch (NotBoundException e) {
 			e.printStackTrace();
 		} 
     	
     	resultCombo.getItems().addAll("준비중","낙찰","유찰");
     	resultCombo.setValue(resultCombo.getItems().get(0));
     	
     	try {
			stuffList = service.getAllShow();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
     	
     	data = FXCollections.observableArrayList(stuffList);
     	
     	table.setItems(data);
     	
     	numCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_no"));
     	nameCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_name"));
     	resultCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_result"));
     	
     	

    }
}
