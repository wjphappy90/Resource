package com.heima.test;

import java.util.Scanner;

public class Test6 {

	/**
	 * * A:案例演示
		* 需求：把字符串反转
			* 举例：键盘录入"abc"		
			* 输出结果："cba"
		*分析:
		*1,通过键盘录入获取字符串Scanner
		*2,将字符串转换成字符数组
		*3,倒着遍历字符数组,并再次拼接成字符串
		*4,打印 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				//创建键盘录入对象
		System.out.println("请输入一个字符串:");
		String line = sc.nextLine();						//将键盘录入的字符串存储在line中
		
		char[] arr = line.toCharArray();					//将字符串转换为字符数组
		
		String s = "";
		for(int i = arr.length-1; i >= 0; i--) {			//倒着遍历字符数组
			s = s + arr[i];									//拼接成字符串
		}
		
		System.out.println(s);
	}

}
