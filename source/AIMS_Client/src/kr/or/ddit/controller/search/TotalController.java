package kr.or.ddit.controller.search;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.search.ISearchService;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CategoryAVO;
import kr.or.ddit.vo.CategoryBVO;
import kr.or.ddit.vo.CategoryCVO;
import kr.or.ddit.vo.CourtVO;

public class TotalController {
	List<A_articleVO> stuffList;
	ObservableList<A_articleVO> data;
	    
	ISearchService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<CategoryAVO> CA;

    @FXML
    private ComboBox<CategoryBVO> CB;

    @FXML
    private ComboBox<CategoryCVO> CC;

    @FXML
    private ComboBox<CourtVO> courtCom;
    
    @FXML
    private ComboBox<String> courtAddrCom;


    @FXML
    private TextField minLow;

    @FXML
    private TextField maxLow;

    @FXML
    private TextField minPrice;

    @FXML
    private TextField maxPrice;

    @FXML
    private ComboBox<String> resultCom;

    @FXML
    private TextField minTour;

    @FXML
    private TextField maxTour;

    @FXML
    private Button btnSearch;
    
    @FXML
    private DatePicker datePicker1;

    @FXML
    private DatePicker datePicker2;
    
    @FXML
    private TableView<A_articleVO> table;

    @FXML
    private TableColumn<A_articleVO, String> numCol;

    @FXML
    private TableColumn<A_articleVO, String> nameCol;

    @FXML
    private TableColumn<A_articleVO, String> dateCol;

    @FXML
    private TableColumn<A_articleVO, String> priceCol;

    @FXML
    private TableColumn<A_articleVO, String> tourCol;

