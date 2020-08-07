/*
算术运算符，常见的四则运算：

加	+
减	-
乘	*
除	/
*/
public class Demo03Operator {
	
	public static void main(String[] args) {
		System.out.println(100 + 20); // 120，说明运算符可以用于常量
		
		int x = 10;
		int y = 20;
		System.out.println(x - y); // -10，运算符也可以用于变量
		
		System.out.println(x * y); // 200
		// 如果println小括号当中写的是一个表达式
		// 那么将会首先将表达式计算出来，然后对结果进行打印
		
		// Java当中整数之间的除法，进行的是“整除”
		// 小学时候的算法：被除数 / 除数 = 商 (余数)
		// Java当中整数除法，只看商，不看余数。
		int a = 10;
		int b = 3;
		System.out.println(a / b); // 结果是3。商3，余数1
		
		// 如果计算当中有小数参与，那么结果一定是小数
		int m = 10;
		double n = 3.0;
		System.out.println(m + n); // 13.0
	}
	
}