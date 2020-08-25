package kr.or.ddit.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import kr.or.ddit.service.InoticeServer;
import kr.or.ddit.service.noticeServerImpl;
import kr.or.ddit.service.InformationUse.AgencyServiceImpl;
import kr.or.ddit.service.InformationUse.FAQServiceImpl;
import kr.or.ddit.service.InformationUse.IAgencyService;
import kr.or.ddit.service.InformationUse.IFAQService;
import kr.or.ddit.service.InformationUse.IManagerAgencyService;
import kr.or.ddit.service.InformationUse.IManagerFAQService;
import kr.or.ddit.service.InformationUse.ManagerAgencyServiceImpl;
import kr.or.ddit.service.InformationUse.ManagerFAQServiceImpl;
import kr.or.ddit.service.adminmypage.ImemberInfoService;
import kr.or.ddit.service.adminmypage.MemberInfoServiceImpl;
import kr.or.ddit.service.auction.IauctionServer;
import kr.or.ddit.service.auction.auctionServerImpl;
import kr.or.ddit.service.knowledge.IKnowledgeService;
import kr.or.ddit.service.knowledge.KnowledgeServiceImpl;
import kr.or.ddit.service.law.ILawService;
import kr.or.ddit.service.law.LawService;
import kr.or.ddit.service.login.ILoginService;
import kr.or.ddit.service.login.LoginServiceImpl;
import kr.or.ddit.service.main.ImainService;
import kr.or.ddit.service.main.mainServiceImpl;
import kr.or.ddit.service.member.IService;
import kr.or.ddit.service.member.ServiceImpl;
import kr.or.ddit.service.mypage.CalendarService;
import kr.or.ddit.service.mypage.ICalendarService;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.service.mypage.MymemberServiceImpl;
import kr.or.ddit.service.search.ISearchService;
import kr.or.ddit.service.search.SearchService;
import kr.or.ddit.service.statistics.IStatisticsService;
import kr.or.ddit.service.statistics.StatisticsServiceImpl;
import kr.or.ddit.service.stuff.AdminService;
import kr.or.ddit.service.stuff.IAdminService;





public class MainServer extends UnicastRemoteObject {

   protected MainServer() throws RemoteException {
   }

   void startNoiceServer() {
      System.out.println("서버준비중...");
      try {
      InoticeServer inf = noticeServerImpl.getInstance();
      
      Registry reg = LocateRegistry.createRegistry(8888);
      reg.rebind("notice", inf);
      
      IFAQService inf1 = FAQServiceImpl.getInstance();
      reg.rebind("FAQ", inf1);
      IAgencyService inf2 = AgencyServiceImpl.getInstance();
      reg.rebind("Agency", inf2);
      IManagerFAQService inf3 = ManagerFAQServiceImpl.getInstance();
      reg.rebind("ManagerFAQ", inf3);
      IManagerAgencyService inf4 = ManagerAgencyServiceImpl.getInstance();
      reg.rebind("ManagerAgency", inf4);
      IKnowledgeService inf5 = KnowledgeServiceImpl.getInstance();
      reg.rebind("knowledge", inf5);
      IAdminService inf6 = AdminService.getInstance();
      reg.rebind("adminService", inf6);
      ISearchService inf7 = SearchService.getInstance();
      reg.rebind("searchService", inf7);
      ImemberInfoService inf8 = MemberInfoServiceImpl.getInstance();
      reg.rebind("ImemberInfoService", inf8);
      IMymemberService inf9 = MymemberServiceImpl.getInstance();
      reg.rebind("IMymemberService", inf9);	
      IauctionServer inf10 = auctionServerImpl.getInstance(); 
      reg.rebind("auction",inf10);
      IService inf11 = ServiceImpl.getInstance();
      reg.rebind("IService", inf11);	
      ILoginService inf12 = LoginServiceImpl.getInstance();
      reg.rebind("login", inf12);
      ICalendarService inf13 = CalendarService.getInstance();
      reg.rebind("calendar", inf13);
      ImainService inf14 = mainServiceImpl.getInstance();
      reg.rebind("main", inf14);
      ILawService inf15 = LawService.getInstance();
      reg.rebind("lawService", inf15);
      IStatisticsService inf16 = StatisticsServiceImpl.getInstance();
      reg.rebind("statistics", inf16);
 
      System.out.println("서버가 준비되었습니다..");
      } catch (Exception e) {
         e.printStackTrace();

      }
      
   }
   
   public static void main(String[] args) throws RemoteException {
      new MainServer().startNoiceServer();
   }

}