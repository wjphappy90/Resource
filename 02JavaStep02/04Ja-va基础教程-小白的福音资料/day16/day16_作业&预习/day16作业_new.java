1.分析以下需求，并用代码实现：
	(1)定义一个方法swap()传入集合和两个角标使集合中元素交换位置()
	(2)思路
		a.定义一个临时变量, 记住其中一个元素
		b.用第一个位置存放第二个位置上的元素
		c.用第二个位置存放临时变量记住的元素

2.分析以下需求，并用代码实现：
	(1)有如下代码：
		public static void main(String[] args) {
			List<String> list = new ArrayList<>();
			list.add("b");
			list.add("f");
			list.add("e");
			list.add("c");
			list.add("a");
			list.add("d");
			sort(list);
			System.out.println(list);	// a, b, c, d, e, f
		}
	(2)要求对集合中添加的元素排序
	
3.分析以下需求，并用代码实现：
	(1)有如下代码：
		List<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		
		System.out.println(frequency(list, "a"));	// 3
		System.out.println(frequency(list, "b"));	// 2
		System.out.println(frequency(list, "c"));	// 1
		System.out.println(frequency(list, "d"));	// 5
		System.out.println(frequency(list, "xxx"));	// 0
	(2)定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1
	
4.分析以下需求，并用代码实现：
	(1)编写一个泛形方法，实现指定位置数组元素的交换
	(2)编写一个泛形方法，接收一个任意数组，并反转数组中的所有元素
