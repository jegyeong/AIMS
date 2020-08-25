package kr.or.ddit.controller.search;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


// webview용 import 
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Point;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MapController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView web;

    @FXML
    void initialize() {
    	web.getEngine().load("http://192.168.0.118:8999/MapAPI/Map.html");
    	

    }
   
    
//    
//    @FXML
//    void initialize() {
//    	initFX();
//    	WebView webView = new WebView();
//    	WebEngine webEngine = webView.getEngine();
//    	webEngine.load("http://localhost/MapAPI/Map.html");
//    	Map.getChildren().add(webView);
//    }
}