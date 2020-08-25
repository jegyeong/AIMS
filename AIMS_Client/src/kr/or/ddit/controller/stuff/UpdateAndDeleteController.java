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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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


public class UpdateAndDeleteController {
	private File ApprFile;
	private A_articleVO vo; 
	private List<File> imgList = new ArrayList<File>();
	private List<Map<String,String>> deleteList = new ArrayList<Map<String,String>>();
	private List<FileInfoVO> insertList = new ArrayList<FileInfoVO>();
	IAdminService service;
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
    private ComboBox<String> courtAddrCom;

    @FXML
    private TextField B_txtAdd1;

    @FXML
    private TextField B_txtAdd2;


    @FXML
    private TextField detailAdd1;

    @FXML
    private Button btnAddSearch_B;

    @FXML
    private TextField txtLow;

    @FXML
    private TextField txtPaper;

    @FXML
    private Button btnPaperFile;

    @FXML
    private TextField txtPrice;
    
    @FXML
    private DatePicker datepicker;

    @FXML
    private ComboBox<String> txtH;

    @FXML
    private ComboBox<String> txtM;

    @FXML
    private Button btnPic;

    @FXML
    private TextField txtArea;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnOK;
    
    @FXML
    private HBox hBoxImg;

    private JSObject javascriptConnector;
    private JavaConnector javaConnector = new JavaConnector();
    
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

        fxPanel.setSize(new Dimension(600, 650));
        fxPanel.setLocation(new Point(0, 27));

        frame.getContentPane().setPreferredSize(new Dimension(380, 420));
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
        webview.setMinSize(380, 420);
        webview.setMaxSize(380, 420);

        WebEngine webEngine = webview.getEngine();
        webEngine.load("http://192.168.0.118:8999/MapAPI/ADDAPI.html");
        
