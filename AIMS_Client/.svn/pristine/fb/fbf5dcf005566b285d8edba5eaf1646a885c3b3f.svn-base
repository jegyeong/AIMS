package kr.or.ddit.controller.statistics;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.service.statistics.IStatisticsService;
import kr.or.ddit.vo.ResultVO;

public class Area_StatisticsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboSido;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView<ResultVO> AreaTable;

    @FXML
    private TableColumn<?, ?> sidoCol;

    @FXML
    private TableColumn<?, ?> auctionCol;

    @FXML
    private TableColumn<?, ?> saleCol;

    @FXML
    private TableColumn<?, ?> connCol;

    @FXML
    private TableColumn<?, ?> sellerCol;

    @FXML
    private TableColumn<?, ?> salerateCol;

    @FXML
    private TableColumn<?, ?> sellerrateCol;

    @FXML
    private Button btnNotice;

    private Statistics_GraphController graphController;
    
    @FXML
    void AreaTableClick(MouseEvent event) {
    	if(AreaTable.getSelectionModel().isEmpty()) {
    		return;
    	}
    	
    	try {
    		Stage parentStage = (Stage) AreaTable.getScene().getWindow();
    		
//    		CategoryAxis xAxis = new CategoryAxis();
//    		NumberAxis yAxis = new NumberAxis();
//    		BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
//    		
//    		xAxis.setLabel("시군구");
//    		yAxis.setLabel("매각 퍼센트(%)");
//    		
//    		Number salerate = (Number) salerateCol.getCellData(1);
//    		XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
//    		ser1.setName(salerateCol.getText());
//    		ser1.getData().add(new XYChart.Data<String, Number>(salerateCol.getText(), salerate));
//    		
//    		XYChart.Series<String, Number> ser2 = new XYChart.Series<String, Number>();
//    		ser2.setName(sellerrateCol.getText());
//    		
//    		bc.getData().add(ser1);
			
    		FXMLLoader loader = new FXMLLoader(Area_StatisticsController.class.getResource("../../fxml/statistics/statistics_Graph.fxml"));
    		Parent root = loader.load();
    		graphController = loader.getController();
    		
    		if(!AreaTable.getSelectionModel().isEmpty()) {
    			ResultVO resVo = AreaTable.getSelectionModel().getSelectedItem();
    		
    			graphController.setResVo(resVo);
    		}
    		
			Stage dialog = new Stage(StageStyle.DECORATED);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(parentStage);
			
			Scene scene = new Scene(root);
			
			dialog.setScene(scene);
			dialog.setTitle("지역별 통계 그래프");
			dialog.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void btnNoticeClick(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnNotice.getScene().getWindow();
    	Parent root = FXMLLoader.load(Area_StatisticsController.class.getResource("../../fxml/statistics/statistics_notice.fxml"));
    	
    	Stage dialog = new Stage(StageStyle.DECORATED);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(stage);
		
    	Scene scene = new Scene(root);
    	dialog.setScene(scene);
    	dialog.setTitle("유의사항");
    	dialog.show();
    }

    @FXML
    void btnSearchClick(ActionEvent event) {
    	setData();
    }
    
    @FXML
    void comboSidoClick(ActionEvent event) {
    	
    }

    private IStatisticsService service;
    private ObservableList<ResultVO> data;
    
    public void setData() {
    	try {
	    	String sido = comboSido.getValue();
	    	List<ResultVO> resList = service.getAllResult(sido);
	    	data = FXCollections.observableArrayList(resList);
	    	AreaTable.setItems(data);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void initialize() {
    	try {
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
    		
    		service = (IStatisticsService) reg.lookup("statistics");
    		
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
        comboSido.getItems().addAll("시/도", "서울", "부산", "대구", "인천",
        							"광주", "대전", "울산", "세종특별자치시", "경기도",
        							"강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도",
        							"경상남도", "제주특별자치도");
        comboSido.setValue(comboSido.getItems().get(0));
        
        sidoCol.setCellValueFactory(new PropertyValueFactory<>("a_art_loc"));
        auctionCol.setCellValueFactory(new PropertyValueFactory<>("auction"));
        saleCol.setCellValueFactory(new PropertyValueFactory<>("sale"));
        connCol.setCellValueFactory(new PropertyValueFactory<>("conn"));
        sellerCol.setCellValueFactory(new PropertyValueFactory<>("seller"));
        salerateCol.setCellValueFactory(new PropertyValueFactory<>("salerate"));
        sellerrateCol.setCellValueFactory(new PropertyValueFactory<>("sellerrate"));
        
        sidoCol.setStyle("-fx-alignment: CENTER;");
        auctionCol.setStyle("-fx-alignment: CENTER;");
        saleCol.setStyle("-fx-alignment: CENTER;");
        connCol.setStyle("-fx-alignment: CENTER;");
        sellerCol.setStyle("-fx-alignment: CENTER;");
        salerateCol.setStyle("-fx-alignment: CENTER;");
        sellerrateCol.setStyle("-fx-alignment: CENTER;");
        
    }
}
