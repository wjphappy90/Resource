package com.heima.test;

import java.io.File;
import java.io.FilenameFilter;

public class Test3 {

	/**
	 * @param args
	 * * A:案例演示
	 * 需求：判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
	 */
	public static void main(String[] args) {
		File dir = new File("E:\\");
		
//		String[] arr = dir.list();					//获取e盘下所有的文件或文件夹
//		for (String string : arr) {
//			if(string.endsWith(".jpg")) {
//				System.out.println(string);
//			}
//		}
		
		/*File[] subFiles = dir.listFiles();			//获取e盘下所有的文件或文件夹对象
		
		for (File subFile : subFiles) {
			if(subFile.isFile() && subFile.getName().endsWith(".jpg")) {
				System.out.println(subFile);
			}
		}*/
		
		String[] arr = dir.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				//System.out.println(dir);
				//System.out.println(name);
				File file = new File(dir, name);
				return file.isFile() && file.getName().endsWith(".jpg");
			}
		});
		
		for (String string : arr) {
			System.out.println(string);
		}
	}

}
