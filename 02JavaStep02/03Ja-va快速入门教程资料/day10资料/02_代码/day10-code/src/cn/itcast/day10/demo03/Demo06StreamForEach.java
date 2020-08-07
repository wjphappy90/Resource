package cn.itcast.day10.demo03;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * 如果希望在流当中进行元素的遍历操作，可以使用forEach方法：
 * 
 * forEach(Lambda表达式)：意思是，对流当中的每一个元素都要进行操作。
 * 参数Lambda表达式必须是一个能够消费一个参数，而且不产生数据结果的Lambda。
 * 
 * 例如：
 * Lambda：		s -> System.out.println(s);
 * 方法引用：	System::println
 */
public class Demo06StreamForEach {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("迪丽热巴");
		list.add("古力娜扎");
		list.add("玛尔扎哈");

		Stream<String> streamA = list.stream();
		streamA.forEach((String str) -> {
			System.out.println(str);
		});
		System.out.println("==============");
		
		list.stream().forEach((String str) -> {
			System.out.println(str);
		});
		System.out.println("==============");
		
		list.stream().forEach(str -> {
			System.out.println(str);
		});
		System.out.println("==============");
		
		list.stream().forEach(System.out::println);
	}

}
