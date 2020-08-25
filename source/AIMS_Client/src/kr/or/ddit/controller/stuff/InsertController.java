package kr.or.ddit.controller.stuff;

import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.stuff.IAdminService;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.CategoryAVO;
import kr.or.ddit.vo.CategoryBVO;
import kr.or.ddit.vo.CategoryCVO;
import kr.or.ddit.vo.CourtVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.ImageVO;
import netscape.javascript.JSObject;

public class InsertController {
	private List<File> imgList = new ArrayList<File>();
	private File apprFile;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private ComboBox<CategoryAVO> CA;

    @FXML
    private ComboBox<CategoryBVO> CB;

    @FXML
    private ComboBox<CategoryCVO> CC;

    @FXML
    private ComboBox<CourtVO> CourtCom;

    @FXML
    private ComboBox<String> courtAddCom;

    @FXML
    private TextField txtLow;

    @FXML
    private TextField B_txtAdd1;

    @FXML
    private TextField B_txtAdd2;

    @FXML
    private TextField detailAdd1;

    @FXML
    private Button btnAddSearch_B;

    @FXML
    private TextField txtPaper;

    @FXML
    private Button btnPaperFile;

    @FXML
    private TextField txtPrice;

    @FXML
    private Button btnPic;
    
    @FXML
    private DatePicker datepicker;

    @FXML
    private ComboBox<String> txtH;

    @FXML
    private ComboBox<String> txtM;

    @FXML
    private TextField txtArea;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnBack;
    @FXML
    private HBox hBoxImage;
    
    private JSObject javascriptConnector;
    private JavaConnector javaConnector = new JavaConnector();
   

//---------------------------------------------------------------------------------------------------------------------------  
    @FXML
    void btnAddSearch_BClick(ActionEvent event) {

       initFX();
    }
    
    private void initFX() {
        JFrame frame = new JFrame("FX");

        frame.getContentPane().setLayout(null);

        final JFXPanel fxPanel = new JFXPanel();

        frame.add(fxPanel);
        frame.setVisible(true);

        fxPanel.setSize(new Dimension(500, 650));
        fxPanel.setLocation(new Point(0, 27));

        frame.getContentPane().setPreferredSize(new Dimension(500, 650));
        frame.pack();
        frame.setResizable(false);

        Platform.runLater(new Runnable() {
           public void run() {
              initAndLoadWebView(fxPanel);
           }
        });
     }
    
    public class JavaConnector{
        public void setZipData(String zipcode,String addr, String detail) {

           B_txtAdd1.setText(zipcode);
           B_txtAdd2.setText(addr);
           detailAdd1.setText(detail);
        }
     }

     private void initAndLoadWebView(final JFXPanel fxPanel) {
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);

        WebView webview = new WebView();
        group.getChildren().add(webview);
        webview.setMinSize(500, 650);
        webview.setMaxSize(500, 650);

        WebEngine webEngine = webview.getEngine();
        webEngine.load("http://localhost:8999/MapAPI/ADDAPI.html");
        
