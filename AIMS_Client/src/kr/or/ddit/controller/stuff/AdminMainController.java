package kr.or.ddit.controller.stuff;

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
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.service.stuff.IAdminService;
import kr.or.ddit.vo.A_articleVO;


public class AdminMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnHome;

    @FXML
    private AnchorPane AA;

    @FXML
    private TextField tfSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<A_articleVO> table;

    @FXML
    private TableColumn<A_articleVO, String> numCol;

    @FXML
    private TableColumn<A_articleVO, String> nameCol;

    @FXML
    private Pagination page;

    @FXML
    private Button btnInsert;

    @FXML
    void btnHomeClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.stuff.AdminMainController").getResource("../../fxml/adminmain/AdminMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnInsert.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("관리자 메인 페이지");
    	stage.show();
    }

    @FXML
    void btnInsertClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	
    	FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.stuff.AdminMainController").getResource("../../fxml/stuff/fxmlInsert.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) table.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("등록");
    	stage.show();
    	
    }

    @FXML
    void btnSearchClick(ActionEvent event) {
    	String txt = tfSearch.getText();
    	
    	data = null;
    	
    	try {
			stuffList = service.NumSearch(txt);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	data = FXCollections.observableArrayList(stuffList);
    	
    	table.setItems(data);
    	
    }

    @FXML
    void tableClick(MouseEvent event) throws IOException, ClassNotFoundException {
    	
    	FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.stuff.AdminMainController").getResource("../../fxml/stuff/fxmlUpdateAndDelete.fxml"));
    	Parent root = loader.load();
    	
    	UpdateAndDeleteController controller = loader.getController(); // 다른 컨트롤러를 미리 가져와
    	controller.setTextField(table.getSelectionModel().getSelectedItem()); // 그 컨트롤러에 테이블에선택한애의 값을 넘겨줘
    	  	
    	Stage stage = (Stage) btnInsert.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("물건 상세정보 ");
    	stage.show();
    	
    }

    List<A_articleVO> stuffList;
    ObservableList<A_articleVO> data;
    
    IAdminService service;
    String select="";
     
     @FXML
     void initialize() {
     	//Service객체 생성
     	try {
     		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
 			service =  (IAdminService)reg.lookup("adminService");
 		} catch (RemoteException e) {
 			e.printStackTrace();
 		} catch (NotBoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
      try {
		stuffList = service.getAllStuff();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      data = FXCollections.observableArrayList(stuffList);
      
      table.setItems(data);
      
      numCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_no"));
      nameCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_name"));
      
      

    }
}
