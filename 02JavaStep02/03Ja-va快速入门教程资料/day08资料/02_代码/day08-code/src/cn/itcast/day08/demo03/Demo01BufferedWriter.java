package cn.itcast.day08.demo03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * BufferedWriter和FileWriter差不多，也是一种用来写文件的类，属于字符输出流。
 * 区别在于BufferedWriter肚子里有一个长度为8192的char[]字符数组，当作缓冲区使用。
 * 每次在写数据的时候，实际上都是在不断地向缓冲数组当中添加字符。
 * 如果缓冲数组已经满了，那么将会统一地写到硬盘的文件当中。
 * 如果还没有写满，那么就等待下一次写入。
 * 如果最终关闭流的时候，数组仍然没满，那么也会将剩余的有效部分写到硬盘文件里。
 * 
 * 如何使用BufferedWriter？
 * 1. 首先创建一个普通的FileWriter
 * 2. 将这个普通的FileWriter包装成为缓冲的BufferedWriter，用构造方法。
 * 3. 后面BufferedWriter使用的方法和FileWriter基本一样。
 * 
 * 构造方法：
 * public BufferedWriter(FileWriter fw)：参数就是一个普通的FileWriter对象。
 */
public class Demo01BufferedWriter {
	
	public static void main(String[] args) throws IOException {
		// 首先创建一个普通的FileWriter
		FileWriter fw = new FileWriter("file08.txt");
		// 将这个普通的FileWriter对象传递给BufferedWriter构造方法即可。
		BufferedWriter bw = new BufferedWriter(fw);
		// 后面bw的时候，和fw基本没有区别。
		bw.write("Hello");
		// 关闭流
		bw.close();
	}

}
