package kr.or.ddit.controller.auction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import kr.or.ddit.service.auction.IauctionServer;
import kr.or.ddit.service.stuff.IAdminService;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.A_articleVO;
import kr.or.ddit.vo.Auctioning_RecordVO;
import kr.or.ddit.vo.FileInfoVO;

public class AuctionRoomController {
	private IauctionServer service;
	private Socket socket;
	private Socket socket1;
	private A_articleVO a_articleVO;
	private DataOutputStream dos;
	private DataInputStream dis;
	private DataOutputStream dos1;
	private IAdminService imgService;
	private List<File> imgList = new ArrayList<File>(); 

	@FXML
	private Button btn_imgPrev;

	@FXML
	private Button btn_imgNext;

	@FXML
	private Label col_no;

	@FXML
	private Label col_loc;

	@FXML
	private Label col_couNo;

	@FXML
	private Label col_tour;

	@FXML
	private Label col_inter;

	@FXML
	private Label col_cnt;

	@FXML
	private Label col_low;

	@FXML
	private Label col_price;

	@FXML
	private Label col_catA;

	@FXML
	private Label col_catB;

	@FXML
	private Label col_catC;

	@FXML
	private Label tf_area;

	@FXML
	private Label col_area;

	@FXML
	private Label tf_state;

	@FXML
	private Label tf_Bidder;

	@FXML
	private Label tf_bidAmount;

	@FXML
	private Button btnBidding;

	@FXML
	private TextField tf_price;

	@FXML
	private Button btnBack;

	@FXML
	private Circle chk_1;

	@FXML
	private Circle chk_2;

	@FXML
	private Circle chk_3;

	@FXML
	private ImageView imgViewer;

