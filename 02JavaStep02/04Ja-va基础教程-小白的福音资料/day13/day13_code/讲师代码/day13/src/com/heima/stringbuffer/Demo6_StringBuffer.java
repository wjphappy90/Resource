package com.heima.stringbuffer;

public class Demo6_StringBuffer {

	/**
	 * * A:String -- StringBuffer
		* a:通过构造方法
		* b:通过append()方法
	* B:StringBuffer -- String
		* a:通过构造方法
		* b:通过toString()方法
		* c:通过subString(0,length);

	 */
	public static void main(String[] args) {
		//demo1();
		StringBuffer sb = new StringBuffer("heima");
		
		String s1 = new String(sb);						//通过构造将StringBuffer转换为String
		System.out.println(s1);
		
		String s2 = sb.toString();						//通过toString方法将StringBuffer转换为String
		System.out.println(s2);
		
		String s3 = sb.substring(0, sb.length());		//通过截取子字符串将StringBuffer转换为String
		System.out.println(s3);
	}

	private static void demo1() {
		StringBuffer sb1 = new StringBuffer("heima");			//通过构造方法将字符串转换为StringBuffer对象
		System.out.println(sb1);
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("heima");									//通过append方法将字符串转换为StringBuffer对象
		System.out.println(sb2);
	}

}
