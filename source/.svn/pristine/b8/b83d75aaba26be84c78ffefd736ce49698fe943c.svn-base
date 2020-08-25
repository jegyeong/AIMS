package kr.or.ddit.controller.knowledge.user;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import kr.or.ddit.vo.A_TerminologyVO;

public class TermShowController {

	private AuctionTermsController termsController;
	
    public AuctionTermsController getTermsController() {
		return termsController;
	}

	public void setTermsController(AuctionTermsController termsController) {
		this.termsController = termsController;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameTf;

    @FXML
    private TextArea exTxtArea;

    private A_TerminologyVO termVo;
    public void show(A_TerminologyVO termVo) {
		try {
			this.termVo = termVo;
			nameTf.setText(termVo.getA_ter_name());
			exTxtArea.setText(termVo.getA_ter_content());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    void initialize() {
    	
    }
}
