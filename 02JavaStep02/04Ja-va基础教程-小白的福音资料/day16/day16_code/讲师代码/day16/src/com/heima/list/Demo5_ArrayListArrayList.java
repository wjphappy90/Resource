package com.heima.list;

import java.util.ArrayList;

import com.heima.bean.Person;

public class Demo5_ArrayListArrayList {

	/**
	 * * A:案例演示
	 * 集合嵌套之ArrayList嵌套ArrayList
	 * 案例:
	 * 我们学科,学科又分为若个班级
	 * 整个学科一个大集合
	 * 若干个班级分为每一个小集合
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Person>> list = new ArrayList<>();
		
		ArrayList<Person> first = new ArrayList<>();				//创建第一个班级
		first.add(new Person("杨幂", 30));
		first.add(new Person("李冰冰", 33));
		first.add(new Person("范冰冰", 20));
		
		ArrayList<Person> second = new ArrayList<>();
		second.add(new Person("黄晓明", 31));
		second.add(new Person("赵薇", 33));
		second.add(new Person("陈坤", 32));
		
		//将班级添加到学科集合中
		list.add(first);
		list.add(second);
		
		//遍历学科集合
		for(ArrayList<Person> a : list) {
			for(Person p : a) {
				System.out.println(p);
			}
		}
	}

}
