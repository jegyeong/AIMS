package kr.or.ddit.service.auction;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class AcutionStartScheduler {
	
	public AcutionStartScheduler(auctionServerImpl service){
		JobDataMap jobMap = new JobDataMap();
		jobMap.put("service",service);

		
		JobDetail changeData = JobBuilder.newJob(changeData.class).usingJobData(jobMap).build();
		CronTrigger changeDataTrigger  = TriggerBuilder.newTrigger()
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0 6 ? * MON-FRI")).build();
//				.withSchedule(CronScheduleBuilder.cronSchedule("30 3 15 * * ? *")).build();
//				.withSchedule(CronScheduleBuilder.cronSchedule("0  15 23 4 ? 2020")).build();
		StdSchedulerFactory startSchFactory = new StdSchedulerFactory();
		
		
		try {
			Scheduler startSch = startSchFactory.getScheduler();
			startSch.start();
			startSch.scheduleJob(changeData, changeDataTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	

	
}
