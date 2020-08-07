package cn.itcast.day05.demo01;

import java.util.Scanner; // 一定要写在package后面

/*
 * 题目：键盘输入两个int数字，定义一个方法，求出其中的最大值。
 * 
 * 步骤：
 * 1. 键盘输入就用Scanner（导包、创建、使用）
 * 2. 定义方法的三要素
 * 返回值类型：最终结果一定是int类型
 * 方法名称：getMax
 * 参数列表：两个int类型
 * 3. 调用方法，得到返回值（最终结果最大值）。
 * 4. 打印最终结果。
 * 
 * 注意事项：
 * 对于有返回值的方法，必须保证有且仅有一个return会被执行。
 */
public class Demo07MethodMax {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 创建
		
		System.out.println("请输入第一个数字：");
		int a = sc.nextInt();
		System.out.println("请输入第二个数字：");
		int b = sc.nextInt();
		
		// 调用方法，获取返回值结果
		int max = getMax(a, b);
		System.out.println("最大值：" + max);
	}
	
	public static int getMax(int x, int y) {
//		int max; // 最大值结果
//		if (x > y) {
//			max = x;
//		} else {
//			max = y;
//		}
//		return max;
		
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}

}
