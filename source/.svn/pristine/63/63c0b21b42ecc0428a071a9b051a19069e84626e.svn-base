package kr.or.ddit.AlertDialog;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DirectoryChooseDialogController {
	private File file;
//	private String downloadFilePath;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNext;

    @FXML
    private Button btnCancle;

    @FXML
    private TextField tfFilePath;

    @FXML
    private Button btnChooseDir;

    @FXML
    private Label tfFileName;

    @FXML
    void onClickedBtnCancle(ActionEvent event) {
    	Stage stage = (Stage)btnCancle.getScene().getWindow();
    	if(AlertUtil.showAlert(stage, "파일 전송을 취소하시겠습니까?")) {
    		stage.close();
    	}
    }

    @FXML
    void onClickedBtnChooseDir(ActionEvent event) {
    	Stage stage = (Stage)btnCancle.getScene().getWindow();
    	
    	DirectoryChooser dirChooser = new DirectoryChooser();
		File selectedDir = dirChooser.showDialog(stage);
		
		if(selectedDir!=null) {
			tfFilePath.setText(selectedDir.getPath());
		}	
    }
    
    @FXML
    void onClickedBtnNext(ActionEvent event) {
    	Stage stage = (Stage)btnCancle.getScene().getWindow();
    	try {
    	FXMLLoader loader = new FXMLLoader(DirectoryChooseDialogController.class.getResource("DownloadDialog.fxml"));
    	Parent root = loader.load();
    	
    	DownloadDialogController controller = loader.getController();
    	
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.setTitle("파일 전송");
    	stage.show();
    	controller.setFilePath(tfFilePath.getText()+"/",file);
    	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }
    
    public void setFile(File file) {
    	this.file = file;
    	tfFileName.setText(file.getName());
    }
    
    @FXML
    void initialize() {
    	tfFilePath.setEditable(false);
    	btnNext.setDisable(true);
    	
    	tfFilePath.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				btnNext.setDisable(false);
			}
		});
    	
    	

    }
}
