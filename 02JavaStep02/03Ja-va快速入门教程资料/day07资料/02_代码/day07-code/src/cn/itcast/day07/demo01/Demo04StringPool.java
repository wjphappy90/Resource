package cn.itcast.day07.demo01;

/*
 * 字符串是最为常用的对象，所以在程序当中往往会出现很多个重复的字符串。
 * 为了节省内存，所以引入了“字符串池”的设计，可以重复利用字符串。
 * 
 * 关于字符串池的几点描述：
 * 1. 字符串池是位于堆内存当中的一小块儿空间，用来保存若干个字符串的地址值。
 * 2. 字符串池当中绝对不会出现重复的字符串对应的地址，保证字符串不重复。
 * 3. 凡是直接双引号的字符串默认都在池中；而new出来的字符串默认不在池中。
 * 
 * 对于基本类型来说，==是进行数据内容的相同比较；但是对于引用类型来说，==是进行地址值的相同比较。
 * 如果是两个对象，那么地址值必然不同；如果地址值相同，那么必然是同一个对象。
 */
public class Demo04StringPool {
	
	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println(str1 == str2); // true
		
		char[] array = { 'H', 'e', 'l', 'l', 'o' };
		String str3 = new String(array);
		String str4 = new String(array);
		System.out.println(str3 == str4); // false
		
		System.out.println(str1 == str3); // false
	}

}
