package com.heima.tests;
/**
 * 4.分析以下需求，并用代码实现：
 *	(1)定义数字字符串数组{"010","3223","666","7890987","123123"}
 *	(2)判断该数字字符串数组中的数字字符串是否是对称(第一个数字和最后一个数字相等，第二个数字和倒数第二个数字是相等的，依次类推)的，并逐个输出
 *	(3)如：010 是对称的，3223 是对称的，123123 不是对称的
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		//英文单词symmetrical，表示对称的
		String[] strs = {"010","3223","666","7890987","123123"};
		for (String str : strs) {
			boolean b = isSymmString(str);
			System.out.println(str+(b==true?" 是":" 不是")+"对称的");			
		}
		
	}
	//判断数字字符串是否是对称的
	private static boolean isSymmString(String str) {
		char[] arr = str.toCharArray();
		for(int start =0,end=arr.length-1;start<=end;start++,end--) {
			if(arr[start]!=arr[end]) {
				return false;
			}
		}
		return true;
	}
}
