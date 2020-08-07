package cn.itcast.question;

import java.io.File;
import java.io.IOException;

/*需求: 如果我们想在下面这个目录中创建文件a.txt, 那么该如何实现?
 E:\\hello\\world\\Java\\a.txt 创建一个文件.*/

////格式书写错误 F：后面没有双斜杠   
//		如果File对象的根目录( F：)与当前项目所在盘符一致，那么就会在该程序或该程序包所在目录创建文件或文件夹（使用开发工具会有一些变化）。
//		如果File对象的根目录( F：)与当前项目所在盘符不一致，就会在该根目录下创建文件或文件夹(按正常理解即可)
		

public class WrongFileTest2 {
	public static void main(String[] args) {
		// 创建具有指定路径的文件对象

		File file = new File("F:hello\\world\\Java");//格式书写错误 F：后面没有双斜杠
			
		System.out.println(file);
		File txtFile = new File(file, "a.txt");
		System.out.println(txtFile);
		System.out.println(file.mkdirs());
		try {
			System.out.println(txtFile.createNewFile());
		} catch (IOException e) {
			System.out.println("创建失败");
			e.printStackTrace();
		}
	}
}
