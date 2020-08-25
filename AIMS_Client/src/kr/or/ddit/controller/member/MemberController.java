package kr.or.ddit.controller.member;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.AgreeView.AgreeViewController;
import kr.or.ddit.controller.main.MainPageLoginController;
import kr.or.ddit.service.member.IService;
import kr.or.ddit.vo.MemberVO;

// 회원가입 화면
public class MemberController {

	private IService service;
	private ObservableList <MemberVO> data;
	private List<MemberVO> memList;
	private MemberVO memVO;
	private String confirmNumber ="";
	private MemberController memberController;
	
	public MemberController getMemberController() {
		return memberController;
	}
	
	public void setMemberController(MemberController memberController) {
		this.memberController = memberController;
	}
	
	
    public AnchorPane getMemberView() {
		return memberView;
	}

	public void setMemberView(AnchorPane memberView) {
		this.memberView = memberView;
	}


	  @FXML
	    private AnchorPane memberView;

	    @FXML
	    private TextField tfid;

	    @FXML
	    private PasswordField tfpass;

	    @FXML
	    private PasswordField tfRePass;

	    @FXML
	    private TextField tfname;

	    @FXML
	    private TextField tfreg;

	    @FXML
	    private TextField tfadd;

	    @FXML
	    private TextField tfTel;

	    @FXML
	    private TextField tfEmail;

	    @FXML
	    private TextField tfNum;

	    @FXML
	    private Button btnJungbokCon;

	    @FXML
	    private Button btnNumCom;

	    @FXML
	    private Button btnConfirm;

	    @FXML
	    private Button btnHome;

	    @FXML
	    private Button btnAddSerach;

	    @FXML
	    private TextField tfadd2;

	    @FXML
	    private Button btnEmailCon;

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
	    private Label labelEmail;
	  
