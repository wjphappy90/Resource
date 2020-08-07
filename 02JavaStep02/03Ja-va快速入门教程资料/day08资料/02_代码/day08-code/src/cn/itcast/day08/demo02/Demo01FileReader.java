package cn.itcast.day08.demo02;

import java.io.FileReader;
import java.io.IOException;

/*
 * FileReader用来将文本文件当中的字符读取到程序当中。
 * 
 * 使用的步骤：
 * 1. 导包
 * import java.io.FileReader;
 * 
 * 2. 创建，构造方法：
 * public FileReader(String fileName)：参数仍然是文件的路径名。
 * FileReader fr = new FileReader("fileXxx.txt");
 * 如果指定的文件名对应的文件不存在，那么将会直接报错。
 * 
 * 3. 使用，成员方法：
 * 读取单个字符：public int read()：读取下一个字符，得到对应的ASCII或Unicode值。
 * 关闭释放资源：public void close()
 * 
 * 使用FileReader的步骤也是三个字：创、读、关。
 */
public class Demo01FileReader {
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file06.txt"); // 创建
		
		// 返回值是读取到的单个字符，对应的ASCII或者是Unicode数值
		int ch = fr.read();
		System.out.println(ch); // 97, a
		
		ch = fr.read();
		System.out.println(ch); // 98, b
		
		ch = fr.read();
		System.out.println(ch); // 99, c
		
		ch = fr.read();
		System.out.println(ch); // -1，代表没有更多字符可以读取
		
		ch = fr.read();
		System.out.println(ch); // -1，代表没有更多字符可以读取
		
		fr.close(); // 关闭
	}
	
}
