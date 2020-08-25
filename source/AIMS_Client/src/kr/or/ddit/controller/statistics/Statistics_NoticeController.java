package kr.or.ddit.controller.statistics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Statistics_NoticeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgView;

    @FXML
    void initialize() {
        imgView.setImage(new Image(Statistics_NoticeController.class.getResourceAsStream("../../image/statistics.png")));
    }
}
