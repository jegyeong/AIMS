package kr.or.ddit.main.adminmypage;



import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
// 회원정보 관리 화면 창 
public class MemberInfoMain extends Application {

	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		
			Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		
		
			Parent root = FXMLLoader.load(MemberInfoMain.class.getResource("../../fxml/adminmypage/memberInfo.fxml"));
		
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("회원관리");
			primaryStage.show();
			
		
	}
	public static void main(String[] args) {
		launch(args);
	}

	
}

