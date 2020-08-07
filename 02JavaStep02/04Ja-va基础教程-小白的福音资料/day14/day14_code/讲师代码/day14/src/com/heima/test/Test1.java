package com.heima.test;

import java.util.Arrays;

public class Test1 {

	/**
	 * @param args
	 * * A:案例演示
	 * 需求：我有如下一个字符串:”91 27 46 38 50”，请写代码实现最终输出结果是：”27 38 46 50 91”
	 * 100
	 * 80
	 * 分析:
	 * 1,将字符串切割成字符串数组
	 * 2,将字符串转换成数字并将其存储在一个等长度的int数组中
	 * 3,排序
	 * 4,将排序后的结果遍历并拼接成一个字符串
	 */
	public static void main(String[] args) {
		String s = "91 27 46 38 50";
		//1,将字符串切割成字符串数组
		String[] sArr = s.split(" ");
		//2,将字符串转换成数字并将其存储在一个等长度的int数组中
		int[] arr = new int[sArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sArr[i]); 	//将数字字符串转换成数字
		}
		
		//3,排序
		Arrays.sort(arr);
		
		//4,将排序后的结果遍历并拼接成一个字符串27 38 46 50 91
		/*String str = "";
		for (int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1) {
				str = str + arr[i];				//27 38 46 50 91
			}else {
				str = str + arr[i] + " ";		//27 38 46 50 
			}
		}
		
		System.out.println(str);*/
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1) {
				sb.append(arr[i]);
			}else {
				sb.append(arr[i] + " ");
			}
		}
		
		System.out.println(sb);
	}

}
