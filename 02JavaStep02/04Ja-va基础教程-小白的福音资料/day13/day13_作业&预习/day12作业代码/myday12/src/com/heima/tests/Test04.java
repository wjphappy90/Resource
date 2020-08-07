package com.heima.tests;
/**
 * A:案例演示	
 * 	统计大串中小串出现的次数
 * @author JX
 *
 */
public class Test04 {

	public static void main(String[] args) {
		//定义大串
		String max = "woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma";
		//定义小串
		String min = "heima";
		
		//定义计数器变量
		int count = 0;
		//定义索引
		int index = 0;
		//定义循环,判断小串是否在大串中出现
		while(max.indexOf(min,index)!= -1) {
			count++;									//计数器自增
			index = max.indexOf(min,index)+min.length();
		}
		
		System.out.println(count);
	}
}

