package com.heima.otherclass;

public class Demo1_Math {

	/**
	 * @param args
	 * * A:Math类概述
		* Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。 
	* B:成员方法
		* public static int abs(int a)
		* public static double ceil(double a)
		* public static double floor(double a)
		* public static int max(int a,int b) min自学
		* public static double pow(double a,double b)
		* public static double random()
		* public static int round(float a) 参数为double的自学
		* public static double sqrt(double a)
	 */
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.abs(-10));  			//取绝对值
		
		//ceil天花板
		/*
		 * 13.0
		 * 12.3
		 * 12.0
		 */
		System.out.println(Math.ceil(12.3));			//向上取整,但是结果是一个double
		System.out.println(Math.ceil(12.99));
		
		System.out.println("-----------");
		//floor地板
		/*
		 * 13.0
		 * 12.3
		 * 12.0
		 */
		System.out.println(Math.floor(12.3));			//向下取整,但是结果是一个double
		System.out.println(Math.floor(12.99));
		
		//获取两个值中的最大值
		System.out.println(Math.max(20, 30));
		
		//前面的数是底数,后面的数是指数
		System.out.println(Math.pow(2, 3));				//2.0 ^ 3.0
		
		//生成0.0到1.0之间的所以小数,包括0.0,不包括1.0
		System.out.println(Math.random());
		
		//四舍五入
		System.out.println(Math.round(12.3f));
		System.out.println(Math.round(12.9f));
		
		//开平方
		System.out.println(Math.sqrt(4));
		System.out.println(Math.sqrt(2));
		System.out.println(Math.sqrt(3));
	}

}
