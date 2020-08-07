package cn.itcast.day05.demo01;

/*
 * 关于名称的两个问题：
 * 1. 变量的名称能不能和方法的名称一样？可以。
 * 2. 如果有两个方法，每一个方法当中都有一个同名的变量，是否可以？可以，虽然名称一样，但是是两个变量。
 */
public class Demo05Names {
	
	public static void main(String[] args) {
		int result = 100; // main方法当中的变量
		System.out.println("main当中的result：" + result); // 100
		
		int sum = sum(10, 20);
		System.out.println(sum); // 30
	}
	
	public static int sum(int a, int b) {
		int result = a + b;
		System.out.println("sum当中的result：" + result); // 30
		return result;
	}

}
