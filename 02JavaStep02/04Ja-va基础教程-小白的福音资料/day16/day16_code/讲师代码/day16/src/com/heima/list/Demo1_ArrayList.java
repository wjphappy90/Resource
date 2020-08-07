package com.heima.list;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Demo1_ArrayList {

	/**
	 * * A:案例演示
		* 需求：ArrayList去除集合中字符串的重复值(字符串的内容相同)
		* 思路：创建新集合方式
	 */
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("c");
		
		ArrayList newList = getSingle(list);
		System.out.println(newList);
	}

	/*
	 * 创建新集合将重复元素去掉
	 * 1,明确返回值类型,返回ArrayList
	 * 2,明确参数列表ArrayList
	 * 
	 * 分析:
	 * 1,创建新集合
	 * 2,根据传入的集合(老集合)获取迭代器
	 * 3,遍历老集合
	 * 4,通过新集合判断是否包含老集合中的元素,如果包含就不添加,如果不包含就添加
	 */
	public static ArrayList getSingle(ArrayList list) {
		ArrayList newList = new ArrayList<>();					//1,创建新集合
		Iterator it = list.iterator();							//2,根据传入的集合(老集合)获取迭代器
		
		while(it.hasNext()) {									//3,遍历老集合
			Object obj = it.next();								//记录住每一个元素
			if(!newList.contains(obj)) {						//如果新集合中不包含老集合中的元素
				newList.add(obj);								//将该元素添加
			}
		}
		
		return newList;
	}
}
