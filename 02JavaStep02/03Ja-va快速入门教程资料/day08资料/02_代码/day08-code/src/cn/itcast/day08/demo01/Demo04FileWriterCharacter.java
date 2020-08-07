package cn.itcast.day08.demo01;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 计算机当中一切都是数字，文本文件当中其实保存的就是数字，
 * 能够看到文字图形，是因为软件帮我们进行了翻译，翻译的规则就是：
 * ASCII码表，还有另外一张更大的表叫做Unicode码表。
 * 后者包含了全世界所有数以万计的文字。
 * 
 * FileWriter提供了一种重载形式的write方法，可以直接根据数字写文件。
 * public void write(int ch)：参数就是单个文字所对应的数字值
 */
public class Demo04FileWriterCharacter {
	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("file04.txt");
		
		fw.write("Hello");
		fw.write(20013); // 代表“中”
		fw.write("国");
		fw.close();
	}

}
