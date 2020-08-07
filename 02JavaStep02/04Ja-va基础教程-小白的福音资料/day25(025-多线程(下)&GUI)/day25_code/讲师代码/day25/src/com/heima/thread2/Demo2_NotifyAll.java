package com.heima.thread2;

public class Demo2_NotifyAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Printer2 p = new Printer2();
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print1();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print2();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						p.print3();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
/*1,在同步代码块中,用哪个对象锁,就用哪个对象调用wait方法
 * 2,为什么wait方法和notify方法定义在Object这个类中?
 * 	锁对象可以是任意对象,那么任意对象对应的类都是Object类的子类,
 *  也就是Object是所有的类的基类,所以将将方法定义在Object这个类中就会让任意对象对其调用所以wait方法和notify方法需要定义在Object这个类中
 * 3,sleep方法和wait方法的区别?
 * a,sleep在同步代码块或者同步函数中,不释放锁
 *		wait在同步代码块或者同步函数中,释放锁
 * 
 * b,sleep方法必须传入参数,参数其实就是时间,时间到了自动醒来
 * 	wait方法可以传入参数,也可以不传入参数
 *		如果给wait方法传入时间参数,用法与sleep相似,时间到就停止等待(通常用的都是没有参数的wait方法)
 */ 
class Printer2 {
	private int flag = 1;
	public void print1() throws InterruptedException {							
		synchronized(this) {
			while(flag != 1) {
				this.wait();					//当前线程等待
			}
			System.out.print("黑");
			System.out.print("马");
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
			flag = 2;
			//this.notify();						//随机唤醒单个等待的线程
			this.notifyAll();
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this) {
			while(flag != 2) {
				this.wait();					//线程2在此等待
			}
			System.out.print("传");
			System.out.print("智");
			System.out.print("播");
			System.out.print("客");
			System.out.print("\r\n");
			flag = 3;
			//this.notify();
			this.notifyAll();
		}
	}
	
	public void print3() throws InterruptedException {
		synchronized(this) {
			while(flag != 3) {
				this.wait();						//线程3在此等待,if语句是在哪里等待,就在哪里起来
													//while循环是循环判断,每次都会判断标记
			}
			System.out.print("i");
			System.out.print("t");
			System.out.print("h");
			System.out.print("e");
			System.out.print("i");
			System.out.print("m");
			System.out.print("a");
			System.out.print("\r\n");
			flag = 1;
			//this.notify();
			this.notifyAll();
		}
	}
}

