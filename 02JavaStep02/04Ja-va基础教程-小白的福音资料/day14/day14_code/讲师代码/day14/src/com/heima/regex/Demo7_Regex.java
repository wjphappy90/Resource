package com.heima.regex;

public class Demo7_Regex {

	/**
	 * * A:正则表达式的分组功能
			* 捕获组可以通过从左到右计算其开括号来编号。例如，在表达式 ((A)(B(C))) 中，存在四个这样的组： 
		* 
				1     ((A)(B(C))) 
				2     (A 
				3     (B(C)) 
				4     (C) 
			
				组零始终代表整个表达式。
		B:案例演示
			a:切割
				需求：请按照叠词切割： "sdqqfgkkkhjppppkl";
			b:替换
				需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
				将字符串还原成:“我要学编程”。
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		
		/*
		 * 需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
				将字符串还原成:“我要学编程”。
		 */
		String s = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
		String s2 = s.replaceAll("\\.+", "");
		String s3 = s2.replaceAll("(.)\\1+", "$1");	//$1代表第一组中的内容
		System.out.println(s3);
	}

	public static void demo2() {
		//需求：请按照叠词切割： "sdqqfgkkkhjppppkl";
		String s = "sdqqfgkkkhjppppkl";
		String regex = "(.)\\1+";					//+代表第一组出现一次到多次
		String[] arr = s.split(regex);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void demo1() {
		//叠词 快快乐乐,高高兴兴
		/*String regex = "(.)\\1(.)\\2";					//\\1代表第一组又出现一次	\\2代表第二组又出现一次
		System.out.println("快快乐乐".matches(regex));
		System.out.println("快乐乐乐".matches(regex));
		System.out.println("高高兴兴".matches(regex));
		System.out.println("死啦死啦".matches(regex));*/
		
		//叠词 死啦死啦,高兴高兴
		String regex2 = "(..)\\1";
		System.out.println("死啦死啦".matches(regex2));
		System.out.println("高兴高兴".matches(regex2));
		System.out.println("快快乐乐".matches(regex2));
	}

}
