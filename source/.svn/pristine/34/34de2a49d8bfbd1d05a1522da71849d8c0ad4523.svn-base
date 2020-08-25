package kr.or.ddit.main.search;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLSearchMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		Parent root = FXMLLoader.load(FXMLSearchMain.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("검색");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
