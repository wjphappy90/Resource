package cn.itcast.question;


import java.io.File;
import java.io.IOException;

/*需求: 如果我们想在下面这个目录中创建文件a.txt, 那么该如何实现?
 E:hello\\world\\Java\\a.txt 创建一个文件.*/


/*java.io.IOException: 系统找不到指定的路径*/
public class WrongFileTest {
	public static void main(String[] args) {
		// 创建具有指定路径的文件对象
		
		File file = new File("F:\\hello\\world\\Java\\a.txt");// 创建文件的时候，要保证对应的文件夹已经存在
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("创建失败");
			e.printStackTrace();
		}
	}
}
