package kr.or.ddit.main.stuff;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FxmlMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		Parent root = FXMLLoader.load(FxmlMain.class.getResource("../../fxml/stuff/fxmlAdminMain.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("정보관리");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	} 
}
