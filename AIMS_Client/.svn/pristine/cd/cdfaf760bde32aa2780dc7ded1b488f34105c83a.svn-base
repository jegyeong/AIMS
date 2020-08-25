package kr.or.ddit.controller.mypage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import com.sun.mail.util.QEncoderStream;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.FileInfoVO;

public class AnswerPopUpController {
	Com_AnswerVO answerVO;
	IMymemberService service;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView webView;

    @FXML
    private ListView<File> listView;

    @FXML
    private Label tfTitle;

    public void setdata(Com_AnswerVO answerVO) {
    	this.answerVO = answerVO;
    	tfTitle.setText(answerVO.getCom_ans_title());
    	
    	webView.getEngine().loadContent(answerVO.getCom_ans_content());
    	
    	try {
			for(FileInfoVO infoVO : service.AnsFileServerToClient(answerVO.getCom_ans_no())) {
				File file = new File(infoVO.getFileName());
				FileInputStream fis = new FileInputStream(file);
				fis.read(infoVO.getFileData());
				listView.getItems().add(file);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    @FXML
	void initialize() {
		try {

			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (IMymemberService) reg.lookup("IMymemberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		listView.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if(listView.getSelectionModel().getSelectedItem() == null) return;
				
				AlertUtil.showDonwload((Stage)tfTitle.getScene().getWindow(), listView.getSelectionModel().getSelectedItem());
			}
		});
	}
}
