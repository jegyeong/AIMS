package kr.or.ddit.main.InformationUse;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainControllerInformationUse extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),24);
		try {
//			Parent root = FXMLLoader.load(
//				MainController.class.getResource("../fxml/MainTemplate.fxml"));
			Parent root = FXMLLoader.load(
					MainControllerInformationUse.class.getResource("../../fxml/informationUse/MainTemplate.fxml"));
			
			Scene scene = new Scene(root);
		
			primaryStage.setScene(scene);
			primaryStage.setTitle("법원정보");
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
