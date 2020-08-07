package com.heima.tests;
/**
 * 1.分析以下需求，并用代码实现：
 *	(1)模拟Arrays.toString(int[] arr);方法，自己封装一个public static String toString(int[] arr);
 *	(2)如果int类型数组arr为null，toString方法返回字符串"null"
 *	(3)如果int类型数组arr长度为0，toString方法返回字符串"[]"
 *	(4)如果int类型数组arr的内容为{1,2,3,4,5},toString方法返回字符串"[1, 2, 3, 4, 5]"
 * @author JX
 *
 */
public class Test01 {
	public static void main(String[] args) {
		int[] arr1 = null;
		System.out.println(toString(arr1));
		int[] arr2 = new int[0];
		System.out.println(toString(arr2));
		int[] arr3 = {1,2,3,4,5};
		System.out.println(toString(arr3));
	}
	public static String toString(int[] arr) {
		//数组为空直接返回字符串"null"
        if (arr == null)
            return "null";
        int maxLen = arr.length - 1;
        //数组长度为0，返回字符串"[]"
        if (maxLen == -1)
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; ; i++) {
            sb.append(arr[i]);
            if (i == maxLen)
                return sb.append(']').toString();
            sb.append(", ");
        }
    }
}
