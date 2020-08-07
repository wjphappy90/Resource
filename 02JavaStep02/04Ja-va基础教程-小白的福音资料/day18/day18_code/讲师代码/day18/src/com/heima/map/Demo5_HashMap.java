package com.heima.map;

import java.util.HashMap;

import com.heima.bean.Student;

public class Demo5_HashMap {
	/*
	 * * A:案例演示
	 * HashMap集合键是Student值是String的案例
	 * 键是学生对象,代表每一个学生
	 * 值是字符串对象,代表学生归属地
	 */
	public static void main(String[] args) {
		HashMap<Student, String> hm = new HashMap<>();
		hm.put(new Student("张三", 23), "北京");
		hm.put(new Student("张三", 23), "上海");
		hm.put(new Student("李四", 24), "广州");
		hm.put(new Student("王五", 25), "深圳");
		
		System.out.println(hm);
	}
}
