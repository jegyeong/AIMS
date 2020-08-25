package kr.or.ddit.controller.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kr.or.ddit.controller.login.loginController;

public class MainPageYetLoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lbSearchId;

    @FXML
    private Label lvSearchPW;

    @FXML
    private Label lvCreateId;

    @FXML
	void onClickedLbSearchId(MouseEvent event) {
		try {
			Stage stage = (Stage) btnLogin.getScene().getWindow();
			Parent root = FXMLLoader.load(MainPageController.class.getResource("../../fxml/findIdPass/FindId.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("AIMS");
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    @FXML
    void onClickedLvCreateId(MouseEvent event) {
    	try {
			Stage stage = (Stage) btnLogin.getScene().getWindow();
			Parent root = FXMLLoader.load(MainPageController.class.getResource("../../fxml/member/Member.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("AIMS");
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickedLvSearchPW(MouseEvent event) {
    	try {
			Stage stage =(Stage)btnLogin.getScene().getWindow();
    		Parent root = FXMLLoader.load(MainPageController.class.getResource("../../fxml/findIdPass/FindPass.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("AIMS");
			stage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
    	btnLogin.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				try {
					Stage stage =(Stage)btnLogin.getScene().getWindow();
					FXMLLoader loader = new FXMLLoader(MainPageController.class.getResource("../../fxml/login/login.fxml"));
		    		Parent root = loader.load();
		    		loginController controller = loader.getController();
		    		controller.setNextPage("../../fxml/main/MainPage.fxml");
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("AIMS");
					stage.show();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});

    }
}
