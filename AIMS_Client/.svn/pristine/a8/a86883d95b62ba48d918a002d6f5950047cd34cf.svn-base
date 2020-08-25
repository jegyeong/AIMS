package kr.or.ddit.main.mypage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// 마이페이지 main
public class MymemberMain extends Application{

	@Override
	public void start(Stage primaryStage){
		try {
			Parent root = FXMLLoader.load(MymemberMain.class.getResource("../../fxml/mypage/Mymember.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("마이페이지");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}

