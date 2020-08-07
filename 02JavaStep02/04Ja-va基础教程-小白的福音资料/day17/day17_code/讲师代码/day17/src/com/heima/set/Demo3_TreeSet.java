package com.heima.set;

import java.util.Comparator;
import java.util.TreeSet;

import com.heiam.bean.Person;

public class Demo3_TreeSet {

	/**
	 * @param args
	 * TreeSet集合是用来对象元素进行排序的,同样他也可以保证元素的唯一
	 * 当compareTo方法返回0的时候集合中只有一个元素
	 * 当compareTo方法返回正数的时候集合会怎么存就怎么取
	 * 当compareTo方法返回负数的时候集合会倒序存储
	 */
	public static void main(String[] args) {
		//demo1();
		//demo2();
		//demo3();
		//demo4();
		//需求:将字符串按照长度排序
		TreeSet<String> ts = new TreeSet<>(new CompareByLen());		//Comparator c = new CompareByLen();
		ts.add("aaaaaaaa");
		ts.add("z");
		ts.add("wc");
		ts.add("nba");
		ts.add("cba");
		
		System.out.println(ts);
	}

	public static void demo4() {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("zhangsan", 23));
		ts.add(new Person("lisi", 13));
		ts.add(new Person("wangwu", 33));
		ts.add(new Person("zhaoliu", 43));
		ts.add(new Person("aaaa", 53));
		
		System.out.println(ts);
	}

	public static void demo3() {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("李四", 13));
		ts.add(new Person("张三", 23));
		ts.add(new Person("王五", 43));
		ts.add(new Person("赵六", 33));
		
		System.out.println('张' + 0);
		System.out.println('李' + 0);
		System.out.println('王' + 0);
		System.out.println('赵' + 0);
		
		System.out.println(ts);
	}

	public static void demo2() {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("张三", 23));
		ts.add(new Person("李四", 13));
		ts.add(new Person("周七", 13));
		ts.add(new Person("王五", 43));
		ts.add(new Person("赵六", 33));
		
		System.out.println(ts);
	}

	public static void demo1() {
		TreeSet<Integer> ts = new TreeSet<>();
		ts.add(3);
		ts.add(1);
		ts.add(1);
		ts.add(2);
		ts.add(2);
		ts.add(3);
		ts.add(3);
		
		System.out.println(ts);
	}

}


class CompareByLen /*extends Object*/ implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {		//按照字符串的长度比较
		int num = s1.length() - s2.length();		//长度为主要条件
		return num == 0 ? s1.compareTo(s2) : num;	//内容为次要条件
	}
	
}