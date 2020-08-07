package com.heima.map;

import java.util.LinkedHashMap;

public class Demo6_LinkedHashMap {

	/**
	 * @param args
	 * LinkedHashMap可以保证怎么存就怎么取
	 */
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		lhm.put("张三", 23);
		lhm.put("李四", 24);
		lhm.put("赵六", 26);
		lhm.put("王五", 25);
		
		System.out.println(lhm);
	}

}
