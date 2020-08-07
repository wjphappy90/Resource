package com.heima.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.heima.domain.Person;
/**
 * 2.分析以下需求，并用代码实现：
 *	(1)有如下代码：
 *		//....
 *	(2)要求对集合中添加的元素排序
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("b");
		list.add("f");
		list.add("e");
		list.add("c");
		list.add("a");
		list.add("d");
		sort(list);
		System.out.println(list); // a, b, c, d, e, f	
	}

	// 对集合中的元素排序(泛型为String)
	private static void sort(List<String> list) {
		// 直接使用冒泡排序,没有将集合转成数组
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				String str1 = list.get(j);
				String str2 = list.get(j + 1);
				// 下面这种方式无法实现list集合中的元素的交换
				/*
				 * if (str1.compareTo(str2) > 0) { String temp = str1; str1 =
				 * str2; str2 = temp; }
				 */
				if (str1.compareTo(str2) > 0) {
					list.set(j, str2);
					list.set(j + 1, str1);
				}
			}
		}
	}
	
}
