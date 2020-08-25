package kr.or.ddit.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import kr.or.ddit.main.stuff.FxmlMain;

public class MainController extends Application {


	@Override
	public void start(Stage primaryStage)  {
		try {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		Parent root= FXMLLoader.load(MainController.class.getResource("../fxml/main/MainPage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("AIMS");
		primaryStage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
