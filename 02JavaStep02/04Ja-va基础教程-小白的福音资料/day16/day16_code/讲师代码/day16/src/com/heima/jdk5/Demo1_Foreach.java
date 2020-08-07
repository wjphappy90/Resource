package com.heima.jdk5;

import java.util.ArrayList;
import java.util.Iterator;

import com.heima.bean.Person;

public class Demo1_Foreach {

	/**
	 * * A:增强for概述
			* 简化数组和Collection集合的遍历
		* B:格式：
		* 
				for(元素数据类型 变量 : 数组或者Collection集合) {
					使用变量即可，该变量就是元素
				}
		* C:案例演示
			* 数组，集合存储元素用增强for遍历
		* D:好处
			* 简化遍历
		增强for循环底层依赖的是迭代器(Iterator)
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		
		//1,普通for循环删除,索引要--
		/*for(int i = 0; i < list.size(); i++) {
			if("b".equals(list.get(i))) {
				list.remove(i--);							//通过索引删除元素
			}
		}*/
		
		//2,迭代器删除
		/*Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			if("b".equals(it.next())) {
				//list.remove("b");							//不能用集合的删除方法,因为迭代过程中如果集合修改会出现并发修改异常
				it.remove();
			}
		}*/
		
		/*for(Iterator<String> it2 = list.iterator(); it2.hasNext();) {
			if("b".equals(it2.next())) {
				//list.remove("b");							//不能用集合的删除方法,因为迭代过程中如果集合修改会出现并发修改异常
				it2.remove();
			}
		}*/
		//3,增强for循环,增强for循环不能删除,只能遍历
		for (String string : list) {
			if("b".equals(string)) {
				list.remove("b");
			}
		}
		System.out.println(list);
	}

	public static void demo2() {
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("张三", 23));
		list.add(new Person("李四", 24));
		list.add(new Person("王五", 25));
		list.add(new Person("赵六", 26));
		
		for (Person person : list) {
			System.out.println(person);
		}
	}

	public static void demo1() {
		int[] arr = {11,22,33,44,55};
		for (int i : arr) {
			System.out.println(i);
		}
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		for (String string : list) {
			System.out.println(string);
		}
	}

}
