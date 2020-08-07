package cn.itcast.day05.demo01;

/*
 * 如何调用一个定义好的方法？
 * 
 * 1. 单独调用
 * 格式：方法名称(参数值);
 * 在使用单独调用的时候，无法使用方法的返回值。
 * 
 * 2. 打印调用
 * 格式：System.out.println(方法名称(参数值));
 * 调用方法，并且将返回值打印显示出来。
 * 
 * 3. 赋值调用
 * 格式：数据类型 变量名称 = 方法名称(参数值);
 * 调用方法，并且将返回值交给一个变量。注意，变量的数据类型必须和方法的返回值类型对应。
 */
public class Demo03MethodInvoke {
	
	public static void main(String[] args) {
		// 单独调用
		sum(10, 20);
		System.out.println("=============");
		
		// 打印调用
		System.out.println(sum(100, 200));
		System.out.println("=============");
		
		// 赋值调用
		int num = sum(15, 23);
		num += 100;
		System.out.println(num); // 138
	}
	
	public static int sum(int a, int b) {
		System.out.println("求和的方法执行啦！");
		int result = a + b;
		return result;
	}

}
