package com.heima.syn;

public class Demo3_Ticket {

	/**
	 * 需求:铁路售票,一共100张,通过四个窗口卖完.
	 */
	public static void main(String[] args) {
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
	}

}

class Ticket extends Thread {
	private static int ticket = 100;
	//private static Object obj = new Object();		//如果用引用数据类型成员变量当作锁对象,必须是静态的
	public void run() {
		while(true) {
			synchronized(Ticket.class) {
				if(ticket <= 0) {
					break;
				}
				try {
					Thread.sleep(10);				//线程1睡,线程2睡,线程3睡,线程4睡
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println(getName() + "...这是第" + ticket-- + "号票");
			}
		}
	}
}
