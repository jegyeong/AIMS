package kr.or.ddit.controller.InformationUse;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import kr.or.ddit.service.InformationUse.IAgencyService;
import kr.or.ddit.service.InformationUse.IFAQService;
import kr.or.ddit.vo.FAQVO;

public class FAQController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<FAQVO> tableView;

	@FXML
	private TableColumn<?, ?> colWriteNum;

	@FXML
	private TableColumn<?, ?> colWriteTitle;

	@FXML
	private Pagination pagintion;

	private int rowsPerPage = 27; 		// 한 화면에 보여줄 데이터 개수 지정
	private int totalCount;				// 전체 레코드 수
	private int pageCount;
	
	// 정보 들고 다니려고 만든 것
	private AnchorPane contentsArea;

	public AnchorPane getContentsArea() {
		return contentsArea;
	}

	public void setContentsArea(AnchorPane contentsArea) {
		this.contentsArea = contentsArea;
	}

	public FAQVO faqVoInfo;

	public FAQVO getFaqVoInfo() {
		return faqVoInfo;
	}

	public void setFaqVoInfo(FAQVO faqVoInfo) {
		this.faqVoInfo = faqVoInfo;
	}

	private ObservableList<FAQVO> faqTableList;
	private IFAQService service;


	@FXML
	void paginationCliked(MouseEvent event) {

	}

	
	@FXML
    void onClickedTabelView(MouseEvent event) throws ClassNotFoundException {
		if(tableView.getSelectionModel().getSelectedItem()==null)return;
		
		try {
			FAQVO faqVo = tableView.getSelectionModel().getSelectedItem();

			FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.InformationUse.FAQController").getResource("../../fxml/InformationUse/FAQDetails.fxml"));
			Parent root = loader.load();

			FAQDetailsController faqCon = loader.getController();

			// 뭐가 있으면 지워주기
			contentsArea.getChildren().clear();
			contentsArea.getChildren().add(root);

			// 값 넣어주기
			faqCon.setName(faqVo);
			
			Stage stage = new Stage();
    		
    		stage.showingProperty().addListener(new ChangeListener<Boolean>() {
    			@Override
    			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
    				changeTableView(0);
    			}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	 public void changeTableView(int index){
			int start = index * rowsPerPage;
			int end = Math.min(start + rowsPerPage, totalCount);
			
			Map<String, Integer> pageMap = new HashMap<String, Integer>();
			pageMap.put("start", start);
			pageMap.put("end", end);
			
			try {
				tableView.setItems(FXCollections.observableArrayList(service.getPagingFAQList(pageMap)));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	 
	private void setData() {
		try {
			List<FAQVO> faqList = service.getAllFAQList();
			faqTableList = FXCollections.observableArrayList(faqList);
			tableView.setItems(faqTableList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {

		// SERVICE 만들기
		try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (IFAQService) reg.lookup("FAQ");
		} catch (RemoteException e) {
			e.printStackTrace();

		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		colWriteNum.setCellValueFactory(new PropertyValueFactory<>("faq_no"));
		colWriteTitle.setCellValueFactory(new PropertyValueFactory<>("faq_title"));

		
		setData();
		
		try {
			totalCount = service.getAllFAQList().size();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		pageCount = (int) Math.ceil((double)totalCount/rowsPerPage);
		System.out.println(pageCount);
		pagintion.setPageCount(pageCount);
		pagintion.setCurrentPageIndex(0);
		pagintion.currentPageIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				changeTableView(newValue.intValue());
			}
		});
		
		changeTableView(0);
	}
}
