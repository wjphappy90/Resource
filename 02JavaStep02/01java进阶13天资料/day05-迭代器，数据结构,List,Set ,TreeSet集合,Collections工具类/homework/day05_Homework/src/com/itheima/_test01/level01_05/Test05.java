package com.itheima._test01.level01_05;

import java.util.LinkedList;

/*
 * 练习LinkedList基本方法: add, set, get, remove, clear, size方法
 */
public class Test05 {
	public static void main(String[] args) {
		// 1.创建LinkedList
		LinkedList<String> arr = new LinkedList<String>();

		// 2.使用add方法添加元素
		arr.add("西门吹雪");
		arr.add("西门吹雪");
		arr.add("西门吹雪");
		arr.add("西门吹风");
		arr.add("西门吹水");

		// 3.使用add方法在指定索引添加元素
		arr.add(2, "西门吹雨");

		// 4.使用set方法修改指定位置索引
		arr.set(0, "东门");

		for (String str : arr) {
			System.out.println(str);
		}

		System.out.println("--------------");
		// 5.使用get方法获取指定索引的元素
		System.out.println(arr.get(1));

		// 6.使用size方法获取集合大小
		System.out.println(arr.size());

		// 7.使用remove方法删除指定索引的元素
		arr.remove(3);

		// 8.使用clear清空集合中的元素
		arr.clear();
		System.out.println(arr);
	}
}
