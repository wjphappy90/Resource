package cn.itcast.day08.demo01;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 如何才能实现换行的效果？
 * 换行其实也是一种字符，叫做“换行符”。
 * 
 * Windows当中的换行符是：\r\n	这叫做两个字符，一个是\r，一个是\n
 * macOS当中的换行符是：早期是\r，现在是\n
 * Linux当中的换行符是：\n
 */
public class Demo03FileWriterLine {
	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("file03.txt");
		fw.write("迪丽热巴\r\n");
		fw.write("\r\n"); // 代表一个Windows当中的换行符
		fw.write("古力娜扎");
		fw.close();
	}

}
