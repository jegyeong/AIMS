package kr.or.ddit.controller.search;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.service.search.ISearchService;
import kr.or.ddit.vo.A_articleVO;

public class PriceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfSearch_1;

    @FXML
    private TextField tfSearch_2;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<A_articleVO> table;

    @FXML
    private TableColumn<A_articleVO, String> numCol;

    @FXML
    private TableColumn<A_articleVO, String> nameCol;

    @FXML
    private TableColumn<A_articleVO, String> colPrice;

    @FXML
    void btnSearchClick(ActionEvent event) {
    	String start = null;
    	String end = null;
    	
    	if(!tfSearch_1.getText().isEmpty()) {
    	start = tfSearch_1.getText();
    	}
    	if(!tfSearch_2.getText().isEmpty()) {
    	end = tfSearch_2.getText();
    	}
    	
    	Map<String, String> priceMap = new HashMap<String, String>();
    	
    	priceMap.put("start", start);
    	priceMap.put("end", end);
    	
    	try {
			stuffList = service.priceSearch(priceMap);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	data = FXCollections.observableArrayList(stuffList);
    	
    	table.setItems(data);
    	
    }

    @FXML
    void tableClick(MouseEvent event) {
    	if(table.getSelectionModel().getSelectedItem()==null) return;
    	FXMLLoader loader = new FXMLLoader(NumController.class.getResource("../../fxml/search/fxmlDetail.fxml"));
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
			controller.setNextPage("../../fxml/search/fxmlPrice.fxml");
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

    ISearchService service;
    
    List<A_articleVO> stuffList;
    ObservableList<A_articleVO> data;

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
			stuffList = service.getAllShow();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
     	data = FXCollections.observableArrayList(stuffList);
     	
     	table.setItems(data);
     	
     	
     	tfSearch_1.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			tfSearch_1.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					tfSearch_1.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
     	tfSearch_2.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			tfSearch_2.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					tfSearch_2.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
     	
     	numCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_no"));
		nameCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_name"));
		colPrice.setCellValueFactory(new PropertyValueFactory<A_articleVO,String>("a_art_price"));
		colPrice.setCellFactory(new Callback<TableColumn<A_articleVO,String>, TableCell<A_articleVO,String>>() {
			
			@Override
			public TableCell<A_articleVO, String> call(TableColumn<A_articleVO, String> param) {
				return new TableCell<A_articleVO, String>(){
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty&&item!=null) {
							 NumberFormat format = NumberFormat.getNumberInstance();
							setText(format.format(Long.parseLong(item))+"원");
						}else {
							setText(null);
						}
					}
				};
			}
		});
			
    }
}