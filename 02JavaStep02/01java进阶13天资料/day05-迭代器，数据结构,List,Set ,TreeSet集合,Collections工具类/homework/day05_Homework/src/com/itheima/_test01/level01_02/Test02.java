package com.itheima._test01.level01_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 往ArrayList添加以下元素”abc1”, ”abc2”, ”abc3”, ”abc4”.使用迭代器获取ArrayList集合中的元素
 */
public class Test02 {

	public static void main(String[] args) {
		// 1.创建集合对象
		Collection<String> coll = new ArrayList<String>();
		// 2.往集合中存放元素
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");

		// 3.获取容器的迭代器
		Iterator<String> it = coll.iterator();

		// 4.使用迭代器判断是否有下一个元素
		while (it.hasNext()) {
			// 5.使用迭代器对象获取集合中的元素
			System.out.println(it.next());
		}
	}

}
