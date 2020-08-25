package kr.or.ddit.controller.InformationUse;

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.InformationUse.IAgencyService;
import kr.or.ddit.service.InformationUse.IManagerFAQService;
import kr.or.ddit.vo.CourtVO;
import kr.or.ddit.vo.FAQVO;

public class ManagerFAQDetailsController {
	
	public FAQVO faqVoInfo;
	
	public FAQVO getFaqVoInfo() {
		return faqVoInfo;
	}

	public void setFaqVoInfo(FAQVO faqVoInfo) {
		this.faqVoInfo = faqVoInfo;
	}

    
    private ObservableList<FAQVO> faqTableList;
    private IManagerFAQService service;
    private FAQVO faqVo;
	
	private ObservableList<File> fileData;
	
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private AnchorPane contentsArea;
    
    public AnchorPane getContentsArea() {
    	return contentsArea;
    }
    
    public void setContentsArea(AnchorPane contentsArea) {
    	this.contentsArea = contentsArea;
    }
    @FXML
    private URL location;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea tfContents;

    @FXML
    private TextField tfFile;

    @FXML
    private Button btnConfirm;
    
    @FXML
    private Button btnModify;
    
    @FXML
    private Button btnFrontModi;
    
    @FXML
	private ListView<File> lv_File;
    
    @FXML
	private Button btnFileAdd;

	@FXML
	private Button btnFileDelete;
	
	 @FXML
	 private Button btnFrontDelete;
	
	
    
	
    
    public void setName(FAQVO faqVo) {
    	this.faqVo = faqVo;
    	tfTitle.setText(faqVo.getFaq_title());
    	tfContents.setText(faqVo.getFaq_content());
    }
    
    //활성화상태로 만드는 버튼
    @FXML
    void btnFrontModiClicked(ActionEvent event) {
    	
    	//ManagerFAQServiceImpl service;
    	//수정 가능한 상태로 만들기
        tfTitle.setEditable(true);
        tfContents.setEditable(true);
        lv_File.setVisible(true);
        btnFileAdd.setVisible(true);
        btnFileDelete.setVisible(true);
        //btnConfirm.setDisable(true);
        
    }
    
    @FXML
    void btnFileAddClicked(ActionEvent event) {
//    	Stage stage = (Stage) btnFileAdd.getScene().getWindow();
//    	FileChooser fileChooser = new FileChooser();
//    	
//    	fileChooser.getExtensionFilters().addAll(new E )
    	

    }

    @FXML
    void btnFileDeleteClicked(ActionEvent event) {

    }
    
    //수정한거 등록하는 버튼
    //값을 받아와서 DB에 저장하기
    @FXML
    void btnModifyClicked(ActionEvent event) {
    	//alert창
    	if(AlertUtil.showAlert((Stage) btnConfirm.getScene().getWindow(), "FAQ를등록하시겠습니까?")) {
	    	String title = tfTitle.getText();
	        String content = tfContents.getText();
	        
	         //비어있으면 비활성화
	         if(title==null) {
	         	btnModify.setDisable(true);
	         	tfTitle.requestFocus();
	         }
	         if(content==null) {
	         	btnModify.setDisable(true);
	         	tfContents.requestFocus();
	         }
	         
	         //FAQVO faqVo = new FAQVO();
	         faqVo.setFaq_title(title);
	         faqVo.setFaq_content(content);
	         
	         //중복검사.
	         try {
				int cnt = service.updateFAQ(faqVo); 
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//         if(cnt>0) {
	//        	 //AlertUti.infoMsg("저장 성공!");
	//        	 tfTitle.clear();
	//        	 tfContents.clear();
	//         }
	         tfTitle.setEditable(false);
	         tfContents.setEditable(false);
    	}
    }
    
    //삭제버튼
    @FXML
    void btnFrontDeleteClicked(ActionEvent event) {
    	if(AlertUtil.showAlert((Stage) btnConfirm.getScene().getWindow(), "FAQ삭제하시겠습니까?")) {
    		String faqNo = faqVo.getFaq_no();
    		int cnt = 0;
    		try {
				cnt = service.deleteFAQ(faqNo);
			} catch (RemoteException e) {
				
				e.printStackTrace();
			}
    		
    		if(cnt!=0) {
    			try {
            		FXMLLoader loader = new FXMLLoader(ManagerFAQDetailsController.class.getResource("../../fxml/InformationUse/ManagerFAQ.fxml"));
            		Parent root = loader.load();
            		ManagerFAQController mfadCon = loader.getController();
            		mfadCon.setContentsArea(contentsArea);
            		mfadCon.setFaqVoInfo(getFaqVoInfo());
            		
            		if(contentsArea.getChildren().size()!=0) {
            			for(int i=0; i<contentsArea.getChildren().size(); i++) {
            				contentsArea.getChildren().remove(i);
            			}
            		}
            		contentsArea.getChildren().add(root);
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
    		}else {
    			return;
    		}
    		
    		
    		
    	}
    }
    
    
    
    @FXML
    void btnConfirmClicked(ActionEvent event) {
//    	Stage currentStage = (Stage) btnConfirm.getScene().getWindow();
//    	
//    	//currentStage.close();
//    	currentStage.toBack();
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(ManagerFAQDetailsController.class.getResource("../../fxml/InformationUse/ManagerFAQ.fxml"));
    		Parent root = loader.load();
    		ManagerFAQController mfadCon = loader.getController();
    		mfadCon.setContentsArea(contentsArea);
    		mfadCon.setFaqVoInfo(getFaqVoInfo());
    		
    		if(contentsArea.getChildren().size()!=0) {
    			for(int i=0; i<contentsArea.getChildren().size(); i++) {
    				contentsArea.getChildren().remove(i);
    			}
    		}
    		contentsArea.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    


	@FXML
    void initialize() {
      //service객체 생성
    	try {
			Registry reg = LocateRegistry.getRegistry(8888);
			service = (IManagerFAQService) reg.lookup("ManagerFAQ");
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
        
        faqTableList = FXCollections.observableArrayList();
        
        //수정 불가능한 상태로 만들기
        tfTitle.setEditable(false);
        tfContents.setEditable(false);
        //btnConfirm.setDisable(true);
//        lv_File.setVisible(false);
//        btnFileAdd.setVisible(false);
//        btnFileDelete.setVisible(false);
  
        
    }
	
	
}
