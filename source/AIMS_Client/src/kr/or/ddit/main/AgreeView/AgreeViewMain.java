package kr.or.ddit.main.AgreeView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// 이용약관동의서 
public class AgreeViewMain  extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		
		Parent root = FXMLLoader.load(AgreeViewMain.class.getResource("../../fxml/AgreeView/AgreeView.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("이용약관동의");
		primaryStage.show();
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
}
