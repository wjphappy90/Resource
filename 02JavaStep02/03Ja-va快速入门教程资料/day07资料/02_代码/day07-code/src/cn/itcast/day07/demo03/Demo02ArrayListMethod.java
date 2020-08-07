package cn.itcast.day07.demo03;

import java.util.ArrayList;

/*
 * 如何使用已经创建好的集合呢？常用的方法有三个：
 * 
 * 1. 添加元素
 * public boolean add(E element)：向集合当中添加一个元素，参数是被添加的元素，而返回值一定是true值代表成功。
 * 
 * 2. 获取元素
 * public E get(int index)：从集合当中获取一个元素，参数是元素索引（从0开始），返回值就是获取得到的元素对象。
 * 
 * 3. 获取长度
 * public int size()：获取集合的元素个数，集合的长度，得到int数字。
 * 
 * 注意事项：
 * ArrayList集合直接打印对象名称，得到的不是地址值，而是内容，格式和数组类似。
 * 简单了解原因：是因为ArrayList这个类其中的toString方法有特殊处理。（今后学习。）
 * 
 * 对于ArrayList集合来说，添加的add动作一定是成功的，返回值必然是true。
 * 但是对于其他的集合来说，add方法就不一定成功了。
 */
public class Demo02ArrayListMethod {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		System.out.println(list); // []
		
		// 向集合当中添加元素：add
		list.add("鹿晗");
		list.add("吴亦凡");
		list.add("张艺兴");
		System.out.println(list); // [鹿晗, 吴亦凡, 张艺兴]
		
		boolean success = list.add("关晓彤");
		System.out.println("添加元素是否成功：" + success); // true
		System.out.println(list); // [鹿晗, 吴亦凡, 张艺兴, 关晓彤]
		System.out.println("====================");
		
		String name = list.get(1); // 获取第1号元素
		System.out.println(name); // 吴亦凡
		System.out.println(list); // [鹿晗, 吴亦凡, 张艺兴, 关晓彤]
		System.out.println("====================");
		
		System.out.println("集合的长度：" + list.size()); // 4
		list.add("赵丽颖");
		list.add("迪丽热巴");
		list.add("古力娜扎");
		list.add("玛尔扎哈"); 
		System.out.println("集合的长度：" + list.size()); // 8
	}

}
