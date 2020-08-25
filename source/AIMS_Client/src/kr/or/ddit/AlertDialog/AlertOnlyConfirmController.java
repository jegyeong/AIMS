package kr.or.ddit.AlertDialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertOnlyConfirmController {
	private boolean state;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_Msg;

    @FXML
    private Button btnOK;

    @FXML
    void onclickedBtnOK(ActionEvent event) {
    	state = false;
    	Stage stage = (Stage) btnOK.getScene().getWindow();
    	stage.close();
    	
    }
    
    public void alertMessageSet(String msg1) {
    	lbl_Msg.setText(msg1);
    }
    
    public void alertButtonSet(String msg1) {
    	btnOK.setText(msg1);
    }
    
    public boolean getState() {
		return state;
	}

    @FXML
    void initialize() {
      

    }
}
