package cn.itcast.day04.demo02;

/*
 * 数组元素的索引编号，从0开始，一直到“长度-1”为止。
 * 如果一个数组长度为3，那么元素的编号分别是：0、1、2。没有3号元素的！
 * 
 * 如果访问的数组元素索引不存在，那么将会发生“数组索引越界异常”：
 * ArrayIndexOutOfBoundsException
 * 只要出现这种异常，一定是访问的数组元素并不存在。
 */
public class Demo05Problem {
	
	public static void main(String[] args) {
		int[] array = { 10, 20, 30 };
		System.out.println(array[0]); // 10
		System.out.println(array[1]); // 20
		System.out.println(array[2]); // 30
		System.out.println("数组的长度：" + array.length);
		System.out.println("================");
		
		// System.out.println(array[3]); // 编译没有报错，运行就会报错！
		System.out.println(array[-1]); // 数组索引从0开始，绝对不可能为负数，所以也会运行出现异常！
	}

}
