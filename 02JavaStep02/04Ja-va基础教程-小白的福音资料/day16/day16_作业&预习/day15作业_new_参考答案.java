1.分析以下需求，并用代码实现：
	(1)生成10个1至100之间的随机整数(不能重复)，存入一个List集合(可以先不使用泛型，泛型明天讲)
	(2)编写方法对List集合进行排序,禁用Collections.sort方法和TreeSet
	(2)然后利用迭代器遍历集合元素并输出
	(3)如：15 18 20 40 46 60 65 70 75 91
		答：参考答案
			package com.heima.tests;
			import java.util.ArrayList;
			import java.util.Iterator;
			import java.util.List;
			import java.util.Random;
			public class Test01 {
				public static void main(String[] args) {
					List<Integer> list = getRandomNum();
					sort(list);
					Iterator<Integer> it = list.iterator();
					while(it.hasNext()) {
						System.out.print(it.next()+" ");
					}
					System.out.println();
				}
				
				//生成10个1-100的随机数
				public static List<Integer> getRandomNum() {
					//1.创建ArrayList集合存放生成的随机数
					List<Integer> list = new ArrayList<Integer>();
					//2.创建Random对象,用于生成随机数
					Random r = new Random();
					//3.将生成的5个随机数存入list集合中
					while(list.size()<10) {
						int num = r.nextInt(100)+1;
						//去重
						if(!list.contains(num)) {
							list.add(num);
						}
					}
					return list;
				}
				//对List集合中的数字进行从小到大的排序
				public static void sort(List<Integer> list) {
					//1.将list集合转成Integer类型的数组
					Integer[] arr = list.toArray(new Integer[list.size()]);
					//2.定义冒泡排序算法
					for(int i = 0;i<arr.length-1;i++) {
						for(int j = 0;j<arr.length-1-i;j++) {
							if(arr[j]>arr[j+1]) {//3.自动拆箱
								int temp = arr[j];
								arr[j] = arr[j+1];
								arr[j+1] = temp;
							}
						}
					}
					//4.将排序后数组中的元素重新放入集合中
					for(int i = 0;i<arr.length;i++) {
						list.set(i, arr[i]);
					}
				}
			}

	
2.分析以下需求，并用代码实现：
	(1)定义List集合，存入多个字符串
	(2)删除集合中字符串"def"
	(3)然后利用迭代器遍历集合元素并输出
		答：参考答案
			package com.heima.tests;
			import java.util.ArrayList;
			import java.util.Iterator;
			import java.util.List;
			public class Test02 {
				public static void main(String[] args) {
					List<String> list = new ArrayList<String>();
					list.add("abce0fgh");
					list.add("ab2e0fgh");
					list.add("ab3e0fgh");
					list.add("ab5e0fgh");
					list.add("ab6e0fgh");
					list.add("ab5e0f8gh");
					list.add("000234ab5e0f8g9h");
					list.add("abc");
					list.add("def");
					list.add("ghi");
					//调用deleteStrFromList方法删除集合中的字符串"def"
					deleteStrFromList(list, "def");
					//利用迭代器遍历集合元素并输出
					Iterator<String> it = list.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
					System.out.println();
				}
				// 删除ArrayList集合中的"abc"字符串
				public static void deleteStrFromList(List<String> list,String delStr) {
					//1.获取迭代器对象，并进行遍历
					Iterator<String> it = list.iterator();
					while(it.hasNext()) {
						String str = it.next();
						//2.判断集合中的元素是否等于"abc",如果相等，就删除
						if(null!=delStr&&delStr.equals(str)) {
							it.remove();
						}
					}
				}
			}

	
3.分析以下需求，并用代码实现：
	(1)定义List集合，存入多个字符串
	(2)删除集合中包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
	(3)然后利用迭代器遍历集合元素并输出
		答：参考答案
			package com.heima.tests;
			import java.util.ArrayList;
			import java.util.Iterator;
			import java.util.List;
			import java.util.regex.Matcher;
			import java.util.regex.Pattern;
			public class Test03 {
				public static void main(String[] args) {
					ArrayList<String> list = new ArrayList<>();
					list.add("abce0fgh");
					list.add("ab2e0fgh");
					list.add("ab3e0fgh");
					list.add("ab5e0fgh");
					list.add("ab6e0fgh");
					list.add("ab5e0f8gh");
					list.add("000234ab5e0f8g9h");
					list.add("abc");
					list.add("def");
					list.add("ghi");
					deleteNum4(list);
					//利用迭代器遍历集合元素并输出
					Iterator<String> it = list.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
					System.out.println();
				}

				// 利用遍历的方式判断是否包含0-9的字符串
				private static void deleteNum1(List<String> list) {
					// 1.遍历集合
					Iterator<String> it = list.iterator();// 获取迭代器
					while (it.hasNext()) {// it.remove();
						String str = (String) it.next();// str.contains(String str)
						for (int i = 0; i <= 9; i++) {// 0-9的数字
							// 2.判断字符串中是否包含0-9的字符串
							if (str.contains(i + "")) {// 0->"0"
								it.remove();
								break;
							}
						}
					}
				}

				// 利用正则表达式,后面讲到
				private static void deleteNum2(List<String> list) {
					// 1.遍历集合
					Iterator<String> it = list.iterator();// 获取迭代器
					// 2.定义正则表达式
					String regex = "\\w*\\d+\\w*";
					while (it.hasNext()) {// it.remove();
						String str = it.next();// str.contains(String str)
						// 3.用正则去匹配
						if (str.matches(regex)) {
							// 4.删除匹配的字符串
							it.remove();
						}
					}
				}

				// 利用正则表达式方法2,后面讲到
				private static void deleteNum3(List<String> list) {
					// 1.遍历集合
					Iterator<String> it = list.iterator();// 获取迭代器
					// 2.定义正则表达式
					String regex = "\\d+";
					Pattern p = Pattern.compile(regex);
					while (it.hasNext()) {// it.remove();
						String str = (String) it.next();// str.contains(String str)
						// 3.获取匹配器对象
						Matcher m = p.matcher(str);
						// 4.用匹配器对象去寻找
						if (m.find()) {
							// 5.删除匹配的字符串
							it.remove();
						}
					}
				}
				// 利用remove(int index)方法删除
				private static void deleteNum4(List<String> list) {
					// 1.遍历集合
					for(int i = 0;i<list.size();i++) {
						/*if(list.get(i).matches("\\w*\\d+\\w*")) {
							list.remove(i--);
						}*/
						String str = list.get(i);
						for (int j = 0; j <= 9; j++) {// 0-9的数字
							// 2.判断字符串中是否包含0-9的字符串
							if (str.contains(j + "")) {// 0->"0"
								list.remove(i--);
								break;
							}
						}			
					}		
				}

			}

4.练习今天的课堂代码

