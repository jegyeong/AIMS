package kr.or.ddit.controller.InformationUse;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Pagination;
import kr.or.ddit.service.InformationUse.IAgencyService;
import kr.or.ddit.vo.AgencyVO;


public class AgencyController {
	private IAgencyService service;
	   
	private ObservableList<AgencyVO> AgencyCmboProrList1; //肄ㅻ낫諛뺤뒪�씠 �뜲�씠�꽣瑜� ���옣�븷 由ъ뒪�듃(踰뺤썝�씠由�)
	private ObservableList<AgencyVO> AgencyCmboProrList2; //肄ㅻ낫諛뺤뒪�씠 �뜲�씠�꽣瑜� ���옣�븷 由ъ뒪�듃(踰뺤썝�씠由�)
    private ObservableList<AgencyVO> AgencyTableList; //TableView�쓽 �뜲�씠�꽣瑜� ���옣�븷 由ъ뒪�듃
    private AnchorPane contentsArea;
 

    @FXML
    private AnchorPane anchorPane;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboArea; //吏��뿭

    @FXML
    private Button btnSearch; //寃��깋踰꾪듉
    
    @FXML
    private ComboBox<String> comboProvince; //踰뺤썝�씠由�
    
    //�뀒�씠釉붾럭
    @FXML
    private TableView<AgencyVO> tableView;
    
    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddr;

    @FXML
    private Pagination pagintion;
    
    
    //�뜲�씠�꽣 媛�吏�怨� �떎�땲�젮怨� 留뚮뱶�뒗寃�
    
    public AnchorPane getContentsArea() {
		return contentsArea;
	}

	public void setContentsArea(AnchorPane contentsArea) {
		this.contentsArea = contentsArea;
	}
	
	public AgencyVO AgencyVoInfo;
	
	public AgencyVO getAgencyVoInfo() {
		return AgencyVoInfo;
	}

	public void setAgencyVoInfo(AgencyVO AgencyVoInfo) {
		this.AgencyVoInfo = AgencyVoInfo;
	}
    
    

   
	@FXML
    void btnSearchClicked(ActionEvent event) {
    	List<AgencyVO> List = new ArrayList<AgencyVO>();
    	
    	Map<String, String> paraMap = new HashMap<String, String>();
    	paraMap.put("para1", comboArea.getValue());
		paraMap.put("para2", comboProvince.getValue());
		try {
			List = service.getCourtBoth(paraMap);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		AgencyCmboProrList1 = FXCollections.observableArrayList(List);
		System.out.println(AgencyCmboProrList1);
		tableView.setItems(AgencyCmboProrList1);
//    	tableView.setItems(service.getCourtBoth(paraMap));
    	
    }

    @FXML
    void tableViewClicked(MouseEvent event) throws ClassNotFoundException  {
		if(tableView.getSelectionModel().isEmpty()) return;
    		try {
    		FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.InformationUse.AgencyController").getResource("../../fxml/InformationUse/AgencyDetails.fxml"));
    		Parent root = loader.load();
    		
    		AgencyDeitalsController adCon = loader.getController();
    		AgencyVO agencyVo = tableView.getSelectionModel().getSelectedItem();
    		//�뜲�씠�꽣 媛�吏�怨� �떎�땺�젮怨� �꽔�뼱以�寃�
    		adCon.setContentsArea(getContentsArea());
    		
    		//萸먭� �엳�쑝硫� 吏��썙二쇨린
    		int size = contentsArea.getChildren().size();
    		if(size!=0) {
    			for(int i=0; i<size; i++) {
    				contentsArea.getChildren().remove(i);
    			}
    		}
    		contentsArea.getChildren().add(root);
    		
    		//媛� �꽔�뼱二쇨린(Deatils�뿉�꽌 �벝 媛� 誘몃━ �꽔�뼱以�寃�)
    		adCon.setName(agencyVo);

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
//    	
    }




    @FXML
    void paginationCliked(MouseEvent event) {
//    	int totalCount = 25;
//    	int countList = 10;
//    	if(totalCount % countList > 0) {
//    		totalPage++;
//    	}
    }
    
    private int rowsPerPage = 24; 		// 한 화면에 보여줄 데이터 개수 지정
	private int totalCount;				// 전체 레코드 수
	private int pageCount;				// 페이지 수
	
	//private TableView<MemberVO> table;	// TableView객체 변수 선언 
//	private Pagination pagination;		// Pagination객체 변수 선언
//	private Object setcurrentPageIndex;
	
    public void changeTableView(int index){
		int start = index * rowsPerPage;
		int end = Math.min(start + rowsPerPage, totalCount);
		
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("start", start);
		pageMap.put("end", end);
		
		try {
			tableView.setItems(FXCollections.observableArrayList(service.getPagingCourtList(pageMap)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

    @FXML
    void initialize() {
    	// 넣어주기 > 이걸로 검색할 수 있게
		//service객체 생성
    	try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (IAgencyService) reg.lookup("Agency");
		} catch (RemoteException e) {
			e.printStackTrace();
			
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	
    	colName.setCellValueFactory(new PropertyValueFactory<>("cou_name")); 
    	colAddr.setCellValueFactory(new PropertyValueFactory<>("cou_loc"));
    	
    	String StringcomboArea[] = { "서울특별시", "부산광역시", "대구광역시", "인천광역시", "광주광역시", "대전광역시", "울산광역시", "세종특별자치시", "경기도",
				"강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "전체"};
    	
    	ObservableList<String> observableList = FXCollections.observableArrayList(StringcomboArea);
    	comboArea.setItems(observableList);
    	comboArea.setValue("전체");
    	// comboArea.setCellFactory(new PropertyValueFactory<>("StringcomboArea"));
		// StringcomboArea가 comboArea에 들어가게 셋팅해준거

		// comboArea의 값 가져오기
    	String comboAddr = comboArea.getValue();
    	// 가져온 값으로 sql문 돌려서 observaleList에 저장하기
    	if(comboAddr.equals("전체")) {
    		try {
				AgencyTableList = FXCollections.observableArrayList(service.getAllCourt());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		try {
				AgencyTableList = FXCollections.observableArrayList(service.getAreaSearch(comboAddr));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    	
    	// 콤보박스에 이 값들을 셋팅
    	tableView.setItems(AgencyTableList);
    	
    	// 이 목록들을 VO에 저장하고 tableView에 나오게 하기 >
//    	/AddListener : 함수를 불러온다. 콜백
    	comboArea.valueProperty().addListener(new ChangeListener<String>() {
    		
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			// 현재 선택된 콤보값 구하기
				// 현재 선택한 콤보값에 맞는 상품 데이터를 구해서 TableView에 셋팅하기
    			List<AgencyVO> List = new ArrayList<AgencyVO>();
    	    	
    	    	Map<String, String> paraMap = new HashMap<String, String>();
    			
				try {
					 ;
					comboProvince.setItems(FXCollections.observableArrayList(service.getCourtSi(newValue)));
					
					
					paraMap.put("para1", comboArea.getValue());
					paraMap.put("para2", comboProvince.getValue());	
					//AgencyCmboProrList2 = (ObservableList<AgencyVO>) service.getCourtBoth(paraMap);
					//service.getCourtBoth(paraMap);
					List = service.getCourtBoth(paraMap);
					
//					AgencyCmboProrList1 = FXCollections.observableArrayList(List);
//					tableView.setItems(AgencyCmboProrList1);
//					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
    			
				
    		}
    		
		});
    	
        	try {
    			totalCount = service.getAllCourt().size();
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












