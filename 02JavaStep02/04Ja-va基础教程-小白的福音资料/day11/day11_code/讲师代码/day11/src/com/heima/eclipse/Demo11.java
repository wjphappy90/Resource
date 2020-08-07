package com.heima.eclipse;

import com.heima.animal.Cat;


public class Demo11 {
	/*  
	    * A:新建 ctrl + n
		* B:格式化  ctrl+shift+f
		* C:导入包  ctrl+shift+o 
		* D:注释  ctrl+/,ctrl+shift+/,ctrl+shift+\
		* E:代码上下移动 选中代码alt+上/下箭头
		* F:查看源码  选中类名(F3或者Ctrl+鼠标点击)
		* G:查找具体的类 ctrl + shift + t
		* H:查找具体类的具体方法 ctrl + o
		* I:给建议 ctrl+1,根据右边生成左边的数据类型,生成方法
		* J:删除代码 ctrl + d
		* K:抽取方法alt + shift + m 
		* L:改名alt + shift + r 
	*/

	public static void main(String[] args) {
		//demo2();
		//Student student = new Student("张三", 23);
		//System.out.println(student.getName() +"..."+ student.getAge());
		Cat cat = new Cat();
		cat.eat();
		cat.sleep();
	
	
	}

	private static void demo2() {
		int[] arr1 = { 11, 22, 33, 44, 55 };

		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		// Scanner scanner = new Scanner(System.in);

		int a = 10;
		int b = 20;
		int sum = add(a, b);
	}

	public static int add(int a, int b) {
		return a + b;
	}
}
