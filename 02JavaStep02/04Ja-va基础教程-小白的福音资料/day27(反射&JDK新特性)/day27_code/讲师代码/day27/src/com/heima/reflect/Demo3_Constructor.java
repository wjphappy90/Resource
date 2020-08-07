package com.heima.reflect;

import java.lang.reflect.Constructor;

import com.heima.bean.Person;

public class Demo3_Constructor {

	/**
	 * Class类的newInstance()方法是使用该类无参的构造函数创建对象, 如果一个类没有无参的构造函数,
	 * 就不能这样创建了,可以调用Class类的getConstructor
	 * (String.class,int.class)方法获取一个指定的构造函数然后再调用Constructor类的newInstance
	 * ("张三",20)方法创建对象
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.heima.bean.Person");
		//Person p = (Person) clazz.newInstance();				通过无餐构造创建对象
		//System.out.println(p);
		Constructor c = clazz.getConstructor(String.class,int.class);	//获取有参构造
		Person p = (Person) c.newInstance("张三",23);						//通过有参构造创建对象
		System.out.println(p);
	}

}
