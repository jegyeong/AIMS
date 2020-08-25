package kr.or.ddit.service.auction;

import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import kr.or.ddit.vo.A_articleVO;

public class AuctionData implements Job{
	
		@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		JobDataMap dataMap = arg0.getMergedJobDataMap();
		A_articleVO articleVO = (A_articleVO) dataMap.get("article");
		
		auctionServerImpl service = (auctionServerImpl) dataMap.get("service");
		
		System.out.println("서버값 : "+service);
		
		Map<String,List<String>> map = service.getAuctionState();
		
		map.get(articleVO.getA_art_no()).set(2, "경매중");

	}
}

