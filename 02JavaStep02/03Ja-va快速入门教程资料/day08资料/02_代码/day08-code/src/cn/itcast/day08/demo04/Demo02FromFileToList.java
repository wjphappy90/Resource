package cn.itcast.day08.demo04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 题目：
 * 与上一题相反，将文件中的字符串文本读取到集合当中，并且每一行文本作为集合中的一个字符串元素。
 * 
 * 步骤：
 * 1. 需要读文件，那么可以使用：FileReader、BufferedReader
 * 2. 为了性能更高，最好用谁：BufferedReader（只有BufferedReader才有）
 * 3. 需要有一个集合来存放读取出来的字符串：ArrayList<String>
 * 4. 读取一行：readLine
 * 5. 将读到的字符串添加到集合当中：add
 * 6. 上述4-5步骤是一个循环的过程，读取得到null就要停止。
 * 7. 关闭流。
 * 8. 遍历集合，查看所有字符串元素的内容。
 */
public class Demo02FromFileToList {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("练习1.txt"));
		ArrayList<String> list = new ArrayList<>();
		
		String line; // 代表一行字符串
		while ((line = br.readLine()) != null) {
			list.add(line); // 将读取得到的一行字符串绝蛮王到集合当中
		}
		br.close(); // 关闭流
		// 遍历集合
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
