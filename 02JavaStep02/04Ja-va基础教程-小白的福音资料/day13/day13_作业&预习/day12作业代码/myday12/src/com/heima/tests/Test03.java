package com.heima.tests;

import java.util.Scanner;
/**
 * 5.分析以下需求，并用代码实现：
 *	(1)从键盘录入一个字符串
 *	(2)统计该串中有大写字母、小写字母、数字各有多少个。
 *		举例:
 *			Hello12345World
 *			大写 : 2个
 *			小写 : 8个
 *			数字 : 5个
 * @author JX
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//1.创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入字符串(可以包含数字、字母及其它符号):");
		//2.用户输入字符串"ABCDEabcd123456!@#$%^"
		String s = sc.nextLine();
		int big = 0;
		int small = 0;
		int num = 0;
		int other = 0;
		//1,获取每一个字符,通过for循环遍历
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);						//通过索引获取每一个字符
			//2,判断字符是否在这个范围内
			if(c >= 'A' && c <= 'Z') {
				big++;									//如果满足是大写字母,就让其对应的变量自增
			}else if(c >= 'a' && c <= 'z') {
				small++;
			}else if(c >= '0' && c <= '9') {
				num++;
			}else {
				other++;
			}
		}
		
		//3,打印每一个计数器的结果
		System.out.println(s + "中大写字母有:" + big + "个,小写字母有:" + small + "个,数字字符:" 
		+ num + "个,其他字符:" + other + "个");
	}
}
