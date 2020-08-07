package com.heima.tests;

import java.util.Arrays;
import java.util.LinkedHashSet;
/**
 * 2.分析以下需求，并用代码实现：
 *	(1)定义一个int类型的一维数组，内容为{6,2,9,6,1,2,6,7,8}
 *	(2)去除上面定义的数组中的重复元素，打印最终结果{6, 2, 9, 1, 7, 8}
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		int[] arr = {6,2,9,6,1,2,6,7,8};
		arr = getSingleArr(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println("==============");
		int[] arr2 = new int[]{6,2,9,6,1,2,6,7,8};
		System.out.println(printArr(arr2));
	}
	//数组去重的方法
	public static int[] getSingleArr(int[] arr) {
		//index表示既能表示当前存入数据在新数组中的位置，又能表示存数新数组中的数据的个数
		int index = 0;
		//1.定义一个和老数组长度相同的数组
		int[] newArr = new int[arr.length];
		//2.遍历老数组的内容
		for(int i = 0;i<arr.length;i++) {
			//3.定义flag标记，表示新数组中是否包含当前遍历到的老数组内容
			boolean flag = false;
			//4.遍历新数组，查看是否包含老数组中的当前元素，如果不包含，flag置为true
			for (int j = 0;j<newArr.length;j++) {
				if (arr[i] == newArr[j]) {
					flag = true;
					break;
				}
			}
			//5.flag为false时说明新数组中不包含当前遍历的老数组的内容，并将当前遍历的老数组的元素存入新数组中
			if (!flag) {
				newArr[index++] = arr[i];
			}
		}
		//return Arrays.copyOf(newArr, index);
		//6.去除新数组中的无效的元素
		//7.定义一个需要返回给调用者的数组returnArr，该数组的长度为index
		int[] returnArr = new int[index];
		//8.将新数组中的index个元素存入returnArr数组中，并将该数组返回
		for(int i=0;i<index;i++) {
			returnArr[i] = newArr[i];
		}
		return returnArr;
	}
	//自定义打印数组的方法prinArr，格式{6, 2, 9, 1, 7, 8}
	public static String printArr(int[] arr) {
		//1.如果arr==null，直接返回"null"
		if(null == arr) {
			return "null";
		}
		//2.如果数组的长度为0，直接返回"[]"
		int maxLength = arr.length-1;
		String s = "";
		if(-1==maxLength) {
			return "[]";
		}
		//3.遍历数组元素将数组封装成"[6, 2, 9, 1, 7, 8]"格式
		s+="{";		
		for(int index = 0;;index++ ) {
			s+=arr[index];
			if(index==maxLength)
				return s+"}";
			s+=", ";
		}
	}
}