        // kakaozipcode의 webview와 연동되어서 값을 가져오는 부분 
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue)->{
        if(Worker.State.SUCCEEDED==newValue) {
           JSObject window = (JSObject) webEngine.executeScript("window");
           window.setMember("javaConnector", javaConnector);
           javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");
        }
     });
        
     }

 //---------------------------------------------------------------------------------------------------------------------------  
    @FXML
    void btnBackClick(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(AdminMainController.class.getResource("../../fxml/stuff/fxmlAdminMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnPic.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("정보관리");
    	stage.show();
    }

    @FXML
    void btnInsertClick(ActionEvent event) throws ParseException {
    	
    	if(AlertUtil.showAlert((Stage) btnPic.getScene().getWindow(), "물건 정보를 등록 하시겠습니까?") ) {
    		A_articleVO articleVo = new A_articleVO();
        	
        	articleVo.setA_art_addnum(B_txtAdd1.getText());
        	articleVo.setA_art_loc(B_txtAdd2.getText());
        	articleVo.setA_art_detailadd(detailAdd1.getText());
        	articleVo.setCou_no(CourtCom.getValue().getCou_no());
        	articleVo.setCat_a_no(CA.getValue().getCat_a_no());
        	articleVo.setCat_b_no(CB.getValue().getCat_b_no());
        	articleVo.setCat_c_no(CC.getValue().getCat_c_no());
        	articleVo.setA_art_low(txtLow.getText());
        	articleVo.setA_art_area(txtArea.getText());
        	
        	String day = datepicker.getValue().toString()+ " " + txtH.getValue() + ":" + txtM.getValue();
        	articleVo.setA_art_day(day);

        	articleVo.setA_art_name(txtName.getText());
        	articleVo.setA_art_appr(txtPaper.getText());
        	articleVo.setA_art_price(txtPrice.getText());
        	
        	try {
        	File apprFile=new File(txtPaper.getText());
        	byte[] apprData = new byte[(int) apprFile.length()];
        	FileInputStream fis= new FileInputStream(apprFile);
			
        	fis.read(apprData);
       
        	fis.close();
        	
        	FileInfoVO filedata = new FileInfoVO();
        	filedata.setFileData(apprData);
        	filedata.setFileName(apprFile.getName());
        	articleVo.setA_art_appr(service.clientToServer("ApprFile", filedata));
        	service.insertStuff(articleVo);
        	} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        	try {
				for(File file : imgList) {
					ImageVO imageVO = new ImageVO();
		        	byte[] apprData = new byte[(int) file.length()];
		        	FileInputStream fis= new FileInputStream(file);
		        	fis.read(apprData);
		        	fis.close();
		        	
		        	FileInfoVO filedata = new FileInfoVO();
		        	filedata.setFileData(apprData);
		        	filedata.setFileName(file.getName());
		        	imageVO.setImg_addr(service.clientToServer("ImageFile", filedata));
		        	service.insertImageFile(imageVO);
	        	}
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        	try {
        	FXMLLoader loader = new FXMLLoader(AdminMainController.class.getResource("../../fxml/stuff/fxmlAdminMain.fxml"));
        	Parent root = loader.load();
				
			
        	  	
        	Stage stage = (Stage) btnPic.getScene().getWindow(); 
        	Scene scene = new Scene(root);
        	
        	stage.setScene(scene);
        	stage.setTitle("정보관리");
        	stage.show();
        	} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnPaperFileClick(ActionEvent event) {
    	Stage stage = (Stage) btnBack.getScene().getWindow();
    	
        FileChooser fileChooser = new FileChooser(); //파일 선택하는 창이 열림

        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All file", "*.*")); // 보여줄, 저장할 파일의 형식



        File selectedFile = fileChooser.showOpenDialog(stage);
        apprFile = selectedFile;
        txtPaper.setText(selectedFile.getPath());
    }

    @FXML
    void btnPicClick(ActionEvent event) {
    	Stage stage = (Stage) btnBack.getScene().getWindow();
    	
        FileChooser fileChooser = new FileChooser(); //파일 선택하는 창이 열림

 
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("image file", "*.jpg", "*.gif", "*.png"));

   
        
        File selectedFile = fileChooser.showOpenDialog(stage);
        imgList.add(selectedFile);
        
        
        Image img = new Image(selectedFile.toURI().toString());
        
        ImageView imgView = new ImageView();
        imgView.setFitHeight(135);
        imgView.setFitWidth(135);
        imgView.setImage(img);
        imgView.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				hBoxImage.getChildren().remove(imgView);
				
			}
		});
        
        hBoxImage.getChildren().add(imgView);
        
        
    }
    
   IAdminService service;
   String select="";
    
    @FXML
    void initialize() {
    	txtPaper.setEditable(false);
    	
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
    	
//------------------------------------------------------------------------------------------------------------
    // 정규식
    	txtLow.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				txtLow.textProperty().addListener((Observable, oldValue, newValue) -> {
		           if(!newValue.matches("^[0-9]+$")) {
		        	   txtLow.setText(newValue.replaceAll("[^0-9]", ""));
		           }
		        });
			}
		});
    
    	txtPrice.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				txtPrice.textProperty().addListener((Observable, oldValue, newValue) -> {
		           if(!newValue.matches("^[0-9]+$")) {
		        	   txtPrice.setText(newValue.replaceAll("[^0-9]", ""));
		           }
		        });
			}
		});
    	
    	txtArea.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				txtArea.textProperty().addListener((Observable, oldValue, newValue) -> {
		           if(!newValue.matches("^[0-9]+$")) {
		        	   txtArea.setText(newValue.replaceAll("[^0-9]", ""));
		           }
		        });
			}
		});
    	
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
    	//CA.setValue(CA.getItems().get(0));
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
    	//CB.setValue(CB.getItems().get(0));
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
    	//CC.setValue(CC.getItems().get(0));
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	ObservableList<CategoryBVO> Bdata = FXCollections.observableArrayList(Blist);
		    	
		    	CB.setItems(Bdata);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	ObservableList<CategoryCVO> Cdata = FXCollections.observableArrayList(Clist);
		    	
		    	CC.setItems(Cdata);
				
			}
		});
//----------------------------------------------------------------------------------------------------------------    	
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
     		
		});courtAddCom.setButtonCell(new ListCell<String>() {
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
				
				CourtCom.setItems(courtData);
			}
		});
  //----------------------------------------------------------------------------------------------------------
     	// 법원 콤보박스 세팅
     	CourtCom.setCellFactory(new Callback<ListView<CourtVO>, ListCell<CourtVO>>() {
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
		CourtCom.setButtonCell(new ListCell<CourtVO>() {
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
    	
		txtH.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13"
				, "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
		txtH.setValue(txtH.getItems().get(0));
		txtM.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
								"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
								"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", 
								"31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
								"41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
								"51", "52", "53", "54", "55", "56", "57", "58", "59");
		txtM.setValue(txtM.getItems().get(0));
    	
    	
    	
		B_txtAdd1.setEditable(false);
		B_txtAdd2.setEditable(false);
//		detailAdd1.setEditable(false);
		txtPaper.setEditable(false);
		datepicker.setEditable(false);
    }
}


