package com.heima.test;

public class Test2 {

	/**
	 * * A:案例演示
	 * 需求：遍历字符串
	 */
	public static void main(String[] args) {
		String s = "heima";
		
		for(int i = 0; i < s.length(); i++) {			//通过for循环获取到字符串中每个字符的索引
			/*char c = s.charAt(i);
			System.out.println(c);*/
			System.out.println(s.charAt(i));			//通过索引获取每一个字符	
		}
	}

}
