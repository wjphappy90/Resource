package com.heima.tests;
/**
 * 1.分析以下需求，并用代码实现：
 *	(1)定义一个存放手机号码的数字字符串数组{"16210626656","18601066888","13912387666","13156166693","15115888028"}
 *	(2)利用正则表达式过滤出符合条件的手机号码，
 *		规则：第1位是1，第二位可以是数字358其中之一，后面6位任意数字，最后5位为任意相同的数字。
 *	(3)如：18601066888 13912387666
 * @author JX
 *
 */
public class Test01 {
	public static void main(String[] args) {
		String regex = "[1][358]\\d{6}(\\d)\\1{2}";
		String phone1 = "18601088888";
		String phone2 = "13912366666";
		String[] numbers = {"16210626656","18601066888","13912387666","13156166693","15115888028"};
		System.out.println("有以下号码符合要求：");
		for(int i = 0;i<numbers.length;i++) {
			boolean flag = numbers[i].matches(regex);
			if(flag) {
				System.out.println(numbers[i]);
			}
		}		
	}
}
