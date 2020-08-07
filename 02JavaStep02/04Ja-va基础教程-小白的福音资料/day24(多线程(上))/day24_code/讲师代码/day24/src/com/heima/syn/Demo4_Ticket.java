package com.heima.syn;

public class Demo4_Ticket {

	/**
	 * @param args
	 * 火车站卖票的例子用实现Runnable接口
	 */
	public static void main(String[] args) {
		MyTicket mt = new MyTicket();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		new Thread(mt).start();
		
		/*Thread t1 = new Thread(mt);				//多次启动一个线程是非法的
		t1.start();
		t1.start();
		t1.start();
		t1.start();*/
	}

}

class MyTicket implements Runnable {
	private int tickets = 100;
	@Override
	public void run() {
		while(true) {
			synchronized(this) {
				if(tickets <= 0) {
					break;
				}
				try {
					Thread.sleep(10);				//线程1睡,线程2睡,线程3睡,线程4睡
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...这是第" + tickets-- + "号票");
			}
		}
	}
}