	@FXML
	void onClickedBtnBack(ActionEvent event) {
		try {
			socket.close();
			socket1.close();
			Stage stage = (Stage) btn_imgNext.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader(AuctionRoomController.class.getResource("AuctionMain./fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void onClickedBtnBidding(ActionEvent event) {
		if (!tf_state.getText().equals("경매중"))
			return;

		if (Long.parseLong(tf_bidAmount.getText()) < Long.parseLong(tf_price.getText())) {
			try {
				dos1.writeUTF("reset");
				dos.writeUTF("info");
				dos.writeUTF(Session.loginUser.getMem_id());
				dos.writeUTF(tf_price.getText());
				
				Auctioning_RecordVO recordVO = new Auctioning_RecordVO();
				recordVO.setA_rec_price(tf_price.getText());
				recordVO.setMem_id(Session.loginUser.getMem_id());
				recordVO.setA_art_no(a_articleVO.getA_art_no());
				service.insertRecording(recordVO);
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@FXML
	void onClickedBtn_imgNext(ActionEvent event) {
		try {
    		
	    	if(imgList.size()-1>Integer.parseInt(imgViewer.getId())) {
	    		FileInputStream fis = new FileInputStream(imgList.get(Integer.parseInt(imgViewer.getId())+1));
				Image image = new Image(fis);
				imgViewer.setImage(image);
				imgViewer.setId((Integer.parseInt(imgViewer.getId())+1)+"");
					
	    	}else {
	    		FileInputStream fis = new FileInputStream(imgList.get(0));
				Image image = new Image(fis);
				imgViewer.setImage(image);
				imgViewer.setId("0");
				
	    	}
	    	
	    	} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}

	@FXML
	void onclickedBtn_imgPrev(ActionEvent event) {
		try {
        	if(Integer.parseInt(imgViewer.getId())-1<0) {
    			FileInputStream fis = new FileInputStream(imgList.get((imgList.size()-1)));
    			Image image = new Image(fis);
    			imgViewer.setImage(image);
    			imgViewer.setId((imgList.size()-1)+"");
        	}else {
        		FileInputStream fis = new FileInputStream(imgList.get(Integer.parseInt(imgViewer.getId())-1));
    			Image image = new Image(fis);
    			imgViewer.setImage(image);
    			imgViewer.setId((Integer.parseInt(imgViewer.getId())-1)+"");
    			
        	}
        	
        	} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
	}

	public void setdata(A_articleVO a_articleVO) {
		this.a_articleVO = a_articleVO;
		A_articleVO info = null;
		try {
			info = service.getArticleInfo(this.a_articleVO.getA_art_no());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		col_area.setText(info.getA_art_area());
		col_catA.setText(info.getCat_a_no());
		col_catB.setText(info.getCat_b_no());
		col_catC.setText(info.getCat_c_no());
		col_cnt.setText(info.getA_art_cnt() + "");
		col_couNo.setText(info.getCou_no());
		col_inter.setText(info.getA_art_inter());
		col_loc.setText(info.getA_art_loc());
		col_low.setText(info.getA_art_low());
		col_no.setText(info.getA_art_no());
		col_price.setText(info.getA_art_price());
		col_tour.setText(info.getA_art_tour() + "");
		tf_bidAmount.setText(info.getA_art_low());
		
		try {
			for (FileInfoVO infoVO : imgService.ImgServerToClient(a_articleVO)) {
				System.out.println(infoVO.getFileName());
				File file = new File(infoVO.getFileName());
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(infoVO.getFileData());
				imgList.add(file);
			}
			
			FileInputStream fis = new FileInputStream(imgList.get(0));
			Image image = new Image(fis);
			imgViewer.setImage(image);
			imgViewer.setId("0");
			imgViewer.setFitWidth(216);
			imgViewer.setFitHeight(228);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			dos.writeUTF(a_articleVO.getA_art_no());
			dos1.writeUTF(a_articleVO.getA_art_no());

			final String won = dis.readUTF();
			final String id = dis.readUTF();
			final String state = dis.readUTF();
			final String cntState = dis.readUTF();

			Platform.runLater(() -> {
				tf_bidAmount.setText(won);
				tf_Bidder.setText(id);
				checklight(cntState);
				if (Integer.parseInt(cntState) > 0 && Integer.parseInt(cntState) < 3) {
					tf_state.setText("경매중");
				} else {
					tf_state.setText(state);
				}

				if (state.equals("낙찰") || state.equals("유찰")) {
					btnBidding.setDisable(true);
				}
			});

			ClientReceiver th = new ClientReceiver(this.socket);
			th.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void checklight(String state) {
		if (state.equals("1")) {
			chk_1.setStyle("-fx-fill:red");
		}
		if (state.equals("2")) {
			chk_1.setStyle("-fx-fill:red");
			chk_2.setStyle("-fx-fill:red");
		}
		if (state.equals("3")) {
			chk_1.setStyle("-fx-fill:red");
			chk_2.setStyle("-fx-fill:red");
			chk_3.setStyle("-fx-fill:red");
			btnBidding.setDisable(true);
			Platform.runLater(() -> {
				if (tf_Bidder.getText().equals("입찰자 없음")) {

					tf_state.setText("유찰");
				} else {
					tf_state.setText("낙찰");
				}
			});
		}

	}

	@FXML
	void initialize() {

		try {
			Registry reg = LocateRegistry.getRegistry("192.168.0.118", 8888);
			service = (IauctionServer) reg.lookup("auction");
			imgService = (IAdminService) reg.lookup("adminService");

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

		try {
			socket = new Socket("192.168.0.118", 9999);
			socket1 = new Socket("192.168.0.118", 9998);

			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			dos1 = new DataOutputStream(socket1.getOutputStream());

			ClientReceiver1 receiver1 = new ClientReceiver1(socket1);
			receiver1.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		tf_state.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue.equals("낙찰") || newValue.equals("유찰")) {
					try {
						dos1.writeUTF(tf_state.getText());
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		});
		
		tf_price.setOnKeyTyped(new EventHandler<KeyEvent>() {
    		@Override
    		public void handle(KeyEvent event) {
    			tf_price.textProperty().addListener((Observable, oldValue, newValue) -> {
    				if(!newValue.matches("^[0-9]+$")) {
    					tf_price.setText(newValue.replaceAll("[^0-9]", ""));
    				}
    			});
    		}
    	});
	}

	class ClientReceiver extends Thread {
		private Socket socket;
		private DataInputStream in;

		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(this.socket.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (socket != null) {
				try {
					String id = in.readUTF();
					String won = in.readUTF();
					Platform.runLater(() -> {
						tf_Bidder.setText(id);
						tf_bidAmount.setText(won);
					});
					chk_1.setStyle("-fx-fill:red");
					chk_2.setStyle("-fx-fill:blue");
					chk_3.setStyle("-fx-fill:blue");
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

	}
		
	class ClientReceiver1 extends Thread {
		private Socket socket;
		private DataInputStream in;

		public ClientReceiver1(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(this.socket.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (socket != null) {
				try {
					String type = in.readUTF();
					if (type.equals("경매중")) {
						Platform.runLater(() -> {
							tf_state.setText(type);
						});
					} else {
						Platform.runLater(() -> {
							checklight(type);
						});
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
