package cn.itcast.day05.demo02;

/*
 * 如果一个方法只是要执行一些操作而已，并没有最终的数据结果要交还给调用处，那么这个方法就是没有返回值的方法。
 * 需要使用一个关键字：void。
 * 
 * 定义一个没有返回值的方法：
 * 修饰符 void 方法名称(参数类型 参数名称) {
 * 		方法体
 * 		return; // 最后的一行return一般都是省略不写的
 * }
 * 
 * 格式的调整：
 * 1. 返回值类型固定写成关键字：void
 * 2. 不能return一个具体的返回值，只能写return直接分号
 * 3. 如果方法最后一行是return那么则一般省略。
 */
public class Demo01MethodVoid {
	
	public static void main(String[] args) {
		// 单独调用
		printHelloWorld();
		System.out.println("=================");
		
		printHelloWorldCount(20);
	}
	
	/*
	 * 定义一个方法，用来打印输出固定10次HelloWorld
	 * 三要素
	 * 返回值类型：只是进行屏幕的打印输出而已，没有结果数据产生。返回值类型，使用void。
	 * 方法名称：printHelloWorld
	 * 参数列表：不需要任何条件，自己就能独立完成任务，所以不用参数，参数留空
	 */
	public static void printHelloWorld() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Hello, World! " + i);
		}
	}
	
	/*
	 * 定义一个方法，用来打印输出指定次数的HelloWorld
	 * 三要素
	 * 返回值类型：仍然还是屏幕打印输出，所以并没有结果数据需要还给调用处，仍然使用void
	 * 方法名称：printHelloWorldCount
	 * 参数列表：需要知道到底是几次，所以需要一个int类型
	 */
	public static void printHelloWorldCount(int count) {
		for (int i = 1; i <= count; i++) {
			System.out.println("Hello, World! " + i);
		}
	}
	
}
