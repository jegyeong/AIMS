package kr.or.ddit.controller.InformationUse;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.AlertDialog.AlertUtil;
import kr.or.ddit.controller.knowledge.user.KnowledgeMainController;
import kr.or.ddit.controller.login.loginController;
import kr.or.ddit.controller.main.MainPageController;
import kr.or.ddit.controller.mypage.MymemberController;
import kr.or.ddit.controller.notice.user.NoticeMainController;
import kr.or.ddit.controller.search.ButtonController;
import kr.or.ddit.controller.search.MapController;
import kr.or.ddit.controller.statistics.StatisticsMainController;
import kr.or.ddit.session.Session;
import kr.or.ddit.vo.FAQVO;

public class SiteMapController {
	
	private MainTemplateController mainController;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorSiteMap;

    @FXML
    private Label auctionNoticeList;

    @FXML
    private Label auctionNotice;

    @FXML
    private Label actionGoods;

    @FXML
    private Label actionSearchNum;

    @FXML
    private Label actionSearchMap;

    @FXML
    private Label actionSearchTime;

    @FXML
    private Label actionSearchLike;

    @FXML
    private Label actionSearchResult;

    @FXML
    private Label statistics;

    @FXML
    private Label statisticsAtea;

    @FXML
    private Label knowledgeStep;

    @FXML
    private Label knowledgeTerms;

    @FXML
    private Label knowledgeFormat;

    @FXML
    private Label knowledgeGuide;

    @FXML
    private Label knowledgeRules;

    @FXML
    private Label knowledge;

    @FXML
    private Label myAction;

    @FXML
    private Label myActionSchedule;

    @FXML
    private Label myActionLike;

    @FXML
    private Label myActionInfo;

    @FXML
    private Label myActionCompl;

    @FXML
    private Label myActionHistory;

    @FXML
    private Label myActionSecession;
    
    @FXML
    private Label actionSearchCourt;

    @FXML
    private Label actionSearchCategory;

    @FXML
    private Label actionSearchAppr;

    @FXML
    private Label actionSearchLow;

    @FXML
    private Label actionSearchArea;

    @FXML
    private Label actionSearchTour;

    @FXML
    private Label actionSearchCnt;

    @FXML
    private Label actionSearchAll;

    @FXML
    void actionGoodsClicked(MouseEvent event) {
    	
    }

    @FXML
    void actionSearchLikeClicked(MouseEvent event) {
    	try {
			
			//FXMLLoader loader = new FXMLLoader(loginController.class.getResource("../../fxml/main/mainPage.fxml"));
			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Stage stage = (Stage) actionSearchLike.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

			Parent inter = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlInter.fxml"));
			
			anchorSiteMap.getChildren().clear();
			
			anchorSiteMap.getChildren().addAll(inter);

		} catch (IOException e) {
			e.printStackTrace();
		}

		}

