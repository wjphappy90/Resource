package cn.itcast.day08.demo02;

import java.io.FileReader;
import java.io.IOException;

public class Demo04FileReaderArrayWhile {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file07.txt");
		
		char[] buf = new char[2];
		int len; // 代表有效个数
		while ((len = fr.read(buf)) != -1) {
			String str = new String(buf, 0, len);
			System.out.println(str);
		}
		
		fr.close();
	}

}
