package com.heima.otherclass;

import java.util.Date;

public class Demo6_Date {

	/**
	 * * A:Date类的概述是util包下的,不能导入sql包的
			* 类 Date 表示特定的瞬间，精确到毫秒。 
		* B:构造方法
			* public Date()
			* public Date(long date)
		* C:成员方法
			* public long getTime()
			* public void setTime(long time)
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		Date d1 = new Date();	
		d1.setTime(1000);								//设置毫秒值,改变时间对象
		System.out.println(d1);
	}

	public static void demo2() {
		Date d1 = new Date();	
		System.out.println(d1.getTime());				//通过时间对象获取毫秒值
		System.out.println(System.currentTimeMillis());	//通过系统类的方法获取当前时间毫秒值
	}

	public static void demo1() {
		Date d1 = new Date();					//如果没有传参数代表的是当前时间
		System.out.println(d1);
		
		Date d2 = new Date(0);					//如果构造方法中参数传为0代表的是1970年1月1日
		System.out.println(d2);					//通过毫秒值创建时间对象
	}

}
