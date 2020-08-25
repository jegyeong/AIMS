package kr.or.ddit.controller.knowledge.admin;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kr.or.ddit.controller.law.AdminLawEditController;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.Related_LawVO;

public class AdminKnowledgeLawController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<Related_LawVO> lawTable;

	@FXML
	private TableColumn<Related_LawVO, String> nameCol;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnHome;

	@FXML
	void btnAddClick(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnAdd.getScene().getWindow();
		Parent add = FXMLLoader.load(AdminKnowledgeLawController.class.getResource("../../../fxml/law/fxmlLawAdd.fxml"));

		Scene scene = new Scene(add);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void btnHomeClick(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnHome.getScene().getWindow();
		Parent main = FXMLLoader.load(AdminKnowledgeLawController.class.getResource("../../../fxml/knowledge/admin/adminKnowledgeMain.fxml"));

		Scene scene = new Scene(main);
		stage.setScene(scene);
		stage.show();
	}

	private IKnowledgeService service;
	private ObservableList<Related_LawVO> data;


	
    @FXML
    void lawTableClick(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(AdminKnowledgeLawController.class.getResource("../../../fxml/law/fxmlLawEdit.fxml"));
    	Parent root = loader.load();
    	
    	AdminLawEditController controller = loader.getController(); // 다른 컨트롤러를 미리 가져와
    	controller.setTextField(lawTable.getSelectionModel().getSelectedItem()); // 그 컨트롤러에 테이블에선택한애의 값을 넘겨줘
    	  	
    	Stage stage = (Stage) btnAdd.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("법률 수정 or 삭제");
    	stage.show();
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
		
		List<Related_LawVO> list = null;
		try {
			list = service.getAllLaw();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		data = FXCollections.observableArrayList(list);
		
		lawTable.setItems(data);
		
		nameCol.setCellValueFactory(new PropertyValueFactory<Related_LawVO, String>("rel_l_title"));
		
	}
}
