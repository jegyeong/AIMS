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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.vo.A_TerminologyVO;

public class AdminKnowledgeTermsController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<A_TerminologyVO> termsTable;

	@FXML
	private TableColumn<?, ?> termsCol;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnHome;

	@FXML
	private AnchorPane termsAnchor;

	@FXML
	void btnAddClick(ActionEvent event) throws IOException, ClassNotFoundException {
		Stage stage = (Stage) btnAdd.getScene().getWindow();
		Parent add = FXMLLoader.load(Class.forName("kr.or.ddit.controller.knowledge.admin.AdminKnowledgeTermsController").getResource("../../../fxml/knowledge/admin/termsAdd.fxml"));

		Scene scene = new Scene(add);
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void btnHomeClick(ActionEvent event) throws IOException, ClassNotFoundException {
		Stage stage = (Stage) btnHome.getScene().getWindow();
		Parent main = FXMLLoader
				.load(Class.forName("kr.or.ddit.controller.knowledge.admin.AdminKnowledgeTermsController").getResource("../../../fxml/knowledge/admin/adminKnowledgeMain.fxml"));

		Scene scene = new Scene(main);
		stage.setScene(scene);
		stage.show();
	}

	private TermsEditController editController;
	private IKnowledgeService service;
	private ObservableList<A_TerminologyVO> data;

	private void setData() {
		try {
			List<A_TerminologyVO> termList = service.getTerms();
			data = FXCollections.observableArrayList(termList);
			termsTable.setItems(data);

			if (!termsTable.getSelectionModel().isEmpty()) {
				A_TerminologyVO termVo = termsTable.getSelectionModel().getSelectedItem();

				editController.show(termVo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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

		termsCol.setCellValueFactory(new PropertyValueFactory<>("a_ter_name"));

		setData();

		termsTable.setOnMouseClicked(e -> { // 테이블안에 값을 클릭했을 경우(수정, 삭제 화면 띄우기)
			if (termsTable.getSelectionModel().isEmpty()) {
				return;
			}
			try {
				FXMLLoader loader = new FXMLLoader(
						Class.forName("kr.or.ddit.controller.knowledge.admin.AdminKnowledgeTermsController").getResource("../../../fxml/knowledge/admin/termsEdit.fxml"));
				Parent root = loader.load();
				editController = loader.getController();

				if (!termsTable.getSelectionModel().isEmpty()) {
					A_TerminologyVO termVo = termsTable.getSelectionModel().getSelectedItem();

					editController.show(termVo);
				}

				Stage mainStage = (Stage) termsTable.getScene().getWindow();

//	        	Stage edit = new Stage(StageStyle.DECORATED);
//	        	edit.initModality(Modality.WINDOW_MODAL);
//	        	edit.initOwner(mainStage);

				Scene scene = new Scene(root);
				mainStage.setScene(scene);
				mainStage.show();

			} catch (IOException e2) {
				e2.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}
}
