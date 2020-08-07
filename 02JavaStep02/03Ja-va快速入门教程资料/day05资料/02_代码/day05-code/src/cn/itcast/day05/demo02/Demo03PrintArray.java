package cn.itcast.day05.demo02;

/*
 * 题目：定义一个方法，用来对数组进行遍历。
 * 遍历：就是逐一、挨个儿处理。默认的遍历操作就是打印输出。
 * 遍历数组：将数组当中的每一个元素逐一打印显示出来。
 * 
 * 分析：
 * 1. 首先需要准备一个数组。
 * 2. 定义一个方法，三要素
 * 返回值类型：只是进行打印显示而已，没有结果数据，所以用void
 * 方法名称：printArray
 * 参数列表：需要给我一个数组，我才能遍历它。所以需要一个int[]数组
 * 3. 调用方法，传入一个数组。
 */
public class Demo03PrintArray {
	
	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50, 65, 75 };
		
		printArray(array);
	}
	
	/*
	 * 三要素
	 * 返回值类型：只是进行打印显示而已，没有结果数据，所以用void
	 * 方法名称：printArray
	 * 参数列表：需要给我一个数组，我才能遍历它。所以需要一个int[]数组
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
