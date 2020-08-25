package kr.or.ddit.controller.adminmypage;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.javafx.css.Style;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.adminmain.AdminMain;
import kr.or.ddit.controller.mypage.MyInformationController;
import kr.or.ddit.controller.stuff.AdminMainController;
import kr.or.ddit.service.adminmypage.ImemberInfoService;
import kr.or.ddit.vo.MemberVO;


//회원정보 관리 첫 화면 
public class MemberInfoController {

	private MemberInfoModifyController memberInfoController;

	public MemberInfoModifyController getMainInfoController() {
		return memberInfoController;
	}

	public void setMainController(MemberInfoModifyController mainController) {
		this.memberInfoController = mainController;
	}
	
//	public void setMainController(MyInformationController myInformationController) {
//	
//	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	// 검색창
	@FXML
	private TextField textfiled;

	// 회원 id 검색 버튼
	@FXML
	private Button search;

	@FXML
	private TableView<MemberVO> memTable;

	@FXML
	private TableColumn<?, ?> memid;

	@FXML
	private TableColumn<?, ?> memName;

	@FXML
	private TableColumn<?, ?> memReg;
	
	
	@FXML
    private TableColumn<?, ?> activeCol;

	// 정보수정 버튼
	@FXML
	private Button memberModi;

	// 정보수정 버튼
	@FXML
	private Button blacklist;

	// 홈으로 버튼
	@FXML
	private Button home;

	private ImemberInfoService service;
	private ObservableList<MemberVO> memberInfoList;// 검색을 눌렀을 떄

	private MemberInfoModifyController modifyController;

	private void setData() {
		try {
			List<MemberVO> memList = service.getSearchMember(textfiled.getText());
			memberInfoList = FXCollections.observableArrayList(memList);
			memTable.setItems(memberInfoList);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setMainController(MyInformationController myInformationController) {
		// TODO Auto-generated method stub
		
	}

	// 블랙리스트 버튼
	@FXML
	void blacklistBtn(ActionEvent event) {
		if(memTable.getSelectionModel().isEmpty()) {
			return;
		}
		
		try {
		
			MemberVO memVo = memTable.getSelectionModel().getSelectedItem(); // 테이블에서 선택한 값을  넣어줌 
			
			System.out.println(memVo.getMem_id() + " --> " + memVo.getMem_blacklist() );
			
			if(memVo.getMem_blacklist().equals("YES")) { // 선택한 값의 블랙리스트 값이 yes 이면 
					int black = service.deleteBlackListMember(memVo.getMem_id());
					if(black == 1) {
						System.out.println("성공");
					}else {
						System.out.println("실패");
					}
					
				
			}else if(memVo.getMem_blacklist().equals("NO")){
					int noblack = service.insertBlackListMember(memVo.getMem_id());
					if(noblack == 1) {
						System.out.println("성공");
					}else {
						System.out.println("실패");
					}
					
				
			}
			setData();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// 홈으로 버튼을 누르면 메인창으로 이동한다. fxml파일 연결해야 함
	@FXML
	void homeBtn(ActionEvent event) throws IOException {
		
		if(AlertUtil.showAlert((Stage) memberModi.getScene().getWindow(), "메인페이지로  ", "이동하시겠습니까?", "이동", "취소")) {
			FXMLLoader loader = new FXMLLoader(AdminMainController.class.getResource("../../fxml/adminmain/AdminMain.fxml"));
	    	Parent root = loader.load();
	    	  	
	    	Stage stage = (Stage) memberModi.getScene().getWindow(); 
	    	Scene scene = new Scene(root);
	    	
	    	stage.setScene(scene);
	    	stage.setTitle("관리자 메인 페이지");
	    	stage.show();
		};
	}

	private void setMainController(MemberInfoController memberInfoController2) {
		// TODO Auto-generated method stub

	}

	// 회원 수정 버튼을 누르면 화면 전환
	@FXML
	void memModiBtn(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(
				MemberInfoController.class.getResource("../../fxml/adminmypage/memberInfoModify.fxml"));
		Parent root = loader.load();
		Stage stage = (Stage) memTable.getScene().getWindow();

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("회원정보 수정");
		stage.show();

		// �쉶�썝 �젙蹂� 梨꾩썙 �꽔�뒗 遺�遺�
		modifyController = loader.getController();
		if (!memTable.getSelectionModel().isEmpty()) {
			MemberVO mifvo = memTable.getSelectionModel().getSelectedItem();
			modifyController.show(mifvo);
		}

	}

	// 회원관리 테이블 뷰
	// 테이블 뷰를 선택하면 수정버튼이 활성화 되도록 바뀌어 진다.

	@FXML
	void memTableView(MouseEvent event) {

		if (memTable.getSelectionModel().isEmpty()) {
			return;
		}
		memberModi.setDisable(false);

		//
		
	}

	// id 검색버튼
	@FXML
	void serchBtn(ActionEvent event) {
		setData();
	}

	// 검색 창
	@FXML
	void textfiled(ActionEvent event) {

	}

	@FXML
	void initialize() {
		// service 생성
		try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (ImemberInfoService) reg.lookup("ImemberInfoService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		// -------------------------------------------
//		memTable.setRowFactory(new Callback<TableView<MemberInfoVO>, TableRow<MemberInfoVO>>() {
//			
//			@Override
//			public TableRow<MemberInfoVO> call(TableView<MemberInfoVO> param) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
		
		
		memTable.setRowFactory(tv -> new TableRow<MemberVO>() {
		    @Override
		    protected void updateItem(MemberVO item, boolean empty) {
		        super.updateItem(item, empty);
		        if (item == null || item.getMem_blacklist() == null)
		            setStyle("");
		        else if (item.getMem_blacklist().equals("YES"))
		            setStyle("-fx-background-color: pink;"); //#0000ff
		        else
		            setStyle("");
		    }
		});
		
		
		//-------------------------------------------
		
		
		// 뷰에 각 컬럼 설정
		memid.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		memName.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
		memReg.setCellValueFactory(new PropertyValueFactory<>("mem_regno"));
		activeCol.setCellValueFactory(new PropertyValueFactory<>("mem_active"));

		setData();

	}



}
