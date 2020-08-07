package cn.itcast.day08.demo01;

import java.io.FileWriter;
import java.io.IOException;

/*
 * FileWriter当中写数据的方法write有5种重载形式：
 * 
 * public void write(int ch)：参数是单个文字对应的数字（参考ASCII或者Unicode表）
 * public void write(String str)：写一个完整的字符串。
 * public void write(String str, int offset, int count)：写字符串当中的一部分内容。
 * public void write(char[] array)：写一个完整的字符数组。
 * public void write(char[] array, int offset, int count)：写字符数组当中的一部分内容。
 */
public class Demo05FileWriterOverload {
	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("file05.txt");
		
		// 写单个字符
		fw.write(65); // A
		fw.write(66); // B
		fw.write(67); // C
		fw.write(48); // 0
		fw.write(97); // a
		// ===================
		
		// 写一个完整的字符串
		fw.write("World\r\n");
		fw.write("Hello");
		// ===================
		
		// 写一个字符串当中的部分内容
		String str = "生前何必久睡，死后自会长眠。";
		fw.write(str, 7, 6); // 死后自会长眠
		// ===================
		
		char[] array = { 'J', 'a', 'v', 'a', '!' };
		// 写一个完整的字符数组
		fw.write(array);
		
		// 写一个字符数组的部分内容
		fw.write(array, 1, 3);
		
		fw.close();
	}

}
