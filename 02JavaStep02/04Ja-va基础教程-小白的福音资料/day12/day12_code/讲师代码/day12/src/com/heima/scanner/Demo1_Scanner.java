package com.heima.scanner;

import java.util.Scanner;

public class Demo1_Scanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				//键盘录入
		//int i = sc.nextInt();								//键盘录入整数存储在i中
		//System.out.println(i);
		if(sc.hasNextInt()) {								//判断键盘录入的是否是int类型的数据
			int i = sc.nextInt();							//键盘录入的数据存储在i中
			System.out.println(i);
		}else {
			System.out.println("输入的类型错误");
		}
		
	}

}
