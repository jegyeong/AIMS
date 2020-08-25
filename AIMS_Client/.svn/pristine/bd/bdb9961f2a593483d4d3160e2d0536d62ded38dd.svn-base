package kr.or.ddit.controller.notice.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.InoticeServer;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.FileInfoVO;

public class NoticeComplainAdminController {
	private AnchorPane dialog;
	public AnchorPane getDialog() {
		return dialog;
	}

	public void setDialog(AnchorPane dialog) {
		this.dialog = dialog;
	}

	private InoticeServer service;
	private Com_QuestionVO com_QuestionVO; 
    public Com_QuestionVO getCom_QuestionVO() {
		return com_QuestionVO;
	}

	public void setCom_QuestionVO(Com_QuestionVO com_QuestionVO) {
		this.com_QuestionVO = com_QuestionVO;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lb_Title;

    @FXML
    private WebView wv_content;

    @FXML
    private ListView<File> lv_file;

    @FXML
    private Button btn_Answer1;

    @FXML
    private Button btn_Back;

    @FXML
    void onClickedBtn_Answer(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(NoticeAdminMainController.class.getResource("../../../fxml/notice/admin/NoticComplainAnswerAdmin.fxml"));
    		Parent root = loader.load();
    	
    		NoticeComplainAnswerAdminController controller = loader.getController();
    		controller.setDialog(dialog);
    		controller.setdata(com_QuestionVO);
    		dialog.getChildren().remove(0);
    		dialog.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickedBtn_Back(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(NoticeAdminMainController.class.getResource("../../../fxml/notice/admin/NoticComplainListAdmin.fxml"));
    		Parent root = loader.load();
    	
    		NoticeComplainListController controller = loader.getController();
    		controller.setDialog(dialog);
    		dialog.getChildren().remove(0);
    		dialog.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickedFileDownload(MouseEvent event) {
    	File file = lv_file.getSelectionModel().getSelectedItem();
		if(file == null) return;
		
		AlertUtil.showDonwload((Stage)btn_Answer1.getScene().getWindow(), file);
		
    }
    
    public void setData(Com_QuestionVO com_QuestionVO) {
    	this.com_QuestionVO = com_QuestionVO;
    	lb_Title.setText(com_QuestionVO.getCom_que_title());
    	wv_content.getEngine().loadContent(com_QuestionVO.getCom_que_content());
    	try {
			List<FileInfoVO> list = service.questionServerToClient(service.getQuestionFileList(com_QuestionVO.getCom_que_no()));
			for(FileInfoVO data :list) {
				File file =  new File(data.getFileName());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(data.getFileData());
				fos.flush();
				lv_file.getItems().add(file);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	try {
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (InoticeServer) reg.lookup("notice");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    
    	
    }
}
