package cn.itcast.day10.demo03;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * 如果希望对流当中的元素进行过滤，可以使用过滤方法：
 * 
 * filter(能产生boolean结果的Lambda)：如果参数Lambda产生了true，则要元素；如果产生了false，则不要元素。
 */
public class Demo05StreamFilter {
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(90);
		list1.add(85);
		list1.add(60);
		
		Stream<Integer> stream1 = list1.stream().filter((Integer num) -> {
			boolean b = num > 80;
			return b;
		});
		
		Stream<Integer> stream2 = list1.stream().filter(num -> {
			boolean b = num > 80;
			return b;
		});
		
		Stream<Integer> stream3 = list1.stream().filter(num -> {
			return num > 80;
		});
		
		Stream<Integer> stream4 = list1.stream().filter(n -> n > 80);
		System.out.println("==================");
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("赵丽颖");
		list2.add("赵丽颖");
		list2.add("宋小宝");
		
		Stream<String> streamA = list2.stream().filter((String str) -> {
//			boolean b = "赵丽颖".equals(str);
			boolean b = str.equals("赵丽颖");
			return b;
		});
		
		Stream<String> streamB = list2.stream().filter(s -> {
			boolean b = s.equals("赵丽颖");
			return b;
		});
		
		Stream<String> streamC = list2.stream().filter(s -> {
			return s.equals("赵丽颖");
		});
		
		Stream<String> streamD = list2.stream().filter(s -> s.equals("赵丽颖"));
	}

}
