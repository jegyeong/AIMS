package kr.or.ddit.controller.mypage;


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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;


// 내 민원 창 
public class Com_QuestionController {
	
	private  IMymemberService service;
	private ObservableList<Com_QuestionVO>  data;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Com_QuestionVO> inforView;

    @FXML
    private TableColumn<?, ?> Title;

    @FXML
    private TableColumn<?, ?> Date;
    
    @FXML
    private TableColumn<Com_AnswerVO, String> state;

    @FXML
    void inforView(ActionEvent event) {
    	
    }
    
    //db데이터를 가져와 tableView에 출력하는 메소드 
    private void setComQuestionData() throws RemoteException {
    	System.out.println(Session.loginUser.getMem_id());
    	List <Com_QuestionVO> comQusetionList = service.getMyQuestion(Session.loginUser.getMem_id());
    	data = FXCollections.observableArrayList(comQusetionList);
    	inforView.setItems(data);
    	
    }
    

    @FXML
    void initialize() throws RemoteException {
    	
    	try {
    		Registry reg = LocateRegistry.getRegistry("192.168.0.118",8888);
			service = (IMymemberService) reg.lookup("IMymemberService");
		} catch (RemoteException e) {
			e.printStackTrace();
		}catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	inforView.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				if(inforView.getSelectionModel().getSelectedItem()==null)return;
				try {
				Map<String,String> data = new HashMap<>();
				data.put("no", inforView.getSelectionModel().getSelectedItem().getCom_que_no());
				Com_AnswerVO answerVO =service.getMyAnswer(data);
				if(answerVO == null) return;
				
					FXMLLoader loader = new FXMLLoader(Com_QuestionController.class.getResource("../../fxml/mypage/fxmlAnswerPopup.fxml"));
					Parent root = loader.load();
					AnswerPopUpController controller = loader.getController();
					
					controller.setdata(answerVO);
					
					Scene scene = new Scene(root);
			    	Stage popupDialog = new Stage();
			    	Stage stage =  (Stage)inforView.getScene().getWindow();
			    	
			    	popupDialog.initModality(Modality.WINDOW_MODAL);
			    	popupDialog.initOwner(stage);
			    
			    	
			    	popupDialog.setScene(scene);
			    
			    	popupDialog.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		});
    	
    	
    	Title.setCellValueFactory(new PropertyValueFactory<>("com_que_title"));
    	Date.setCellValueFactory(new PropertyValueFactory<>("com_que_writeday"));
    	state.setCellValueFactory(new PropertyValueFactory<>("com_que_no"));
    	
    	setComQuestionData();
    	
    	state.setCellFactory(new Callback<TableColumn<Com_AnswerVO,String>, TableCell<Com_AnswerVO,String>>() {
			
			@Override
			public TableCell<Com_AnswerVO, String> call(TableColumn<Com_AnswerVO, String> param) {
				
				return new TableCell<Com_AnswerVO, String>(){
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(!empty) {
							
							Map<String,String> data = new HashMap<>();
							data.put("no", item);
				
						
							try {
								Com_AnswerVO answerVO = service.getMyAnswer(data);
								if(answerVO==null) {
									setText("답변대기");
								}else {
									setText("답변완료");
								}
								
								
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
