package cn.itcast.day05.demo03;

/*
 * 现有的问题描述：
 * 对于类似的多个方法，全都是执行相加的操作，但是因为参数列表不一样，所以需要记住多个名字。太麻烦！
 * 
 * 解决方案：
 * 使用方法重载（Overload）的技术，可以达到效果：
 * 对于类似功能的多个方法，只要记住一个相同的方法名即可。可以根据参数列表的不同自动适配。
 * 
 * 方法重载（Overload）：方法的名称相同，但是参数列表不同。
 * 
 * 什么叫做参数列表不同？
 * 1. 参数的个数不同。
 * 2. 参数的类型不同。
 * 3. 参数的多类型顺序不同。
 * 
 * 重载与下列因素无关：
 * 1. 与返回值类型无关
 * 2. 与参数的名称无关
 */
public class Demo01MethodOverload {
	
	public static void main(String[] args) {
//		System.out.println(sumTwo(10, 20)); // 30
//		System.out.println(sumThree(10, 20, 30)); // 60
//		System.out.println(sumFour(10, 20, 30, 40)); // 100
		
		System.out.println(sum(10, 20)); // 两个参数的运行
		System.out.println(sum(10, 20, 30)); // 三个参数的运行
		System.out.println(sum(10, 20, 30, 40)); // 四个参数的运行
		
//		System.out.println(sum(10, 20, 30, 40, 50)); // 谁都对不上，没有任何一种重载形式使用，所以报错！
		
		System.out.println("==============");
		
		System.out.println(sum(10, 20)); // 两个int
		System.out.println(sum(10.0, 20.0)); // 两个double
		System.out.println("==============");
		
		System.out.println(sum(10, 2.5)); // 先int后double
		System.out.println(sum(2.5, 10)); // 先double后int
	}
	
	public static int sum(int a, int b) {
		System.out.println("有2个int参数的方法执行！");
		return a + b;
	}
	
	// 错误写法！无法根据参数的名称进行重载。
//	public static int sum(int x, int y) {
//		System.out.println("有2个int参数的方法执行！");
//		return x + y;
//	}
	
	// 错误写法！无法根据返回值类型的不同进行重载。
//	public static double sum(int a, int b) {
//		System.out.println("有2个int参数的方法执行！");
//		return a + b + 0.0; // int + int + double --> double
//	}
	
	public static double sum(int a, double b) {
		// 表达式当中需要运算的数据类型不一样，怎么办？
		// 谁的数据范围大，结果就是谁
		System.out.println("先int后double的方法执行！");
		return a + b; // int + double --> double
	}
	
	public static double sum(double a, int b) {
		System.out.println("先double后int的方法执行！");
		return a + b; // double
	}
	
	public static double sum(double a, double b) {
		System.out.println("有2个double参数的方法执行！");
		return a + b;
	}
	
	public static int sum(int a, int b, int c) {
		System.out.println("有3个int参数的方法执行！");
		return a + b + c;
	}
	
	public static int sum(int a, int b, int c, int d) {
		System.out.println("有4个int参数的方法执行！");
		return a + b + c + d;
	}

}
