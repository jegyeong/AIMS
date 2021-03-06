package kr.or.ddit.controller.notice.admin;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import kr.or.ddit.service.InoticeServer;
import kr.or.ddit.vo.Com_QuestionVO;

public class NoticeComplainListController {
	private int rowsPerPage = 29; // 한 화면에 보여줄 데이터 개수
	private int totalCount; // 전체 레코드 수가 저장될 변수
	private int pageCount; // 페이지 수
	private AnchorPane dialog;
	private InoticeServer service;
   
	public AnchorPane getDialog() {
		return dialog;
	}

	public void setDialog(AnchorPane dialog) {
		this.dialog = dialog;
	}


	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Com_QuestionVO> tv_List;

    @FXML
    private TableColumn<?, ?> col_no;

    @FXML
    private TableColumn<Com_QuestionVO, String> col_cate;

    @FXML
    private TableColumn<?, ?> col_title;

    @FXML
    private TableColumn<?, ?> col_date;

    @FXML
    private Pagination pagin;

    @FXML
    void onClickedTv_Result(MouseEvent event) throws ClassNotFoundException {
    	Com_QuestionVO data = tv_List.getSelectionModel().getSelectedItem();
    	if(data==null) return;
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(Class.forName("kr.or.ddit.controller.notice.admin.NoticeAdminMainController").getResource("../../../fxml/notice/admin/NoticComplainAdmin.fxml"));
    		Parent root = loader.load();
    	
    		NoticeComplainAdminController controller = loader.getController();
    		controller.setDialog(dialog);
    		controller.setData(tv_List.getSelectionModel().getSelectedItem());
    		dialog.getChildren().remove(0);
    		dialog.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
  
	public void changeTableView(int index) {
		int start = index * rowsPerPage; // 시작번호7
		int end = Math.min(start + rowsPerPage, totalCount); // 끝 번호

		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("start", start);
		pageMap.put("end", end);

		// 테이블에 갖고온 데이터 설정하기
		try {
			tv_List.setItems(FXCollections.observableArrayList(service.getPaginQuestionList(pageMap)));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
    @FXML
    void initialize() {
     	try {
     		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (InoticeServer) reg.lookup("notice");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	col_no.setCellValueFactory(new PropertyValueFactory<>("com_que_no"));
    	col_cate.setCellValueFactory(new PropertyValueFactory<>("cat_a_no"));
    	col_title.setCellValueFactory(new PropertyValueFactory<>("com_que_title"));
    	col_date.setCellValueFactory(new PropertyValueFactory<>("com_que_writeday"));
    	
    	try {
			totalCount = service.getQuestionTotalcount();
		} catch (RemoteException e) {

			e.printStackTrace();
		}
    	
		pageCount = (int) Math.ceil((double) totalCount / rowsPerPage);
		System.out.println(pageCount);
		pagin.setPageCount(pageCount);
		pagin.setCurrentPageIndex(0);
		changeTableView(0);
    	
    	
    	col_cate.setCellFactory(new Callback<TableColumn<Com_QuestionVO,String>, TableCell<Com_QuestionVO,String>>() {
			
			@Override
			public TableCell<Com_QuestionVO, String> call(TableColumn<Com_QuestionVO, String> param) {
				
				return new TableCell<Com_QuestionVO, String>(){
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						
						if(!empty) {
							try {
								
									setText(service.getCategoryInfo(item).getCat_a_name());
							} catch (RemoteException e) {
								e.printStackTrace();
							}
						}else {
							setText(null);
						}
						
					}
				};
			}
		});
    	
    
    }
    
    
}
