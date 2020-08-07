package cn.itcast.day07.demo02;

/*
 * 如果希望将字符串当中指定的部分进行替换操作，需要使用：
 * 
 * public String replace(CharSequence oldStr, CharSequence newStr)：将字符串当中出现的所有oldStr部分，替换成为指定的newStr。
 * 参数oldStr代表需要被替换的老字符串部分
 * 参数newStr代表需要替换成为的新字符串部分
 * 参数类型CharSequence现阶段可以简单地认为就是字符串String。
 * 
 * 注意：
 * 字符串的内容不会发生改变的，所以replace方法的返回值结果是一个全新的字符串。
 */
public class Demo04StringReplace {
	
	public static void main(String[] args) {
		String str1 = "How do you do?";
		String str2 = str1.replace("o", "*");
		System.out.println(str1); // How do you do?
		System.out.println(str2); // H*w d* y*u d*?
		System.out.println("===============");
		
		String str3 = "会不会玩儿啊！你大爷！真是服了！";
		String str4 = str3.replace("你大爷", "***");
		System.out.println(str4); // 会不会玩儿啊！***！真是服了！
	}

}
