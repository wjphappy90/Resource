package com.itheima._test02.level02_03;

import java.util.ArrayList;
import java.util.HashSet;


/*
 * ArrayList有以下元素: "a","f","b","c","a","d"
 * 利用HashSet对ArrayList集合去重(最终结果: ArrayList中没有重复元素)
 */
public class Test03 {
	public static void main(String[] args) {
		// 1.创建ArrayList
		ArrayList<String> list = new ArrayList<>();

		// 2.使用add方法往ArrayList添加元素
		list.add("a");
		list.add("f");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("d");

		// 3.创建HashSet.用于将ArrayList中重复的元素去除
		HashSet<String> set = new HashSet<>();

		// 4.调用HashSet的addAll方法,将ArrayList中的元素添加到HashSet中
		for (String s : list) {
			set.add(s);
		}

		// 5.清空list的所有元素
		list.clear();

		// 6.将set集合中的元素再添加回ArrayList集合
		list.addAll(set);
		System.out.println(list);
	}
}