package com.itheima.test02;

/*
 * 编写一个泛形方法名称为swap，实现指定位置数组元素的交换.数组和要交换的索引作为方法参数
 */
public class Test03 {

	public static void main(String[] args) {
		// 3.定义一个String数组,调用swap方法,交换指定索引的元素
		String[] strs = { "a", "b", "c" };
		swap(strs, 0, 2);

		// 4.打印交换后的元素
		for (String s : strs) {
			System.out.print(s + " ");
		}

		System.out.println();

		// 5.定义一个Integer数组,调用swap方法,交换指定索引的元素
		Integer[] arr = { 1, 8, 9, 5, 7 };
		swap(arr, 0, 2);

		// 6.打印交换后的元素
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
	}

	// 1.编写一个泛形方法，数组是任意类型,并传入2个要交换位置的索引
	public static <T> void swap(T[] arr, int i, int j) {
		// 2.使用第三方变量的方式交换数组中的元素
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
