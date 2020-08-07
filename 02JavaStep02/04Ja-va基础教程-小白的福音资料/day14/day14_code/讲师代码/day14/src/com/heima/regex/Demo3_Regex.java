package com.heima.regex;

public class Demo3_Regex {

	/**
	 * 	. 任何字符
		\d 数字：[0-9] 
		\D 非数字： [^0-9] 
		\s 空白字符：[ \t\n\x0B\f\r] 
		\S 非空白字符：[^\s] 
		\w 单词字符：[a-zA-Z_0-9] 
		\W 非单词字符：[^\w] 

	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//demo5();
		//demo6();
		String regex = "\\W";
		System.out.println("a".matches(regex));
		System.out.println("z".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo6() {
		String regex = "\\w";
		System.out.println("a".matches(regex));
		System.out.println("z".matches(regex));
		System.out.println("_".matches(regex));
		System.out.println("%".matches(regex));
	}

	private static void demo5() {
		String regex = "\\S";
		System.out.println(" ".matches(regex));
		System.out.println("	".matches(regex));
		System.out.println("a".matches(regex));
	}

	private static void demo4() {
		String regex = "\\s";
		System.out.println(" ".matches(regex));
		System.out.println("	".matches(regex)); 				//一个tab键
		System.out.println("    ".matches(regex)); 				//四个空格
	}

	private static void demo3() {
		String regex = "\\D";
		System.out.println("0".matches(regex));
		System.out.println("9".matches(regex));
		System.out.println("a".matches(regex));
	}

	private static void demo2() {
		String regex = "\\d";					//\代表转义字符,如果想表示\d的话,需要\\d
		System.out.println("0".matches(regex));
		System.out.println("a".matches(regex));
		System.out.println("9".matches(regex));
	}

	private static void demo1() {
		String regex = "..";
		System.out.println("a".matches(regex));
		System.out.println("ab".matches(regex));
	}

}
