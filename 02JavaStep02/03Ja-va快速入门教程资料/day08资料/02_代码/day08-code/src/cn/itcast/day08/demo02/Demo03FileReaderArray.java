package cn.itcast.day08.demo02;

import java.io.FileReader;
import java.io.IOException;

/*
 * 如果读取字符是一个一个地，那么效率很低。
 * 为了提高效率，FileReader提供了另外一种重载形式的read方法：
 * 
 * public int read(char[] buf)：一次读取整个字符数组的数据。
 * 参数是一个字符数组，用来承载读取到的多个字符。
 * 返回值代表的是数组当中读取到的有效个数。
 */
public class Demo03FileReaderArray {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file07.txt");
		
		char[] buf = new char[2]; // 这是一个一次性可以装两个字符的车，缓冲区
		
		int len = fr.read(buf);
		System.out.println("len=" + len); // 2，读取到了2个有效字符
		String str = new String(buf, 0, len); // 根据字符数组来创建一个字符串
		System.out.println("str=" + str); // he
		
		len = fr.read(buf);
		System.out.println("len=" + len); // 2，读取到了2个有效字符
		str = new String(buf, 0, len); // 根据字符数组来创建一个字符串
		System.out.println("str=" + str); // ll
		
		len = fr.read(buf);
		System.out.println("len=" + len); // 1，只读取到了1个有效字符
		str = new String(buf, 0, len); // 使用字符数组当中的【有效部分】来创建字符串
		System.out.println("str=" + str); // ol
		
		len = fr.read(buf);
		System.out.println("len=" + len); // -1，代表没有更多内容
		
		len = fr.read(buf);
		System.out.println("len=" + len); // -1，代表没有更多内容
		
		fr.close();
	}

}
