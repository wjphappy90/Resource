package com.heima.chario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo1_FileReader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		FileReader fr = new FileReader("xxx.txt");
		int c;
		
		while((c = fr.read()) != -1) {					//通过项目默认的码表一次读取一个字符
			System.out.print((char)c);
		}
		
		fr.close();
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("xxx.txt");
		int x = fr.read();
		System.out.println(x);
		char c = (char)x;
		System.out.println(c);
		fr.close();
	}

}
