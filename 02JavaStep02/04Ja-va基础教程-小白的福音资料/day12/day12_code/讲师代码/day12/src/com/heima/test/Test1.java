package com.heima.test;

import java.util.Scanner;

public class Test1 {

	/**
	 * * A:案例演示
		* 需求：模拟登录,给三次机会,并提示还有几次。
		* 用户名和密码都是admin
		* 分析:
		* 1,模拟登录,需要键盘录入,Scanner
		* 2,给三次机会,需要循环,for
		* 3,并提示有几次,需要判断,if
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		//创建键盘录入对象
		
		for(int i = 0; i < 3; i++) {
			System.out.println("请输入用户名:");
			String userName = sc.nextLine();			//将键盘录入的用户名存储在userName中
			System.out.println("请输入密码:");
			String password = sc.nextLine();			//将键盘录入的密码存储在password中
			
			//如果是字符串常量和字符串变量比较,通常都是字符串常量调用方法,将变量当作参数传递,防止空指针异常
			if("admin".equals(userName) && "admin".equals(password)) {
				System.out.println("欢迎" + userName + "登录");
				break;									//跳出循环
			}else {
				if(i == 2) {
					System.out.println("您的错误次数已到,请明天再来吧");
				}else {
					System.out.println("录入错误,您还有" + (2-i) + "次机会");
				}
			}
		
		}
	}

}
