package com.heima.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 * 3.分析以下需求，并用代码实现：
 *	(1)通过键盘录入日期字符串，格式(2015-10-20)
 *	(2)输出该日期是星期几及这一年的第几天
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) throws Exception {
		//1.创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字日期字符串(格式:2015-10-20):");
		//2.获取键盘录入的字符串日期
		String dateStr = sc.nextLine();
		//3.定义格式化和解析日期的对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年-MM月-dd日");
		//4.将输入的字符串日期转换成日期对象
		Date date = sdf.parse(dateStr);
		//5.将日期对象转换成Calendar对象
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		//6.获取该日期对象是一周的第几天
		int week = c.get(Calendar.DAY_OF_WEEK);
		//7.获取该日期对象是一年中的第几天
		int day = c.get(Calendar.DAY_OF_YEAR);
		//8.格式化date对象用于打印
		String dateStr2 = sdf2.format(date);
		System.out.println(dateStr2+" 是 "+getWeek(week)+"，是  "+c.get(Calendar.YEAR)+"年的第 "+day+" 天");
	}
	
	/*
	 * 将星期存储表中进行查表
	 * 1,返回值类型String
	 * 2,参数列表int week
	 */	
	public static String getWeek(int week) {
		String[] arr = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		
		return arr[week];
	}
}
