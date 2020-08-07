package com.heima.thread;

public class Demo3_Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();	//4,创建Runnable的子类对象
		//Runnable target = mr;	mr = 0x0011
		Thread t = new Thread(mr);			//5,将其当作参数传递给Thread的构造函数
		t.start();							//6,开启线程
		
		for(int i = 0; i < 1000; i++) {
			System.out.println("bb");
		}
	}

}

class MyRunnable implements Runnable {		//1,定义一个类实现Runnable

	@Override
	public void run() {						//2,重写run方法
		for(int i = 0; i < 1000; i++) {		//3,将要执行的代码写在run方法中
			System.out.println("aaaaaaaaaaaa");
		}
	}
	
}