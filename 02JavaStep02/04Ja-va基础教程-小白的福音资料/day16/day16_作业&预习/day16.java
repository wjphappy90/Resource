1,定义一个方法swap()传入集合和两个角标使集合中元素交换位置
	a,定义一个临时变量, 记住其中一个元素
	b,用第一个位置存放第二个位置上的元素
	c, 用第二个位置存放临时变量记住的元素
	
2,把集合中存储多个Person对象,Person有姓名和年龄,找出年龄最大的
	a,定义一个Person类型的变量, 先记住第一个元素
	b,循环遍历集合
	c,用每一个元素和变量比较年龄, 如果集合中的元素比变量记住的年龄大
	d,用变量记住这个年龄较大的元素
	e,返回变量记住的元素
3,把集合中的元素反转
	a,定义循环, 循环size()/2次
	b,第一次交换第一个和最后一个, 第二次交换第二个和倒数第二个

4,public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("b");
		list1.add("f");
		list1.add("e");
		list1.add("c");
		list1.add("a");
		list1.add("d");
		sort1(list1);
		System.out.println(list1);	// a, b, c, d, e, f
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(5);
		list2.add(8);
		list2.add(3);
		list2.add(1);
		list2.add(4);

		sort2(list2);
		System.out.println(list2); //1,3,4,5,8
	}
	对集合中添加的元素排序
5,List<String> list = new ArrayList<>();
		
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
		定义方法统计集合中指定元素出现的次数
6,定义一个replaceAll方法,将传入的新值替换集合中的老值(list,old,new)

