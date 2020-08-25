package kr.or.ddit.main.knowledge;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Admin_KnowledgeMain extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		Parent root = FXMLLoader.load(Admin_KnowledgeMain.class.getResource("../../fxml/knowledge/admin/adminKnowledgeMain.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("경매 지식 관리 페이지");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
