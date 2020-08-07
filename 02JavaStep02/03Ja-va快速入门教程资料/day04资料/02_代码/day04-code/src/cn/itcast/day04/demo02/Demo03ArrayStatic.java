package cn.itcast.day04.demo02;

/*
 * 数组在初始化的时候，还有另外一种方式：静态初始化。
 * 
 * 静态初始化不会直接指定长度，而是直接指定具体的元素内容。
 * 标准格式：
 * 数据类型[] 数组名称 = new 数据类型[] { 元素1, 元素2, 元素3, ... };
 * 
 * 标准格式也可以拆分成为两个步骤：
 * 数据类型[] 数组名称;
 * 数组名称 = new 数据类型[] {...};
 * 
 * 简便格式：
 * 数据类型[] 数组名称 = { 元素1, 元素2, 元素3, ... };
 * 一旦使用了简便格式，必须一个步骤完成初始化，不能拆分成为两个步骤。
 * 
 * 注意事项：
 * 1. 虽然静态初始化没有指定长度，但是仍然可以根据具体元素的个数自动推算出来长度。
 * 2. 虽然简便格式当中可以不写new...，但是仍然有内存当中开辟空间的过程。
 * 3. 虽然直接指定了具体元素内容，但是仍然会有默认值被替换的过程。
 */
public class Demo03ArrayStatic {
	
	public static void main(String[] args) {
		// 动态初始化
		int[] arrayA = new int[3];
		arrayA[0] = 10;
		arrayA[1] = 20;
		arrayA[2] = 30;
		System.out.println(arrayA[0]); // 10
		System.out.println(arrayA[1]); // 20
		System.out.println(arrayA[2]); // 30
		System.out.println("=================");
		
		// 静态初始化，一个步骤：
		int[] arrayB = new int[] { 15, 25, 35 };
		System.out.println(arrayB); // 地址值
		System.out.println(arrayB[0]); // 15
		System.out.println(arrayB[1]); // 25
		System.out.println(arrayB[2]); // 35
		System.out.println("=================");
		
		// 静态初始化，两个步骤也可以：
		int[] arrayC;
		arrayC = new int[] { 13, 23, 33 };
		System.out.println(arrayC[0]); // 13
		System.out.println(arrayC[1]); // 23
		System.out.println(arrayC[2]); // 33
		System.out.println("=================");
		
		// 简便格式，必须使用一个步骤一次到位
		int[] arrayD = { 16, 26, 36 };
		System.out.println(arrayD[0]); // 16
		System.out.println(arrayD[1]); // 26
		System.out.println(arrayD[2]); // 36
		System.out.println("=================");
		
		// 错误写法！简便格式的静态初始化不能拆分成为两个步骤！
//		int[] arrayE;
//		arrayE = { 10, 20, 30 };
	}

}
