package com.heima.object;

import com.heima.bean.Student;

public class Demo1_HashCode {

	public static void main(String[] args) {
		Object object = new Object();
		int hashCode = object.hashCode();
		System.out.println(hashCode);

		Student s1 = new Student("张三", 23);
		Student s2 = new Student("李四", 24);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}
