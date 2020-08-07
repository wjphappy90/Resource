/*
赋值运算符

1. 基本赋值运算符：=	不是数学当中相等的意思，而是代表一个动作，将右侧的数据交给左边的变量进行存储。
2. 复合赋值运算符：
	+=		a += 3		a = a + 3
	-=		b -= 4		b = b - 4
	*=		c *= 5		c = c * 5
	/=		d /= 6		d = d / 6
	%=		e %= 7		e = e % 7

注意事项：
	赋值运算符只能左侧是一个变量，左侧不能是常量。右侧都行。
*/
public class Demo07Operator {
	public static void main(String[] args) {
		int num1 = 10;
		num1++;
		num1++;
		num1++;
		System.out.println(num1); // 13
		
		int num2 = 20;
		num2 += 5; // num2 = num2 + 5;
		System.out.println(num2); // 25
		
		int a = 10;
		a %= 3; // a = a % 3
		System.out.println(a); // 1
		
		int var1 = 100; // 正确写法
		// 200 = 100; // 错误写法！左侧不能是常量
		// 200 = 200; // 仍然错误！
		int var2 = var1; // 只要左边是变量，右侧是常量或者是变量都行
		System.out.println(var2); // 100
	}
}