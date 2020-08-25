package kr.or.ddit.service.auction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class AuctionInsertData implements Job{
	
		@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		JobDataMap dataMap = arg0.getMergedJobDataMap();
		auctionServerImpl service = (auctionServerImpl) dataMap.get("service");
		
		
		Map<String,List<String>> map = service.getAuctionState();
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String no = it.next();
			String won = map.get(no).get(0);
			String id = map.get(no).get(1);
			String state = map.get(no).get(2);
			
			Map<String,String> info = new HashMap<String, String>();
			info.put("id", id);
			info.put("no", no);
			info.put("won", won);
			info.put("state",state);
			if(service.insertArticleResult(info)<0) {
				System.out.println(no+"의 경매 결과insert실패..");
			}
		}
		

	}
}