    @FXML
    void btnSearchClick(ActionEvent event) {
    	Map<String, String> data = new HashMap<String, String>();
    	
    	if(datePicker1.getValue()!=null) {
    		String []day = datePicker1.getValue().toString().split("-");
    		data.put("day1",day[0]+day[1]+day[2]);
    	}
    	
    	if(datePicker2.getValue()!=null) {
    		String []day = datePicker2.getValue().toString().split("-");
    		data.put("day2",day[0]+day[1]+day[2]);
    	}
    	
    	if(CA.getValue()!=null) {
    		data.put("catA",CA.getValue().getCat_a_name());
    	}
    	
    	if(CB.getValue()!=null) {
    		data.put("catA",CB.getValue().getCat_b_name());
    	}
    	if(CC.getValue()!=null) {
    		data.put("catA",CC.getValue().getCat_c_name());
    	}
    	
    	if(courtAddrCom.getValue()!=null) {
    		data.put("loc",courtAddrCom.getValue());
    	}
    	
    	if(courtCom.getValue()!=null) {
    		data.put("cou",courtCom.getValue().getCou_no());
    	}
    	
    	if(resultCom.getValue()!=null) {
    		data.put("result",resultCom.getValue());
    	}
    	
    	
    	if(!minLow.getText().equals("")) {
    		data.put("low1",minLow.getText());
    	}
    	if(!maxLow.getText().equals("")) {
    		data.put("low2",maxLow.getText());
    	}
    	
    	if(!minPrice.getText().equals("")) {
    		data.put("price1",minPrice.getText());
    	}
    	if(!maxPrice.getText().equals("")) {
    		data.put("price2",maxPrice.getText());
    	}
    	if(!minTour.getText().equals("")) {
    		data.put("tour1",minTour.getText());
    	}
    	if(!maxTour.getText().equals("")) {
    		data.put("tour2",maxTour.getText());
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
    	//controller.setMainAP(mainAP);
    	Stage stage = (Stage) btnSearch.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("물건 상세정보 ");
    	stage.show();
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
    	
//------------------------------------------------------------------------------------------------------------
    	//콤보박스 설정 (대분류)
    	List<CategoryAVO> Alist = null;
		try {
			Alist = service.getAllACategory();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ObservableList<CategoryAVO> Adata = FXCollections.observableArrayList(Alist);
    	
    	CA.setItems(Adata);
    	
    	CA.setCellFactory(new Callback<ListView<CategoryAVO>, ListCell<CategoryAVO>>() {
			@Override
			public ListCell<CategoryAVO> call(ListView<CategoryAVO> param) {
				return new ListCell<CategoryAVO>() {
					@Override
					protected void updateItem(CategoryAVO item, boolean empty) {
						super.updateItem(item, empty);
						if(item == null || empty) {
							setText(null);
						}else {
							setText(item.getCat_a_name());
						}
					}
				};
			}
		});
    	CA.setButtonCell(new ListCell<CategoryAVO>() {
    		@Override
    		protected void updateItem(CategoryAVO item, boolean empty) {
    			super.updateItem(item, empty);
    			if(item == null || empty) {
    				setText(null);
    			}else {
    				setText(item.getCat_a_name());
    			}
    		}
    	});
//--------------------------------------------------------------------------------------------------------------    	
    	//콤보박스 설정(중분류)
    	List<CategoryBVO> Blist = null;
		try {
			Blist = service.getAllBCategory(CA.getItems().get(0).getCat_a_no());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ObservableList<CategoryBVO> Bdata = FXCollections.observableArrayList(Blist);
    	
    	CB.setItems(Bdata);
    	
    	CB.setCellFactory(new Callback<ListView<CategoryBVO>, ListCell<CategoryBVO>>() {
    		@Override
    		public ListCell<CategoryBVO> call(ListView<CategoryBVO> param) {
    			return new ListCell<CategoryBVO>() {
    				@Override
    				protected void updateItem(CategoryBVO item, boolean empty) {
    					super.updateItem(item, empty);
    					if(item == null || empty) {
    						setText(null);
    					}else {
    						setText(item.getCat_b_name());
    					}
    				}
    			};
    		}
		});
    	CB.setButtonCell(new ListCell<CategoryBVO>() {
    		@Override
    		protected void updateItem(CategoryBVO item, boolean empty) {
    			super.updateItem(item, empty);
    			if(item==null || empty) {
    				setText(null);
    			}else {
    				setText(item.getCat_b_name());
    			}
    		}
    	});
//----------------------------------------------------------------------------------------------------------------    	
    	//콤보박스 설정(소분류)
    	List<CategoryCVO> Clist = null;
		try {
			Clist = service.getAllCCategory(CB.getItems().get(0).getCat_b_no());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ObservableList<CategoryCVO> Cdata = FXCollections.observableArrayList(Clist);
    	
    	CC.setItems(Cdata);
    	
    	CC.setCellFactory(new Callback<ListView<CategoryCVO>, ListCell<CategoryCVO>>() {
    		@Override
    		public ListCell<CategoryCVO> call(ListView<CategoryCVO> param) {
    			return new ListCell<CategoryCVO>() {
    				@Override
    				protected void updateItem(CategoryCVO item, boolean empty) {
    					super.updateItem(item, empty);
    					if(item == null || empty) {
    						setText(null);
    					}else {
    						setText(item.getCat_c_name());
    					}
    				}
    			};
    		}
		});
    	CC.setButtonCell(new ListCell<CategoryCVO>() {
    		@Override
    		protected void updateItem(CategoryCVO item, boolean empty) {
    			super.updateItem(item, empty);
    			if(item == null || empty) {
    				setText(null);
    			}else {
    				setText(item.getCat_c_name());
    			}
    		}
    	});
//----------------------------------------------------------------------------------------------------------------    	
    	// 콤보박스 클릭이벤트 대분류 (addListener)
    	CA.valueProperty().addListener(new ChangeListener<CategoryAVO>() {
			@Override
			public void changed(ObservableValue<? extends CategoryAVO> observable, CategoryAVO oldValue,
					CategoryAVO newValue) {
				
				List<CategoryBVO> Blist = null;
				try {
					Blist = service.getAllBCategory(newValue.getCat_a_no());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
		    	ObservableList<CategoryBVO> Bdata = FXCollections.observableArrayList(Blist);
		    	
		    	CB.setItems(Bdata);
		    	CB.setValue(CB.getItems().get(0));
//		    	CC.getItems().removeAll();
			}
		});
//----------------------------------------------------------------------------------------------------------------    	
    	// 콤보박스 클릭이벤트 중분류 (addListener)
    	CB.valueProperty().addListener(new ChangeListener<CategoryBVO>() {
			@Override
			public void changed(ObservableValue<? extends CategoryBVO> observable, CategoryBVO oldValue,
					CategoryBVO newValue) {
		    	List<CategoryCVO> Clist = null;
				try {
					Clist = service.getAllCCategory(newValue.getCat_b_no());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
		    	ObservableList<CategoryCVO> Cdata = FXCollections.observableArrayList(Clist);
		    	
		    	CC.setItems(Cdata);
				
			}
		});
//-------------------------------------------------------------------------------------------------------------------
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
     	
     	courtAddrCom.setItems(doData);
     	
     	courtAddrCom.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
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
     	courtAddrCom.setButtonCell(new ListCell<String>() {
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

//-------------------------------------------------------------------------------------------------------
     	// 법원의 지역 클릭이벤트
		courtAddrCom.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				List<CourtVO> courtList = null;
				
				try {
					courtList = service.getAllCourt(newValue);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
				ObservableList<CourtVO> courtData = FXCollections.observableArrayList(courtList);
				
				courtCom.setItems(courtData);
			}
		});
  //----------------------------------------------------------------------------------------------------------
     	// 법원 콤보박스 세팅
		courtCom.setCellFactory(new Callback<ListView<CourtVO>, ListCell<CourtVO>>() {
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
		courtCom.setButtonCell(new ListCell<CourtVO>() {
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
//------------------------------------------------------------------------------------------------------------  	
    	// 경매결과 콤보박스 설정
     	resultCom.getItems().addAll("준비중","낙찰","유찰");
//------------------------------------------------------------------------------------------------------------  	
     	try {
			stuffList = service.getAllShow();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
     	
     	data = FXCollections.observableArrayList(stuffList);
     	
     	table.setItems(data);
     	
     	numCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_no"));
     	nameCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_name"));
     	dateCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_day"));
     	priceCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_price"));
     	tourCol.setCellValueFactory(new PropertyValueFactory<A_articleVO, String>("a_art_tour"));
    	
    	
    	
    	
     	minLow.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				minLow.textProperty().addListener((Observable, oldValue, newValue) -> {
		           if(!newValue.matches("^[0-9]+$")) {
		        	   minLow.setText(newValue.replaceAll("[^0-9]", ""));
		           }
		        });
			}
		});
    	maxLow.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				maxLow.textProperty().addListener((Observable, oldValue, newValue) -> {
		           if(!newValue.matches("^[0-9]+$")) {
		        	   maxLow.setText(newValue.replaceAll("[^0-9]", ""));
		           }
		        });
			}
		});
    	minPrice.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				minPrice.textProperty().addListener((Observable, oldValue, newValue) -> {
		           if(!newValue.matches("^[0-9]+$")) {
		        	   minPrice.setText(newValue.replaceAll("[^0-9]", ""));
		           }
		        });
			}
		});
    	maxPrice.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			maxPrice.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					maxPrice.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
    	minTour.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			minTour.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					minTour.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
    	maxTour.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			maxTour.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					maxTour.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
    	
    
    	
    	
    
    	priceCol.setCellFactory(new Callback<TableColumn<A_articleVO,String>, TableCell<A_articleVO,String>>() {
			
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
