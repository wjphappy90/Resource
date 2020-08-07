package com.heima.test;

import java.util.HashSet;
import java.util.Random;

public class Test1 {

	/**
	 * * A:案例演示
	 * 需求：编写一个程序，获取10个1至20的随机数，要求随机数不能重复。并把最终的随机数输出到控制台。
	 * 
	 * 分析:
	 * 1,有Random类创建随机数对象
	 * 2,需要存储10个随机数,而且不能重复,所以我们用HashSet集合
	 * 3,如果HashSet的size是小于10就可以不断的存储,如果大于等于10就停止存储
	 * 4,通过Random类中的nextInt(n)方法获取1到20之间的随机数,并将这些随机数存储在HashSet集合中
	 * 5,遍历HashSet
	 */
	public static void main(String[] args) {
		//1,有Random类创建随机数对象
		Random r = new Random();
		//2,需要存储10个随机数,而且不能重复,所以我们用HashSet集合
		HashSet<Integer> hs = new HashSet<>();
		//3,如果HashSet的size是小于10就可以不断的存储,如果大于等于10就停止存储
		while(hs.size() < 10) {
			//4,通过Random类中的nextInt(n)方法获取1到20之间的随机数,并将这些随机数存储在HashSet集合中
			hs.add(r.nextInt(20) + 1);
		}
		// 5,遍历HashSet
		for (Integer integer : hs) {
			System.out.println(integer);
		}
		
	}

}
