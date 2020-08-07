package com.heima.otherclass;

import java.util.Calendar;

public class Demo9_Calendar {

	/**
	 * * A:Calendar类的概述
			* Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
		* B:成员方法
			* public static Calendar getInstance()
			* public int get(int field)
		* C:成员方法
			* public void add(int field,int amount)
			* public final void set(int year,int month,int date)
		* D:案例演示
			* Calendar类的成员方法使用
	 */
	public static void main(String[] args) {
		//demo1();
		Calendar c = Calendar.getInstance();			//父类引用指向子类对象
		//c.add(Calendar.MONTH, -1);					//对指定的字段进行向前减或向后加
		//c.set(Calendar.YEAR, 2000);					//修改指定字段
		c.set(2000, 7, 8);
		
		System.out.println(c.get(Calendar.YEAR) + "年" + getNum((c.get(Calendar.MONTH)+1)) 
				+ "月" + getNum(c.get(Calendar.DAY_OF_MONTH)) + "日" + getWeek(c.get(Calendar.DAY_OF_WEEK)));
	}

	public static void demo1() {
		Calendar c = Calendar.getInstance();			//父类引用指向子类对象
		//System.out.println(c);
		System.out.println(c.get(Calendar.YEAR));		//通过字段获取年
		System.out.println(c.get(Calendar.MONTH));		//通过字段后期月,但是月是从0开始编号的
		System.out.println(c.get(Calendar.DAY_OF_MONTH));//月中的第几天
		System.out.println(c.get(Calendar.DAY_OF_WEEK));//周日是第一天,周六是最后一天
		
		System.out.println(c.get(Calendar.YEAR) + "年" + getNum((c.get(Calendar.MONTH)+1)) 
				+ "月" + getNum(c.get(Calendar.DAY_OF_MONTH)) + "日" + getWeek(c.get(Calendar.DAY_OF_WEEK)));
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
	
	/*
	 * 如果是个数数字前面补0
	 * 1,返回值类型String类型
	 * 2,参数列表,int num
	 */
	public static String getNum(int num) {
		/*if(num > 9) {
			return "" + num;
		}else {
			return "0" + num;
		}*/
		return num > 9 ? "" + num : "0" + num;
	}
}
