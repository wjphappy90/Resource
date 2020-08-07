package com.heima.tests;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 3.分析以下需求，并用代码实现：
 *	(1)统计每个单词出现的次数
 *	(2)有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
 *	(3)打印格式：
 *		to=3
 * 		think=1
 * 		you=2
 * 		//........
 * @author JX
 *
 */
public class Test03 {
	public static void main(String[] args) {
		//1.分割字符串
		String[] arr = "If you want to change your fate I think you must come to the dark horse to learn java".split(" ");
		//2.分拣存储
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String key:arr){
			//System.out.println(key);每个单词
			/*if(!map.containsKey(key)){//查看是否存在该单词
				map.put(key, 1);
			} else {//存在
				map.put(key, map.get(key)+1);
			}*/
			Integer value = map.get(key);
			if(null == value) {
				map.put(key, 1);
			} else {
				map.put(key, value+1);
			}
		}
		//3.查看每个单词出现的次数
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"="+value);
		}
	}
}
