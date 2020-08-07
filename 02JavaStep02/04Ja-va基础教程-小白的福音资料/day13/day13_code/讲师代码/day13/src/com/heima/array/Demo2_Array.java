package com.heima.array;

public class Demo2_Array {

	/**
	 * * A:案例演示
			* 数组高级二分查找代码
		* B:注意事项
			* 如果数组无序，就不能使用二分查找。
				* 因为如果你排序了，但是你排序的时候已经改变了我最原始的元素索引。

	 */
	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77};
		System.out.println(getIndex(arr, 22));
		System.out.println(getIndex(arr, 66));
		System.out.println(getIndex(arr, 88));
	}
	
	/*
	 * 二分查找
	 * 1,返回值类型,int
	 * 2,参数列表int[] arr,int value
	 */
	
	public static int getIndex(int[] arr, int value) {
		int min = 0;
		int max = arr.length - 1;
		int mid = (min + max) / 2;
		
		while(arr[mid] != value) {					//当中间值不等于要找的值,就开始循环查找
			if(arr[mid] < value) {					//当中间值小于了要找的值
				min = mid + 1;						//最小的索引改变
			}else if (arr[mid] > value){			//当中间值大于了要找的值
				max = mid - 1;						//最大的索引改变
			}
			
			mid = (min + max) / 2;					//无论最大还是最小改变,中间索引都会随之改变
			
			if(min > max) {							//如果最小索引大于了最大索引,就没有查找的可能性了
				return -1;							//返回-1
			}
		}
		return mid;
	}
}
