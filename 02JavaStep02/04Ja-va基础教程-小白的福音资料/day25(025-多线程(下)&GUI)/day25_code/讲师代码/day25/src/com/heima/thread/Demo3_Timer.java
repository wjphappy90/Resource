package com.heima.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo3_Timer {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Timer t = new Timer();
		//在指定时间安排指定任务
		//第一个参数,是安排的任务,第二个参数是执行的时间,第三个参数是过多长时间再重复执行
		t.schedule(new MyTimerTask(), new Date(188, 6, 1, 14, 22, 50),3000);	
		
		while(true) {
			Thread.sleep(1000);
			System.out.println(new Date());
		}
	}

}

class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("起床背英语单词");
	}
}
