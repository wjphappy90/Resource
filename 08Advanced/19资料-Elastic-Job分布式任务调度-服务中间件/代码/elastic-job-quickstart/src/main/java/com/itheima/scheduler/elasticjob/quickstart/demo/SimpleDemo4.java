package com.itheima.scheduler.elasticjob.quickstart.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Administrator
 * @version 1.0
 **/
public class SimpleDemo4 {
    public static void main(String[] args) throws SchedulerException {

        //创建一个Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //创建JobDetail
        JobBuilder jobDetailBuilder = JobBuilder.newJob(MyJob.class);
        jobDetailBuilder.withIdentity("jobName","jobGroupName");
        JobDetail jobDetail = jobDetailBuilder.build();
        //创建触发的CronTrigger 支持按日历调度
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName", "triggerGroupName")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();
        //创建触发的SimpleTrigger 简单的间隔调度
        /*SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName","triggerGroupName")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();*/
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
