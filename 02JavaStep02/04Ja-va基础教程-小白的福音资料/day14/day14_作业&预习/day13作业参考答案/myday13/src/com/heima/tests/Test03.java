package com.heima.tests;
/**
 * 4.分析以下需求，并用代码实现：
 *	(1)打印由7，8，9三个数组组成的三位数，要求该三位数中任意两位数字不能相同
 *	(2)打印格式最后的三位数字以空格分隔，如789 798 879 897 978 987
 * @author JX
 *
 */
public class Test03 {
	public static void main(String[] args) {
		int[] arr = {7,8,9};
		int len = arr.length;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				for(int k=0;k<len;k++) {
					if((arr[i]!=arr[j])&&(arr[j]!=arr[k])&&(arr[k]!=arr[i])) {
						int temp = arr[i]*100+arr[j]*10+arr[k];
						sb.append(temp+" ");
					}
				}
			}
		}
		//链式编程去掉最后一个空格
		sb.replace(sb.lastIndexOf(" "), sb.length(), "");
		System.out.println(sb.toString());
	}
}
