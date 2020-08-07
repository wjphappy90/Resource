package cn.itcast.day07.demo03;

import java.util.ArrayList;

/*
 * 题目：遍历集合当中的所有字符串对象。
 */
public class Demo03ArrayListEach {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		// 添加：add
		list.add("迪丽热巴");
		list.add("古力娜扎");
		list.add("玛尔扎哈");
		
		System.out.println(list);
		
		// 遍历输出每一个字符串对象
		// 集合的长度获取：size()
		for (int i = 0; i < list.size(); i++) {
			// 获取一个当前元素：get(int)
			String name = list.get(i);
			System.out.println(name);
		}
	}

}
