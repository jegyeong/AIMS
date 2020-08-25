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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.service.search.ISearchService;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CourtVO;

public class CourtController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<CourtVO> searchCom;
    
    @FXML
    private ComboBox<String> courtAddCom;
    
    
    @FXML
    private Button btnSearch;

    @FXML
    private TableView<A_articleVO> table;

    @FXML
    private TableColumn<A_articleVO, String> numCol;

    @FXML
    private TableColumn<A_articleVO, String> nameCol;

    @FXML
    private TableColumn<?, ?> colCourt;

    List<A_articleVO> stuffList;
    ObservableList<A_articleVO> data;
    
    ISearchService service;
    

    
    
    @FXML
    void btnSearchClick(ActionEvent event) {
    	Map<String,String> data = new HashMap();
    	if(courtAddCom.getValue()!=null) {
    		data.put("loc",courtAddCom.getValue());
    	}
    	if(searchCom.getValue()!=null) {
    		data.put("cou",searchCom.getValue().getCou_no());
    	}
    	try {
			table.setItems(FXCollections.observableArrayList(service.totalSearch(data)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void tableClick(MouseEvent event) throws IOException {
    	if(table.getSelectionModel().getSelectedItem()==null) return;
    	
    	FXMLLoader loader = new FXMLLoader(NumController.class.getResource("../../fxml/search/fxmlDetail.fxml"));
    	Parent root = loader.load();
    	
    	DetailController controller = loader.getController(); // 다른 컨트롤러를 미리 가져와
    	controller.setTextField(table.getSelectionModel().getSelectedItem()); // 그 컨트롤러에 테이블에선택한애의 값을 넘겨줘
    	  	
    	Stage stage = (Stage) btnSearch.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("물건 상세정보 ");
    	stage.show();
    }
    
    public void setData(String loc,CourtVO cou) {
    	
    	for(int i = 0 ; i <courtAddCom.getItems().size();i++){
    		if(courtAddCom.getItems().get(i).equals(loc)) {
    			courtAddCom.setValue(courtAddCom.getItems().get(i));
    		}
    	}
    	
    	
    	for(int i = 0 ; i <searchCom.getItems().size();i++){
    		if(searchCom.getItems().get(i).getCou_no().equals(cou.getCou_no())) {
    			searchCom.setValue(searchCom.getItems().get(i));
    		}
    	}
    	String txt = searchCom.getValue().getCou_no();
    	
    	try {
			stuffList = service.courtSearch(txt);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    
    	data = FXCollections.observableArrayList(stuffList);
    	
    	table.setItems(data);
    	
    }
    
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
//-----------------------------------------------------------------------------------------------------------
     	//법원의 지역 콤보박스 설정
     	List<String> deoList = null;
     	
     	try {
			deoList = service.courtAdd();
			System.out.println(deoList);
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
     	
     	ObservableList<String> doData = FXCollections.observableArrayList(deoList);
     	
     	courtAddCom.setItems(doData);
     	
     	courtAddCom.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(item == null || empty) {
							setText(null);
						}else {
							setText(item);
						}
					}
				};
			}
     		
		});
     	courtAddCom.setButtonCell(new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				// TODO Auto-generated method stub
				super.updateItem(item, empty);
				if(item == null || empty) {
					setText(null);
				}else {
					setText(item);
				}
			}
		});
		//courtAddCom.setValue(courtAddCom.getItems().get(0));

//-------------------------------------------------------------------------------------------------------
     	// 법원의 지역 클릭이벤트
     	courtAddCom.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				List<CourtVO> courtList = null;
				
				try {
					courtList = service.getAllCourt(newValue);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
				ObservableList<CourtVO> courtData = FXCollections.observableArrayList(courtList);
				
				searchCom.setItems(courtData);
			}
		});
  //----------------------------------------------------------------------------------------------------------
     	// 법원 콤보박스 세팅
		searchCom.setCellFactory(new Callback<ListView<CourtVO>, ListCell<CourtVO>>() {
			@Override
			public ListCell<CourtVO> call(ListView<CourtVO> param) {
				return new ListCell<CourtVO>() {
					@Override
					protected void updateItem(CourtVO item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if (!empty) {
							setText(item.getCou_name());
						} else {
							setText(null);
						}
					}
				};
			}
		});
		
		searchCom.setButtonCell(new ListCell<CourtVO>() {
			@Override
			protected void updateItem(CourtVO item, boolean empty) {
				super.updateItem(item, empty);
				if (!empty) {
					setText(item.getCou_name());
				} else {
					setText(null);
				}
			}
		});
		//searchCom.setValue(searchCom.getItems().get(0));
     	
//-------------------------------------------------------------------------------------------------------
     	
     	
     	try {
			stuffList = service.getAllShow();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
     	data = FXCollections.observableArrayList(stuffList);
     	
     	table.setItems(data);
     	
     	numCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_no"));
     	nameCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_name"));
     	colCourt.setCellValueFactory(new PropertyValueFactory<>("cou_no"));
    }
}
