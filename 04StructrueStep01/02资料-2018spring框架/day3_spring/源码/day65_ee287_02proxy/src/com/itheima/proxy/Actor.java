package com.itheima.proxy;

/**
 * 一个演员
 * @author zhy
 *
 */
public class Actor implements IActor{

	/**
	 * 基本的演出
	 * @param money
	 */
	public void basicAct(float money){
		System.out.println("拿到钱，开始基本的表演："+money);
	}
	
	/**
	 * 危险的表演
	 * @param money
	 */
	public void dangerAct(float money){
		System.out.println("拿到钱，开始危险的表演："+money);
	}
}
