package cn.itcast.day04.demo02;

/*
 * 无论动态还是静态初始化，数组都具有长度。如何才能获取长度呢？
 * 格式：
 * 数组名称.length
 * 将会得到一个int数字，代表数组的长度。
 * 
 * 【注意】
 * 一个数组一旦在内存当中被创建了，那么数组的长度就不能发生改变。
 */
public class Demo04ArrayLength {
	
	public static void main(String[] args) {
		// 静态初始化
		int[] arrayA = { 3, 6, 4, 8, 6, 9, 3, 7, 3, 10, 100 };
		System.out.println(arrayA.length); // 11
		
		// 动态初始化
		int[] arrayB = new int[25];
		int len = arrayB.length;
		System.out.println(len); // 25
	}

}
