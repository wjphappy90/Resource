/*
Java当中的数据类型分成两种：

1. 基本类型【今天重点】
	整数类型：	byte short int long
	浮点类型：	float double
	字符类型：	char
	布尔类型：	boolean

2. 引用类型（今天作为了解，以后慢慢学习）
	字符串、类、接口、数组、Lambda……
	
注意事项：
对于byte、short、int类型的变量来说，只要右侧不超过左侧的范围即可。
但是对于long类型的变量来说，右侧直接写上就是一个int类型，所以一定要有后缀字母L。
*/
public class Demo01DataType {
	public static void main(String[] args) {
		// 首先使用整数类型对应的变量
		// 方案一，两个步骤：
		// 数据类型 变量名称; // 创建变量
		// 变量名称 = 数据值; // 赋值，把右边给左边
		byte num1; // 创建一个byte类型的变量，名称叫做num1
		num1 = 100; // 赋值，将右侧的常量100，交给左侧的变量num1进行存储
		System.out.println(num1); // 100
		
		num1 = 108; // 改变了变量num1当中的数据
		System.out.println(num1); // 108
		
		// 方案二，一个步骤：
		// 数据类型 变量名称 = 数据值; // 创建变量的同时，立刻赋值
		byte num2 = 90; // 右侧进行赋值的数值，不能超过左侧变量的类型范围
		System.out.println(num2); // 90
		
		// byte num3 = 128; // 错误写法！超过了byte的范围，-128~127
		
		short num4 = 30000;
		System.out.println(num4); // 30000
		
		int num5 = 1800000000; // 18个亿
		System.out.println(num5); // 1800000000
		
		// 注意！右侧是一个int类型的常量，所以直接写上就超过了21个亿
		long num6 = 4200000000L; // 42个亿
		System.out.println(num6);
		
		// 右侧是一个浮点数，默认是double类型，但是左边是float类型
		// float num7 = 3.14; // 错误写法！
		float num8 = 3.14F; // 右边带有后缀F的，所以右边是float类型
		System.out.println(num8); // 3.14
		
		double num9 = 2.5;
		System.out.println(num9); // 2.5
		
		char zifu1 = 'A';
		System.out.println(zifu1); // A
		
		char zifu2 = '中';
		System.out.println(zifu2); // 中
		
		boolean var1 = true;
		System.out.println(var1); // true
		
		boolean var2 = false;
		System.out.println(var2); // false
		
		// boolean var3 = 0; // 错误写法！只能有true和false两种取值，写其他的，都算错
		
		// 如何使用字符串类型的变量呢？
		// 字符串类型写法是：String（不是关键字）
		
		// 两个步骤使用变量
		String str1;
		str1 = "Hello";
		System.out.println(str1); // Hello
		
		// 一个步骤使用变量
		String str2 = "World";
		System.out.println(str2); // World
	}
}