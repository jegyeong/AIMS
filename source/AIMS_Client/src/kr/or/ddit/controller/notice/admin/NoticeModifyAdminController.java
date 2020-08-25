package kr.or.ddit.controller.notice.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.NoticeVO;

public class NoticeModifyAdminController {
	private InoticeServer service;
	private AnchorPane dialog;
	private NoticeVO noticeVO;

	public AnchorPane getDialog() {
		return dialog;
	}

	public void setDialog(AnchorPane dialog) {
		this.dialog = dialog;
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
	private Button btn_Modify;

	@FXML
	private Button btn_Delete;

	@FXML
	private Button btn_Back;

	@FXML
	void onClickedBtn_Back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(
					NoticeModifyAdminController.class.getResource("../../../fxml/notice/admin/NoticeAdmin.fxml"));
			Parent root = loader.load();
			NoticeAdminController controller = loader.getController();
			controller.setDialog(getDialog());
			dialog.getChildren().remove(0);
			dialog.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void onClickedBtn_Delete(ActionEvent event) {
		Stage stage = (Stage) btn_Back.getScene().getWindow();
		if (AlertUtil.showAlert(stage, "삭제하시겠습니까?")) {
			try {
				service.deleteAllNotice_File(noticeVO.getNotice_no());
				service.deleteNotice(noticeVO.getNotice_no());
				
				try {
					FXMLLoader loader = new FXMLLoader(
							NoticeModifyAdminController.class.getResource("../../../fxml/notice/admin/NoticeAdmin.fxml"));
					Parent root = loader.load();
					NoticeAdminController controller = loader.getController();
					controller.setDialog(getDialog());
					dialog.getChildren().remove(0);
					dialog.getChildren().add(root);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
	}

	@FXML
	void onClickedBtn_Modify(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(NoticeModifyAdminController.class.getResource("../../../fxml/notice/admin/NoticModifyAdmin2.fxml"));
			Parent root = loader.load();
			NoticeModifyAdminController2 controller = loader.getController();
			controller.setModifyInfo(noticeVO);
			controller.setDialog(getDialog());
			
			dialog.getChildren().remove(0);
			dialog.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setInfoData(NoticeVO noticeVO) {
		this.noticeVO = noticeVO;
		System.out.println(this.noticeVO);
		lb_Title.setText(noticeVO.getNotice_title());
		wv_content.getEngine().loadContent(noticeVO.getNotice_content());

		ObservableList<File> fileData = null;
		List<File> fileList = new ArrayList<File>();

		try {
			for (FileInfoVO filedate : service
					.noticeServerToClient(service.getNoticeFileList(noticeVO.getNotice_no()))) {
				File file = new File(filedate.getFileName());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(filedate.getFileData());
				fos.flush();
				fileList.add(file);
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fileData = FXCollections.observableArrayList(fileList);
		lv_file.setItems(fileData);
	}

	@FXML
	void onClickedFileDownload(MouseEvent event) {
		if (lv_file.getSelectionModel() == null)
			return;

		Stage stage = (Stage) btn_Back.getScene().getWindow();
		AlertUtil.showDonwload(stage, lv_file.getSelectionModel().getSelectedItem());

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
