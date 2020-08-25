package kr.or.ddit.controller.findIdPass;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
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

public class FindIdController {
	private MemberVO memberVo;
	private ILoginService service;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelName;

    @FXML
    private TextField tfName;

    @FXML
    private Label labelEmail;

    @FXML
    private TextField tfEmail;

    @FXML
    private Button btn_confirm;

    @FXML
    private Button btnCancel;
    
    @FXML
    private Button btn_findPass;

    @FXML
    void btnCancel_clicked(MouseEvent event) throws ClassNotFoundException {
    	try {
			FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.findIdPass.loginController").getResource("../../fxml/main/MainPage.fxml"));
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
			memberVo1.setMem_email(tfEmail.getText());
			
			memberVo = service.findIdUser(memberVo1);
			
			if(memberVo!=null) {
				AlertUtil.showAlertOnlyConfirm((Stage) btn_confirm.getScene().getWindow(), "회원님의 id는"+memberVo.getMem_id()+"입니다.", "확인");
			}else if(tfName.getText().equals("")||tfEmail.getText().equals("")) {
				AlertUtil.showAlertOnlyConfirm((Stage) btn_confirm.getScene().getWindow(), "빈칸을 모두 입력해주세요", "확인");
			}else {
				AlertUtil.showAlertOnlyConfirm((Stage) btn_confirm.getScene().getWindow(), "없는 정보입니다. 다시 확인해주세요", "확인");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btn_findPass_clicked(MouseEvent event) throws ClassNotFoundException {
    	try {
			FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.findIdPass.loginController").getResource("../../fxml/findIdPass/FindPass.fxml"));
			Parent root = loader.load();
			FindPassController logCon = loader.getController();
			Stage stage = (Stage) btn_confirm.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void labelEmail_clicked(MouseEvent event) {
    	tfEmail.requestFocus();
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