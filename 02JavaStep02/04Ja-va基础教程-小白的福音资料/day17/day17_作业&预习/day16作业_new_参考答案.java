
1.分析以下需求，并用代码实现：
	(1)定义一个方法swap()传入集合和两个角标使集合中元素交换位置()
	(2)思路
		a.定义一个临时变量, 记住其中一个元素
		b.用第一个位置存放第二个位置上的元素
		c.用第二个位置存放临时变量记住的元素
		答：参考答案
			//实体类Person，以下题目都是用这个实体类
				package com.heima.domain;
				public class Person {
					private String name;
					private int age;
					public Person() {
						// TODO Auto-generated constructor stub
					}
					public Person(String name, int age) {
						super();
						this.name = name;
						this.age = age;
					}
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public int getAge() {
						return age;
					}
					public void setAge(int age) {
						this.age = age;
					}
					@Override
					public String toString() {
						return "Person [name=" + name + ", age=" + age + "]";
					}
					
				}
				
				
				package com.heima.tests;
				import java.util.ArrayList;
				import java.util.List;
				import com.heima.domain.Person;
				public class Test01 {
					public static void main(String[] args) {
						//测试集合中存入字符串
						ArrayList<String> al = new ArrayList<>();
						al.add("a");
						al.add("b");
						al.add("c");
						al.add("d");
						System.out.println(al);
						swap(al,0,3);
						System.out.println(al);
						//测试集合中存入自定义对象
						ArrayList<Person> al2 = new ArrayList<>();
						al2.add(new Person("zs", 20));
						al2.add(new Person("ls", 30));
						al2.add(new Person("ww", 10));
						al2.add(new Person("zl", 40));
						al2.add(new Person("kw", 22));
						System.out.println("------------------");
						System.out.println(al2);
						swap(al2,0,4);
						System.out.println(al2);
					}
					
					//定义一个带泛型的方法
					public static void swap(List list,int index1,int index2) {
						//1.获取list集合中索引为index1的值
						Object obj = list.get(index1);
						//2.将集合中索引index1位置设置为索引index2的值
						list.set(index1, list.get(index2));
						//3.将集合index2位置设置为t
						list.set(index2, obj);
					}
					
					//定义一个带泛型的方法
					public static <T> void swap2(List<T> list,int index1,int index2) {
						//1.获取list集合中索引为index1的值
						T t = list.get(index1);
						//2.将集合中索引index1位置设置为索引index2的值
						list.set(index1, list.get(index2));
						//3.将集合index2位置设置为t
						list.set(index2, t);
					}
				}
		
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
		答：参考答案
				package com.heima.tests;
				import java.util.ArrayList;
				import java.util.Comparator;
				import java.util.List;
				import com.heima.domain.Person;
				public class Test02 {
					public static void main(String[] args) {
						List<String> list = new ArrayList<>();
						list.add("b");
						list.add("f");
						list.add("e");
						list.add("c");
						list.add("a");
						list.add("d");
						sort(list);
						System.out.println(list); // a, b, c, d, e, f					
					}

					// 对集合中的元素排序(泛型为String)
					private static void sort(List<String> list) {
						// 直接使用冒泡排序,没有将集合转成数组
						for (int i = 0; i < list.size() - 1; i++) {
							for (int j = 0; j < list.size() - 1 - i; j++) {
								String str1 = list.get(j);
								String str2 = list.get(j + 1);
								// 下面这种方式无法实现list集合中的元素的交换
								/*
								 if (str1.compareTo(str2) > 0) { 
									 String temp = str1; 
									 str1 = str2; 
									 str2 = temp; 
								 }
								 */
								if (str1.compareTo(str2) > 0) {
									list.set(j, str2);
									list.set(j + 1, str1);
								}
							}
						}
					}					
				}

	
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
		答：参考答案
				package com.heima.tests;
				import java.util.ArrayList;
				import java.util.List;
				import com.heima.domain.Person;
				public class Test03 {
					public static void main(String[] args) {
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
						
						//测试方法 System.out.println(frequency(list, "a")); // 3
						System.out.println(frequency(list, "b"));  // 2
						System.out.println(frequency(list, "c"));  // 1
						System.out.println(frequency(list, "d"));  // 5
						System.out.println(frequency(list, "xxx")); // 0
						
						
					}
					// 统计集合中元素出现的次数
					private static int frequency(List<String> list, String value) {
						int count = 0;
						// 1.使用增强for遍历集合
						for (String str : list) {
							// 2.如果当前元素是要查找的元素value,计数器count加1
							if (value.equals(str))
								count++;
						}
						// 3.返回计数器
						return count;
					}
				}

	


	
4.分析以下需求，并用代码实现：
	(1)编写一个泛形方法，实现指定位置数组元素的交换
	(2)编写一个泛形方法，接收一个任意数组，并反转数组中的所有元素
		答：参考答案
				package com.heima.tests;
				import java.util.Arrays;
				public class Test04 {
					public static void main(String[] args) {
						String s[] = {"a","b","c"};
						exchange(s, 0, 2);
						//Arrays.asList(s):将数组s转换成集合
						System.out.println(Arrays.asList(s));
						
						String s1 [] = {"a","b","c","d"};
						reverse(s1);
						System.out.println(Arrays.asList(s1));
					}
					//1.编写一个泛形方法，实现指定位置数组元素的交换
					public static <T> void exchange(T[] t, int index1, int index2) {
						T temp = t[index1];
						t[index1] = t[index2];
						t[index2] = temp;
					}
					//2.编写一个泛形方法，接收一个任意数组，并颠倒数组中的所有元素
					public static <T> void reverse(T[] t){
						
						int startIndex = 0;
						int endIndex = t.length -1;
						
						while(startIndex<endIndex){
							T temp = t[startIndex];
							t[startIndex] = t[endIndex];
							t[endIndex] = temp;
							startIndex++;
							endIndex--;
						}
						
					}
				}

