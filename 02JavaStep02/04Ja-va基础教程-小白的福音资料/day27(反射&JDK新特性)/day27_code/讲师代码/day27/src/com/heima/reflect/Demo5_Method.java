package com.heima.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.heima.bean.Person;

public class Demo5_Method {

	/**
	 * Class.getMethod(String, Class...) 和 Class.getDeclaredMethod(String,
	 * Class...)方法可以获取类中的指定方法,调用invoke(Object,
	 * Object...)可以调用该方法,Class.getMethod("eat") invoke(obj)
	 * Class.getMethod("eat",int.class) invoke(obj,10)
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.heima.bean.Person");
		Constructor c = clazz.getConstructor(String.class,int.class);	//获取有参构造
		Person p = (Person) c.newInstance("张三",23);						//通过有参构造创建对象
		
		Method m = clazz.getMethod("eat");								//获取eat方法
		m.invoke(p);
		
		Method m2 = clazz.getMethod("eat", int.class);					//获取有参的eat方法
		m2.invoke(p, 10);
	}

}
