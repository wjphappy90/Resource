package com.heima.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Test3 {

	/**
	 *  需求:将集合中的重复元素去掉
	 *  
	 *  分析:
	 *  1,创建List集合存储若干个重复元素
	 *  2,单独定义方法去除重复
	 *  3,打印一下List集合
	 */
	public static void main(String[] args) {
		//1,创建List集合存储若干个重复元素
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		
		//2,单独定义方法去除重复
		getSingle(list);
		
		//3,打印一下List集合
		System.out.println(list);
	}
	/*
	 * 分析
	 * 去除List集合中的重复元素
	 * 1,创建一个LinkedHashSet集合
	 * 2,将List集合中所有的元素添加到LinkedHashSet集合
	 * 3,将list集合中的元素清除
	 * 4,将LinkedHashSet集合中的元素添加回List集合中
	 */
	public static void getSingle(List<String> list) {
		//1,创建一个LinkedHashSet集合
		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		//2,将List集合中所有的元素添加到LinkedHashSet集合
		lhs.addAll(list);
		//3,将list集合中的元素清除
		list.clear();
		//4,将LinkedHashSet集合中的元素添加回List集合中
		list.addAll(lhs);
	}

}
