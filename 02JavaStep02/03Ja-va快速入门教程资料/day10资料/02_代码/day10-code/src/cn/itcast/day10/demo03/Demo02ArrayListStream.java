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
public class Demo02ArrayListStream {
	
	public static void main(String[] args) {
		// 首先创建一个集合，然后放入指定格式的字符串
		ArrayList<String> recordList = new ArrayList<>();
		recordList.add("赵丽颖,98");
		recordList.add("鹿晗,95");
		recordList.add("宋小宝,87");
		
		// Stream API更优写法！
		recordList.stream().map(s -> s.split(",")[1]).map(Integer::parseInt)
			.filter(n -> n > 90).forEach(System.out::println);
	}

}
