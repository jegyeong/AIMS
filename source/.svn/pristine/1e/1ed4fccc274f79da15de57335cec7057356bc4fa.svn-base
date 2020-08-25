package kr.or.ddit.service.auction;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import kr.or.ddit.vo.A_articleVO;

public class changeData implements Job{
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		JobDataMap dataMap = arg0.getMergedJobDataMap(); 
		auctionServerImpl service = (auctionServerImpl) dataMap.get("service");
		Map<String,List<String>> map = service.getAuctionState();
		
		try {
			for(A_articleVO articleVO:service.getTotalArticleList()) {
				String date = articleVO.getA_art_day();
				String year = date.split(" ")[0].split("-")[0];
				String month = date.split(" ")[0].split("-")[1];
				String day = date.split(" ")[0].split("-")[2];
				String hour = date.split(" ")[1].split(":")[0];
				String minute = date.split(" ")[1].split(":")[1];
				String seconde = date.split(" ")[1].split(":")[2];
				String data = seconde+" "+minute+" "+hour+" "+day+" "+month+" ? "+year;
				List<String> list = new ArrayList<String>();
				list.add(articleVO.getA_art_low());
				list.add("입찰자 없음");
				list.add("준비중");
				list.add("0");
				map.put(articleVO.getA_art_no(),list);
				
				JobDataMap artMap = new JobDataMap();
				artMap.put("article",articleVO);
				artMap.put("service",service);
				
				JobDetail changeData = JobBuilder.newJob(AuctionData.class).usingJobData(artMap).build();
				CronTrigger changeDataTrigger  = TriggerBuilder.newTrigger()
						.withSchedule(CronScheduleBuilder.cronSchedule(data)).build();
				StdSchedulerFactory startSchFactory = new StdSchedulerFactory();
				try {
					Scheduler startSch = startSchFactory.getScheduler();
					startSch.start();
					startSch.scheduleJob(changeData, changeDataTrigger);
				} catch (SchedulerException e) {
					e.printStackTrace();
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
}
}