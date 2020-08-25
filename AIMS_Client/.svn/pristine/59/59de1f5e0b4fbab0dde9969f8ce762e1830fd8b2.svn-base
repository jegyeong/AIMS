package kr.or.ddit.controller.InformationUse;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import kr.or.ddit.service.InformationUse.IAgencyService;
import kr.or.ddit.service.InformationUse.IFAQService;
import kr.or.ddit.service.InformationUse.IManagerFAQService;
import kr.or.ddit.vo.FAQVO;


public class ManagerFAQController {
    private AnchorPane contentsArea;
   
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<FAQVO> tableView;

    @FXML
    private TableColumn<?, ?> colWriteNum;

    @FXML
    private TableColumn<?, ?> colWriteTitle;

    @FXML
    private Pagination pagintion;
    
    @FXML
    private Button btnModify;
   
    public AnchorPane getContentsArea() {
		return contentsArea;
	}

	public void setContentsArea(AnchorPane contentsArea) {
		this.contentsArea = contentsArea;
	}
	
	public FAQVO faqVoInfo;
	
	public FAQVO getFaqVoInfo() {
		return faqVoInfo;
	}

	public void setFaqVoInfo(FAQVO faqVoInfo) {
		this.faqVoInfo = faqVoInfo;
	}

	private ObservableList<FAQVO> faqTableList;
    private IManagerFAQService service;
    
//    @FXML
//    void btnDeleteClicked(MouseEvent event) {
//    	//종료
//    	Stage currentStage = (Stage) btnDelete.getScene().getWindow();
//    	currentStage.close();
//    	
//    	//alert창 띄우기
//    }
    
    
    //자세히 보기 버튼(수정)버튼 클릭
    @FXML
    void btnModifyClicked(ActionEvent event) {
    	
    	try {
    		if(tableView.getSelectionModel().isEmpty()) {
    			return;
    		}
	    	FAQVO faqVo = tableView.getSelectionModel().getSelectedItem();
	    	
	    	//컨트롤러 이거 맞아?
	    	
	    	FXMLLoader loader = new FXMLLoader(ManagerFAQController.class.getResource("../../fxml/InformationUse/ManagerFAQDetails.fxml"));
	    	
	    	Parent root = loader.load();
	    	ManagerFAQDetailsController faqCon1 = loader.getController();
	    	faqCon1.setContentsArea(getContentsArea());
	    	//뭐가 있으면 지워주기
	    	faqCon1.setFaqVoInfo(getFaqVoInfo());
			int size = contentsArea.getChildren().size();
			if(size!=0) {
				for(int i=0; i<size; i++) {
					contentsArea.getChildren().remove(0);
				}
			}
			contentsArea.getChildren().add(root);
	    	
	    	//값 넣어주기
			faqCon1.setName(faqVo);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    }

    @FXML
    void paginationCliked(MouseEvent event) {

    }
    
    @FXML
    void tableClicked(MouseEvent event) {
    	try {
	    	FAQVO faqVo = tableView.getSelectionModel().getSelectedItem();
	    	
	    	FXMLLoader loader = new FXMLLoader(ManagerFAQController.class.getResource("../../fxml/InformationUse/ManagerFAQDetails.fxml"));
	    	
	    	Parent root = loader.load();
	    	ManagerFAQDetailsController faqCon1 = loader.getController();
	    	
	    	//뭐가 있으면 지워주기
			int size = contentsArea.getChildren().size();
			if(size!=0) {
				for(int i=0; i<size; i++) {
					contentsArea.getChildren().remove(0);
				}
			}
			contentsArea.getChildren().add(root);
	    	
	    	//값 넣어주기
			faqCon1.setName(faqVo);
    	}catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void initialize() {
      //service객체 생성
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (IManagerFAQService) reg.lookup("ManagerFAQ");
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        try {
			faqTableList = FXCollections.observableArrayList(service.getAllFAQList());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        
        colWriteNum.setCellValueFactory(new PropertyValueFactory<>("faq_no"));
        colWriteTitle.setCellValueFactory(new PropertyValueFactory<>("faq_title"));
        tableView.setItems(faqTableList);

    }
}
