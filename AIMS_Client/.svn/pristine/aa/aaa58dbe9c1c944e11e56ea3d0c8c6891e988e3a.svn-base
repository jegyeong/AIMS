package kr.or.ddit.controller.knowledge.user;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GuideController {
	private boolean state;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView mainView;

    @FXML
    private AnchorPane subAnchor;

    @FXML
    private Label lblGuide;

    @FXML
    void lblGuideClick(MouseEvent event) throws IOException {
    	try {
			
		if (!state) {
			Parent root = FXMLLoader.load(GuideController.class.getResource("../../../fxml/knowledge/user/guideSub.fxml"));

			for (int i = 0; i < subAnchor.getChildren().size(); i++) {
				subAnchor.getChildren().remove(i);
			}
			subAnchor.getChildren().addAll(root);
			state=true;
		}else {
			Parent root2 = FXMLLoader.load(GuideController.class.getResource("../../../fxml/knowledge/user/guideSub2.fxml"));
	    	
	    	for(int i = 0; i < subAnchor.getChildren().size(); i++) {
	    		subAnchor.getChildren().remove(i);
	    	}
	    	subAnchor.getChildren().addAll(root2);
	    	state=false;
		}
    	
    	} catch (Exception e) {
    		// TODO: handle exception
    	}
    	

    	
    	
    }

    @FXML
    void initialize() {
    	mainView.setImage(new Image(AuctionStepController.class.getResourceAsStream("../../../image/process_bid.gif")));
    	mainView.setFitWidth(700);
    	mainView.setFitHeight(260);
    	mainView.setLayoutY(5);
    	mainView.setLayoutX(105);

    	try {
	    	Parent root = FXMLLoader.load(GuideController.class.getResource("../../../fxml/knowledge/user/guideSub.fxml"));
	
			for (int i = 0; i < subAnchor.getChildren().size(); i++) {
				subAnchor.getChildren().remove(i);
			}
			subAnchor.getChildren().addAll(root);
			state=true;
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
}
