package com.heima.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import com.heima.bean.BaseStudent;
import com.heima.bean.Student;

public class Demo2_Genric {

	/**
	 * 泛型固定下边界
	 * ? super E  
	 * 
	 * 泛型固定上边界
	 * ? extends E
	 */
	public static void main(String[] args) {
		//demo1();
		TreeSet<Student> ts1 = new TreeSet<>(new CompareByAge());
		ts1.add(new Student("张三", 33));
		ts1.add(new Student("李四", 13));
		ts1.add(new Student("王五", 23));
		ts1.add(new Student("赵六", 43));
		
		TreeSet<BaseStudent> ts2 = new TreeSet<>(new CompareByAge());
		ts2.add(new BaseStudent("张三", 33));
		ts2.add(new BaseStudent("李四", 13));
		ts2.add(new BaseStudent("王五", 23));
		ts2.add(new BaseStudent("赵六", 43));
		
		System.out.println(ts2);
	}

	public static void demo1() {
		ArrayList<Student> list1 = new ArrayList<>();
		list1.add(new Student("张三", 23));
		list1.add(new Student("李四", 24));
		
		ArrayList<BaseStudent> list2 = new ArrayList<>();
		list2.add(new BaseStudent("王五", 25));
		list2.add(new BaseStudent("赵六", 26));
		
		list1.addAll(list2);
	}

}

class CompareByAge implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int num = s1.getAge() - s2.getAge();
		return num == 0 ? s1.getName().compareTo(s2.getName()) :  num;
	}
	
}
