package com.heima.debug;

public class Demo1 {

  /**
	* 
	* 如何查看程序执行流程		
	* 什么是断点：
		* 就是一个标记，从哪里开始。
	* 如何设置断点：
		* 你想看哪里的程序，你就在那个有效程序的左边双击即可。
	* 在哪里设置断点：
		* 哪里不会点哪里。
		* 目前：我们就在每个方法的第一条有效语句上都加。
	* 如何运行设置断点后的程序：
		* 右键 -- Debug as -- Java Application
	* 看哪些地方：
		* Debug：断点测试的地方
		* 在这个地方，记住F6，或者点击也可以。一次看一行的执行过程。
		* Variables：查看程序的变量变化
		* ForDemo：被查看的源文件
		* Console：控制台
	* 如何去断点：
		* a:再次双击即可
		* b:找到Debug视图，Variables界面，找到Breakpoints，并点击，然后看到所有的断点，最后点击那个双叉
    */
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i < 6; i++) {
			sum = sum + i;
		}
		
		System.out.println(sum);

	}

}
