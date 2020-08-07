package cn.itcast.day10.demo03;

import java.util.ArrayList;

/*
 * 题目：
 * 有一个集合里面存放的字符串，样子如："赵丽颖,98"、"鹿晗,95"、"宋小宝, 87"
 * 要求打印输出所有成绩当中大于90分的数字。
 * 
 * 分析：
 * 1. 首先定义一个集合ArrayList，存入指定格式的若干个字符串。
 * 2. 我们只想要逗号后面的，那么就要分割字符串：split，然后取用结果数组当中的1号元素
 * 3. 根据字符串切割出来的"98"仍然是一个String，需要转换成为int：Integer.parseInt静态方法
 * 4. 要判断一下转换之后的int是不是大于90，筛选
 * 5. 对筛选之后的最终结果进行打印输出。
 */
public class Demo01ArrayList {
	
	public static void main(String[] args) {
		// 首先创建一个集合，然后放入指定格式的字符串
		ArrayList<String> recordList = new ArrayList<>();
		recordList.add("赵丽颖,98");
		recordList.add("鹿晗,95");
		recordList.add("宋小宝,87");
		
		// 应该拆分一下每个字符串，只要逗号后面的
		ArrayList<String> scoreList = new ArrayList<>(); // 保存的多个字符串是："98"、"95"、"87"
		for (int i = 0; i < recordList.size(); i++) {
			String record = recordList.get(i); // 当前字符串："赵丽颖,98"
			String[] array = record.split(",");
			String score = array[1]; // "98"
			scoreList.add(score);
		}
		
		
		// 将字符串"98"转换成为int数字98
		ArrayList<Integer> numList = new ArrayList<>(); // 保存的多个数字是：98、95、87
		for (int i = 0; i < scoreList.size(); i++) {
			String score = scoreList.get(i); // "98"
			int num = Integer.parseInt(score);
			numList.add(num);
		}
		
		// 过滤一下，筛选，只要大于90的，小于等于90的不要
		ArrayList<Integer> resultList = new ArrayList<>(); // 最终结果集合
		for (int i = 0; i < numList.size(); i++) {
			int num = numList.get(i); // 98
			if (num > 90) {
				resultList.add(num);
			}
		}
		
		// 最后遍历最终结果集合，打印输出
		for (int i = 0; i < resultList.size(); i++) {
			int result = resultList.get(i);
			System.out.println(result);
		}
	}

}
