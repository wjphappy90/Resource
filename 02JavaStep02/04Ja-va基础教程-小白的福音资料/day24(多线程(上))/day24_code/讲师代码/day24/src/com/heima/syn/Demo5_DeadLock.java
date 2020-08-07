package com.heima.syn;

public class Demo5_DeadLock {

	/**
	 * @param args
	 */
	private static String s1 = "筷子左";
	private static String s2 = "筷子右";

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				while(true) {
					synchronized(s1) {
						System.out.println(getName() + "...获取" + s1 + "等待" + s2);
						synchronized(s2) {
							System.out.println(getName() + "...拿到" + s2 + "开吃");
						}
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					synchronized(s2) {
						System.out.println(getName() + "...获取" + s2 + "等待" + s1);
						synchronized(s1) {
							System.out.println(getName() + "...拿到" + s1 + "开吃");
						}
					}
				}
			}
		}.start();
	}
}
