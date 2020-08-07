package com.heima.otherclass;

import java.util.Calendar;

public class Demo8_Calendar {

	/**
	 * * A:Calendar类的概述
			* Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
		* B:成员方法
			* public static Calendar getInstance()
			* public int get(int field)
	 */
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();		//父类引用指向子类对象
		//System.out.println(c);					//证明重写了toString方法打印了对象中所有的属性
		System.out.println(c.get(Calendar.YEAR));  	//通过字段获取对应的值
		System.out.println(c.get(Calendar.MONTH));
	}

}
