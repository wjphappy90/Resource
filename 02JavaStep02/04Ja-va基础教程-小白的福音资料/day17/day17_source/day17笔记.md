###17.01_集合框架(HashSet存储字符串并遍历)
* A:Set集合概述及特点
	* 通过API查看即可
* B:案例演示
	* HashSet存储字符串并遍历
	* 
		 	HashSet<String> hs = new HashSet<>();
			boolean b1 = hs.add("a");
			boolean b2 = hs.add("a");			//当存储不成功的时候,返回false
			
			System.out.println(b1);
			System.out.println(b2);
			for(String s : hs) {
				System.out.println(s);
			}

###17.02_集合框架(HashSet存储自定义对象保证元素唯一性)
* A:案例演示
	* 存储自定义对象，并保证元素唯一性。

			HashSet<Person> hs = new HashSet<>();
			hs.add(new Person("张三", 23));
			hs.add(new Person("张三", 23));
			hs.add(new Person("李四", 23));
			hs.add(new Person("李四", 23));
			hs.add(new Person("王五", 23));
			hs.add(new Person("赵六", 23));
* 重写hashCode()和equals()方法
###17.03_集合框架(HashSet存储自定义对象保证元素唯一性图解及代码优化)
* A:画图演示
	* 画图说明比较过程
* B:代码优化
	* 为了减少比较，优化hashCode()代码写法。
	* 最终版就是自动生成即可。

###17.04_集合框架(HashSet如何保证元素唯一性的原理)
* 1.HashSet原理
	* 我们使用Set集合都是需要去掉重复元素的, 如果在存储的时候逐个equals()比较, 效率较低,哈希算法提高了去重复的效率, 降低了使用equals()方法的次数
	* 当HashSet调用add()方法存储对象的时候, 先调用对象的hashCode()方法得到一个哈希值, 然后在集合中查找是否有哈希值相同的对象
		* 如果没有哈希值相同的对象就直接存入集合
		* 如果有哈希值相同的对象, 就和哈希值相同的对象逐个进行equals()比较,比较结果为false就存入, true则不存
* 2.将自定义类的对象存入HashSet去重复
	* 类中必须重写hashCode()和equals()方法
	* hashCode(): 属性相同的对象返回值必须相同, 属性不同的返回值尽量不同(提高效率)
	* equals(): 属性相同返回true, 属性不同返回false,返回false的时候存储

###17.05_集合框架(LinkedHashSet的概述和使用)
* A:LinkedHashSet的特点
* B:案例演示
	* LinkedHashSet的特点
		* 可以保证怎么存就怎么取 

###17.06_集合框架(产生10个1-20之间的随机数要求随机数不能重复)
* A:案例演示
	* 需求：编写一个程序，获取10个1至20的随机数，要求随机数不能重复。并把最终的随机数输出到控制台。
	* 
			HashSet<Integer> hs = new HashSet<>();		//创建集合对象
			Random r = new Random();					//创建随机数对象
			
			while(hs.size() < 10) {
				int num = r.nextInt(20) + 1;			//生成1到20的随机数
				hs.add(num);
			}
			
			for (Integer integer : hs) {				//遍历集合
				System.out.println(integer);			//打印每一个元素
			}

###17.07_集合框架(练习)
* 使用Scanner从键盘读取一行输入,去掉其中重复字符, 打印出不同的那些字符
	* aaaabbbcccddd

			Scanner sc = new Scanner(System.in);			//创建键盘录入对象
			System.out.println("请输入一行字符串:");
			String line = sc.nextLine();					//将键盘录入的字符串存储在line中
			char[] arr = line.toCharArray();				//将字符串转换成字符数组
			HashSet<Character> hs = new HashSet<>();		//创建HashSet集合对象
			
			for(char c : arr) {								//遍历字符数组
				hs.add(c);									//将字符数组中的字符添加到集合中
			}
			
			for (Character ch : hs) {						//遍历集合
				System.out.println(ch);
			}
