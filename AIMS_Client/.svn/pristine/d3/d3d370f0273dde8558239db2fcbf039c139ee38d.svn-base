package kr.or.ddit.controller.InformationUse;

import java.io.IOException;
import java.lang.Thread.State;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kr.or.ddit.controller.login.loginController;
import kr.or.ddit.controller.main.MainPageController;
import kr.or.ddit.main.search.FXMLSearchMain;

public class MainTemplateController {

	private MainTemplateController mainController;
	
	public MainTemplateController getMainController() {
		return mainController;
	}

	public void setMainController(MainTemplateController mainController) {
		this.mainController = mainController;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private VBox btnArea;

	@FXML
	private Button btnFAQ;

	@FXML
	private Button btnAgency;

	@FXML
	private Button btnSiteMap;

	@FXML
	private AnchorPane contentsArea;

	@FXML
	private Button btnHome;

	@FXML
	void btnAgencyClicked(ActionEvent event) {
    
		try {
			FXMLLoader loader = new FXMLLoader(
					MainTemplateController.class.getResource("../../fxml/InformationUse/Agency.fxml"));
			Parent root = loader.load();
			AgencyController mAgenCon = loader.getController();
			mAgenCon.setContentsArea(contentsArea);

			// 뭐가 있으면 지워주기
			if (contentsArea.getChildren().size() != 0) {
				for (int i = 0; i < contentsArea.getChildren().size(); i++) {
					contentsArea.getChildren().remove(i);
				}
			}
			contentsArea.getChildren().add(root);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void btnFAQClicked(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainTemplateController.class.getResource("../../fxml/InformationUse/FAQ.fxml"));
			Parent root = loader.load();
			FAQController mfaqCon = loader.getController();
			mfaqCon.setContentsArea(contentsArea);
			contentsArea.getChildren().clear();
			contentsArea.getChildren().add(root);

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@FXML
	void btnHomeClicked(ActionEvent event) { // 홈으로
		//Stage stage = (Stage) btnAgency.getScene().getWindow();

		try {
			
			
			//FXMLLoader loader = new FXMLLoader(loginController.class.getResource("../../fxml/main/mainPage.fxml"));
			FXMLLoader loader = new FXMLLoader(loginController.class.getResource("../../fxml/main/MainPage.fxml"));
			Parent root = loader.load();
//			MainPageController logCon = loader.getController();
			MainPageController logCon = loader.getController();
			Stage stage = (Stage) btnAgency.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);


		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@FXML
	void btnSiteMapClicked(ActionEvent event) {
		try {
			Parent root = FXMLLoader
					.load(MainTemplateController.class.getResource("../../fxml/InformationUse/SiteMap.fxml"));
			if (contentsArea.getChildren().size() != 0) {
				for (int i = 0; i < contentsArea.getChildren().size(); i++) {
					contentsArea.getChildren().remove(i);
				}
			}
			contentsArea.getChildren().add(root);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainTemplateController.class.getResource("../../fxml/InformationUse/FAQ.fxml"));
			Parent root = loader.load();
			FAQController mfaqCon = loader.getController();
			mfaqCon.setContentsArea(contentsArea);
			contentsArea.getChildren().clear();
			contentsArea.getChildren().add(root);
			
			

		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
