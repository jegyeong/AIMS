package kr.or.ddit.AlertDialog;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AlertDialogController {
	

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
    
    @FXML
    void initialize() {
		
    }
    
    public void alertSet(String msg) {
    	lbl_Msg.setText(msg);
    }
    
    
	public boolean getState() {
		return state;
	}


  
}
