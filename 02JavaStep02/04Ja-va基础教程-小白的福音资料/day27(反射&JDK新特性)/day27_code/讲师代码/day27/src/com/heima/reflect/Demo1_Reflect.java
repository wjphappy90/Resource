package com.heima.reflect;

import com.heima.bean.Person;

public class Demo1_Reflect {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = Class.forName("com.heima.bean.Person");
		Class clazz2 = Person.class;
		
		Person p = new Person();
		Class clazz3 = p.getClass();
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
	}

}