	    @FXML
	    private Button btnAdd;


    
    private void mail() {
    	try {
			
    	 String host = "smtp.naver.com";
         String user = "xovud925@naver.com";   // 계정
         String password = "wldms*36810";         // 패스워드
         
         // SMTP 서버 정보를 설정
         Properties props =new Properties();
         props.put("mail.smtp.host", host);
         props.put("mail.smtp.port", 587);
         props.put("mail.smtp.auth", "true");
         
         Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(user, password);
            }
         });
         
         try {
           MimeMessage message = new MimeMessage(session);
           message.setFrom(new InternetAddress(user)); 
           message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(tfEmail.getText()));
           
           // 메일 제목
           message.setSubject("안녕하세요. 경매관리시스템 AIMS 입니다.");
           
           // 메일 내용
          
           for( int i  = 0;   i < 6; i++) {
        	  int a =(int)(Math.random()*10);
        	  confirmNumber+=a+"";
           }
           
           message.setText("인증번호는" + ""+confirmNumber+""+"입니다.");
          
           
           
           
           // 메일 보내기
           Transport.send(message);
           System.out.println(message);
           System.out.println("메일 전송 완료!");

            
        } catch (MessagingException e) {
           e.printStackTrace();
           System.out.println("전송실패");
        }
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    }
    
    
    // 이메일 확인 버튼
    @FXML
    void btnEmailCon(MouseEvent event) {
    	//불러오기
    	
    	Stage stage = (Stage) btnEmailCon.getScene().getWindow();
    	
    	if(tfEmail.getText().isEmpty()) {
    		AlertUtil.showAlertOnlyConfirm(stage, "입력하신 이메일을  다시 확인해주세요", "확인");
    		
    	}else {
    	AlertUtil.showAlertOnlyConfirm(stage, "이메일이 전송되었습니다. 확인해주세요", "확인");
    	}
    	
    	
    	mail();
    }
    
    // 주소 검색 버튼  
    @FXML
    void btnAddSearch(MouseEvent event) {
    	 try {
	            
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxml/member/AddSearch.fxml"));
	            Parent root = fxmlLoader.load();
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
    
    // 입력창에 정보 넣는거 
    public void inputAddr(String zipcode, String addr) { // 3번째 창한테 받은 정보
    	tfadd.setText(zipcode);
    	tfadd2.setText(addr);
    }
    
    // 확인 버튼 
    @FXML
    void btnConfirm(ActionEvent event) throws RemoteException, ClassNotFoundException {
    	memVO = new MemberVO();
    	memVO.setMem_id(tfid.getText());
    	memVO.setMem_name(tfname.getText());
    	memVO.setMem_pass(tfpass.getText());
    	memVO.setMem_tel(tfTel.getText());
    	memVO.setMem_email(tfEmail.getText());
    	memVO.setMem_regno(tfreg.getText());
    	memVO.setMem_zip(tfadd.getText());
    	memVO.setMem_addr(tfadd2.getText());
    	
    	
    	if(!(memVO.getMem_id().isEmpty() || memVO.getMem_name().isEmpty() ||memVO.getMem_pass().isEmpty() || memVO.getMem_regno().isEmpty()||
    			memVO.getMem_tel().isEmpty() || memVO.getMem_addr().isEmpty() || memVO.getMem_zip().isEmpty() || memVO.getMem_email().isEmpty())) {
    			int cnt = service.insertMemberJoin(memVO);
			if (cnt > 0) {
				Stage currStage = (Stage) btnConfirm.getScene().getWindow();
				AlertUtil.showAlertOnlyConfirm((Stage) btnConfirm.getScene().getWindow(), "축하합니다!! 회원가입 되셨습니다.", "확인");
				
				try {
					FXMLLoader loader = new FXMLLoader(
							Class.forName("kr.or.ddit.controller.member.MemberController").getResource("../../fxml/main/MainPage.fxml"));
					Parent root = loader.load();

					Scene scene = new Scene(root);
					currStage.setScene(scene);
					currStage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
    		
    	}else {
    		Stage currStage = (Stage) btnConfirm.getScene().getWindow();
    		AlertUtil.showAlertOnlyConfirm((Stage) btnConfirm.getScene().getWindow(), "빈칸을 입력해주세요.","확인");
    	}
    }

    // 홈으로 버튼 
    @FXML
    void btnHome(ActionEvent event) throws ClassNotFoundException {
    	// 버튼을 누르면 화면 전환 
    	try {
			Stage currentStage = (Stage) btnHome.getScene().getWindow();
			if (AlertUtil.showAlert(currentStage, "홈으로", "이동하시겠습니까?", "이동", "취소")) {

				FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.member.MemberController").getResource("../../fxml/main/MainPage.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				currentStage.setScene(scene);
				currentStage.show();
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    
    // 인증번호 확인
    @FXML
    void btnNumCon(MouseEvent event) {
    	if(tfNum.getText().equals(confirmNumber)) {
    		//일치했을때
    		Stage currStage = (Stage) btnConfirm.getScene().getWindow();
    		AlertUtil.showAlert((Stage)btnConfirm.getScene().getWindow(),"입력하신 인증번호가 ","확인되었습니다.","확인","취소");
    		btnConfirm.setDisable(false);
    	}else {
    		//일치하지 않을때
    		Stage currStage = (Stage) btnConfirm.getScene().getWindow();
    		AlertUtil.showAlert((Stage)btnConfirm.getScene().getWindow(),"입력하신 인증번호가 ","틀렸습니다.","확인","취소");
    	}
    }
    
    
    
    
    // id중복확인 버튼 
    @FXML
    void btnjungbokCon(MouseEvent event) throws RemoteException {
    	String id = tfid.getText();
    	if(service.getMemberId(id) != null) {
    		Stage currStage = (Stage) btnJungbokCon.getScene().getWindow();
    		AlertUtil.showAlert((Stage) btnJungbokCon.getScene().getWindow(), "이미 사용되고 있는 ","아이디 입니다.","확인","취소");	
    	}else {
    		Stage currStage = (Stage) btnJungbokCon.getScene().getWindow();
    		AlertUtil.showAlert((Stage) btnJungbokCon.getScene().getWindow(), "사용 가능한 ","아이디입니다.","확인","취소");
    	}

    }
 
    
	 
    
    @FXML
    void initialize() {
    	try {
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (IService) reg.lookup("IService");
		} catch (RemoteException e) {
			e.printStackTrace();
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
	
		

  
//    	// 비밀번호 입력창 정규식 확인 
//    	pass.textProperty().addListener(new ChangeListener<String>() {
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//
//
//				String p = "^[a-z0-9_-]{6,18}$";
//				
//				System.out.println(newValue);
//				
//				if((newValue.equals(p))) {
//						passLabel.setText("사용 가능한 비밀번호 형식 입니다.");
//					}else {
//						passLabel.setText("형식에 맞는 비밀번호를 넣어주세요.");
//					}
//			}
//		});
 
    	
    
    	
    	// 입력 받는 값 저장하는거 
    	memVO = new MemberVO();
    	
    	memVO.setMem_id(tfid.getText());
    	memVO.setMem_name(tfname.getText());
    	memVO.setMem_pass(tfpass.getText());
    	memVO.setMem_regno(tfreg.getText());
    	memVO.setMem_tel(tfTel.getText());
    	memVO.setMem_email(tfEmail.getText());
    	memVO.setMem_zip(tfadd.getText());
    	memVO.setMem_addr(tfadd2.getText());

    	

    	
    	// 정규식---------------------------------------------------------------------------------------------------------       

        // 아이디
         tfid.textProperty().addListener((Observable, oldValue, newValue) -> {
            if(!newValue.matches("[A-Za-z0-9_-]{5,20}$")) {
               if(!newValue.matches("\\d*")) {
            	   tfid.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,20}$", " "));
                  idLabel.setText("5-20자의 영문자와 숫자 사용");
               }
            }else if(newValue.matches("[A-Za-z0-9_-]{5,20}$")) {
               idLabel.setText(" ");
            }
         });
         
         // 패스워드
         tfpass.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("[A-Za-z0-9_-]{5,15}$")) {
              if(!newValue.matches("\\d*")) {
            	  tfpass.setText(newValue.replaceAll("[A-Za-z0-9_-]{5,15}$", " "));
            	  passLabel.setText("5-15자의 영문자, 숫자만 가능");
              }
           } else if(newValue.matches("[A-Za-z0-9_-]{5,15}$")) {
        	   passLabel.setText(" ");
           }
        });
         
       //   패스워드 일치
         tfRePass.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!tfpass.getText().equals(tfRePass.getText())) {
        	   passLabel.setText("비밀번호가 일치하지 않습니다.");   
           }else if (newValue.equals(tfRePass.getText())) {
        	   passLabel.setText(" ");   
              
           }
         });
        
        // 이름
         tfname.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("^[가-힣]*$")) {
              if(!newValue.matches("\\d*")) {
            	  tfname.setText(newValue.replaceAll("^[가-힣]*$", " "));
                 nameLabel.setText("정확한  한글 이름을 입력해 주세요.");
              }
           }else if(newValue.matches("^[가-힣]*$")) {
        	   nameLabel.setText(" ");
           }
        });
        
        // 주민등록번호
        tfreg.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches("[0-9]{6}\\-[0-9]{7}$")) {
              if(!newValue.matches("\\d*")) {
            	  tfreg.setText(newValue.replaceAll("[0-9]{6}\\-[0-9]{7}$", ""));
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
        
        // 패스워드 일치
//        agreeBox.textProperty().addListener((Observable, oldValue, newValue) -> {
//           if(agreeBox.isSelected()) {
//              agreeCheck.setText(" ");   
//           }else {
//              agreeCheck.setText("약관에 동의해 주세요!");   
//              
//           }
//         });
        
        //agreeCheck.setText(agreeBox.isSelected() ? "동의완료!" : "약관에 동의해 주세요!");

        
 // ---------------------------------------------------------------------------------------------------------------   
      
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        
        
        // 이메일 정규식 확인 
        tfEmail.textProperty().addListener((Observable, oldValue, newValue) -> {
           if(!newValue.matches(emailPattern)) {
              if(!newValue.matches("\\d*")) {
             	 tfEmail.setText(newValue.replaceAll(emailPattern, ""));
             	 labelEmail.setText("형식에 맞는 이메일주소를 입력해주세요.");
              }
           }else if(newValue.matches(emailPattern)) {
        	   labelEmail.setText(" ");
           }
        });
        
        
        
        
    }

}
