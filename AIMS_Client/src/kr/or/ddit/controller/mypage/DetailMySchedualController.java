package kr.or.ddit.controller.mypage;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.InterestVO;

public class DetailMySchedualController {

	private IMymemberService service;
	private ObservableList<InterestVO> data;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane DetailView;

    @FXML
    private TableView<A_articleVO> tcView;

    @FXML
    private TableColumn<?, ?> tcProdname;

    @FXML
    private TableColumn<?, ?> tcProdtime;

//    @FXML
//    private Button btnBack;
//
//    @FXML
//    void btnBack(ActionEvent event) { }

    @FXML
    void tcView(ActionEvent event) {

    }
    
    // db에 잇는거 불러오는거 
    public void getDetail(String year, String Month,String Day ) throws RemoteException{
    	Map<String,String> info = new HashMap<String, String>();
    	info.put("id", Session.loginUser.getMem_id());
    	info.put("day", year+Month+Day);
    	
    	
    	tcView.setItems(FXCollections.observableArrayList(service.getMydetailSH(info)));
    }
    
    
    
    
    

    @FXML
    void initialize() throws RemoteException {
    	try {
    		
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
    		service = (IMymemberService) reg.lookup("IMymemberService");
		} catch (RemoteException e) {
		e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	
    	tcProdname.setCellValueFactory(new PropertyValueFactory<>("a_art_name"));
    	tcProdtime.setCellValueFactory(new PropertyValueFactory<>("a_art_day"));
    	
    	
        
    }
}
