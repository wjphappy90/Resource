package cn.itcast.day06.demo01;

import java.util.Arrays;

/*
 * 面向过程：
 * 当需要实现一个功能的时候，所有的步骤都要亲力亲为，处理每一个代码细节。
 * 
 * 面向对象：
 */
public class Demo01PrintArray {
	
	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50 };
		
		// 首先使用面向过程的思想，每一个步骤细节都要亲自处理
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + "]");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		
		System.out.println("==================");
		
		// 使用面向对象的思想，达到同样的效果。
		// 自己不处理详细的步骤，而是找人帮我做事儿。
		// 在JDK当中已经给我们提供好了一个工具，叫做Arrays
		// 通过这个工具就可以将数组转换成为指定格式的字符串
		
		// 我自己不做，而是找Arrays帮我把数组转换成为指定格式的字符串
		System.out.println(Arrays.toString(array));
	}

}
