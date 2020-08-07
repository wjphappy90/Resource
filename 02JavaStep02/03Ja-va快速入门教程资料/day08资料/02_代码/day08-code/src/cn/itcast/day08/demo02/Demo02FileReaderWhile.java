package cn.itcast.day08.demo02;

import java.io.FileReader;
import java.io.IOException;

/*
 * 注意事项：
 * 每次调用read方法，都会尝试读取下一个新字符。
 * 
 * 扩展一点小技巧：
 * 如果一个int变量确实是一个文字对应的ASCII值，那么可以通过格式将其翻译成为文字：
 * (char) 变量名称
 */
public class Demo02FileReaderWhile {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file06.txt"); // 创建
		
		// 下面的错误！因为每次read方法执行，都会读取一个新字符，直到-1为止。
//		while (fr.read() != -1) {
//			System.out.println(fr.read());
//		}
		
		int ch; // 代表一个单个字符（对应的ASCII/Unicode）
		while ((ch = fr.read()) != -1) {
			System.out.println((char) ch);
		}
		
		// (x + y) > z
		
		fr.close(); // 关闭
	}
	
}
