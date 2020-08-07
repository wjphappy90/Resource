package com.heima.string;

public class Demo1_String {

	/**
	 * a:字符串字面值"abc"也可以看成是一个字符串对象。
	 * b:字符串是常量，一旦被赋值，就不能被改变。
	 */
	public static void main(String[] args) {
		//Person p = new Person();
		String str = "abc";					//"abc"可以看成一个字符串对象
		str = "def";						//当把"def"赋值给str,原来的"abc"就变成了垃圾
		System.out.println(str);			//String类重写了toString方法返回的是该对象本身
		
	}

}
