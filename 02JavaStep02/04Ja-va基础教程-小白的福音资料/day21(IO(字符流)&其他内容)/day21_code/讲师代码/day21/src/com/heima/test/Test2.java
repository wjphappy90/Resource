package com.heima.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Test2 {

	/**
	 * @param args
	 * 获取一个文本上每个字符出现的次数,将结果写在times.txt上
	 * 
	 * 1,创建带缓冲区的输入流对象
	 * 2,创建双列集合对象,目的是把字符当作键,把字符出现的次数当作值
	 * 3,通过读取不断向集合中存储,存储的时候要判断,如果不包含这个键就将键和值为1存储,如果包含就将键和值加1存储
	 * 4,关闭输入流
	 * 5,创建输出流对象
	 * 6,将结果写出
	 * 7,关闭输出流
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//1,创建带缓冲区的输入流对象
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
		//2,创建双列集合对象,目的是把字符当作键,把字符出现的次数当作值
		HashMap<Character, Integer> hm = new HashMap<>();
		//3,通过读取不断向集合中存储,存储的时候要判断,如果不包含这个键就将键和值为1存储,如果包含就将键和值加1存储
		int c;
		while((c = br.read()) != -1) {
			char ch = (char)c;
			/*if(!hm.containsKey(ch)) {
				hm.put(ch, 1);
			}else {
				hm.put(ch, hm.get(ch) +  1);
			}*/
			
			hm.put(ch, !hm.containsKey(ch)? 1 : hm.get(ch) + 1);
		}
		//4,关闭输入流
		br.close();
		//5,创建输出流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("times.txt"));
		//6,将结果写出
		
		for (Character key : hm.keySet()) {
			bw.write(key + "=" + hm.get(key));
		}
		
		bw.close();
	}

}
