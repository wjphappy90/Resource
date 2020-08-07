package com.heima.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo8_Pattern {

	/**
	 * Pattern p = Pattern.compile("a*b");
		 Matcher m = p.matcher("aaaaab");
		 boolean b = m.matches();
		 
		* A:正则表达式的获取功能
			* Pattern和Matcher的结合使用
		* B:案例演示
			* 需求：把一个字符串中的手机号码获取出来
	 */
	public static void main(String[] args) {
		//demo1();
		String s = "我的手机是18511866260,我曾用过18987654321,还用过18812345678";
		String regex = "1[3578]\\d{9}";
		
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		
		/*boolean b1 = m.find();
		System.out.println(b1);
		System.out.println(m.group());
		
		boolean b2 = m.find();
		System.out.println(b2);
		System.out.println(m.group());*/
		
		while(m.find())
			System.out.println(m.group());
	}

	public static void demo1() {
		Pattern p = Pattern.compile("a*b");					//获取到正则表达式
		Matcher m = p.matcher("aaaaab");					//获取匹配器
		boolean b = m.matches();							//看是否能匹配,匹配就返回true
		
		System.out.println(b);
		
		System.out.println("aaaaab".matches("a*b"));  		//与上面的结果一样
	}

}
