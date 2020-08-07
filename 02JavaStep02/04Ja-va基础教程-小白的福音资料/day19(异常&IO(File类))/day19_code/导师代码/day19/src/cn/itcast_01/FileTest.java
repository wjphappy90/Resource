package cn.itcast_01;

import java.io.File;
import java.io.IOException;

/*
 * 需求: 如果我们想在指定盘符下面的“hello\\world\\Java”
 * 这个目录中创建文件a.txt, 那么该如何实现?
 */
public class FileTest {
	public static void main(String[] args) throws IOException {
		File file1 = new File("D:\\hello\\world\\Java");
		file1.mkdirs();
		// File file2 = new File("D:\\hello\\world\\Java\\a.txt");
		// File file2 = new File("D:\\hello\\world\\Java","a.txt");
		File file2 = new File(file1, "a.txt");
		file2.createNewFile();

	}
}
