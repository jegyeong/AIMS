package kr.or.ddit.main.login;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class loginMain extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		Parent root = FXMLLoader.load(loginMain.class.getResource("../../fxml/login/login.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("로그인 페이지");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
