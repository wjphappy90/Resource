package cn.itcast.day08.demo03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * BufferedReader额外提供了一个方法，可以读取一整行字符串。
 * 
 * public String readLine()：读取一整行字符串，返回值当中不包含换行符。
 */
public class Demo04ReadLine {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file11.txt");
		BufferedReader br = new BufferedReader(fr);
		
//		String line = br.readLine();
//		System.out.println(line); // Hello
//		
//		line = br.readLine();
//		System.out.println(line); // World
//		
//		line = br.readLine();
//		System.out.println(line); // Java
//		
//		line = br.readLine();
//		System.out.println(line); // null
//		System.out.println(line == null); // true
		
		String line; // 代表一行字符串
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
	}

}
