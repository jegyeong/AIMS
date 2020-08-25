package kr.or.ddit.controller.adminmypage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.mypage.MymemIntersetController;
import kr.or.ddit.service.adminmypage.ImemberInfoService;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.vo.Article_ResultVO;
import kr.or.ddit.vo.InterestArticleVO;
import kr.or.ddit.vo.InterestVO;

import kr.or.ddit.vo.MemberVO;

public class MemberInfoModifyController {
	
	
	private ImemberInfoService service;
	private IMymemberService intservice;
	private ObservableList<MemberVO> data;
	private String confirmNumber = "";
	private MemberVO memInfoVO;
//	private InterestVO interVO;
//	private InterestArticleVO intArtiVO;
//	private Article_ResultVO aresutVO;
	
	
	private  MymemIntersetController interestController;
	
	public MymemIntersetController getInterestController() {
		return interestController;
	}
	
	public void setMainController(MymemIntersetController interestController) {
		this.interestController=interestController;
	}
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane memberView;
    @FXML
    private AnchorPane memVIEW;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfPass;

    @FXML
    private TextField tfRePass;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfReg;

    @FXML
    private TextField tfAdd;
    
    @FXML
    private TextField tfAdd2;

    @FXML
    private TextField tfTel;

 

    @FXML
    private Label passLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label telLabel;

    @FXML
    private Label regLabel;

    @FXML
    private Label blacklistLabel;
    
    @FXML
    private Label labelEmail;
    

    @FXML
    private Button btnnumCom;

    @FXML
    private Button btnAddSerach;

    @FXML
    private Button btnemailCon;
    
    @FXML
    private Button btnModify;

    @FXML
    private Button btnhome;

