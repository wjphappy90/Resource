package com.heima.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Demo4_ListIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");									//Object obj = new String();
		list.add("b");
		list.add("world");
		list.add("c");
		list.add("d");
		list.add("e");
		
		ListIterator lit = list.listIterator();			//获取迭代器
		while(lit.hasNext()) {
			System.out.println(lit.next()); 			//获取元素并将指针向后移动
		}
		
		System.out.println("-----------------");
		
		while(lit.hasPrevious()) {
			System.out.println(lit.previous()); 		//获取元素并将指针向前移动
		}
	}

}
