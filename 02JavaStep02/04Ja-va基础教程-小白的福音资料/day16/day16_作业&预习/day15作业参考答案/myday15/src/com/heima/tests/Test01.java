package com.heima.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/**
 * 1.分析以下需求，并用代码实现：
 *	(1)生成10个1至100之间的随机整数(不能重复)，存入一个List集合(可以先不适用泛型，泛型明天讲)
 *	(2)编写方法对List集合进行排序,禁用Collections.sort方法和TreeSet
 *	(2)然后利用迭代器遍历集合元素并输出
 *	(3)如：15 18 20 40 46 60 65 70 75 91
 * @author JX
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List<Integer> list = getRandomNum();
		sort(list);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
	
	//生成10个1-100的随机数
	public static List<Integer> getRandomNum() {
		//1.创建ArrayList集合存放生成的随机数
		List<Integer> list = new ArrayList<Integer>();
		//2.创建Random对象,用于生成随机数
		Random r = new Random();
		//3.将生成的5个随机数存入list集合中
		while(list.size()<10) {
			int num = r.nextInt(100)+1;
			//去重
			if(!list.contains(num)) {
				list.add(num);
			}
		}
		return list;
	}
	//对List集合中的数字进行从小到大的排序
	public static void sort(List<Integer> list) {
		//1.将list集合转成Integer类型的数组
		Integer[] arr = list.toArray(new Integer[list.size()]);
		//2.定义冒泡排序算法
		for(int i = 0;i<arr.length-1;i++) {
			for(int j = 0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {//3.自动拆箱
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		//4.将排序后数组中的元素重新放入集合中
		for(int i = 0;i<arr.length;i++) {
			list.set(i, arr[i]);
		}
	}
}
