/*
算术运算符当中有一对儿：
自增运算符：++		就是在变量原有的基础上，累加一个1（涨一个数）
自减运算符：--		就是在变量原有的基础上，累减一个1（降一个数）

使用格式：
	1. 可以用在变量的前面，例如：	++num
	2. 也可以用在变量的后面，例如：	num++

使用方式：
	1. 单独使用：自己独立成为一个步骤语句，不和其他任何操作混合。
	2. 混合使用：和其他操作一起混合。

前和后两个使用方式的区别：
1. 单独使用的时候，前++和后++没有任何区别。
2. 混合使用的时候，前++和后++存在【重大区别】：
	A. 如果是【前++】，那么变量立刻马上+1，然后拿着结果进行使用。【先加后用】
	B. 如果是【后++】，那么首先使用变量当前的本来数据，然后再进行+1操作。【先用后加】
	
注意事项：自增运算符和自减运算符，只能用于变量，不能用于常量。
*/
public class Demo06Operator {
	public static void main(String[] args) {
		int num1 = 10;
		// 单独使用前++
		++num1;
		System.out.println(num1); // 11
		
		// 单独使用后++
		num1++;
		System.out.println(num1); // 12
		
		System.out.println("======================");
		
		int num2 = 20;
		// 和输出语句一起混合使用
		System.out.println(++num2); // 21
		System.out.println(num2); // 21
		
		System.out.println("======================");
		
		int num3 = 30;
		System.out.println(num3++); // 30
		System.out.println(num3); // 31
		
		System.out.println("======================");
		
		// 如果和赋值一起混合使用
		int x = 10;
		int y = 20;
		
		int result1 = x++;
		System.out.println(result1); // 10
		System.out.println(x); // 11
		
		System.out.println("======================");
		
		int result2 = ++y;
		System.out.println(result2); // 21
		System.out.println(y); // 21
		
		System.out.println("======================");
		
		int a = 10;
		int b = 20;
		// 11 + 20
		int result3 = ++a + b--;
		System.out.println(result3); // 31
		System.out.println(a); // 11
		System.out.println(b); // 19
		
		// System.out.println(100++); // 错误写法！常量不能使用++或者--
	}
}