    @FXML
    void actionSearchMapClicked(MouseEvent event) {
    	try {
/*			
			//FXMLLoader loader = new FXMLLoader(loginController.class.getResource("../../fxml/main/mainPage.fxml"));
			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Stage stage = (Stage) myActionCompl.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

			Parent map = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlMap.fxml"));
			
			anchorSiteMap.getChildren().clear();
			
			anchorSiteMap.getChildren().addAll(map);
*/			
			FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlMap.fxml");
			Stage stage = (Stage) actionSearchMap.getScene().getWindow();
			Scene scene = new Scene(root);
			
			stage.setScene(scene);
			stage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchNumClicked(MouseEvent event) throws IOException {
    	try {
			
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlNum.fxml");
			Stage stage = (Stage) actionSearchNum.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchResultClicked(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlResult.fxml");
			Stage stage = (Stage) actionSearchResult.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchTime(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlDate.fxml");
			Stage stage = (Stage) actionSearchTime.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void actionSearchAll(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlTotal.fxml");
			Stage stage = (Stage) actionSearchAll.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchAppr(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlPrice.fxml");
			Stage stage = (Stage) actionSearchAppr.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchArea(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlArea.fxml");
			Stage stage = (Stage) actionSearchArea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchCategory(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlCategory.fxml");
			Stage stage = (Stage) actionSearchCategory.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchCnt(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlCnt.fxml");
			Stage stage = (Stage) actionSearchCnt.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionSearchCourtClick(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlCourt.fxml");
			Stage stage = (Stage) actionSearchCourt.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void actionSearchTour(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlTour.fxml");
			Stage stage = (Stage) actionSearchTour.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void actionSearchLow(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			ButtonController btnCon = loader.getController();
			btnCon.setAADialog("../../fxml/search/fxmlLow.fxml");
			Stage stage = (Stage) actionSearchLow.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void auctionNoticeList(MouseEvent event) throws IOException {
    	Stage mainstage = (Stage) auctionNoticeList.getScene().getWindow();
    	Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/auction/AuctionMain.fxml"));
    	
    	Stage stage = new Stage(StageStyle.DECORATED);
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.initOwner(mainstage);
    	
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void auctionNoticeTitle(MouseEvent event) {
    	
    }

    @FXML
    void knowledgeClicked(MouseEvent event) {
    	
    }

    @FXML
    void knowledgeFormatClicked(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/knowledge/user/knowledgeMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			KnowledgeMainController knowledgeCon = loader.getController();
			knowledgeCon.setAADialog("../../fxml/knowledge/user/auctionFormat.fxml");
			Stage stage = (Stage) knowledgeFormat.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void knowledgeGuideClicked(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/knowledge/user/knowledgeMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			KnowledgeMainController knowledgeCon = loader.getController();
			knowledgeCon.setAADialog("../../fxml/knowledge/user/guide.fxml");
			Stage stage = (Stage) knowledgeGuide.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void knowledgeRules(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/knowledge/user/knowledgeMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			KnowledgeMainController knowledgeCon = loader.getController();
			knowledgeCon.setAADialog("../../fxml/law/fxmlLaw.fxml");
			Stage stage = (Stage) knowledgeRules.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void knowledgeStepClicked(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/knowledge/user/knowledgeMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			KnowledgeMainController knowledgeCon = loader.getController();
			knowledgeCon.setAADialog("../../fxml/knowledge/user/auctionStep.fxml");
			Stage stage = (Stage) knowledgeStep.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void knowledgeTermsClicked(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/knowledge/user/knowledgeMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			KnowledgeMainController knowledgeCon = loader.getController();
			knowledgeCon.setAADialog("../../fxml/knowledge/user/auctionTerms.fxml");
			Stage stage = (Stage) knowledgeTerms.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }




    @FXML
    void statisticsAteaClicked(MouseEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/statistics/statisticsMain.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			StatisticsMainController statisticsCon = loader.getController();
			statisticsCon.setSubAnchorDialog("../../fxml/statistics/area_statistics.fxml");
			Stage stage = (Stage) statisticsAtea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void statisticsClicked(MouseEvent event) {

    }
    
    @FXML
    void myActionInfo(MouseEvent event) { //내정보
    	if(Session.loginUser==null) {
    		AlertUtil.showAlertOnlyConfirm((Stage) knowledgeStep.getScene().getWindow(), "회원만 사용가능합니다.", "확인");
    		return;
    	}
    	
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/mypage/Mymember.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			MymemberController myMemCon = loader.getController();
			myMemCon.setAADialog("../../fxml/mypage/MyInformation.fxml");
			Stage stage = (Stage) statisticsAtea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void myActionComplClciked(MouseEvent event) { //내민원
    	if(Session.loginUser==null) {
    		AlertUtil.showAlertOnlyConfirm((Stage) knowledgeStep.getScene().getWindow(), "회원만 사용가능합니다.", "확인");
    		return;
    	}
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/mypage/Mymember.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			MymemberController myMemCon = loader.getController();
			myMemCon.setAADialog("../../fxml/mypage/Com_QuestionController.fxml");
			Stage stage = (Stage) statisticsAtea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void myActionHistoryClicked(MouseEvent event) { //내경매내역
    	if(Session.loginUser==null) {
    		AlertUtil.showAlertOnlyConfirm((Stage) knowledgeStep.getScene().getWindow(), "회원만 사용가능합니다.", "확인");
    		return;
    	}
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/mypage/Mymember.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			MymemberController myMemCon = loader.getController();
			myMemCon.setAADialog("../../fxml/mypage/MyAuction.fxml");
			Stage stage = (Stage) statisticsAtea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void myActionLikeClicked(MouseEvent event) { //내관심물건
    	if(Session.loginUser==null) {
    		AlertUtil.showAlertOnlyConfirm((Stage) knowledgeStep.getScene().getWindow(), "회원만 사용가능합니다.", "확인");
    		return;
    	}
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/mypage/Mymember.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			MymemberController myMemCon = loader.getController();
			myMemCon.setAADialog("../../fxml/mypage/MymemInterest.fxml");
			Stage stage = (Stage) statisticsAtea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void myActionScheduleClicked(MouseEvent event) { //내일정
    	if(Session.loginUser==null) {
    		AlertUtil.showAlertOnlyConfirm((Stage) knowledgeStep.getScene().getWindow(), "회원만 사용가능합니다.", "확인");
    		return;
    	}
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/mypage/Mymember.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			MymemberController myMemCon = loader.getController();
			myMemCon.setAADialog("../../fxml/mypage/MySchedual.fxml");
			Stage stage = (Stage) statisticsAtea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void myActionSecessionClciked(MouseEvent event) { //회원탈퇴
    	if(Session.loginUser==null) {
    		AlertUtil.showAlertOnlyConfirm((Stage) knowledgeStep.getScene().getWindow(), "회원만 사용가능합니다.", "확인");
    		return;
    	}
    	try {
    		FXMLLoader loader = new FXMLLoader(SiteMapController.class.getResource("../../fxml/mypage/Mymember.fxml"));
//			Parent root = FXMLLoader.load(SiteMapController.class.getResource("../../fxml/search/fxmlButtonMain.fxml"));
//			MainPageController logCon = loader.getController();
			Parent root = loader.load();
			MymemberController myMemCon = loader.getController();
			myMemCon.setAADialog("../../fxml/mypage/Mymemtaltoe.fxml");
			Stage stage = (Stage) statisticsAtea.getScene().getWindow();
			Scene scene = new Scene(root);

			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

//	void setAADialog(String path ) {
//		try {
//			Parent root = FXMLLoader.load(ButtonController.class.getResource(path));
//		
//			if (AA.getChildren().size() != 0) {
//				for (int i = 0; i < AA.getChildren().size(); i++) {
//					AA.getChildren().remove(i);
//				}
//			}
//			AA.getChildren().add(root);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

    @FXML
    void initialize() {
        assert anchorSiteMap != null : "fx:id=\"anchorSiteMap\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert auctionNoticeList != null : "fx:id=\"auctionNoticeList\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert auctionNotice != null : "fx:id=\"auctionNotice\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert actionGoods != null : "fx:id=\"actionGoods\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert actionSearchNum != null : "fx:id=\"actionSearchNum\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert actionSearchMap != null : "fx:id=\"actionSearchMap\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert actionSearchTime != null : "fx:id=\"actionSearchTime\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert actionSearchLike != null : "fx:id=\"actionSearchLike\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert actionSearchResult != null : "fx:id=\"actionSearchResult\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert statistics != null : "fx:id=\"statistics\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert statisticsAtea != null : "fx:id=\"statisticsAtea\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert knowledgeStep != null : "fx:id=\"knowledgeStep\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert knowledgeTerms != null : "fx:id=\"knowledgeTerms\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert knowledgeFormat != null : "fx:id=\"knowledgeFormat\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert knowledgeGuide != null : "fx:id=\"knowledgeGuide\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert knowledgeRules != null : "fx:id=\"knowledgeRules\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert knowledge != null : "fx:id=\"knowledge\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert myAction != null : "fx:id=\"myAction\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert myActionSchedule != null : "fx:id=\"myActionSchedule\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert myActionLike != null : "fx:id=\"myActionLike\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert myActionInfo != null : "fx:id=\"myActionInfo\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert myActionCompl != null : "fx:id=\"myActionCompl\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert myActionHistory != null : "fx:id=\"myActionHistory\" was not injected: check your FXML file 'SiteMap.fxml'.";
        assert myActionSecession != null : "fx:id=\"myActionSecession\" was not injected: check your FXML file 'SiteMap.fxml'.";

    }
}
