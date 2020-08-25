package kr.or.ddit.controller.knowledge.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GuideSubController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView subView1;

    @FXML
    private ImageView subView2;

    @FXML
    private ImageView subView3;

    @FXML
    private ImageView subView4;

    @FXML
    private ImageView subView5;

    @FXML
    void initialize() {
    	subView1.setImage(new Image(GuideSubController.class.getResourceAsStream("../../../image/process_bid_d_01.gif")));
    	subView2.setImage(new Image(GuideSubController.class.getResourceAsStream("../../../image/process_bid_d_02.gif")));
    	subView3.setImage(new Image(GuideSubController.class.getResourceAsStream("../../../image/process_bid_d_03.gif")));
    	subView4.setImage(new Image(GuideSubController.class.getResourceAsStream("../../../image/process_bid_d_04.gif")));
    	subView5.setImage(new Image(GuideSubController.class.getResourceAsStream("../../../image/process_bid_d_05.gif")));

    }
}
