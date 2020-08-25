package kr.or.ddit.main.notice;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class mainNotice extends Application {

	@Override
	public void start(Stage primaryStage) {
		Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
		try {
			Parent root = FXMLLoader.load(mainNotice.class.getResource("../../fxml/notice/admin/NoticeAdminMain.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("공지사항 테스트");
			primaryStage.show();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