    @FXML
    private Button btnDelete;
    
    
    // 주소 검색 버튼 
    @FXML
    void btnAddSearch(MouseEvent event) {
    	try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(Class.forName("kr.or.ddit.controller.adminmypage.MemberInfoModifyController").getResource("../../fxml/adminmypage/AddSearch.fxml"));
            Parent root = (Parent)fxmlLoader.load();
            Stage primaryStage = (Stage) btnAddSerach.getScene().getWindow();
            
            Stage primaryStage2 = new Stage(StageStyle.DECORATED);
            primaryStage2.initModality(Modality.WINDOW_MODAL);
            primaryStage2.initOwner(primaryStage);
            
            AddSearch controller = fxmlLoader.getController();
            controller.setDialog(this);
            
            Scene scene = new Scene(root);
            primaryStage2.setScene(scene);
            primaryStage2.setTitle("주소 검색");
            primaryStage2.show();
            
         } catch (Exception e) {
            e.printStackTrace();
         }
    }

    
    
    	
    public void inputAddr(String zipcode, String addr) { // 3번째 창한테 받은 정보
    	tfAdd.setText(zipcode);
    	tfAdd2.setText(addr);
    }
    
    
    
    // 회원정보 삭제 버튼 
    @FXML
    void btnDelete(ActionEvent event) throws ClassNotFoundException {
    	//삭제 버튼 누르면 경고창 나오고 나가는 거 메인화면으로 
    	try {

//        	AlertUtil.showAlert(currentStage, "내 정보를 삭제 ","하시겠습니까?","취소","삭제");
    		
    		Parent alert = FXMLLoader
    				.load(Class.forName("kr.or.ddit.controller.adminmypage.MemberInfoModifyController").getResource("../../AlertDialog/AlertDialog2.fxml "));
    		Stage del =  (Stage) btnDelete.getScene().getWindow();
    		String yes = "삭제";
    		String no = "취소";
    		boolean a = AlertUtil.showAlert(del, "삭제하시겠습니까?", "",yes,no);
    		int cnt  = 0;
    		if(a == false) {
    			return;
    		}else {
    			String id = tfId.getText();
    			
    			cnt = service.updateActive(id);
    		}
    				
    		if(cnt>0) {
    			AlertUtil.showAlert(del, "삭제하였습니다.");
    		}else {
    			AlertUtil.showAlert(del, "삭제 작업 실패!!");
    		}
    		
        	
    		Stage currentStage =  (Stage) btnDelete.getScene().getWindow();
        	FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.adminmypage.MemberInfoModifyController").getResource("../../fxml/adminmypage/memberInfo.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
    		Parent root = loader.load();
    		MemberInfoController memberInfo = loader.getController();
    		memberInfo.setMainController(this);
    		Scene scene = new Scene(root);
    		currentStage.setScene(scene);
    		currentStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
		    
    }
    
    

    
    
    
 

    // 홈으로 버튼
    @FXML
    void btnHome(ActionEvent event) throws ClassNotFoundException {
    	//홈으로 버튼 누르면 경고창 나오고  이동버튼 누르면 첫 화면으로 이동
    	try {
    		Stage currentStage =  (Stage) btnhome.getScene().getWindow();
        	AlertUtil.showAlert(currentStage, "메인페이지로 이동하시겠습니까? ","변경된 정보는 저장되지 않습니다.","취소","이동");
        		
    		FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.adminmypage.MemberInfoModifyController").getResource("../../fxml/adminmypage/memberInfo.fxml")); //홈으로 이동하는곳   나중에 fxml바꾸기ㄴ
    		Parent root = loader.load();
    		MemberInfoController memberInfo = loader.getController();
    		memberInfo.setMainController(this);
    		Scene scene = new Scene(root);
    		currentStage.setScene(scene);
    		currentStage.show();
    		
    	
    		
		} catch (IOException e) {
			// TODO: handle exception
		}
    }
    // 수정버튼
    @FXML
    void btnModify(ActionEvent event) {
    	
    	if(tfId.getText().isEmpty() || tfPass.getText().isEmpty() || tfPass.getText().isEmpty() || tfRePass.getText().isEmpty() 
    			|| tfName.getText().isEmpty() || tfReg.getText().isEmpty() || tfTel.getText().isEmpty() || tfAdd.getText().isEmpty() || tfAdd2.getText().isEmpty()) {
    		
    		Stage currentStage =  (Stage) btnModify.getScene().getWindow();
        	AlertUtil.showAlert((Stage) btnModify.getScene().getWindow(), "빈칸을 입력해주세요");
    	}else {
    		Stage currentStage =  (Stage) btnModify.getScene().getWindow();
        	AlertUtil.showAlert((Stage) btnModify.getScene().getWindow(), "회원정보를 수정하시겠습니까?"); 
        		
        	// 수정한 데이터 저장하는거 
        	memInfoVO = new MemberVO();
        	memInfoVO.setMem_id(tfId.getText());
        	memInfoVO.setMem_pass(tfPass.getText());
        	memInfoVO.setMem_name(tfName.getText());
        	memInfoVO.setMem_regno(tfReg.getText());
        	memInfoVO.setMem_tel(tfTel.getText());
        	memInfoVO.setMem_zip(tfAdd.getText());
        	memInfoVO.setMem_addr(tfAdd2.getText());
        	
        	
        	
        	
        	try {
    			int cnt = service.updateMember(memInfoVO);
    		} catch (RemoteException e) {
    			// TODO: handle exception
    			e.printStackTrace();
    		}
        	
        	
        	
        	
        	
        	try {
        		FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.adminmypage.MemberInfoModifyController").getResource("../../fxml/adminmypage/memberInfo.fxml"));
        		Parent root = loader.load();
        		MemberInfoController memif = loader.getController();
        		memif.setMainController(this);
        		Scene scene = new Scene(root);
        		currentStage.setScene(scene);
        		currentStage.show();
        		
        		
        		
    		} catch (Exception e) {
    			// TODO: handle exception
    		}
    	
    	
    	}
    	
    	
    	
    		
    	
    	
    	
    }
    
    private MemberVO mifVO;
    
    
    // 화면 전환해서 보여지는거 
    public void show(MemberVO mifVO) {
		
		  this.mifVO = mifVO; 
		  tfId.setText(mifVO.getMem_id());
		  tfPass.setText(mifVO.getMem_pass());
		  //textPassRe.setText(mifVO.getMem_pass());
		  tfName.setText(mifVO.getMem_name()); 
		  tfReg.setText(mifVO.getMem_regno());
		  tfTel.setText(mifVO.getMem_tel());
		  blacklistLabel.setText(mifVO.getMem_blacklist());
		  tfAdd.setText(mifVO.getMem_zip()); 
		  tfAdd2.setText(mifVO.getMem_addr());
		  // 아이디 값은 비활성화 
		  tfId.setEditable(false);
		  
    }
    
    

    @FXML
    void initialize() {
    	
    	// service 생성
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			
			service = (ImemberInfoService) reg.lookup("ImemberInfoService");
		} catch (RemoteException e) {
			e.printStackTrace();
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
       
    	

    	
    	// 정규식---------------------------------------------------------------------------------------------------------       
         
         // 패스워드
         tfPass.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("[A-Za-z0-9_-]{5,15}")) {
              if(!newValue.matches("\\d*")) {
            	  tfPass.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,15}", ""));
            	  passLabel.setText("5-15자의 영문자, 숫자만 가능");
              }
           } else if(newValue.matches("[A-Za-z0-9_-]{5,15}")) {
        	   passLabel.setText(" ");
           }
        });
         
       //   패스워드 일치
         tfRePass.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!tfPass.getText().equals(tfRePass.getText())) {
        	   passLabel.setText("비밀번호가 일치하지 않습니다.");   
           }else if (newValue.equals(tfRePass.getText())) {
        	   passLabel.setText("");   
              
           }
         });
        
        // 이름
         tfName.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("^[가-힣]*$")) {
              if(!newValue.matches("\\d*")) {
            	  tfName.setText(newValue.replaceAll("^[가-힣]*$", ""));
                 nameLabel.setText("정확한  한글 이름을 입력해 주세요.");
              }
           }else if(newValue.matches("^[가-힣]*$")) {
        	   nameLabel.setText(" ");
           }
        });
        
        // 주민등록번호
        tfReg.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("[0-9]{6}\\-[0-9]{7}$")) {
              if(!newValue.matches("\\d*")) {
            	  tfReg.setText(newValue.replaceAll("[0-9]{6}\\-[0-9]{7}$", ""));
                 regLabel.setText("주민번호 13자리를 입력해주세요. ex) 123456-1234567");
              }
           }else if(newValue.matches("[0-9]{6}\\-[0-9]{7}$")) {
              regLabel.setText(" ");
           }
        });

        // 전화번호
        tfTel.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("[0-9]{3}\\-[0-9]{4}\\-[0-9]{4}$")) {
              if(!newValue.matches("\\d*")) {
            	  tfTel.setText(newValue.replaceAll("[0-9]{3}\\-[0-9]{4}\\-[0-9]{4}$", ""));
                 telLabel.setText("형식에 맞게 입력해주세요. ex) 010-1234-5678");
              }
           }else if(newValue.matches("[0-9]{3}\\-[0-9]{4}\\-[0-9]{4}$")) {
              telLabel.setText(" ");
           }
        });
        
    	
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
     	
        
    	
    	
       
    	}
    }

