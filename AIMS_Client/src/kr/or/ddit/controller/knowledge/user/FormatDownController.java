package kr.or.ddit.controller.knowledge.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.A_FormJoinForm_FileVO;
import kr.or.ddit.vo.FileInfoVO;

public class FormatDownController {
	private IKnowledgeService service;
	private AuctionFormatController formatController;

	public AuctionFormatController getFormatController() {
		return formatController;
	}

	public void setFormatController(AuctionFormatController formatController) {
		this.formatController = formatController;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField nameTf;

	@FXML
	private ListView<File> fileList;

	private A_FormJoinForm_FileVO joinVo;

	public void show(A_FormJoinForm_FileVO joinVo) {
		try {
			this.joinVo = joinVo;

			nameTf.setText(joinVo.getA_form_name());
//			fileList.getItems().add(joinVo.getForm_f_addr());
			
			for(FileInfoVO infoVO : service.formServerToClient(joinVo.getA_form_no())) {
				File file = new File(infoVO.getFileName());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(infoVO.getFileData());
				fos.flush();
				fileList.getItems().add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		fileList.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				if(fileList.getSelectionModel().getSelectedItem() ==null) return;
			
				AlertUtil.showDonwload((Stage)fileList.getScene().getWindow(), fileList.getSelectionModel().getSelectedItem());
				
			}
		});
	}

	@FXML
	void initialize() {
		try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);

			service = (IKnowledgeService) reg.lookup("knowledge");

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		nameTf.setEditable(false);
	}
}
