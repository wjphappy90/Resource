package com.itheima.proxy;

/**
 * 经纪公司对签约艺人的标准
 * @author zhy
 *
 */
public interface IActor {

	/**
	 * 基本的演出
	 * @param money
	 */
	public void basicAct(float money);
	
	/**
	 * 危险的表演
	 * @param money
	 */
	public void dangerAct(float money);
}
