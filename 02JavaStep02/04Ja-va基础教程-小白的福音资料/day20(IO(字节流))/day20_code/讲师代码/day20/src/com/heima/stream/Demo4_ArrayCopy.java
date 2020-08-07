package com.heima.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4_ArrayCopy {

	/**
	 * @param args
	 * 第三种拷贝
	 * 定义小数组
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		//demo2();
		FileInputStream fis = new FileInputStream("致青春.mp3");
		FileOutputStream fos = new FileOutputStream("copy.mp3");
		
		byte[] arr = new byte[1024 * 8];
		int len;
		while((len = fis.read(arr)) != -1) {				//如果忘记加arr,返回的就不是读取的字节个数,而是字节的码表值
			fos.write(arr,0,len);
		}
		
		fis.close();
		fos.close();
	}

	public static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");
		FileOutputStream fos = new FileOutputStream("yyy.txt");
		
		byte[] arr = new byte[2];
		int len;
		while((len = fis.read(arr)) != -1) {
			fos.write(arr,0,len);
		}
		
		fis.close();
		fos.close();
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("xxx.txt");
		byte[] arr = new byte[2];
		int a = fis.read(arr);						//将文件上的字节读取到字节数组中
		
		System.out.println(a);						//读到的有效字节个数
		for (byte b : arr) {						//第一次获取到文件上的a和b
			System.out.println(b);
		}
		System.out.println("-----------------------");
		int c = fis.read(arr);
		System.out.println(c);
		for (byte b : arr) {
			System.out.println(b);
		}
		fis.close();
	}

}
