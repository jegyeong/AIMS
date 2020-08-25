package kr.or.ddit.controller.knowledge.admin;

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
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.A_FormJoinForm_FileVO;
import kr.or.ddit.vo.A_FormVO;
import kr.or.ddit.vo.FileInfoVO;
import kr.or.ddit.vo.Form_FileVO;

public class FormatEditController {
	private A_FormVO formVo;
	private Form_FileVO fileVo;
	private A_FormJoinForm_FileVO joinVo;
	private IKnowledgeService service;
	private List<File> deleteFileList = new ArrayList<File>();
	private List<File> addFileList = new ArrayList<File>();
	private int loadDataCnt = 0 ;
	private AdminKnowledgeFormatController formatController;

	public AdminKnowledgeFormatController getMainController() {
		return formatController;
	}

	public void setMainController(AdminKnowledgeFormatController formatController) {
		this.formatController = formatController;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField titleTf;

	@FXML
	private ListView<File> fileList;

	@FXML
	private Button btnSearch;

	@FXML
	private Button btnDel;

	@FXML
	private Button btnEdit;


//    private ObservableList<A_FormJoinForm_FileVO> data = FXCollections.observableArrayList();

	@FXML
	void btnDelClick(ActionEvent event) {

		Stage del = (Stage) btnDel.getScene().getWindow();
		String yes = "예";
		String no = "아니오";

		try {
			if (AlertUtil.showAlert(del, "삭제하시겠습니까?", "", yes, no)) {

				Form_FileVO fileVo = new Form_FileVO();
				fileVo.setA_form_no(joinVo.getA_form_no());
				service.deleteFile(fileVo);

				A_FormVO formVo = new A_FormVO();
				formVo.setA_form_no(joinVo.getA_form_no());
				service.deleteForm(formVo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Stage stage =(Stage)btnDel.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnEditClick(ActionEvent event) {
		
		try {
			Parent alert = FXMLLoader
					.load(FormatEditController.class.getResource("../../../AlertDialog/AlertDialog2.fxml"));
			Stage edit = (Stage) btnEdit.getScene().getWindow();
			String yes = "예";
			String no = "아니오";
			
		
			if ( AlertUtil.showAlert(edit, "수정하시겠습니까?", "", yes, no)) {
				A_FormVO formVo = new A_FormVO();
				formVo.setA_form_name(titleTf.getText());
				formVo.setA_form_no(joinVo.getA_form_no());
				service.updateForm(formVo);

				
				for(File file:deleteFileList) {
					
					 Form_FileVO fileVO = new Form_FileVO();
					 fileVO.setA_form_no(joinVo.getA_form_no());
					 fileVO.setForm_f_addr(file.getName());
					service.deleteFile(fileVO);
				}
				for(File file:addFileList) {
					FileInputStream fis = new FileInputStream(file);
					byte[] buffer = new byte[(int) file.length()];
					fis.read(buffer);
					
					FileInfoVO fileData = new FileInfoVO();
					fileData.setFileName(file.getName());
					fileData.setFileData(buffer);
					
					Form_FileVO fileVO = new Form_FileVO();
					fileVO.setForm_f_addr(service.clientToServer("FormFile", fileData));
					fileVO.setA_form_no(joinVo.getA_form_no());
					service.insertFile(fileVO);
				}
			} 
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		Stage stage =(Stage)btnDel.getScene().getWindow();
		stage.close();
	}

	@FXML
	void btnSearchClick(ActionEvent event) {
		Stage search = (Stage) btnSearch.getScene().getWindow();

		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All File", "*.*"),
				new ExtensionFilter("Text File", "*.txt"),
				new ExtensionFilter("Image File", "*.png", "*.jpg", "*,gif"));

		File showDir = new File("d:/");
		fileChooser.setInitialDirectory(showDir);

		List<File> selectedFile = fileChooser.showOpenMultipleDialog(search);
		if (selectedFile != null) {
			for (int i = 0; i < selectedFile.size(); i++) {
				fileList.getItems().add(selectedFile.get(i));
				addFileList.add(selectedFile.get(i));
			}
		}
	}

	public void show(A_FormJoinForm_FileVO joinVo) {
		try {
			this.joinVo = joinVo;

			titleTf.setText(joinVo.getA_form_name());
			
			for(FileInfoVO infoVO : service.formServerToClient(joinVo.getA_form_no())) {
				File file = new File(infoVO.getFileName());
				FileOutputStream fos = new FileOutputStream (file);
				fos.write(infoVO.getFileData());
				fos.flush();
				fileList.getItems().add(file);
				loadDataCnt++;
			}
			
		
			
			


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		try {
			Registry reg = LocateRegistry.getRegistry(8888);

			service = (IKnowledgeService) reg.lookup("knowledge");

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		fileList.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				File file = fileList.getSelectionModel().getSelectedItem();
				if(file == null) return;
				
				if(fileList.getSelectionModel().getSelectedIndex()<loadDataCnt) {
					deleteFileList.add(file);
					fileList.getItems().remove(file);
					loadDataCnt--;
				}else {
					addFileList.remove(file);
					fileList.getItems().remove(file);
				}
				
			}
		});

	}
}
