package kr.or.ddit.controller.search;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.InformationUse.SiteMapController;
import kr.or.ddit.controller.login.loginController;
import kr.or.ddit.service.search.ISearchService;
import kr.or.ddit.service.stuff.IAdminService;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.FileInfoVO;

public class DetailController {
	private AnchorPane mainAP;
	private IAdminService imeageService;
	private List<File> imageList;
	
	public AnchorPane getMainAP() {
		return mainAP;
	}

	public void setMainAP(AnchorPane mainAP) {
		this.mainAP = mainAP;
	}

	private ISearchService service;
	private A_articleVO vo;
	private A_articleVO avo;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AA;

    @FXML
    private ImageView Pic;

    @FXML
    private Label txtNum;

    @FXML
    private Label txtLocal;

    @FXML
    private Label txtCourt;

    @FXML
    private Label txtDate;

    @FXML
    private Label txtTour;

    @FXML
    private Label txtInter;

    @FXML
    private Label txtCnt;

    @FXML
    private Label txtResult;

    @FXML
    private Label txtLow;

    @FXML
    private Label txtA;

    @FXML
    private Label txtB;

    @FXML
    private Label txtC;

    @FXML
    private Label txtPrice;

    @FXML
    private Label txtArea;

    @FXML
    private Button btnInter;

    @FXML
    private Button btnBack;

    @FXML
    private HBox hBoxImg;
    // 조회수
    // 관심등록
    
    @FXML
    void btnBackClick(ActionEvent event) throws IOException {
//    	FXMLLoader loader = new FXMLLoader(ButtonController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//    	Parent root = loader.load();
//    	  	
//    	Stage stage = (Stage) btnBack.getScene().getWindow(); 
//    	Scene scene = new Scene(root);
//    	
//    	stage.setScene(scene);
//    	stage.setTitle("메인");
//    	stage.show();
    	
    	try {
			
    		FXMLLoader loader = new FXMLLoader(DetailController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
			Parent root = loader.load();
			
			ButtonController btnCon = loader.getController();
			
			btnCon.setAADialog("../../fxml/search/fxmlNum.fxml");
			
			Stage stage = (Stage) btnBack.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnInterClick(ActionEvent event) throws IOException {
    	
    	if(Session.loginUser == null) { //로그인 되어 있지 않으면
    		if(AlertUtil.showAlert((Stage) btnBack.getScene().getWindow(), "로그인이 필요한 항목입니다.", "로그인 하시겠습니까?", "확인", "취소")) {
    			FXMLLoader loader = new FXMLLoader(ButtonController.class.getResource("../../fxml/login/login.fxml"));
    	    	Parent root = loader.load();
    	    	 loginController controller = loader.getController();
    	    	 controller.setNextPage("../../fxml/search/fxmlButtonMain.fxml");
    	    	Stage stage = (Stage) btnBack.getScene().getWindow(); 
    	    	Scene scene = new Scene(root);
    	    	
    	    	stage.setScene(scene);
    	    	stage.show();
    		}
    	}else if(AlertUtil.showAlert((Stage) btnBack.getScene().getWindow(), "관심등록 하시겠습니까?") ) {
    		
    		try {
    			Map<String,String> data = new HashMap<String, String>();
    			data.put("no",vo.getA_art_no());
    			data.put("id",Session.loginUser.getMem_id());
				service.insertInter(data);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}
    }
    
    public void setTextField(A_articleVO articleVo) throws RemoteException {
    	vo = service.getInfo(articleVo.getA_art_no()); 
    	
    	
    	txtNum.setText(vo.getA_art_no());
    	txtLocal.setText(vo.getA_art_loc());
    	
    	
    	txtCourt.setText(vo.getCou_no());
    	
    	
    	txtDate.setText(vo.getA_art_day());
    	
    	String tour = vo.getA_art_tour() + "";
    	txtTour.setText(tour);
    	
    	txtInter.setText(vo.getA_art_inter());
    	
    	String cnt = vo.getA_art_cnt() + "";
    	txtCnt.setText(cnt);
    	
    	txtResult.setText(vo.getA_art_result());
    	txtLow.setText(vo.getA_art_low());
    	   
		txtA.setText(vo.getCat_a_no());
		txtB.setText(vo.getCat_b_no());
		txtC.setText(vo.getCat_c_no());
    	
		txtPrice.setText(vo.getA_art_price());
		
		txtArea.setText(vo.getA_art_area());
		

		service.updateCnt(articleVo.getA_art_no());
		
		try {
			for (FileInfoVO infoVO : imeageService.ImgServerToClient(vo)) {
				File file = new File(infoVO.getFileName());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(infoVO.getFileData());
				FileInputStream fis = new FileInputStream(file);
				Image image = new Image(fis);
				ImageView view = new ImageView(image);
				view.setFitHeight(138);
				view.setFitWidth(138);
				
				view.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						
						Pic.setImage(image);
						
					}
				});
				hBoxImg.getChildren().add(view);
				
				if(Pic.getImage()==null) {
					Pic.setImage(image);
				}
			}

			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	try {
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
 			service =  (ISearchService)reg.lookup("searchService");
 			imeageService = (IAdminService)reg.lookup("adminService");
 			
 		} catch (RemoteException e) {
 			e.printStackTrace();
 		} catch (NotBoundException e) {
 			e.printStackTrace();
 		} 

    	
    }
}
