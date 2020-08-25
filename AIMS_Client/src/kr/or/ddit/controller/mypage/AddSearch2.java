package kr.or.ddit.controller.mypage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kr.or.ddit.vo.AddApiVO;

public class AddSearch2 {

	private MyInformationController dialog;
	
    public MyInformationController getDialog() {
		return dialog;
	}

	public void setDialog(MyInformationController dialog) {
		this.dialog = dialog;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label zipcode;

    @FXML
    private Label addr;

    @FXML
    private TextField inputtext;

    @FXML
    private Button ok;

    @FXML
    void btnok(ActionEvent event) {
    	Stage stage = (Stage) ok.getScene().getWindow();
    	if(dialog != null) {
    		dialog.inputAddr(zipcode.getText(), addr.getText()+" "+inputtext.getText()); //첫번째 창한테 넘겨주는 정보
       	}
    	
    	stage.close();
    }
    
	public void setTextField(AddApiVO AAVo) {
		zipcode.setText(AAVo.getZipNo());

		String address = "";
		for (int j = 0; j < 3; j++) {
			address += AAVo.getAdres().split(" ")[j]+" ";
		}

		addr.setText(address);
	}

    @FXML
    void initialize() {
      
    }
}
