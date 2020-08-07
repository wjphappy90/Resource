package cn.itcast.day05.demo02;

/*
 * 对比两种情况：
 * 
 * 1. 定义一个方法，用来【求出】数组元素的总和。（告诉我最终的结果是多少。）
 * 2. 定义一个方法，用来【打印】数组元素的总和。（你自己打印就得了，不用告诉我结果。）
 */
public class Demo05VoidVsReturn {
	
	public static void main(String[] args) {
		int[] array = { 3, 7, 2, 34, 243, -20, -128, 500 };
		
		// 调用sumA方法，将最终的结果放到result里面。
		int result = sumA(array);
		System.out.println("main当中得到了结果：" + result);
		
		// 只能单独调用void方法
		sumB(array);
	}
	
	/*
	 * 1. 定义一个方法，用来【求出】数组元素的总和。
	 * 三要素
	 * 返回值类型：需要将结果数据还给方法的调用处，所以使用int
	 * 方法名称：sumA
	 * 参数列表：int[] array
	 */
	public static int sumA(int[] array) {
		int sum = 0; // 存钱罐
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum; // 变量sum当中的数据，就是最终结果。
	}
	
	/*
	 * 2. 定义一个方法，用来【打印】数组元素的总和。
	 * 三要素
	 * 返回值类型：没有必要将最终的结果交还给调用处，我自己打印就得了。void
	 * 方法名称：sumB
	 * 参数列表：int[] array
	 */
	public static void sumB(int[] array) {
		int sum = 0; // 存钱罐
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		// 这个sum没有必要还给main当中的调用处，我自己直接打印即可
		System.out.println("总和：" + sum);
	}

}
