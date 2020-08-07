package cn.itcast.day10.demo03;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * 获取流之后，可以使用映射方法：map(用于转换的Lambda表达式)
 * 
 * 映射：就是将一个对象转换成为另一个对象，把老对象映射到新对象上。
 * 
 * "赵丽颖,98"	转换成为		"98"		将一个长字符串转换成为一个短字符串
 * "98"			转换成为		98			将一个字符串转换成为一个int数字
 */
public class Demo04StreamMap {
	
	public static void main(String[] args) {
		// 这个集合当中存放的是字符串类型
		ArrayList<String> list = new ArrayList<>();
		list.add("100");
		list.add("200");
		list.add("300");
		
		Stream<Integer> streamA = list.stream().map((String str) -> {
			int num = Integer.parseInt(str);
			return num;
		});
		
		Stream<Integer> streamB = list.stream().map(str -> {
			int num = Integer.parseInt(str);
			return num;
		});
		
		Stream<Integer> streamC = list.stream().map(str -> {
			return Integer.parseInt(str);
		});
		
		Stream<Integer> streamD = list.stream().map(Integer::parseInt);
		
		System.out.println("========================");
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("赵丽颖,98");
		list2.add("鹿晗,95");
		list2.add("宋小宝,87");
		
		Stream<String> stream1 = list2.stream().map((String str) -> {
			String[] array = str.split(",");
			String result = array[1];
			return result;
		});
		
		Stream<String> stream2 = list2.stream().map(s -> {
			String[] array = s.split(",");
			String result = array[1];
			return result;
		});
		
		Stream<String> stream3 = list2.stream().map(s -> {
			String[] array = s.split(",");
			return array[1];
		});
		
		Stream<String> stream4 = list2.stream().map(s -> {
			return s.split(",")[1];
		});
		
		Stream<String> stream5 = list2.stream().map(s -> s.split(",")[1]);
	}

}
