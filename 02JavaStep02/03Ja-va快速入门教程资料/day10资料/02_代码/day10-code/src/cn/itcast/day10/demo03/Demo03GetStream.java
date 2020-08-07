package cn.itcast.day10.demo03;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * Java 8当中的“流”其实就是Stream接口的对象。
 * JDK提供了一个流接口：java.util.stream.Stream<T>
 * 
 * 如何获取流？
 * 1. 根据集合获取流：集合名称.stream()
 * 2. 根据数组获取流：Stream.of(数组名称)
 */
public class Demo03GetStream {
	
	public static void main(String[] args) {
		// 1. 根据集合获取流
		ArrayList<String> list = new ArrayList<>();
		list.add("迪丽热巴");
		list.add("古力娜扎");
		list.add("玛尔扎哈");
		
		Stream<String> streamA = list.stream();
		
		// 2. 根据数组获取流，数组当中的元素必须是引用类型才行
		String[] arrayStr = { "Hello", "World", "Java" };
		Stream<String> streamB = Stream.of(arrayStr);
		
		Integer[] arrayInteger = { 10, 20, 30 };
		Stream<Integer> streamC = Stream.of(arrayInteger);
	}

}
