package com.heima.generic;

import java.util.ArrayList;
import java.util.Iterator;

import com.heima.bean.Person;

public class Demo1_Generic {

	/**
	 	* A:泛型概述
		* B:泛型好处
			* 提高安全性(将运行期的错误转换到编译期) 
			* 省去强转的麻烦
		* C:泛型基本使用
			* <>中放的必须是引用数据类型 
		* D:泛型使用注意事项
			* 前后的泛型必须一致,或者后面的泛型可以省略不写(1.7的新特性菱形泛型)  

	 */
	public static void main(String[] args) {
		//demo1();
		//int[] arr = new byte[5];							//数组要保证前后的数据类型一致
		//ArrayList<Object> list = new ArrayList<Person>();	//集合的泛型要保证前后的数据类型一致
		//ArrayList<Object> list = new ArrayList<>();		//1.7版本的新特性,菱形泛型
		ArrayList<Object> list = new ArrayList<>();			//泛型最好不要定义成Object,没有意义
		list.add("aaa");
		list.add(true);
	}

	public static void demo1() {
		ArrayList<Person> list = new ArrayList<Person>();
	//	list.add(110);
	//	list.add(true);
		list.add(new Person("张三", 23));
		list.add(new Person("李四", 24));
		
		Iterator<Person> it = list.iterator();
		while(it.hasNext()) {
			//System.out.println(it.next());
			
			//System.out.println(it.next().getName() + "..." + it.next().getAge());//next方法只能调用一次,如果调用多次会将指针向后移动多次
			Person p = it.next();			
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}

}
