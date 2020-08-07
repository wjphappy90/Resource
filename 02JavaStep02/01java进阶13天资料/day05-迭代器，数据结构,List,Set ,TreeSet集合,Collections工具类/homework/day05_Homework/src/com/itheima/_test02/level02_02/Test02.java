package com.itheima._test02.level02_02;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 自定义人类:包含姓名,年龄,身高属性.私有成员变量,生成无参,有参构造方法,生成get/set方法.
 * 创建5个人放到ArrayList中.使用迭代器获取每个人的信息.找出最高的人,最矮的人并输出最高人和最矮人的信息.
 * 打印格式如下:最高的人是张三,身高1.80. 最矮的人是李四,身高1.60
 */
public class Test02 {

	public static void main(String[] args) {
		// 2.定义ArrayList
		ArrayList<Person> persons = new ArrayList<>();

		// 3.添加5个学生
		persons.add(new Person("张三", 20, 1.66));
		persons.add(new Person("王昭君", 21, 1.65));
		persons.add(new Person("西施", 20, 1.70));
		persons.add(new Person("杨玉环", 20, 1.72));
		persons.add(new Person("凤姐", 22, 1.80));

		// 4.获取迭代器
		Iterator<Person> itr = persons.iterator();

		// 5.定义最高人
		Person maxHeightPerson = persons.get(0);
		// 6.定义最矮人
		Person minHeightPerson = persons.get(0);

		// 7.循环判断是否有下一个人
		while (itr.hasNext()) {
			// 8.使用next方法获取学生对象
			Person student = itr.next();

			// 9.判断这个人的的身高是否大于最大高度
			if (maxHeightPerson.getHeight() < student.getHeight()) {
				// 10.这个人的的身高大于最大高度.最大身高的人等于这个人
				maxHeightPerson = student;
			} else if (minHeightPerson.getHeight() > student.getHeight()) {
				// 11.判断这个人的的身高是否小于于最矮高度
				// 12.这个人的的身高小于于最矮高度.最矮身高的人等于这个人
				minHeightPerson = student;
			}
		}

		// 13.按照格式打印信息
		System.out.println("最高的人是" + maxHeightPerson.getName() + ",身高 " + maxHeightPerson.getHeight() + ". 最矮的人是"
				+ minHeightPerson.getName() + ",身高 " + minHeightPerson.getHeight());
	}

}
