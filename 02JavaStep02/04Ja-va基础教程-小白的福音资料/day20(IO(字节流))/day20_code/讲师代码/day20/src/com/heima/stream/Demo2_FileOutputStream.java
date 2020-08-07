package com.heima.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2_FileOutputStream {

	/**
	 * @param args
	 * @throws IOException 
	 * FileOutputStream在创建对象的时候是如果没有这个文件会帮我创建出来
	 * 如果有这个文件就会先将文件清空
	 */
	public static void main(String[] args) throws IOException {
		//demo1();
		FileOutputStream fos = new FileOutputStream("yyy.txt",true);	//如果想续写就在第二个参数传true
		fos.write(97);
		fos.write(98);
		
		fos.close();
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("yyy.txt");		//创建字节输出流对象,如果没有就自动创建一个
		//fos.write(97);				//虽然写出的是一个int数,但是到文件上的是一个字节,会自动去除前三个8位
		//fos.write(98);
		//fos.write(99);
		fos.write(100);
		fos.close();
	}

}
