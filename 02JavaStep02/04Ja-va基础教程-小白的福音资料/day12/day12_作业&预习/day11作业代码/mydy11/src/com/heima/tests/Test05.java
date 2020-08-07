package com.heima.tests;

import com.heima.domain.Student;

/**
 * 测试Student类
 * @author JX
 *
 */
public class Test05 {
	public static void main(String[] args) {
		//1.利用空参构造创建对象
		Student s1 = new Student();
		//2.利用set方法给对象属性赋值
		s1.setName("杨过");
		s1.setAge(20);
		s1.setGender("男");
		s1.setScore(95);
		//3.利用get方法打印学生对象对象属性,这里设置的打印格式和toString的格式一样
		System.out.println("Student [name="+s1.getName()+", gender="+s1.getGender()+", age="+s1.getAge()+", score="+s1.getScore()+"]");
		//4.利用tostring打印学生对象信息
		System.out.println(s1.toString());
		System.out.println("==========================================");
		//5.利用有参构造创建对象
		Student s2 = new Student("小龙女","女",35,80);
		//6.利用hashCode方法计算两个学生对象的hashCode值，并打印
		int hashCode1 = s1.hashCode();
		int hashCode2 = s2.hashCode();
		System.out.println("对象s1的hashCode值为："+hashCode1+",对象s2的hashCode值为："+hashCode2);
		//7.利用equals方法判断两个对象是否相同，并打印
		boolean b = s1.equals(s2);
		System.out.println("对象s1和对象s2是"+(b?"相同":"不同")+"的");
	}
}
