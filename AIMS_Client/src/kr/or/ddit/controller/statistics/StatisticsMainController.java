package kr.or.ddit.controller.statistics;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kr.or.ddit.service.statistics.IStatisticsService;

public class StatisticsMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnArea;

    @FXML
    private AnchorPane subAnchor;

    @FXML
    private Button btnHome;
    
    @FXML
    void btnAreaClick(ActionEvent event) throws IOException, ClassNotFoundException {
    	setSubAnchorDialog("../../fxml/statistics/area_statistics.fxml");
    }

    @FXML
    void btnHomeClick(ActionEvent event) throws ClassNotFoundException {
    	Stage stage = (Stage) btnHome.getScene().getWindow();
    	try {
			Parent root = FXMLLoader.load(Class.forName("kr.or.ddit.controller.statistics.Area_StatisticsController").getResource("../../fxml/main/MainPage.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void setSubAnchorDialog(String path) throws ClassNotFoundException {
		try {
			Parent root = FXMLLoader.load(Class.forName("kr.or.ddit.controller.statistics.Area_StatisticsController").getResource(path));
		
			if (subAnchor.getChildren().size() != 0) {
				for (int i = 0; i < subAnchor.getChildren().size(); i++) {
					subAnchor.getChildren().remove(i);
				}
			}
			subAnchor.getChildren().add(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    private IStatisticsService service;
    @FXML
    void initialize() throws ClassNotFoundException {
    	try {
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			
			service = (IStatisticsService) reg.lookup("statistics");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	setSubAnchorDialog("../../fxml/statistics/area_statistics.fxml");
    }
}
