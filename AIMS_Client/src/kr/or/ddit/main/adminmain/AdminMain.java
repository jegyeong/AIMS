package kr.or.ddit.main.adminmain;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import kr.or.ddit.main.stuff.FxmlMain;

public class AdminMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		Parent root = FXMLLoader.load(FxmlMain.class.getResource("../../fxml/adminmain/AdminMain.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("관리자 메인 페이지");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
