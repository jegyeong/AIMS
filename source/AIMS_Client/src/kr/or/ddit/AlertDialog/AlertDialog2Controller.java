package kr.or.ddit.AlertDialog;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertDialog2Controller {
	private boolean state;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lbl_Msg1;

    @FXML
    private Label lbl_Msg2;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancle;

    @FXML
    void onclickedBtnCancle(ActionEvent event) {
   
	state = false;
	Stage stage = (Stage)btnOK.getScene().getWindow();
	stage.close();
    }
    
    @FXML
    void onclickedBtnOK(ActionEvent event) {
    	state =true;
    	Stage stage = (Stage)btnCancle.getScene().getWindow();
    	stage.close();
    }
    
    
    public void alertMessageSet(String msg1,String msg2) {
    	lbl_Msg1.setText(msg1);
    	lbl_Msg2.setText(msg2);
    }
    
    public void alertButtonSet(String msg1,String msg2) {
    	btnOK.setText(msg1);
    	btnCancle.setText(msg2);
    }
    
	public boolean getState() {
		return state;
	}

    @FXML
    void initialize() {
        assert lbl_Msg1 != null : "fx:id=\"lbl_Msg1\" was not injected: check your FXML file 'AlertDialog2.fxml'.";
        assert lbl_Msg2 != null : "fx:id=\"lbl_Msg2\" was not injected: check your FXML file 'AlertDialog2.fxml'.";
        assert btnOK != null : "fx:id=\"btnOK\" was not injected: check your FXML file 'AlertDialog2.fxml'.";
        assert btnCancle != null : "fx:id=\"btnCancle\" was not injected: check your FXML file 'AlertDialog2.fxml'.";

    }
}
