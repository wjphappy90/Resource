package com.itheima.scheduler.elasticjob.quickstart.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;

/**
 * @author Administrator
 * @version 1.0
 **/
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext){
        System.out.printf("time:%s,to do...\n", LocalDateTime.now());
    }
}
