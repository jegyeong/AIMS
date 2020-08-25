package kr.or.ddit.controller.notice.user;

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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.service.InoticeServer;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.Answer_FileVO;
import kr.or.ddit.vo.Category_AVO;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.Question_FileVO;



public class QuestionController {
	
	
	private InoticeServer service;
	private ObservableList<File> fileData;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField tf_Title;

	@FXML
	private ComboBox<Category_AVO> cb_category;

	@FXML
	private HTMLEditor html_content;

	@FXML
	private Button btnFileAdd;

	@FXML
	private Button btnFileDelete;

	@FXML
	private ListView<File> lv_File;

	@FXML
	private Button btnAdd;

	@FXML
	void OnClickedBtnFileAdd(ActionEvent event) {
		Stage stage = (Stage) btnAdd.getScene().getWindow();
		FileChooser fileChooser = new FileChooser();

		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All file", "*.*"));


		File selectedFile = fileChooser.showOpenDialog(stage);
		fileData = FXCollections.observableArrayList(selectedFile);
		lv_File.getItems().addAll(fileData);

	}

	@FXML
	void onClickedBtnAdd(ActionEvent event) {
		boolean insertChk = false;
		Com_QuestionVO questionVO = new Com_QuestionVO();
		questionVO.setCom_que_content(html_content.getHtmlText());
		questionVO.setCom_que_title(tf_Title.getText());
		questionVO.setCat_a_no(cb_category.getSelectionModel().getSelectedItem().getCat_a_no());
		questionVO.setCom_que_writeid(Session.loginUser.getMem_id()); // session을 구현하면 해당아이디에 세션을 넣어준다.
		
	
			
		try {
				insertChk = service.insertCom_Question(questionVO);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
		
	
		if(lv_File.getItems().size()!=0) {
			for (File file : lv_File.getItems()) {
				try {
					FileInputStream fis = new FileInputStream(file);
					byte[] data = new byte[(int) file.length()];
					fis.read(data);
					FileInfoVO fVo = new FileInfoVO();
					fVo.setFileName(file.getName()); // file의 이름을 가져와 객체에 설정한다.
					fVo.setFileData(data); // 읽어온 데이터를 객체에 설정한다.
					
					String filePath =service.clientToServer("QuestionFile", fVo);
					
					Question_FileVO question_FileVO = new Question_FileVO();
					question_FileVO.setQue_f_addr(filePath);

					
					insertChk = service.insertQuestion_file(question_FileVO);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@FXML
	void OnClickedBtnFileDelete(ActionEvent event) {
			if(lv_File.getSelectionModel().getSelectedItem()==null)
				return;
		
			lv_File.getItems().remove(	lv_File.getSelectionModel().getSelectedIndex());

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
		
		try {
			
			ObservableList<Category_AVO> category_AVOs = FXCollections.observableArrayList(service.getCategory_AList());
			cb_category.setItems(category_AVOs);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		} 
		
		
		
		cb_category.setCellFactory(new Callback<ListView<Category_AVO>, ListCell<Category_AVO>>() {
			
			@Override
			public ListCell<Category_AVO> call(ListView<Category_AVO> param) {
				return new ListCell<Category_AVO>() {
					@Override
					protected void updateItem(Category_AVO item, boolean empty) {
						
						super.updateItem(item, empty);
						if(!empty) {
							setText(item.getCat_a_name());
						}else {
							setText(null);
						}
					}
				};
			}
		});
		cb_category.setButtonCell(new ListCell<Category_AVO>() {
			@Override
			protected void updateItem(Category_AVO item, boolean empty) {
				super.updateItem(item, empty);
				if(!empty) {
					setText(item.getCat_a_name());
				}
			}
		});
		
		lv_File.setCellFactory(new Callback<ListView<File>, ListCell<File>>() {
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
