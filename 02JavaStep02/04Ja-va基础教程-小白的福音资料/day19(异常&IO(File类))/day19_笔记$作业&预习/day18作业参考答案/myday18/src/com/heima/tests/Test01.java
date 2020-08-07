package com.heima.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.heima.domain.Student;

/**
 * 1.分析以下需求，并用代码实现：
 *	(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)
 *	(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
 *	(3)利用四种方式遍历Map集合中的内容，格式：key::value
 * @author JX
 *
 */
public class Test01 {
	public static void main(String[] args) {
		// 1.定义HashMap集合,键为Student对象,值为String类型的对象,表示地址
		HashMap<Student, String> map = new HashMap<>();
		map.put(new Student("张三", 20), "北京");
		map.put(new Student("李四", 20), "南京");
		map.put(new Student("王五", 20), "上海");
		map.put(new Student("赵六", 20), "广州");
		map.put(new Student("孙七", 20), "深圳");

		// 遍历方式一:增强for循环(entrySet)
		for (Map.Entry<Student, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}
		
		//遍历方式二:增强for循环(keySet)
		System.out.println("-----------------------------------------");
		for(Student student :map.keySet()) {
			String address = map.get(student);
			System.out.println(student+"::"+address);
		}
		
		// 遍历方式三:迭代器(通过entrySet())
		System.out.println("-----------------------------------------");
		Set<Map.Entry<Student, String>> set = map.entrySet();
		Iterator<Map.Entry<Student, String>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<Student, String> entry = it.next();
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}

		// 遍历方式四:迭代器(通过keySet())
		System.out.println("-----------------------------------------");
		Set<Student> keySet = map.keySet();
		Iterator<Student> it2 = keySet.iterator();
		while(it2.hasNext()) {
			Student student = it2.next();
			String address = map.get(student);
			System.out.println(student+"::"+address);
		}

	}
}
