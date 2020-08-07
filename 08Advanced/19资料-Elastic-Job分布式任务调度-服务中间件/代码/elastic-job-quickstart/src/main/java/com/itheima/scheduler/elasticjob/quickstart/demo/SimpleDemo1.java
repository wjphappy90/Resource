package com.itheima.scheduler.elasticjob.quickstart.demo;

import java.time.LocalDateTime;

/**
 * @author Administrator
 * @version 1.0
 **/
public class SimpleDemo1 {
    public static void main(String[] args) {

        //任务执行间隔时间
        final long timeInterval = 3000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    System.out.printf("time:%s,to do...\n", LocalDateTime.now());
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
