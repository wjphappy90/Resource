package com.heima.wrapclass;

public class Demo2_Integer {

	/**
	 * * A:Integer类概述
			* 通过JDK提供的API，查看Integer类的说明
		
			* Integer 类在对象中包装了一个基本类型 int 的值,
			* 该类提供了多个方法，能在 int 类型和 String 类型之间互相转换，
			* 还提供了处理 int 类型时非常有用的其他一些常量和方法
		* B:构造方法
			* public Integer(int value)
			* public Integer(String s)
		* C:案例演示
			* 使用构造方法创建对象
	 */
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		Integer i1 = new Integer(100);
		System.out.println(i1);
		
		//Integer i2 = new Integer("abc");			//java.lang.NumberFormatException数字格式异常
		//System.out.println(i2);						//因为abc不是数字字符串,所以转换会报错
		
		Integer i3 = new Integer("100");
		System.out.println(i3);
	}

}
