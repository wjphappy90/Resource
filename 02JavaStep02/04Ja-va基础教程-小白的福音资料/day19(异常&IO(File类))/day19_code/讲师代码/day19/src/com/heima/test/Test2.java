package com.heima.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Test2 {

	/**
	 * 键盘录入一个int类型的整数,对其求二进制表现形式
	 * 如果录入的整数过大,给予提示,录入的整数过大请重新录入一个整数BigInteger
	 * 如果录入的是小数,给予提示,录入的是小数,请重新录入一个整数
	 * 如果录入的是其他字符,给予提示,录入的是非法字符,请重新录入一个整数
	 * 
	 * 分析:
	 * 1,创建键盘录入对象
	 * 2,将键盘录入的结果存储在String类型的字符串中,存储int类型中如果有不符合条件的直接报错,无法进行后续判断
	 * 3,键盘录入的结果转换成int类型的数据,是正确的还是错误的
	 * 4,正确的直接转换
	 * 5,错误的要进行对应判断
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数:");
		
		
		while(true) {
			String line = sc.nextLine();					//将键盘录入的结果存储在line中
			try {
				int num = Integer.parseInt(line);				//将字符串转换为整数
				System.out.println(Integer.toBinaryString(num));//将整数转换为二进制
				break;											//跳出循环
			}catch(Exception e) {
				try {
					new BigInteger(line);
					System.out.println("录入错误,您录入的是一个过大整数,请重新输入一个整数:");
				}catch (Exception e2) {							//alt + shif + z (try catch快捷键)
					try {
						new BigDecimal(line);
						System.out.println("录入错误,您录入的是一个小数,请重新输入一个整数:");
					} catch (Exception e1) {
						System.out.println("录入错误,您录入的是非法字符,请重新输入一个整数:");
					}
				}
				
			}
		}
		
		
	}

}
