package com.heima.test;

import java.util.Scanner;

public class Test2 {

	/**
	 * * A:案例演示
	* 
			需求：把字符串反转
				举例：键盘录入"abc"		
				输出结果："cba"
				
			用StringBuffer的功能实现	
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				//创建键盘录入对象
		String line = sc.nextLine();						//将键盘录入的字符串存储在line中
		
		/*StringBuffer sb = new StringBuffer(line);			//将字符串转换为StringBuffer对象
		sb.reverse();										//将缓冲区的内容反转
		
		System.out.println(sb.toString());*/
		
		System.out.println(revString(line));
	}

	/*
	 * 将字符串反转
	 * 1,返回值类型String
	 * 2,参数列表String line
	 */
	
	public static String revString(String line) {
		StringBuffer sb = new StringBuffer(line);			//将字符串转换为StringBuffer对象
		sb.reverse();										//将缓冲区的内容反转
		
		return sb.toString();
	}
}
