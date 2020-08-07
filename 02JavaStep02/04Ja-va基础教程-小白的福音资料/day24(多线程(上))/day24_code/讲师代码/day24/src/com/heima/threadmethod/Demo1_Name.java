package com.heima.threadmethod;

public class Demo1_Name {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//demo1();
		Thread t1 = new Thread() {
			public void run() {
				//this.setName("张三");
				System.out.println(this.getName() + "....aaaaaaaaaaaaa");
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				//this.setName("李四");
				System.out.println(this.getName() + "....bb");
			}
		};
		
		t1.setName("张三");
		t2.setName("李四");
		t1.start();
		t2.start();
	}

	public static void demo1() {
		new Thread("芙蓉姐姐") {							//通过构造方法给name赋值
			public void run() {
				System.out.println(this.getName() + "....aaaaaaaaa");
			}
		}.start();
		
		new Thread("凤姐") {
			public void run() {
				System.out.println(this.getName() + "....bb");
			}
		}.start();
	}

}
