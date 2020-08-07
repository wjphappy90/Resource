package com.heima.threadmethod;

public class Demo2_CurrentThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				System.out.println(getName() + "....aaaaaa");
			}
		}.start();
		
		
		new Thread(new Runnable() {
			public void run() {
				//Thread.currentThread()获取当前正在执行的线程
				System.out.println(Thread.currentThread().getName() + "...bb");
			}
		}).start();
		
		Thread.currentThread().setName("我是主线程");
		System.out.println(Thread.currentThread().getName());
	}

}