###17.08_集合框架(练习)
* 将集合中的重复元素去掉
* 
			public static void main(String[] args) {
				ArrayList<String> list = new ArrayList<>();
				list.add("a");
				list.add("a");
				list.add("a");
				list.add("b");
				list.add("b");
				list.add("b");
				list.add("b");
				list.add("c");
				list.add("c");
				list.add("c");
				list.add("c");
				
				System.out.println(list);
				System.out.println("去除重复后:");
				getSingle(list);
				System.out.println(list);
			}
			
			/*
			 * 将集合中的重复元素去掉
			 * 1,void
			 * 2,List<String> list
			 */
			
			public static void getSingle(List<String> list) {
				LinkedHashSet<String> lhs = new LinkedHashSet<>();
				lhs.addAll(list);									//将list集合中的所有元素添加到lhs
				list.clear();										//清空原集合
				list.addAll(lhs);									//将去除重复的元素添回到list中
			}

###17.09_集合框架(TreeSet存储Integer类型的元素并遍历)
* A:案例演示
	* TreeSet存储Integer类型的元素并遍历

###17.10_集合框架(TreeSet存储自定义对象)
* A:案例演示
	* 存储Person对象

###17.11_集合框架(TreeSet保证元素唯一和自然排序的原理和图解)
* A:画图演示
	* TreeSet保证元素唯一和自然排序的原理和图解

###17.12_集合框架(TreeSet存储自定义对象并遍历练习1)
* A:案例演示
	* TreeSet存储自定义对象并遍历练习1(按照姓名排序)

###17.13_集合框架(TreeSet存储自定义对象并遍历练习2)
* A:案例演示
	* TreeSet存储自定义对象并遍历练习2(按照姓名的长度排序)

###17.14_集合框架(TreeSet保证元素唯一和比较器排序的原理及代码实现)
* A:案例演示
	* TreeSet保证元素唯一和比较器排序的原理及代码实现

###17.15_集合框架(TreeSet原理)
* 1.特点
	* TreeSet是用来排序的, 可以指定一个顺序, 对象存入之后会按照指定的顺序排列
* 2.使用方式
	* a.自然顺序(Comparable)
		* TreeSet类的add()方法中会把存入的对象提升为Comparable类型
		* 调用对象的compareTo()方法和集合中的对象比较
		* 根据compareTo()方法返回的结果进行存储
	* b.比较器顺序(Comparator)
		* 创建TreeSet的时候可以制定 一个Comparator
		* 如果传入了Comparator的子类对象, 那么TreeSet就会按照比较器中的顺序排序
		* add()方法内部会自动调用Comparator接口中compare()方法排序
		* 调用的对象是compare方法的第一个参数,集合中的对象是compare方法的第二个参数
	* c.两种方式的区别
		* TreeSet构造函数什么都不传, 默认按照类中Comparable的顺序(没有就报错ClassCastException)
		* TreeSet如果传入Comparator, 就优先按照Comparator

###17.16_集合框架(练习)
* 在一个集合中存储了无序并且重复的字符串,定义一个方法,让其有序(字典顺序),而且还不能去除重复

			public static void main(String[] args) {
				ArrayList<String> list = new ArrayList<>();
				list.add("ccc");
				list.add("ccc");
				list.add("aaa");
				list.add("aaa");
				list.add("bbb");
				list.add("ddd");
				list.add("ddd");
				
				sort(list);
				System.out.println(list);
			}
			
			/*
			 * 对集合中的元素排序,并保留重复
			 * 1,void
			 * 2,List<String> list
			 */
			public static void sort(List<String> list) {
				TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {		//定义比较器(new Comparator(){}是Comparator的子类对象)
		
					@Override
					public int compare(String s1, String s2) {						//重写compare方法
						int num = s1.compareTo(s2);									//比较内容
						return num == 0 ? 1 : num;									//如果内容一样返回一个不为0的数字即可
					}
				});
				
				ts.addAll(list);													//将list集合中的所有元素添加到ts中
				list.clear();														//清空list
				list.addAll(ts);													//将ts中排序并保留重复的结果在添加到list中
			}

