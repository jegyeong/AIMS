package kr.or.ddit.controller.findIdPass;

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

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.login.loginController;
import kr.or.ddit.controller.main.MainPageController;
import kr.or.ddit.service.login.ILoginService;
import kr.or.ddit.vo.MemberVO;

public class FindPassController {
	private MemberVO memberVo;
	private ILoginService service;
	
	String temporaryPass="";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelName;

    @FXML
    private TextField tfName;

    @FXML
    private Label labelId;

    @FXML
    private TextField tfId;

    @FXML
    private Label labelRegno;

    @FXML
    private TextField tfRegNo;

    @FXML
    private Button btn_confirm;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel_clicked(MouseEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(loginController.class.getResource("../../fxml/main/MainPage.fxml"));
			Parent root = loader.load();
			MainPageController logCon = loader.getController();
			Stage stage = (Stage) btn_confirm.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btn_confirm_clicked(MouseEvent event) {
    	try {
			Stage confirm = (Stage) btn_confirm.getScene().getWindow();
			MemberVO memberVo1 = new MemberVO();
			memberVo1.setMem_name(tfName.getText());
			memberVo1.setMem_id(tfId.getText());
			memberVo1.setMem_regno(tfRegNo.getText());
			memberVo = service.findPassUser(memberVo1);
			
			if(memberVo!=null) {
				//메일보내긔
				//MemberController mail부분 확인하긔
				AlertUtil.showAlertOnlyConfirm((Stage) btn_confirm.getScene().getWindow(), "임시 비밀번호가 발송됩니다. 로그인 후 바로 비밀번호를 수정해주세요", "확인");
				//임시비밀번호 발급
	            for(int i = 0;   i < 7; i++) {
	          	  int a =(int)(Math.random()*10);
	          	  temporaryPass+=a+"";
	            }
	            memberVo.setMem_pass(temporaryPass);
	            int cnt = service.updateTemporaryPass(memberVo);
	            mail(); //메일함수 호출
				
			}else if(tfName.getText().equals("")||tfId.getText().equals("")||tfRegNo.getText().equals("")) {
				AlertUtil.showAlertOnlyConfirm((Stage) btn_confirm.getScene().getWindow(), "빈칸을 모두 입력해주세요", "확인");
			}else {
				AlertUtil.showAlertOnlyConfirm((Stage) btn_confirm.getScene().getWindow(), "없는 정보입니다. 다시 확인해주세요", "확인");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    private void mail() {
    	try {
			String emailAddr = memberVo.getMem_email();
			String finPass = memberVo.getMem_pass();
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
              message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(emailAddr));
              
              // 메일 제목
              message.setSubject("안녕하세요. 경매관리시스템 AIMS 입니다.");
              
              
              
              
              //DB에 비밀번호 넣어주기
              
              //memberVo.setMem_pass(temporaryPass);
              
               
               message.setText("회원님의 임시 비밀번호는" + ""+temporaryPass+""+"입니다.");
              
              
              // 메일 내용
              //message.setText("비밀번호 찾기 메일입니다. 회원님의 비밀번호는" + ""+temporaryPass+""+"입니다.");
             
              
              
              
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

    @FXML
    void labelRegno_clicked(MouseEvent event) {
    	tfRegNo.requestFocus();
    }

    @FXML
    void labelId_clicked(MouseEvent event) {
    	tfId.requestFocus();
    }

    @FXML
    void labelName_clicked(MouseEvent event) {
    	tfName.requestFocus();
    }

    @FXML
    void initialize() {
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118", 8888);
			service = (ILoginService) reg.lookup("login");
		} catch (RemoteException e) {
			e.printStackTrace();

		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    }
}
