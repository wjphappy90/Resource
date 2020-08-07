package com.heima.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo6_Chinese {

	/**
	 * @param args
	 * * 字节流读取中文的问题
			* 字节流在读中文的时候有可能会读到半个中文,造成乱码 
		* 字节流写出中文的问题
			* 字节流直接操作的字节,所以写出中文必须将字符串转换成字节数组 
			* 写出回车换行 write("\r\n".getBytes());
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		FileOutputStream fos = new FileOutputStream("zzz.txt");
		fos.write("我读书少,你不要骗我".getBytes());
		fos.write("\r\n".getBytes());
		fos.close();
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("yyy.txt");
		byte[] arr = new byte[4];
		int len;
		while((len = fis.read(arr)) != -1) {
			System.out.println(new String(arr,0,len));
		}
		
		fis.close();
	}

}