        // kakaozipcode의 webview와 연동되어서 값을 가져오는 부분 
        webEngine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue)->{
        if(Worker.State.SUCCEEDED==newValue) {
           JSObject window = (JSObject) webEngine.executeScript("window");
           window.setMember("javaConnector", javaConnector);
           javascriptConnector = (JSObject) webEngine.executeScript("getJsConnector()");
        }
     });
        
     }

    @FXML
    void btnBackClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.stuff.AdminMainController").getResource("../../fxml/stuff/fxmlAdminMain.fxml"));
    	Parent root = loader.load();
    	  	
    	Stage stage = (Stage) btnPic.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("정보관리");
    	stage.show();
    }

    @FXML
    void btnDeleteClick(ActionEvent event) {
    	A_articleVO articleVo = new A_articleVO();
    	
    	if(AlertUtil.showAlert((Stage) btnPic.getScene().getWindow(), "물건 정보를 삭제 하시겠습니까?") ) {
    		
    		vo.getA_art_no();
    		
    		
    		System.out.println(vo.getA_art_no());
    		
    		try {
				service.deleteStuff(vo.getA_art_no());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		
    	}
    }

    @FXML
    void btnUpdateClick(ActionEvent event) {
    	 txtName.setEditable(true);
         CA.setDisable(false);
         CB.setDisable(false);
         CC.setDisable(false);
         CourtCom.setDisable(false);
         B_txtAdd1.setEditable(true);
         B_txtAdd2.setEditable(true);
         btnAddSearch_B.setDisable(false);
         txtLow.setEditable(true);
         txtPaper.setEditable(false);
         btnPaperFile.setDisable(false);
         txtPrice.setEditable(true);
         btnPic.setDisable(false);
         txtArea.setEditable(true);
         btnOK.setDisable(false);
         courtAddrCom.setDisable(false);
         txtH.setDisable(false);
         txtM.setDisable(false);
    }
    

    @FXML
    void btnOKClick(ActionEvent event) throws ParseException{
    	
    	if(AlertUtil.showAlert((Stage) btnPic.getScene().getWindow(), "물건 정보를 수정 하시겠습니까?") ) {
    		A_articleVO articleVo = new A_articleVO();
    		articleVo.setA_art_no(vo.getA_art_no());
        	articleVo.setA_art_addnum(B_txtAdd1.getText());
        	articleVo.setA_art_loc(B_txtAdd2.getText());
        	articleVo.setCou_no(CourtCom.getValue().getCou_no());
        	articleVo.setCat_a_no(CA.getValue().getCat_a_no());
        	articleVo.setCat_b_no(CB.getValue().getCat_b_no());
        	articleVo.setCat_c_no(CC.getValue().getCat_c_no());
        	articleVo.setA_art_low(txtLow.getText());
        	articleVo.setA_art_area(txtArea.getText());
        	
        	String day = datepicker.getValue().toString()+ " " + txtH.getValue() + ":" + txtM.getValue();
        	articleVo.setA_art_day(day);
        	 
        	articleVo.setA_art_name(txtName.getText());
        	
        	articleVo.setA_art_price(txtPrice.getText());
        	articleVo.setA_art_addnum(B_txtAdd1.getText());
        	
        	if(ApprFile != null) {
        		try {
    				FileInfoVO infoVO = new FileInfoVO();
    				
    				FileInputStream fis = new FileInputStream(ApprFile);
    				byte[] buffer = new byte[(int) ApprFile.length()];
    				fis.read(buffer);
    				fis.close();
    				
    				infoVO.setFileName(ApprFile.getName());
    				infoVO.setFileData(buffer);
    	        	articleVo.setA_art_appr(service.clientToServer("ApprFile",infoVO));
    	        	service.updateStuff(articleVo);
    			} catch (FileNotFoundException e1) {
    				e1.printStackTrace();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
            	
        	}
			
    	  	
    	
    	for(Map<String,String>map : deleteList) {
    		try {
				service.deleteImg_File(map);
			} catch (RemoteException e) {
				e.printStackTrace();
			}    		
    	}
    	
    	
    	for(FileInfoVO infoVO : insertList) {
    		try {
    			ImageVO imageVO = new ImageVO();
    			imageVO.setImg_addr(service.clientToServer("ImageFile", infoVO));
    			imageVO.setA_art_no(vo.getA_art_no());
    			service.insertImageFile1(imageVO);
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    		
    	}
    	}  
        	
    }

    @FXML
    void btnPaperFileClick(ActionEvent event) {
    	Stage stage = (Stage) btnBack.getScene().getWindow();
    	
        FileChooser fileChooser = new FileChooser(); //파일 선택하는 창이 열림

        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All file", "*.*")); // 보여줄, 저장할 파일의 형식


        File selectedFile = fileChooser.showOpenDialog(stage);
        ApprFile = selectedFile; //apprfile은 선택된 파일이다.
        
        txtPaper.clear();
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
        imgView.setId(insertList.size()+"");
        imgView.setFitHeight(135);
        imgView.setFitWidth(135);
        imgView.setImage(img);
       
        try {
        FileInputStream fis = new FileInputStream(selectedFile);
		byte[] buffer = new byte[(int) selectedFile.length()];
		fis.read(buffer);
		
		FileInfoVO fileInfoVO = new FileInfoVO();
		fileInfoVO.setFileData(buffer);
		fileInfoVO.setFileName(selectedFile.getName());
		insertList.add(fileInfoVO);
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
			imgView.setOnMouseClicked(new EventHandler<Event>() {
				@Override
				public void handle(Event event) {
					insertList.remove(hBoxImg.getChildren().remove(hBoxImg.getChildren().indexOf(imgView)).getId());
				}
			});
        hBoxImg.getChildren().add(imgView);
    }
    
    public void setTextField(A_articleVO articleVo) {
    	vo = articleVo;
    	txtName.setText(articleVo.getA_art_name());
    	//-----------------------------------------------------------

    	for(CategoryAVO Avo:CA.getItems()) {
    		if(Avo.getCat_a_no().equals(articleVo.getCat_a_no())) {    			
    			CA.setValue(Avo);
    			break;
    		}
    	}
    	for(CategoryBVO Bvo:CB.getItems()) {
    		if(Bvo.getCat_b_no().equals(articleVo.getCat_b_no())) {    			
    			CB.setValue(Bvo);
    			
    			break;
    		}
    	}
    	for(CategoryCVO Cvo:CC.getItems()) {
    		if(Cvo.getCat_c_no().equals(articleVo.getCat_c_no())) {    			
    			CC.setValue(Cvo);
    			
    			break;
    		}
    	}
    	//-----------------------------------------------------------
    	try {
			String a = service.getcourtAdd(articleVo.getCou_no());
			for(String courtAdd: courtAddrCom.getItems()) {
				if(courtAdd.equals(a)) {
					courtAddrCom.setValue(courtAdd);
				}
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
    	for(CourtVO courtVo :  CourtCom.getItems()) {
    		if(courtVo.getCou_no().equals(articleVo.getCou_no())) {
    			CourtCom.setValue(courtVo);
    			break;
    		}
    	} 	
    	B_txtAdd1.setText(articleVo.getA_art_addnum());
    	B_txtAdd2.setText(articleVo.getA_art_loc());
    	txtLow.setText(articleVo.getA_art_low());
    	txtPaper.setText(articleVo.getA_art_appr());
    	txtPrice.setText(articleVo.getA_art_price());
    	//--------------------------------------------------날짜
    	String full = articleVo.getA_art_day();
    	String fday = full.split(" ")[0];
    	String ftime = full.split(" ")[1];
    	String hour = ftime.split(":")[0];
    	String minute = ftime.split(":")[1];
    	
    	for(String h : txtH.getItems()) {
    		if(h.equals(hour)) {
    			txtH.setValue(h);
    		}
    	}
    	for(String m : txtM.getItems()) {
    		if(m.equals(minute)) {
    			txtM.setValue(m);
    		}
    	}
    	//--------------------------------------------------
    	txtArea.setText(articleVo.getA_art_area());
    	
    	 txtName.setEditable(false);
         CA.setDisable(true);
         CB.setDisable(true);
         CC.setDisable(true);
         CourtCom.setDisable(true);
         B_txtAdd1.setEditable(false);
         B_txtAdd2.setEditable(false);
         btnAddSearch_B.setDisable(false);
         txtLow.setEditable(false);
         txtPaper.setEditable(false);
         btnPaperFile.setDisable(true);
         txtPrice.setEditable(false);
         btnPic.setDisable(true);
         txtArea.setEditable(false);
         btnOK.setDisable(true);
         courtAddrCom.setDisable(true);
         txtH.setDisable(true);
         txtM.setDisable(true);
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate localDate = LocalDate.parse(fday, formatter);
         datepicker.setValue(localDate);
         
         
         try {
			List<FileInfoVO> imgList= service.ImgServerToClient(articleVo);
			for(FileInfoVO infoVO : imgList) {
				File file = new File(infoVO.getFileName());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(infoVO.getFileData());
				fos.flush();
				
				FileInputStream fis = new FileInputStream(file);
			
				Image image = new Image(fis);
				
				
				ImageView imageView = new ImageView();
				imageView.setImage(image);
				imageView.setId(infoVO.getFileName());
				imageView.setFitHeight(135);
				imageView.setFitWidth(135);
				imageView.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						Map<String,String> info = new HashMap<String, String>();
						info.put("no", articleVo.getA_art_no());
						info.put("name", hBoxImg.getChildren().remove(hBoxImg.getChildren().indexOf(imageView)).getId());
						deleteList.add(info);
					}
				});
			
				hBoxImg.getChildren().add(imageView);
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
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
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if (item == null || empty) {
							setText(null);
						} else {
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
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getCat_a_name());
				}
			}
		});

		List<CategoryBVO> Blist = null;
		try {
			Blist = service.getAllBCategory(CA.getItems().get(0).getCat_a_no());
		} catch (RemoteException e) {
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
						if (item == null || empty) {
							setText(null);
						} else {
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
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getCat_b_name());
				}
			}
		});
//----------------------------------------------------------------------------------------------------------------    	
		// 콤보박스 설정(소분류)
		List<CategoryCVO> Clist = null;
		try {
			Clist = service.getAllCCategory(CB.getItems().get(0).getCat_b_no());
		} catch (RemoteException e) {
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
						if (item == null || empty) {
							setText(null);
						} else {
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
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getCat_c_name());
				}
			}
		});
		
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
     		
		});courtAddrCom.setButtonCell(new ListCell<String>() {
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
		//txtH.setValue(txtH.getItems().get(0));
		
		txtM.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
								"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
								"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", 
								"31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
								"41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
								"51", "52", "53", "54", "55", "56", "57", "58", "59");
		//txtM.setValue(txtM.getItems().get(0));
    	
    	
    	
		B_txtAdd1.setEditable(false);
		B_txtAdd2.setEditable(false);
//		detailAdd1.setEditable(false);
		txtPaper.setEditable(false);
		datepicker.setEditable(false);
		
		
    }
}
