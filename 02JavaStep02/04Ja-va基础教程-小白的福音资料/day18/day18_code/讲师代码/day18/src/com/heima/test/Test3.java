package com.heima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Test3 {

	/**
	 * * A:案例演示
	 * 模拟斗地主洗牌和发牌并对牌进行排序的代码实现
	 * 
	 *  分析:
	 * 1,买一副扑克,其实就是自己创建一个集合对象,将扑克牌存储进去
	 * 2,洗牌
	 * 3,发牌
	 * 4,看牌
	 */
	public static void main(String[] args) {
		//1,买一副扑克,其实就是自己创建一个集合对象,将扑克牌存储进去
		String[] num = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		String[] color = {"红桃","黑桃","方片","梅花"};
		HashMap<Integer, String> hm = new HashMap<>();					//存储索引和扑克牌
		ArrayList<Integer> list = new ArrayList<>();					//存储索引
		int index = 0;
		
		//拼接扑克牌并索引和扑克牌存储在hm中
		for(String s1 : num) {											//获取数字
			for(String s2 : color) {									//获取颜色
				hm.put(index, s2.concat(s1));
				list.add(index);										//将索引0到51添加到list集合中
				index++;
			}
		}
		//将小王添加到双列集合中
		hm.put(index, "小王");
		list.add(index);												//将52索引添加到集合中
		index++;
		hm.put(index, "大王");
		list.add(index);												//将52索引添加到集合中
		
		//2,洗牌
		Collections.shuffle(list);
		//3,发牌
		TreeSet<Integer> gaojin = new TreeSet<>();
		TreeSet<Integer> longwu = new TreeSet<>();
		TreeSet<Integer> me = new TreeSet<>();
		TreeSet<Integer> dipai = new TreeSet<>();
		
		for(int i = 0; i < list.size(); i++) {
			if(i >= list.size() - 3) {
				dipai.add(list.get(i));							//将三张底牌存储在底牌集合中
			}else if(i % 3 == 0) {
				gaojin.add(list.get(i));
			}else if(i % 3 == 1) {
				longwu.add(list.get(i));
			}else {
				me.add(list.get(i));
			}
		}
		
		//看牌
		lookPoker(hm, gaojin, "高进");
		lookPoker(hm, longwu, "龙五");
		lookPoker(hm, me, "冯佳");
		lookPoker(hm, dipai, "底牌");
	}
	/*
	 * 看牌
	 * 1,返回值类型void
	 * 2,参数列表HashMap,TreeSet,String name
	 */
	public static void lookPoker(HashMap<Integer, String> hm,TreeSet<Integer> ts ,String name) {
		System.out.print(name + "的牌是:");
		for(Integer i : ts) {						//i代表双列集合中的每一个键
			System.out.print(hm.get(i) + " ");
		}
		System.out.println();
	}
}
