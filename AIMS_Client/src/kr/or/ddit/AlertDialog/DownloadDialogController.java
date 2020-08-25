package kr.or.ddit.AlertDialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class DownloadDialogController {
	private String filePath;
	private File inputFile;
	private File outputFile;
	private double downloadState = 0;
	private downloading th;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressBar pgSend;

    @FXML
    private Button btnConfirm;

    @FXML
    private Button btnCancle;

    @FXML
    private Label tfFileName;

    @FXML
    void onClickBtnCancle(ActionEvent event) {
    	Stage stage=(Stage)btnConfirm.getScene().getWindow();
    	
    	if(AlertUtil.showAlert(stage, "파일 전송이 진행중입니다 취소하시겠습니까?")) {
    		File file = new File(filePath); // 수정해야함
    		th.setStop();
    		file.delete();
    		stage.close();
    	}
    }

    @FXML
    void onClickedBtnConfirm(ActionEvent event) {
    	Stage stage = (Stage)btnCancle.getScene().getWindow();
    	stage.close();
    }


  
    class downloading extends Thread{
    	File inputfile;
    	File outputfile;
    	boolean state;
    	public downloading(File inputfile,File outputfile) {
			this.inputfile = inputfile;
			this.outputfile = outputfile;
		}
    	public void setStop() {
    		state = true;
    	}
    	@Override
    	public void run() {
			while (!state) {
				try {
					FileOutputStream fos = new FileOutputStream(outputfile);

					FileInputStream fis = new FileInputStream(inputfile);
					double downloadTotal = inputFile.length();
					byte[] buffer = new byte[1024];
					int length = 0;

					while ((length = fis.read(buffer)) != -1) {
						fos.write(buffer, 0, length);
						downloadState += length;
						Thread.sleep(1);
						Platform.runLater(() -> {
							pgSend.setProgress(downloadState / downloadTotal);
						});

					}
					fos.flush();
					btnConfirm.setDisable(false);
					btnCancle.setDisable(true);
					break;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
					 catch (InterruptedException e) { e.printStackTrace();
					 }
					 
				

			}
    		
    	}
    }
       
       
    public void setFilePath(String filePath,File file) {    	
    	this.filePath = filePath;
    	inputFile = file;
    	File outfile = new File(filePath + inputFile.getName());
    	outputFile = outfile;
    	tfFileName.setText(inputFile.getName());
    	
    	
    	th = new downloading(inputFile, outputFile);
    	th.start();
//    	Thread thread = new Thread(task);
//    	thread.setDaemon(true);
//		thread.start();
		
		
    }

    
	
    @FXML
    void initialize() {
//    	pgSend.progressProperty().bind(task.progressProperty()); // 속성 바인딩
    	btnConfirm.setDisable(true);  	
    }
}
