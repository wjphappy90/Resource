package com.itheima.scheduler.elasticjob.quickstart.demo;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0
 **/
public class SimpleDemo3 {
    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        //TODO：something
                        System.out.printf("time:%s,to do222...\n", LocalDateTime.now());
                    }
                }, 1,
                3, TimeUnit.SECONDS);
    }
}
