package com.heima.list;

import java.util.ArrayList;
import java.util.List;

public class Demo1_List {

	/**
	 * 	* void add(int index,E element)
		* E remove(int index)
		* E get(int index)
		* E set(int index,E element)
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		list.set(1, "z");						//将指定位置的元素修改
		System.out.println(list);
	}

	public static void demo4() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//Object obj1 = list.get(2);
		//System.out.println(obj1);
		//通过索引遍历List集合
		for(int i = 0;i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void demo3() {
		List list = new ArrayList();
		list.add(111);
		list.add(222);
		list.add(333);
		
		list.remove(111);							//删除的时候不会自动装箱,把111当作索引
		System.out.println(list);
	}

	public static void demo2() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		Object obj = list.remove(1);				//通过索引删除元素,将被删除的元素返回
		System.out.println(obj);
		System.out.println(list);
	}

	public static void demo1() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add(4, "f");						//index<=size并且index>=0都不会报异常
		//list.add(1,"e");
		//list.add(10, "z");					//java.lang.IndexOutOfBoundsException,当存储时使用不存在的索引时
		System.out.println(list);
	}

}
