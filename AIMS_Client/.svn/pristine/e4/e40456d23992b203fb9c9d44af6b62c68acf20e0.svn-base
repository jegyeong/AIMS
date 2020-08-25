package kr.or.ddit.main.member;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// 회원가입 화면 
public class MemberMain extends Application{

	@Override
	public void start(Stage primaryStage) throws IOException {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		Parent root = FXMLLoader.load(MemberMain.class.getResource("../../fxml/member/Member.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("회원가입");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}

}
