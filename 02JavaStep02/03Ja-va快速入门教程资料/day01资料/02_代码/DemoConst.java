/*
数学当中的“常数”：对于方程式 y = 2 + x 来说，其中的数字2是固定不变的，这就是一个常数。
程序当中的“常量”：程序运行期间，不可以发生改变的量。

常量的分类：
	1. 字符串常量：凡是用双引号引起来的内容。
	2. 整数常量：例如100、200、-250。
	3. 浮点常量：例如3.14、-2.5、0.0。
	4. 字符常量：凡是用单引号引起来的单个字符。（只能有且仅有一个字符）
	5. 布尔常量：只有两种取值，true真、false假。
	6. 空常量：null（读作“闹”），代表空，什么都没有。
*/
public class DemoConst {
	
	public static void main(String[] args) {
		// 字符串常量
		System.out.println("Hello, Java!!!");
		System.out.println("A");
		System.out.println(""); // 中间留空，什么都不写，也是正确的写法！
		
		// 整数常量
		System.out.println(100);
		System.out.println(-200);
		
		// 浮点常量（小数）
		System.out.println(3.14);
		System.out.println(-2.5);
		
		// 字符常量
		System.out.println('A');
		System.out.println('9');
		// System.out.println('AB'); // 错误写法！有且仅有一个字符才行。
		// System.out.println(''); // 错误写法！有且仅有一个字符才行。
		
		// 布尔常量
		System.out.println(true);
		System.out.println(false);
		
		// 空常量（null不可以直接用于打印输出）
		// System.out.println(null); // 错误写法！不能直接打印
	}
	
}