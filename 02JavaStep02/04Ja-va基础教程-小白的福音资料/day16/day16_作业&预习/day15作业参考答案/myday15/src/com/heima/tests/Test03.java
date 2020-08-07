package com.heima.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 3.分析以下需求，并用代码实现：
 *	(1)定义List集合，存入多个字符串
 *	(2)删除集合中包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
 *	(3)然后利用迭代器遍历集合元素并输出
 * @author JX
 *
 */
public class Test03 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
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
		deleteNum4(list);
		//利用迭代器遍历集合元素并输出
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
	}

	// 利用遍历的方式判断是否包含0-9的字符串
	private static void deleteNum1(List<String> list) {
		// 1.遍历集合
		Iterator<String> it = list.iterator();// 获取迭代器
		while (it.hasNext()) {// it.remove();
			String str = (String) it.next();// str.contains(String str)
			for (int i = 0; i <= 9; i++) {// 0-9的数字
				// 2.判断字符串中是否包含0-9的字符串
				if (str.contains(i + "")) {// 0->"0"
					it.remove();
					break;
				}
			}
		}
	}

	// 利用正则表达式
	private static void deleteNum2(List<String> list) {
		// 1.遍历集合
		Iterator<String> it = list.iterator();// 获取迭代器
		// 2.定义正则表达式
		String regex = "\\w*\\d+\\w*";
		while (it.hasNext()) {// it.remove();
			String str = it.next();// str.contains(String str)
			// 3.用正则去匹配
			if (str.matches(regex)) {
				// 4.删除匹配的字符串
				it.remove();
			}
		}
	}

	// 利用正则表达式方法2
	private static void deleteNum3(List<String> list) {
		// 1.遍历集合
		Iterator<String> it = list.iterator();// 获取迭代器
		// 2.定义正则表达式
		String regex = "\\d+";
		Pattern p = Pattern.compile(regex);
		while (it.hasNext()) {// it.remove();
			String str = (String) it.next();// str.contains(String str)
			// 3.获取匹配器对象
			Matcher m = p.matcher(str);
			// 4.用匹配器对象去寻找
			if (m.find()) {
				// 5.删除匹配的字符串
				it.remove();
			}
		}
	}
	// 利用remove(int index)方法删除
	private static void deleteNum4(List<String> list) {
		// 1.遍历集合
		for(int i = 0;i<list.size();i++) {
			/*if(list.get(i).matches("\\w*\\d+\\w*")) {
				list.remove(i--);
			}*/
			String str = list.get(i);
			for (int j = 0; j <= 9; j++) {// 0-9的数字
				// 2.判断字符串中是否包含0-9的字符串
				if (str.contains(j + "")) {// 0->"0"
					list.remove(i--);
					break;
				}
			}			
		}		
	}

}
