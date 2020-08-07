package cn.itcast.day04.demo03;

/*
 * 求出数组元素的总和。
 * 
 * 分析：
 * 1. 首先准备一个数组，并且赋一些元素值。
 * 2. 需要准备一个存钱罐，也就是定义一个变量，然后不断放入更多数据，累加。
 * 3. 数组元素每一个都要放入存钱罐当中，也就是逐一处理：for循环。
 * 4. 如何实现累加呢？+=
 */
public class Demo03ArraySum {
	
	public static void main(String[] args) {
		int[] array = new int[6]; // 长度固定，动态初始化
		// 例如王者荣耀当中，每个英雄可以买6件装备
		array[0] = 100; // 第一件装备，攻击力+100
		array[1] = 80; // 第二个简装，攻击力+80
		array[2] = 150; // 第三个简装，攻击力+150
		array[3] = 50; // 第四个简装，攻击力+50
		array[4] = 90; // 第五个简装，攻击力+90
		array[5] = 200; // 第六个简装，攻击力+200
		
		int sum = 0; // 存钱罐，不断向其中累加
		
		// 如何求出总攻击力？
		// 索引值从0-5，有规律，逐一、挨个儿处理，for循环
		for (int i = 0; i < array.length; i++) {
			// 将当前数组元素累加到sum当中
			sum += array[i];
		}
		
		System.out.println("总攻击力：" + sum);
	}

}
