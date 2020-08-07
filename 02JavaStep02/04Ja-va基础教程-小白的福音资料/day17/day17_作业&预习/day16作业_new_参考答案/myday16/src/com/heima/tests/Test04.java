package com.heima.tests;

import java.util.Arrays;

/**
 * 4.分析以下需求，并用代码实现：
 *	(1)编写一个泛形方法，实现指定位置数组元素的交换
 *	(2)编写一个泛形方法，接收一个任意数组，并反转数组中的所有元素
 * @author JX
 *
 */
public class Test04 {
	public static void main(String[] args) {
		String s[] = {"a","b","c"};
        exchange(s, 0, 2);
        //Arrays.asList(s):将数组s转换成集合
        System.out.println(Arrays.asList(s));
        
        String s1 [] = {"a","b","c","d"};
        reverse(s1);
        System.out.println(Arrays.asList(s1));
	}
	//1.编写一个泛形方法，实现指定位置数组元素的交换
	public static <T> void exchange(T[] t, int index1, int index2) {
		T temp = t[index1];
		t[index1] = t[index2];
		t[index2] = temp;
	}
	//2.编写一个泛形方法，接收一个任意数组，并颠倒数组中的所有元素
    public static <T> void reverse(T[] t){
        
        int startIndex = 0;
        int endIndex = t.length -1;
        
        while(startIndex<endIndex){
            T temp = t[startIndex];
            t[startIndex] = t[endIndex];
            t[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
        
    }
}
