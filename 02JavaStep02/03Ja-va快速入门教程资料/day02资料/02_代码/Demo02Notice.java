/*
使用变量的注意事项：

1. 创建的多个变量不能重名。
2. 变量如果没有赋值，不能直接使用；如果要想使用，必须首先赋值。
3. 变量的作用域问题。
【作用域】变量定义在哪个大括号当中就只能在哪里使用，超出了直接所属的大括号，就不能使用。
4. 可以通过一个步骤同时定义多个类型相同的变量。
*/
public class Demo02Notice {
	
	public static void main(String[] args) {
		int num1 = 100; // 创建了一个名叫num1的变量
		// int num1 = 200; // 创建了另一个名字也叫num1的变量，错误写法！
		int num2 = 200; // 创建了另一个名字叫做num2的变量，正确写法！
		System.out.println(num2); // 200
		
		int num3; // 创建了一个变量
		// num3 = 30; // 没有进行赋值的话
		// System.out.println(num3); // 错误写法！没有赋值的变量不能直接使用
		
		// 大括号之内其实可以再写一层大括号
		{
			int num4 = 40;
			System.out.println(num4); // 40
		}
		// System.out.println(num4); // 错误写法！已经超出了num4直接所属的大括号，外面就不能再用了。
		// 既然出来了，外面没有num4了，那么我们自己能不能再定义一个num4变量？
		int num4 = 400;
		System.out.println(num4); // 400
		
		int a, b, c; // 同时创建了三个变量，类型全都是int类型。
		a = 10;
		b = 20;
		c = 30;
		System.out.println(a); // 10
		System.out.println(b); // 20
		System.out.println(c); // 30
		
		int x = 100, y = 200, z = 300;
		System.out.println(x); // 100
		System.out.println(y); // 200
		System.out.println(z); // 300
	}
	
	
	
}