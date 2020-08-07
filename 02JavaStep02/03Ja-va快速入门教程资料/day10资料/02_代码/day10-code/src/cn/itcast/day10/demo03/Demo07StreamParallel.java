package cn.itcast.day10.demo03;

import java.util.ArrayList;

/*
 * 流当中的元素如果特别多，那么只有一个人在逐一、挨个儿处理，肯定比较慢，费劲。
 * 如果对流当中的元素，使用多个人同时处理，这就是“并发”。
 * 
 * 如何才能获取“并发流”（支持并发操作的流）：
 * .parallelStream()
 * 
 * 注意事项：
 * 1. 使用并发流操作的时候，到底有几个人进行同时操作呢？不用管，JDK自己处理。
 * 2. 只要正确使用，就不会出现多个人抢到同一个元素的情况。
 * 3. 如果已经获取了一个普通的流，那么只要再调用一下parallel()方法也会变成并发流。
 * 
 * 总结：
 * 1. 直接获取并发流：.parallelStream()
 * 2. 已经获取了普通流，然后升级成为并发流：.stream().parallel()
 */
public class Demo07StreamParallel {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			list.add("Hello-" + i);
		}
		
		// 这是只有一个人在做打印输出的操作
//		list.stream().forEach(System.out::println);
		
		// 获取一个并发流
		list.parallelStream().forEach(System.out::println);
		
		list.stream().parallel().forEach(System.out::println);
	}

}
