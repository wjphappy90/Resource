package com.heima.tests;
/**
 * 3.分析以下需求，并用代码实现：
 *	(1)定义如下方法public static String getPropertyGetMethodName(String property);
 *	(2)该方法的参数为String类型，表示用户给定的成员变量的名字，返回值类型为String类型，返回值为成员变量对应的get方法的名字
 *	(3)如：用户调用此方法时给定的参数为"name",该方法的返回值为"getName"

 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		String property = "name";
		String propertyGetMethodName = getPropertyGetMethodName(property);
		System.out.println(propertyGetMethodName);
	}
	public static String getPropertyGetMethodName(String property) {
		//1.property.substring(0, 1).toUpperCase():获取属性property的第一个字母并变成大写字母
		//2.property.substring(1):获取属性property的第二个字母以后的字母
		//3.用concat进行字符串的连接		
		return "get".concat(property.substring(0, 1).toUpperCase()).concat(property.substring(1));
	}
}
