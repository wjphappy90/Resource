package com.heima.tests;
/**
 * 2.分析以下需求，并用代码实现：
 *	(1)有一个数字字符串"25 11 -6 20 102 9",数字之间用空格间隔	
 *	(2)利用冒泡排序对这串数字按照从小到大排序，生成一个数值有序的字符串"-6 9 11 20 25 102"
 *	(3)提示:用String类提供的split方法(用" "(空格)作为split方法的参数来切割)，然后生成对应的数字字符串数组
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		String str = "25 11 -6 20 102 9";
		//1.将字符串数字变成字符串数组
		String[] arr = str.split(" ");
		//2.定义一个int数组,长度和arr相同
		int[] intArr = new int[arr.length];
		//3.将arr中的字符串类型的数字转成int类型并存入新数组intArr中
		for(int i =0;i<arr.length;i++) {
			intArr[i] = Integer.parseInt(arr[i]);
		}
		//4.调用sort方法对数组排序
		sort(intArr);
		//5.toString()方法将数组变成字符串
		System.out.println(toString(intArr));
	}
	//定义toString方法,将int[]数组变成字符串形式"23 9 -4 18 100 7"
	private static String toString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;;i++) {
			sb.append(arr[i]);
			if(i==arr.length-1)
				return sb.toString();	
			sb.append(" ");
		}			
	}
	//冒泡排序对整型数组排序
	public static void sort(int[] arr) {
		for(int i =0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
