package com.heima.threadmethod;

public class Demo7_Priority {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(getName() + "...aaaaaaaaa" );
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println(getName() + "...bb" );
				}
			}
		};
		
		//t1.setPriority(10);					设置最大优先级
		//t2.setPriority(1);
		
		t1.setPriority(Thread.MIN_PRIORITY);		//设置最小的线程优先级
		t2.setPriority(Thread.MAX_PRIORITY);		//设置最大的线程优先级
		
		t1.start();
		t2.start();
	}

}
