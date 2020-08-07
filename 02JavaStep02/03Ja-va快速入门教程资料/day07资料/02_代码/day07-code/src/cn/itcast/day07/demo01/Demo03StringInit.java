package cn.itcast.day07.demo01;

/*
 * 字符串创建的常见2+1种方式（两种构造方法，一种直接赋值）。
 * 
 * 常用的两个构造方法：
 * public String(char[] array)：参数是一个字符数组，根据字符数组的内容来创建一个字符串。
 * public String(char[] array, int offset, int count)：根据字符数组的一部分内容来创建字符串。
 * 参数offset代表一个数组当中的起始索引，从0开始。
 * 参数count代表取用多少个字符。
 * 
 * 直接赋值双引号也是一个字符串对象：
 * String str = "Hello";
 */
public class Demo03StringInit {
	
	public static void main(String[] args) {
		char[] array = { 'H', 'e', 'l', 'l', 'o' };
		
		// 根据字符数组来创建字符串
		// 类名称 对象名 = new 类名称(构造参数);
		String str1 = new String(array);
		System.out.println(str1); // Hello
		
		// 根据字符数组的一部分来创建字符串
		String str2 = new String(array, 2, 3);
		System.out.println(str2); // llo
		
		// 如果指定的索引或者个数超出了合理范围，那么将会发生索引越界异常，错误写法：
//		String str3 = new String(array, 100, 200);
		
		// 直接赋值
		String str4 = "Hello, World!";
		System.out.println(str4); // Hello, World!
	}

}
