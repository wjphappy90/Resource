package cn.itcast.question;

import java.io.File;
import java.io.IOException;

/*需求: 如果我们想在下面这个目录中创建文件a.txt, 那么该如何实现?
 E:hello\\world\\Java\\a.txt 创建一个文件.*/

//java.io.IOException: 设备未就绪。

public class WrongFileTest1 {
	public static void main(String[] args) {
		// 创建具有指定路径的文件对象
		// 指定的盘符被占用，不是正常的存储盘符
		File file = new File("E:\\hello\\world\\Java");
		File txtFile = new File(file, "a.txt");
		file.mkdirs();
		try {
			txtFile.createNewFile();
		} catch (IOException e) {
			System.out.println("创建失败");
			e.printStackTrace();
		}
	}
}
