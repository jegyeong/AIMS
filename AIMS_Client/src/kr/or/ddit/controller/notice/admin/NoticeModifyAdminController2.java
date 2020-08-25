package kr.or.ddit.controller.notice.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.InoticeServer;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.Notice_FileVO;

public class NoticeModifyAdminController2 {
	private AnchorPane dialog;
	private NoticeVO noticeVO;
	private InoticeServer service;
	private ObservableList<File> fileData;
	private ArrayList<File> deleteList= new ArrayList<File>();
	private ArrayList<File> addList = new ArrayList<File>();
	private int loadFileCnt = 0;
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
    private TextField tf_title;

    @FXML
    private HTMLEditor html_content;

    @FXML
    private Button btn_AddFile;

    @FXML
    private Button btn_DeleteFile;

    @FXML
    private ListView<File> lv_file;

    @FXML
    private Button btn_Confirm;

    @FXML
    private Button btn_Cancle;

    @FXML
    void onClickedBtn_AddFile(ActionEvent event) {
    	Stage stage = (Stage) btn_Confirm.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All file", "*.*"));

	
		File selectedFile = fileChooser.showOpenDialog(stage);
		lv_file.getItems().add(selectedFile);
		addList.add(selectedFile);
    }
    
    @FXML
    void onClickedBtn_Cancle(ActionEvent event) throws ClassNotFoundException {
    	
    	if(AlertUtil.showAlert((Stage)btn_AddFile.getScene().getWindow(), "해당 페이지를 나가겠습니까?","데이터는 저장되지않습니다.", "나가기", "페이지 머물기")) {
    		try {
    			FXMLLoader loader = new FXMLLoader(
    					Class.forName("kr.or.ddit.controller.notice.admin.NoticeModifyAdminController").getResource("../../../fxml/notice/admin/NoticModifyAdmin.fxml"));
    			Parent root = loader.load();
    			NoticeModifyAdminController controller = loader.getController();
    			controller.setDialog(getDialog());
    			controller.setInfoData(noticeVO);
    			dialog.getChildren().remove(0);
    			dialog.getChildren().add(root);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	
    }

    @FXML
    void onClickedBtn_Confirm(ActionEvent event) throws ClassNotFoundException {
    	if(!AlertUtil.showAlert((Stage)btn_AddFile.getScene().getWindow(), "저장하시겠습니가?")) {
    		return;
    	}
    	noticeVO.setNotice_title(tf_title.getText());
    	noticeVO.setNotice_content(html_content.getHtmlText());
//    	noticeVO.setNotice_writer(Session.loginUser.getMem_id());
    	noticeVO.setNotice_writer("관리자");
    	
    	for(File file :deleteList) {
    		Map<String,String> data = new HashMap<String, String>();
    		data.put("notice_no", noticeVO.getNotice_no());
    		data.put("filename",file.getName());
    		try {
				service.deleteNotice_File(data);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	for(File file:addList) {
    		Map<String,String> data = new HashMap<String, String>();
    		data.put("no", noticeVO.getNotice_no());
    		data.put("file",file.getName());
    		try {
					FileInfoVO fileInfoVO = new FileInfoVO();
					Notice_FileVO notice_FileVO = new Notice_FileVO();
					byte[] buffer =  new byte[(int) file.length()];
					FileInputStream fis = new FileInputStream(file);
					fis.read(buffer);
					fileInfoVO.setFileData(buffer);
					fileInfoVO.setFileName(file.getName());
					String filePath = service.clientToServer("NoticeFile", fileInfoVO);
					notice_FileVO.setFile_addr(filePath);
					notice_FileVO.setNotice_no(noticeVO.getNotice_no());
					service.insertNotice_file2(notice_FileVO);
			} catch (RemoteException e) {	
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
    	}
    	try {
			service.updataNotice(noticeVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	try {
			FXMLLoader loader = new FXMLLoader(
					Class.forName("kr.or.ddit.controller.notice.admin.NoticeModifyAdminController").getResource("../../../fxml/notice/admin/NoticModifyAdmin.fxml"));
			Parent root = loader.load();
			NoticeModifyAdminController controller = loader.getController();
			controller.setDialog(getDialog());
			controller.setInfoData(noticeVO);
			dialog.getChildren().remove(0);
			dialog.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickedBtn_DeleteFile(ActionEvent event) {
    	if(lv_file.getSelectionModel().getSelectedItem()==null)
			return;
    	int deleteNum = lv_file.getSelectionModel().getSelectedIndex();
    	if(deleteNum<=loadFileCnt) {
    		deleteList.add(lv_file.getItems().remove(deleteNum));
    		loadFileCnt--;
    	}else {
    		lv_file.getItems().remove(deleteNum);
    	}
    }


    public void setModifyInfo(NoticeVO noticeVO) {
    	this.noticeVO = noticeVO;
    	tf_title.setText(noticeVO.getNotice_title());
    	html_content.setHtmlText(noticeVO.getNotice_content());
    	List<File> fileList = new ArrayList<File>();
    	List<FileInfoVO> fileData = null;
    
    	
    	try {
    		fileData=service.noticeServerToClient(service.getNoticeFileList(noticeVO.getNotice_no()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    	if(fileData!=null) {
    		for(FileInfoVO data : fileData) {
    			File file = new File(data.getFileName());
    			try {
    			FileOutputStream fos = new FileOutputStream(file);
				fos.write(data.getFileData());
				fos.flush();
				fileList.add(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
    			loadFileCnt++;
    		}
    		ObservableList<File> list = FXCollections.observableArrayList(fileList);
    		lv_file.setItems(list);
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
    	
    	lv_file.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
			@Override
			public ListCell<File> call(ListView<File> param) {
				return new ListCell<File>() {
					@Override
					protected void updateItem(File item, boolean empty) {
						super.updateItem(item, empty);
						if (!empty) {
							setText(item.getName());
						}else {
							setText(null);
						}
					}
				};
			}
		});

    }
}
