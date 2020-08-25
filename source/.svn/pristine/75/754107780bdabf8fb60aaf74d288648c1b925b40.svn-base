package kr.or.ddit.controller.InformationUse;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import kr.or.ddit.service.InformationUse.IAgencyService;
import kr.or.ddit.vo.AgencyVO;

public class AgencyDeitalsController {
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lableAddr;

    @FXML
    private Label lableTel;

    @FXML
    private Label lableRoad;

    @FXML
    private ImageView courtRoad;

    @FXML
    private TextField tfAddr;

    @FXML
    private TextField tfTel;

    @FXML
    private Label labelName;

    @FXML
    private TextField tfName;
    
    @FXML
    private AnchorPane anchorMap;
    
    @FXML
    private WebView webView;
    
    private ObservableList<AgencyVO> agencyList;
    private IAgencyService service;
    private AgencyVO agencyVo;
    
  //데이터 가지고 다니려고 만드는것
    private AnchorPane contentsArea;
    
    public AnchorPane getContentsArea() { 
		return contentsArea;
	}

	public void setContentsArea(AnchorPane contentsArea) {
		this.contentsArea = contentsArea;
	}
	
	public AgencyVO AgencyVoInfo;
	
	public AgencyVO getAgencyVoInfo() {
		return AgencyVoInfo;
	}

	public void setAgencyVoInfo(AgencyVO AgencyVoInfo) {
		this.AgencyVoInfo = AgencyVoInfo;
	}
	
	//값 미리 셋팅하려고 만들어 넣ㅇ느 함수
	public void setName(AgencyVO agencyVo) {
		this.agencyVo = agencyVo;

		tfName.setText(agencyVo.getCou_name());
		tfAddr.setText(agencyVo.getCou_loc());
		tfTel.setText(agencyVo.getCou_tel());
		Map<String,String> info = new HashMap<String,String>();
		info.put("cou_name", tfName.getText());
		info.put("cou_loc", tfAddr.getText());
		try {
			service.insertDataConnect(info);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }


	@FXML
    void courtRoadClicked(MouseEvent event) {

    }

    @FXML
    void tfAddrClicked(ActionEvent event) {

    }

    @FXML
    void tfNameClicked(ActionEvent event) {

    }

    @FXML
    void tfTelclicked(ActionEvent event) {

    }

   
//    
//    //지도
//    private static void initFX() {
//
//    	JFrame frame = new JFrame("FX");
//
////    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    	frame.getContentPane().setLayout(null);
//
//    	final JButton jButton = new JButton("Button");
//
//    	final JFXPanel fxPanel = new JFXPanel();
//
//    	frame.add(jButton);
//
//    	frame.add(fxPanel);
//
//    	frame.setVisible(true);
//
//    	jButton.setSize(new Dimension(200, 27));
//
//    	fxPanel.setSize(new Dimension(300, 300));
//
//    	fxPanel.setLocation(new Point(0, 27));
//
//    	frame.getContentPane().setPreferredSize(new Dimension(300, 327));
//
//    	frame.pack();
//
//    	frame.setResizable(false);
//
//    	Platform.runLater(new Runnable() {
//
//    		public void run() {
//
//    			initAndLoadWebView(fxPanel);
//
//    		}
//
//    	});
//
//    }
//
//    	
//
//    private static void initAndLoadWebView(final JFXPanel fxPanel) {
//
//    	Group group = new Group();
//
//    	Scene scene = new Scene(group);
//
//    	fxPanel.setScene(scene);
//
//    	WebView webView = new WebView();
//
//    	group.getChildren().add(webView);
//
//    	webView.setMinSize(490, 510);
//
//    	webView.setMaxSize(490, 510);
//
//    	WebEngine webEngine = webView.getEngine();
//        webEngine.load("http://localhost:8082/z_map/KakaoMap.html");
//
//    }

    @FXML
    void initialize() {
    	//SERVICE 만들기
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (IAgencyService) reg.lookup("Agency");
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
       
       agencyList = FXCollections.observableArrayList();
 
       webView.getEngine().load("http://localhost/MapAPI/AgencyMap.html");
//       webView.getChildrenUnmodifiable().addListener(new ListChangeListener<Node>() {
//    	   @Override
//    	public void onChanged(Change<? extends Node> c) {
//    		Set<Node>deadSeaScrools = webView.lookupAll(".scroll-bar");
//    		for(Node scroll:deadSeaScrools) {
//    			scroll.setVisible(false);
//    		}
//    		
//    	}
//       });
       tfName.setEditable(false);
       tfTel.setEditable(false);
       tfAddr.setEditable(false);
      
//       WebView webView = new WebView();
//       WebEngine webEngine = webView.getEngine();
//       webEngine.load("http://localhost:8082/z_map/KakaoMap.html");
//       anchorMap.getChildren().add(webView);
       
    }

    
}
