package com.heima.regex;

public class Demo1_Regex {

	/**
	 * * A:正则表达式
			* 是指一个用来描述或者匹配一系列符合某个语法规则的字符串的单个字符串。其实就是一种规则。有自己特殊的应用。
			* 作用:比如注册邮箱,邮箱有用户名和密码,一般会对其限制长度,这个限制长度的事情就是正则表达式做的
		* B:案例演示
			* 需求：校验qq号码.
				* 1:要求必须是5-15位数字
				* 2:0不能开头
				* 3:必须都是数字
				
			* a:非正则表达式实现
			* b:正则表达式实现
	 */
	public static void main(String[] args) {
		System.out.println(checkQQ("012345"));
		System.out.println(checkQQ("a1b345"));
		System.out.println(checkQQ("123456"));
		System.out.println(checkQQ("1234567890987654321"));
		
		String regex = "[1-9]\\d{4,14}";
		System.out.println("2553868".matches(regex));
		System.out.println("012345".matches(regex));
		System.out.println("2553868abc".matches(regex));
	}
	
	/*
	 * 需求：校验qq号码.
	 * 1:要求必须是5-15位数字
	 * 2:0不能开头
	 * 3:必须都是数字
	 * 校验qq
	 * 1,明确返回值类型boolean
	 * 2,明确参数列表String qq
	 */
	public static boolean checkQQ(String qq) {
		boolean flag = true;					//如果校验qq不符合要求就把flag置为false,如果符合要求直接返回
		
		if(qq.length() >= 5 && qq.length() <= 15) {
			if(!qq.startsWith("0")) {
				char[] arr = qq.toCharArray();	//将字符串转换成字符数组
				for (int i = 0; i < arr.length; i++) {
					char ch = arr[i];			//记录每一个字符
					if(!(ch >= '0' && ch <= '9')) {
						flag = false;			//不是数字
						break;
					}
				}
			}else {
				flag = false;					//以0开头,不符合qq标准
			}
		}else {
			flag = false;						//长度不符合
		}
		return flag;
	}
}