###17.17_集合框架(练习)
* 从键盘接收一个字符串, 程序对其中所有字符进行排序,例如键盘输入: helloitcast程序打印:acehillostt

		Scanner sc = new Scanner(System.in);			//创建键盘录入对象
		System.out.println("请输入一行字符串:");
		String line = sc.nextLine();					//将键盘录入的字符串存储在line中
		char[] arr = line.toCharArray();				//将字符串转换成字符数组
		TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

			@Override
			public int compare(Character c1, Character c2) {
				//int num = c1.compareTo(c2);
				int num = c1 - c2;					//自动拆箱
				return num == 0 ? 1 : num;
			}
		});
		
		for(char c : arr) {
			ts.add(c);
		}
		
		for(Character ch : ts) {
			System.out.print(ch);
		}
###17.18_集合框架(练习)
* 程序启动后, 可以从键盘输入接收多个整数, 直到输入quit时结束输入. 把所有输入的整数倒序排列打印.
			Scanner sc = new Scanner(System.in);		//创建键盘录入对象
			System.out.println("请输入:");
			TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {//将比较器传给TreeSet的构造方法
	
				@Override
				public int compare(Integer i1, Integer i2) {
					//int num = i2 - i1;					//自动拆箱
					int num = i2.compareTo(i1);
					return num == 0 ? 1 : num;
				}
			});
			
			while(true) {
				String line = sc.nextLine();			//将键盘录入的字符串存储在line中
				if("quit".equals(line))					//如果字符串常量和变量比较,常量放前面,这样不会出现空指针异常,变量里面可能存储null
					break;
				try {
					int num = Integer.parseInt(line);		//将数字字符串转换成数字
					ts.add(num);
				} catch (Exception e) {
					System.out.println("您录入的数据有误,请输入一个整数");
				}
				
			}
			
			for (Integer i : ts) {						//遍历TreeSet集合
				System.out.println(i);
			}
###17.19_集合框架(键盘录入学生信息按照总分排序后输出在控制台)
* A:案例演示
	* 需求：键盘录入5个学生信息(姓名,语文成绩,数学成绩,英语成绩),按照总分从高到低输出到控制台。
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入5个学生成绩格式是:(姓名,语文成绩,数学成绩,英语成绩)");
			TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
				@Override
				public int compare(Student s1, Student s2) {
					int num = s2.getSum() - s1.getSum();			//根据学生的总成绩降序排列
					return num == 0 ? 1 : num;
				}
			});
			
			while(ts.size() < 5) {
				String line = sc.nextLine();
				try {
					String[] arr = line.split(",");
					int chinese = Integer.parseInt(arr[1]);				//转换语文成绩
					int math = Integer.parseInt(arr[2]);				//转换数学成绩
					int english = Integer.parseInt(arr[3]);				//转换英语成绩
					ts.add(new Student(arr[0], chinese, math, english));
				} catch (Exception e) {
					System.out.println("录入格式有误,输入5个学生成绩格式是:(姓名,语文成绩,数学成绩,英语成绩");
				}
				
			}
			
			System.out.println("排序后的学生成绩是:");
			for (Student s : ts) {
				System.out.println(s);
			}

###17.20_day17总结
* 1.List
	* a.普通for循环, 使用get()逐个获取
	* b.调用iterator()方法得到Iterator, 使用hasNext()和next()方法
	* c.增强for循环, 只要可以使用Iterator的类都可以用
	* d.Vector集合可以使用Enumeration的hasMoreElements()和nextElement()方法
* 2.Set
	* a.调用iterator()方法得到Iterator, 使用hasNext()和next()方法
	* b.增强for循环, 只要可以使用Iterator的类都可以用
* 3.普通for循环,迭代器,增强for循环是否可以在遍历的过程中删除 