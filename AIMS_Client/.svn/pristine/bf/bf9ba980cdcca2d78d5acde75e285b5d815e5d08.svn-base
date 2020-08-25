package kr.or.ddit.controller.mypage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.vo.AddApiVO;

public class AddSearch {
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
    private TextField DongText;

    @FXML
    private Button Search;

    @FXML
    private ListView<AddApiVO> listview;

    @FXML
    void btnSearch(ActionEvent event) {
    	List<AddApiVO> list =searchXML(DongText.getText());
    	
    	ObservableList<AddApiVO> data = FXCollections.observableArrayList(list);
    	listview.setItems(data);
    }

    @FXML
    void listview(MouseEvent event) throws IOException {
    	// 화면전환
    	FXMLLoader loader = new FXMLLoader(AddSearch.class.getResource("../../fxml/mypage/AddSearch2.fxml"));
    	Parent root = loader.load();
    	
    	AddSearch2 controller = loader.getController();
    	controller.setTextField(listview.getSelectionModel().getSelectedItem());
    	controller.setDialog(getDialog());
    	Stage stage = (Stage) Search.getScene().getWindow(); 
    	Scene scene = new Scene(root);
    	
    	stage.setScene(scene);
    	stage.setTitle("상세주소");
    	stage.show();
    }
 
    
    List<AddApiVO> searchXML(String addr) {
   	List<AddApiVO> searchList = new ArrayList<AddApiVO>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;
		
		try {
	        StringBuilder urlBuilder = new StringBuilder("http://openapi.epost.go.kr/postal/retrieveLotNumberAdressAreaCdService/retrieveLotNumberAdressAreaCdService/getDetailListAreaCd"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=VT%2Bn4Z8TqDa0hkOC6w4EPsxqdYjfdHxpkSgou86jw850n%2FiT0psuK04VcB49o70dpk%2B5vo1biOLtD26rbK6wcw%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("searchSe","UTF-8") + "=" + URLEncoder.encode("dong", "UTF-8")); /*dong : 동(읍/면)명/아파트/건물명 post : 우편번호 sido : 시/군/구 */
	        urlBuilder.append("&" + URLEncoder.encode("srchwrd","UTF-8") + "=" + URLEncoder.encode(addr, "UTF-8")); /*검색어*/
	        urlBuilder.append("&" + URLEncoder.encode("countPerPage","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*페이지당 출력될 개수를 지정*/
	        urlBuilder.append("&" + URLEncoder.encode("currentPage","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*출력될 페이지 번호*/
		        URL url = new URL(urlBuilder.toString());
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        
		    //xml 파싱
	        builder = factory.newDocumentBuilder();
	        doc = builder.parse(conn.getInputStream());
	        NodeList nodeList = doc.getElementsByTagName("detailListAreaCd");
	        if(nodeList.getLength()>0) {
	        	int len = nodeList.getLength(); 
				for (int i = 0; i < len; i++) {

					AddApiVO AAVo = new AddApiVO();
					for (Node node = nodeList.item(i).getFirstChild(); node != null; node = node.getNextSibling()) {
						if (node.getNodeName().equals("zipNo")) {
							AAVo.setZipNo(node.getTextContent());
						}

						if (node.getNodeName().equals("adres")) {						
							AAVo.setAdres(node.getTextContent());
						}
					}
					searchList.add(AAVo);
				}
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return searchList;
   }

    @FXML
    void initialize() {
    	
    	listview.setCellFactory(new Callback<ListView<AddApiVO>, ListCell<AddApiVO>>() {
			
			@Override
			public ListCell<AddApiVO> call(ListView<AddApiVO> param) {
				return new ListCell<AddApiVO>() {
					@Override
					protected void updateItem(AddApiVO item, boolean empty) {
						// TODO Auto-generated method stub
						super.updateItem(item, empty);
						if(!empty) {
							setText(item.getAdres() +"\t\t\t"+ item.getZipNo());
						}else {
							setText(null);
						}
					}
				};
					
			}
		});
    	
    	
    
    }
}
