package com.heima.regex;

public class Demo5_Split {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "金三胖.郭美美.李dayone";
		String[] arr = s.split("\\.");				//通过正则表达式切割字符串
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("11111111111111111");
	}

}
