package cn.itcast.day07.demo01;

/*
 * 字符串对象在内存当中一旦被创建，那么内容不可以被改变。
 * 
 * 字符串的内容不会发生改变，每当你觉得好像是变了的时候，一定是创建了新的字符串。
 */
public class Demo05StringEternal {
	
	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(str); // Hello
		
		str = "World";
		System.out.println(str); // World
		
		String str2 = "Love";
		str2 += "Java";
		System.out.println(str2); // LoveJava
	}

}
