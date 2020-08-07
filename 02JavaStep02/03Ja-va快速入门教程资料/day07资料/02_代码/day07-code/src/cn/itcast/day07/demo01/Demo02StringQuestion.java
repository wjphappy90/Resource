package cn.itcast.day07.demo01;

/*
 * 既然说字符串就是一个对象，那么有两个问题需要解释：
 * 
 * 1. 对象肯定有一个类与之对应，那么字符串对应的类是谁：String
 * 为什么String这个类，不需要导包直接就能用？
 * 
 * 所有的类都需要导包才能使用，除了两种情况：
 * A. 要使用的目标类，和当前类位于同一个包下。
 * B. 要使用的目标类，位于java.lang包下，但是不包含子包内容。
 * 
 * 2. 既然字符串是对象，那么为什么直接打印出来就是内容呢？
 * 打印println方法逻辑：
 * 1. 如果是字符串类型，那么直接显示内容。
 * 2. 如果不是字符串类型，那么就想办法内部转换成为字符串，然后再显示。
 * 一般的对象都是使用“类型信息+@+地址值”作为字符串内容的。
 */
public class Demo02StringQuestion {
	
	public static void main(String[] args) {
		String str = "Hello";
		System.out.println(str); // Hello
		
		Person per = new Person();
		System.out.println(per); // cn.itcast.day07.demo01.Person@424c0bc4
	}

}
