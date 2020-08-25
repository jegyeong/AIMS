package kr.or.ddit.main.FindIdPass;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import kr.or.ddit.main.knowledge.KnowledgeMain;

public class FindIdMain extends Application {

	@Override
	public void start(Stage primaryStage)throws IOException {
		
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		
		Parent root = FXMLLoader.load(FindIdMain.class.getResource("../../fxml/findIdPass/FindId.fxml"));
//		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("아이디찾기 페이지");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
