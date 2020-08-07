package com.heima.scanner;

import java.util.Scanner;

public class Demo2_Scanner {

	/**
	 	* A:两个常用的方法：
			* public int nextInt():获取一个int类型的值
			* public String nextLine():获取一个String类型的值
		* B:案例演示
			* a:先演示获取多个int值，多个String值的情况
			* b:再演示先获取int值，然后获取String值出现问题
			* c:问题解决方案
				* 第一种：先获取一个数值后，在创建一个新的键盘录入对象获取字符串。
				* 第二种：把所有的数据都先按照字符串获取，然后要什么，你就对应的转换为什么。(后面讲)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*System.out.println("请输入第一个整数:");
		int i = sc.nextInt();
		System.out.println("请输入第二个整数:");
		int j = sc.nextInt();
		System.out.println("i = " + i + ", j = " + j);*/
		
		/*System.out.println("请输入第一个字符串:");
		String line1 = sc.nextLine();
		System.out.println("请输入第二个字符串:");
		String line2 = sc.nextLine();
		System.out.println("line1 = " + line1 + ", line2 = " + line2 );*/
		
		/*
		 * nextInt()是键盘录入整数的方法,当我们录入10的时候
		 * 其实在键盘上录入的是10和\r\n,nextInt()方法只获取10就结束了
		 * nextLine()是键盘录入字符串的方法,可以接收任意类型,但是他凭什么能获取一行呢?
		 * 通过\r\n,只要遇到\r\n就证明一行结束
		 */
		/*System.out.println("请输入第一个整数:");
		int i = sc.nextInt();
		System.out.println("请输入第二个字符串:");
		String line2 = sc.nextLine();
		//System.out.println("i = " + i + ", line2 = " + line2);
		System.out.println(i);
		System.out.print("11111111111");
		System.out.print(line2);
		System.out.println("2222222222222");*/
		
		/*
		 * 解决方案
		 * 1,创建两次对象,但是浪费空间
		 * 2,键盘录入的都是字符串,都用nextLine方法,后面我们会学习讲整数字符串转换成整数的方法
		 */
		int i = sc.nextInt();
		Scanner sc2 = new Scanner(System.in);
		String line = sc2.nextLine();
		System.out.println(i);
		System.out.println(line);
	}

}
