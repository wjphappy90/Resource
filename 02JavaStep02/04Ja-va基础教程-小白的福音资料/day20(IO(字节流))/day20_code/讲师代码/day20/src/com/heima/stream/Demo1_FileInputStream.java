package com.heima.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo1_FileInputStream {

	/**
	 * @param args
	 * @throws IOException  
	 * read()方法读取的是一个字节,为什么返回是int,而不是byte
	 * 
	 * 00010100 00100100 01000001 11111111 0000000
	 * 
	 * 10000001    byte类型-1的原码
	 * 11111110	   -1的反码
	 * 11111111    -1的补码
	 * 
	 * 00000000 00000000 00000000 11111111
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		FileInputStream fis = new FileInputStream("xxx.txt");	//创建流对象
		int b;
		while((b = fis.read()) != -1) {
			System.out.println(b);
		}
		
		fis.close();
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");	//创建流对象
		int x = fis.read();										//从硬盘上读取一个字节
		System.out.println(x);
		int y = fis.read();
		System.out.println(y);
		int z = fis.read();
		System.out.println(z);
		int a = fis.read();
		System.out.println(a);
		int b = fis.read();
		System.out.println(b);
		fis.close();											//关流释放资源
	}

}
