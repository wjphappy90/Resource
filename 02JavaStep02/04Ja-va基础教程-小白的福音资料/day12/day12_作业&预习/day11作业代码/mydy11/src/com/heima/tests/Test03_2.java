package com.heima.tests;

/**
 * 3.分析以下需求，并用代码实现：
 *	(1)定义一个int类型的一维数组，内容为{6,2,9,15,1,5,20,7,18}
 *	(2)将数组最大元素与最后一位元素进行交换,最小元素与第一位元素进行交换，并打印数组
 * @author JX
 *
 */
public class Test03_2 {
	public static void main(String[] args) {
		int[] arr = {6,2,9,15,1,5,20,7,18};
		printArr(arr); // 交换并打印
	}
	//定义交换数组最大元素与最后一位元素进行交换,最小元素与第一位元素进行交换，并打印数组
	//注意：方法可以嵌套调用但是不能嵌套定义
	public static void printArr(int[] arr) {
		//数组最大元素与最后一位元素进行交换
		int maxIndex = getMaxIndex(arr);
		int minIndex = getMinIndex(arr);
		swap(arr,maxIndex,arr.length-1);
		swap(arr,minIndex,0);
		for (int i : arr) { // 遍历数组输出
			System.out.print(i + " ");
		}
	}
	//定义交换数组指定位置的元素的方法
	public static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//定义方法获取数组最大值对应的索引位置
	public static int getMaxIndex(int[] arr) {
		// 假设数组的第一个元素为最大值
		int index = 0; 
		for (int i = 0; i < arr.length; i++) { // 遍历数组
			if (arr[index] < arr[i]) {
				index = i;
			}
		}
		return index; // 返回最值索引
	}
	//定义方法获取数组最小值对应的索引位置
	public static int getMinIndex(int[] arr) {
		// 假设数组的第一个元素为最小值
		int index = 0; 
		for (int i = 0; i < arr.length; i++) { // 遍历数组
			if (arr[index] > arr[i]) {
				index = i;
			}
		}
		return index; // 返回最值索引
	}
}
