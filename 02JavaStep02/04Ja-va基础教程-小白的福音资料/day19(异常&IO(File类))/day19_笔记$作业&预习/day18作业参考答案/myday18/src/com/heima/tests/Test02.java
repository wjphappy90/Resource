package com.heima.tests;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 2.分析以下需求，并用代码实现：
 *	(1)利用键盘录入，输入一个字符串
 *	(2)统计该字符串中各个字符的数量
 *	(3)如：
 *		用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java"
 *		程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)u(4)v(1)w(1)y(3)~(6)
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//1.定义键盘录入对象输入字符串
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String str = sc.nextLine();
		//2.调用getCharNum方法统计每个字符出现的次数,并返回一个新的字符串a(2)b(1)k(2)...
		String newStr = getCharNums(str);
		//3.打印字符串
		System.out.println(newStr);
	}

	private static String getCharNums(String str) {
		//1.将字符串变成字符数组
		char[] chars = str.toCharArray();
		//2.定义集合TreeMap
		TreeMap<Character,Integer> map = new TreeMap<>();
		//3.遍历字符数组,将对应的字符和次数存入map集合中
		for (char c : chars) {
			map.put(c, map.get(c)!=null?map.get(c)+1:1);//三元运算符统计每个字符的个数
		}
		//4.定义StringBuilder
		StringBuilder sb = new StringBuilder();
		//5.遍历map集合,利用StringBuilder将key-value转成a(2)b(1)...格式
		for(Map.Entry<Character,Integer> entry:map.entrySet()) {
			sb.append(entry.getKey()).append("(").append(entry.getValue()).append(")");
		}
		//6.返回StringBuilder的字符串表现形式
		return sb.toString();
	}
}
