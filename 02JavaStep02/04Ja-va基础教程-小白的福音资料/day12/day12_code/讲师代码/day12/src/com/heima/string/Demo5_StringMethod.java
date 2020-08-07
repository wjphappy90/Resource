package com.heima.string;

public class Demo5_StringMethod {

	/**
	 * * int length():获取字符串的长度。
	* char charAt(int index):获取指定索引位置的字符
	* int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
	* int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
	* int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
	* int indexOf(String str,int fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
	* lastIndexOf
	* String substring(int start):从指定位置开始截取字符串,默认到末尾。
	* String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		String s = "woaiheima";
		s.substring(4);									//subString会产生一个新额字符串,需要将新的字符串记录
		System.out.println(s);
	}

	private static void demo4() {
		String s1 = "heimawudi";
		String s2 = s1.substring(5);
		System.out.println(s2);
		
		String s3 = s1.substring(0, 5);					//包含头,不包含尾,左闭右开
		System.out.println(s3);
	}

	private static void demo3() {
		String s1 = "woaiheima";
		int index1 = s1.indexOf('a', 3);					//从指定位置开始向后找
		System.out.println(index1);
		
		int index2 = s1.lastIndexOf('a');					//从后向前找,第一次出现的字符
		System.out.println(index2);
		
		int index3 = s1.lastIndexOf('a', 7);				//从指定位置向前找
		System.out.println(index3);
	}

	private static void demo2() {
		String s1 = "heima";
		int index = s1.indexOf('e');						//参数接收的是int类型的,传递char类型的会自动提升
		System.out.println(index);
		
		int index2 = s1.indexOf('z');						//如果不存在返回就是-1
		System.out.println(index2);
		
		int index3 = s1.indexOf("ma");						//获取字符串中第一个字符出现的位置
		System.out.println(index3);
		
		int index4 = s1.indexOf("ia");
		System.out.println(index4);
	}

	private static void demo1() {
		//int[] arr = {11,22,33};
		//System.out.println(arr.length);					//数组中的length是属性
		String s1 = "heima";
		System.out.println(s1.length());					//length()是一个方法,获取的是每一个字符的个数
		String s2 = "你要减肥,造吗?";
		System.out.println(s2.length());
		
		char c = s2.charAt(5);								//根据索引获取对应位置的字符
		System.out.println(c);
		char c2 = s2.charAt(10);							//StringIndexOutOfBoundsException字符串索引越界异常
		System.out.println(c2);
	}

}
