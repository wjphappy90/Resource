package cn.itcast.day07.demo02;

import java.util.Scanner;

/*
 * 使用String当中的equals和equalsIgnoreCase两个方法，来模拟一个简单的登录场景。
 * 
 * 分析：
 * 1. 登录需要用户名和密码两个信息，也就是两个字符串。
 * 2. 用户名和密码应该使用键盘输入，获取两个字符串。（使用Scanner需要三个步骤。）
 * 3. 怎样才算是登录成功呢？肯定需要注册时候提前写好正确的用户名、正确的密码。
 * 4. 判断输入的用户名和密码，与正确的用户名、密码必须完全一样：
 * 		A. 用户名必须正确
 * 		B. 密码必须正确
 * 		上述两个条件是“并且”的关系，缺一不可，逻辑运算符：&&
 * 5. 判断一下是否登录成功：if
 * 6. 如果登录成功，显示欢迎信息。如果登录失败，退出系统。
 */
public class Demo02Login {
	
	public static void main(String[] args) {
		// 首先需要注册的时候，指定一个正确的用户名，和正确的密码
		String registUsername = "admin"; // 注册时候正确的用户名
		String registPassword = "123456abc"; // 注册时候正确的密码
		
		// 需要键盘输入两个字符串
		Scanner sc = new Scanner(System.in); // 创建
		System.out.println("请输入用户名：");
		String inputUsername = sc.next(); // 获取键盘输入的用户名字符串
		System.out.println("请输入密码：");
		String inputPassword = sc.next(); // 获取键盘栓书的密码字符串
		
		// 判断一下，两个条件：
		// A. 输入的用户名和注册时候的正确用户名必须一样
		// （用户名一般不区分大小写，内容判断应该使用equalsIgnoreCase）
		// B. 输入的密码和注册时候的正确密码也要一样
		// （密码一定是严格区分大小写，所以内容判断应该使用equals）
		// A和B两个条件都要同时满足才行：&&
		// 既然要判断，肯定使用选择结构：if
		if (inputUsername.equalsIgnoreCase(registUsername) && inputPassword.equals(registPassword)) {
			System.out.println("欢迎使用！");
		} else {
			System.out.println("登录失败！退出！");
		}
	}

}
