package com.heima.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 2.分析以下需求，并用代码实现：
	(1)定义List集合，存入多个字符串
	(2)删除集合中字符串"def"
	(3)然后利用迭代器遍历集合元素并输出
 * @author JX
 *
 */
public class Test02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abce0fgh");
		list.add("ab2e0fgh");
		list.add("ab3e0fgh");
		list.add("ab5e0fgh");
		list.add("ab6e0fgh");
		list.add("ab5e0f8gh");
		list.add("000234ab5e0f8g9h");
		list.add("abc");
		list.add("def");
		list.add("ghi");
		//调用deleteStrFromList方法删除集合中的字符串"def"
		deleteStrFromList(list, "def");
		//利用迭代器遍历集合元素并输出
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
	}
	// 删除ArrayList集合中的"abc"字符串
	public static void deleteStrFromList(List<String> list,String delStr) {
		//1.获取迭代器对象，并进行遍历
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String str = it.next();
			//2.判断集合中的元素是否等于"abc",如果相等，就删除
			if(null!=delStr&&delStr.equals(str)) {
				it.remove();
			}
		}
	}
}
