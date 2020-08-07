package com.heima.test;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test6 {

	/**
	 * 程序启动后, 可以从键盘输入接收多个整数, 直到输入quit时结束输入. 把所有输入的整数倒序排列打印.
	 * 
	 * 1,创建Scanner对象,键盘录入
	 * 2,创建TreeSet集合对象,TreeSet集合中传入比较器
	 * 3,无限循环不断接收整数,遇到quit退出,因为退出是quit,所以键盘录入的时候应该都以字符串的形式录入
	 * 4,判断是quit就退出,不是将其转换为Integer,并添加到集合中
	 * 5,遍历TreeSet集合并打印每一个元素
	 */
	public static void main(String[] args) {
		//1,创建Scanner对象,键盘录入
		Scanner sc = new Scanner(System.in);
		//2,创建TreeSet集合对象,TreeSet集合中传入比较器
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				//int num = i2 - i1;					//自动拆箱
				int num = i2.compareTo(i1);
				return num == 0 ? 1 : num;
			}
		});
		//3,无限循环不断接收整数,遇到quit退出,因为退出是quit,所以键盘录入的时候应该都以字符串的形式录入
		while(true) {
			String line = sc.nextLine();				//将键盘录入的字符串存储在line中
			if("quit".equals(line)) {
				break;
			}
			//4,判断是quit就退出,不是将其转换为Integer,并添加到集合中
			Integer i = Integer.parseInt(line);
			ts.add(i);
		}
		
		// 5,遍历TreeSet集合并打印每一个元素
		for (Integer integer : ts) {
			System.out.println(integer);
		}
	}

}
