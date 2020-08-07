package com.heima.tests;

import java.util.ArrayList;
import java.util.List;

import com.heima.domain.Person;

/**
 * 1.分析以下需求，并用代码实现：
 *	(1)定义一个临时变量, 记住其中一个元素
 *	(2)思路
 *		a.定义一个临时变量, 记住其中一个元素
 *		b.用第一个位置存放第二个位置上的元素
 *		c.用第二个位置存放临时变量记住的元素
 * @author JX
 *
 */
public class Test01 {
	public static void main(String[] args) {
		//测试集合中存入字符串
		ArrayList<String> al = new ArrayList<>();
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("d");
		System.out.println(al);
		swap(al,0,3);
		System.out.println(al);
		//测试集合中存入自定义对象
		ArrayList<Person> al2 = new ArrayList<>();
		al2.add(new Person("zs", 20));
		al2.add(new Person("ls", 30));
		al2.add(new Person("ww", 10));
		al2.add(new Person("zl", 40));
		al2.add(new Person("kw", 22));
		System.out.println("------------------");
		System.out.println(al2);
		swap(al2,0,4);
		System.out.println(al2);
	}
	
	//定义一个带泛型的方法
	public static void swap(List list,int index1,int index2) {
		//1.获取list集合中索引为index1的值
		Object obj = list.get(index1);
		//2.将集合中索引index1位置设置为索引index2的值
		list.set(index1, list.get(index2));
		//3.将集合index2位置设置为t
		list.set(index2, obj);
	}
	
	//定义一个带泛型的方法
	public static <T> void swap2(List<T> list,int index1,int index2) {
		//1.获取list集合中索引为index1的值
		T t = list.get(index1);
		//2.将集合中索引index1位置设置为索引index2的值
		list.set(index1, list.get(index2));
		//3.将集合index2位置设置为t
		list.set(index2, t);
	}
}
