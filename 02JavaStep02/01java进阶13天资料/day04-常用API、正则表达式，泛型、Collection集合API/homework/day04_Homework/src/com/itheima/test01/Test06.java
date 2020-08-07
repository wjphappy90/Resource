package com.itheima.test01;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 练习Collection的add,remove,clear,size方法
 */
public class Test06 {

	public static void main(String[] args) {
		// 1.创建Colection对象.Collection是接口.所以创建子类ArrayList对象
		Collection<String> coll = new ArrayList<String>();

		// 2.往集合中添加对象元素
		coll.add("itcast1");
		coll.add("itcast2");
		coll.add("itcast3");

		// 3.删除元素
		coll.remove("itcast2");

		// 4.获取集合大小
		System.out.println(coll.size());

		// 5.清空集合
		coll.clear();

		// 6.输出集合内容
		System.out.println(coll);
	}

}

