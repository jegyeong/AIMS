package kr.or.ddit.controller.notice.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.InoticeServer;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.Answer_FileVO;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.FileInfoVO;

public class NoticeComplainAnswerAdminController {
	private AnchorPane dialog;
	public AnchorPane getDialog() {
		return dialog;
	}

	public void setDialog(AnchorPane dialog) {
		this.dialog = dialog;
	}

	private InoticeServer service;
	private Com_QuestionVO com_QuestionVO; 
 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tf_title;

    @FXML
    private HTMLEditor html_content;

    @FXML
    private Button btn_addFile;

    @FXML
    private Button btn_deleteFile;

    @FXML
    private ListView<File> lv_file;

    @FXML
    private Button btn_confirm;

    @FXML
    private Button btn_Back;

    @FXML
    void onClickedBtn_Back(ActionEvent event) {
		if (AlertUtil.showAlert((Stage) btn_addFile.getScene().getWindow(), "목록으로 이동하시겠습니까?", "작성한 내용을 저장되지않습니다.", "예",
				"아니요")) {

			try {
				FXMLLoader loader = new FXMLLoader(NoticeAdminMainController.class
						.getResource("../../../fxml/notice/admin/NoticComplainListAdmin.fxml"));
				Parent root = loader.load();

				NoticeComplainListController controller = loader.getController();
				controller.setDialog(dialog);
				dialog.getChildren().remove(0);
				dialog.getChildren().add(root);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

    @FXML
    void onClickedBtn_confim(ActionEvent event) {
    if(!AlertUtil.showAlert((Stage) btn_addFile.getScene().getWindow(),"저장하시겠습니까?")) {
    	return;
    }
    	boolean insertChk = false;
		Com_AnswerVO answerVO = new Com_AnswerVO();
		answerVO.setCom_ans_content(html_content.getHtmlText());
		answerVO.setCom_ans_title(tf_title.getText());
		answerVO.setCom_ans_writeid(Session.loginUser.getMem_id()); // session을 구현하면 해당아이디에 세션을 넣어준다.
		answerVO.setCom_ans_no(com_QuestionVO.getCom_que_no());
		System.out.println(answerVO.getCom_ans_content());
		System.out.println(answerVO.getCom_ans_title());
		System.out.println(answerVO.getCom_ans_writeid());
			
		try {
			insertChk = service.insertCom_Answer(answerVO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
		
	
		if(lv_file.getItems().size()!=0) {
			for (File file : lv_file.getItems()) {
				try {
					FileInputStream fis = new FileInputStream(file);
					byte[] data = new byte[(int) file.length()];
					fis.read(data);
					FileInfoVO fVo = new FileInfoVO();
					fVo.setFileName(file.getName()); // file의 이름을 가져와 객체에 설정한다.
					fVo.setFileData(data); // 읽어온 데이터를 객체에 설정한다.
					
					String filePath =service.clientToServer("AnswerFile", fVo);
					
					Answer_FileVO answer_FileVO = new Answer_FileVO();
					answer_FileVO.setAns_f_addr(filePath);
					answer_FileVO.setCom_ans_no(com_QuestionVO.getCom_que_no());
					
					insertChk = service.insertAnswer_file(answer_FileVO);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	
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
    void onClickedBtn_deleteFile(ActionEvent event) {
    	File file = lv_file.getSelectionModel().getSelectedItem();
    	if(file==null) return;
    	lv_file.getItems().remove(file);
    }
    

    @FXML
    void onClickedBtn_addFile(ActionEvent event) {
    	Stage stage = (Stage) btn_addFile.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All file", "*.*"));

		File showDir = new File("d:/D_other/");
		fileChooser.setInitialDirectory(showDir);

		File selectedFile = fileChooser.showOpenDialog(stage);
		lv_file.getItems().add(selectedFile);
    }
    
    public void setdata(Com_QuestionVO com_QuestionVO) {
    	this.com_QuestionVO = com_QuestionVO;
    	tf_title.setText(com_QuestionVO.getCom_que_title()+"의  답변입니다.");
    	html_content.setHtmlText(com_QuestionVO.getCom_que_content()+"------------------------------------------------------------------------------\n\n"+"");
    	
    	
    }

    @FXML
    void initialize() {
    	
    	try {
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
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
						if(!empty) {
							setText(item.getName());
						}else{
							setText(null);
						}
					}
				};
			}
		});

    }
}
