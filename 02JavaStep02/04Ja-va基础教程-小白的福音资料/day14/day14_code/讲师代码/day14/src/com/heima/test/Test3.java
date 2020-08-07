package com.heima.test;

import java.util.Calendar;
import java.util.Scanner;

public class Test3 {

	/**
	 * * A:案例演示
	 * 需求：键盘录入任意一个年份，判断该年是闰年还是平年
	 * Calendar c = Calendar.getInstance();
	 * 
	 * 分析:
	 * 1,键盘录入年Scanner
	 * 2,创建Calendar c = Calendar.getInstance();
	 * 3,通过set方法设置为那一年的3月1日
	 * 4,将日向前减去1
	 * 5,判断日是多少天,如果是29天返回true否则返回false
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入年份,判断该年份是闰年还是平年:");
		//int year = sc.nextInt();
		
		String line = sc.nextLine();				//录入数字字符串
		int year = Integer.parseInt(line);			//将数字字符串转换成数字
		boolean b = getYear(year);
		System.out.println(b);
	}

	private static boolean getYear(int year) {
		//2,创建Calendar c = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
		//设置为那一年的3月1日
		c.set(year, 2, 1);
		//将日向前减去1
		c.add(Calendar.DAY_OF_MONTH, -1);
		//判断是否是29天
		return c.get(Calendar.DAY_OF_MONTH) == 29;
	}

}
