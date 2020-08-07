package com.itheima.utils;

import java.util.UUID;

/**
 * 文件上传的工具类
 * @author jt
 *
 */
public class UploadUtils {
	
	/**
	 * 传递一个文件名，返回一个唯一的文件名。
	 */
	public static String getUuidFilename(String filename){
		// 在Java的API中有一个类UUID可以产生随机的字符串。aa.txt
		// UUID.randomUUID().toString();
		// 获得文件名的扩展名.
		int idx = filename.lastIndexOf(".");
		String extetions = filename.substring(idx);
		return UUID.randomUUID().toString().replace("-", "")+extetions;
	}
	
	/**
	 * 目录分离的算法实现
	 * @param args
	 */
	public static String getRealPath(String uuidFilename){
		int code1 = uuidFilename.hashCode();
		int d1 = code1 & 0xf;
		int code2 = code1 >>> 4;
		int d2 = code2 & 0xf;
		return "/"+d1+"/"+d2;
	}
	
	public static void main(String[] args) {
		// System.out.println(UUID.randomUUID().toString().replace("-", ""));
		/*String s = getUuidFilename("aa.txt");
		System.out.println(s);*/
		
		String filename = "185363be735345bf8a971d15332601a3.txt";
		int hashCode = filename.hashCode();
		System.out.println(hashCode);
	}
}
