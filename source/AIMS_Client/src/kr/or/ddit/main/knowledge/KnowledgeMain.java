package kr.or.ddit.main.knowledge;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class KnowledgeMain extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"), 24);
		Parent root = FXMLLoader.load(KnowledgeMain.class.getResource("../../fxml/knowledge/user/knowledgeMain.fxml"));
//		Parent root = FXMLLoader.load(KnowledgeMain.class.getResource("../fxml/uesr/knowledgeMain.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("경매 지식 페이지");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
