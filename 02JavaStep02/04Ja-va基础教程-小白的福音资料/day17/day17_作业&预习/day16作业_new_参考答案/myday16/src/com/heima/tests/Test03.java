package com.heima.tests;

import java.util.ArrayList;
import java.util.List;

import com.heima.domain.Person;

/**
 * 3.分析以下需求，并用代码实现：
 *	(1)有如下代码：
 *		//.....
 *	(2)定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1
 * @author JX
 *
 */
public class Test03 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		//测试方法 System.out.println(frequency(list, "a")); // 3
		System.out.println(frequency(list, "b")); // 2
		System.out.println(frequency(list, "c")); // 1
		System.out.println(frequency(list, "d")); // 5
		System.out.println(frequency(list, "xxx")); // 0		
	}

	// 1.统计集合中元素出现的次数
	private static int frequency(List<String> list, String value) {
		int count = 0;
		// 1.使用增强for遍历集合
		for (String str : list) {
			// 2.如果当前元素是要查找的元素value,计数器count加1
			if (value.equals(str))
				count++;
		}
		// 3.返回计数器
		return count;
	}
}
