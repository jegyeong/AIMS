package kr.or.ddit.main.auction;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class mainAuction extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			
			Font.loadFont(getClass().getResourceAsStream("/NanumGothic-ExtraBold.ttf"),32);
			
			Parent root = FXMLLoader.load(mainAuction.class.getResource("../../fxml/auction/AuctionMain.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("경매");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}	
}
