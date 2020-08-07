package com.heima.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test2 {

	/**
	 * * 已知一个类，定义如下： 
	 * package cn.itcast.heima;
	 * 		public class DemoClass {
				public void run() {
					System.out.println("welcome to heima!");
				}
			}
	 * (1) 写一个Properties格式的配置文件，配置类的完整名称。 
	 * (2) 写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，用反射的方式运行run方法。
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("xxx.properties"));	//创建输入流关联xxx.properties
		Class clazz = Class.forName(br.readLine());									//读取配置文件中类名,获取字节码对象
		
		DemoClass dc = (DemoClass) clazz.newInstance();								//通过字节码对象创建对象
		dc.run();
	}

}
