package com.heima.thread;

public class Demo1_Thread {

	/**
	 * @param args
	 * 证明jvm是多线程的
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 100000; i++) {
			new Demo();
		}
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("我是主线程的执行代码");
		}
	}

}

class Demo {

	@Override
	public void finalize() {
		System.out.println("垃圾被清扫了");
	}
	
}