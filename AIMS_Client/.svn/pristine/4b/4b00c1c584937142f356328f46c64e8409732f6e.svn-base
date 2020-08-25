package kr.or.ddit.controller.statistics;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import kr.or.ddit.service.statistics.IStatisticsService;
import kr.or.ddit.vo.ResultVO;

public class Statistics_GraphController {

	private Statistics_GraphController graphController;
	
    public Statistics_GraphController getGraphController() {
		return graphController;
	}

	public void setGraphController(Statistics_GraphController graphController) {
		this.graphController = graphController;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;
    
    @FXML
    private BarChart<String, Number> statisticsBc;

    private IStatisticsService service;
    private ResultVO resVo;
    
    public ResultVO getResVo() {
		return resVo;
	}

	public void setResVo(ResultVO resVo) {
		this.resVo = resVo;
		
		xAxis.setLabel("시/도");
		yAxis.setLabel("매각 퍼센트(%)");
		
		XYChart.Series<String, Number> ser = new XYChart.Series<String, Number>();
		ser.setName("매각율");
		int len = resVo.getSalerate().length();
		ser.getData().add(new Data<>(resVo.getA_art_loc(), Double.parseDouble(resVo.getSalerate().substring(0, len -1))));
		
		XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
		ser1.setName("매각가율");
		int len1 = resVo.getSellerrate().length();
		ser1.getData().add(new Data<>(resVo.getA_art_loc(), Double.parseDouble(resVo.getSellerrate().substring(0, len1 -1))));
		
		statisticsBc.getData().addAll(ser, ser1);
		
	}

	@FXML
    void initialize() throws RemoteException {
    	try {
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
    		
    		service = (IStatisticsService) reg.lookup("statistics");
    		
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    }
}
