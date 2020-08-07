1.分析以下需求，并用代码实现：
	(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)
	(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
	(3)利用四种方式遍历Map集合中的内容，格式：key::value
		答：参考答案
				//学生类
				package com.heima.domain;
				public class Student implements Comparable<Student>{
					private String name;
					private int age;
					public Student() {
						// TODO Auto-generated constructor stub
					}
					
					public Student(String name, int age) {
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
						return "Student [name=" + name + ", age=" + age + "]";
					}

					@Override
					public int compareTo(Student o) {
						
						return this.age-o.age;
					}

				}
				
				//完成需求的代码
				package com.heima.tests;
				import java.util.HashMap;
				import java.util.Iterator;
				import java.util.Map;
				import java.util.Set;
				import com.heima.domain.Student;
				public class Test01 {
					public static void main(String[] args) {
						// 1.定义HashMap集合,键为Student对象,值为String类型的对象,表示地址
						HashMap<Student, String> map = new HashMap<>();
						map.put(new Student("张三", 20), "北京");
						map.put(new Student("李四", 20), "南京");
						map.put(new Student("王五", 20), "上海");
						map.put(new Student("赵六", 20), "广州");
						map.put(new Student("孙七", 20), "深圳");

						// 遍历方式一:增强for循环(entrySet)
						for (Map.Entry<Student, String> entry : map.entrySet()) {
							System.out.println(entry.getKey() + "::" + entry.getValue());
						}
						
						//遍历方式二:增强for循环(keySet)
						System.out.println("-----------------------------------------");
						for(Student student :map.keySet()) {
							String address = map.get(student);
							System.out.println(student+"::"+address);
						}
						
						// 遍历方式三:迭代器(通过entrySet())
						System.out.println("-----------------------------------------");
						Set<Map.Entry<Student, String>> set = map.entrySet();
						Iterator<Map.Entry<Student, String>> it = set.iterator();
						while (it.hasNext()) {
							Map.Entry<Student, String> entry = it.next();
							System.out.println(entry.getKey() + "::" + entry.getValue());
						}

						// 遍历方式四:迭代器(通过keySet())
						System.out.println("-----------------------------------------");
						Set<Student> keySet = map.keySet();
						Iterator<Student> it2 = keySet.iterator();
						while(it2.hasNext()) {
							Student student = it2.next();
							String address = map.get(student);
							System.out.println(student+"::"+address);
						}

					}
				}


	
2.分析以下需求，并用代码实现：
	(1)利用键盘录入，输入一个字符串
	(2)统计该字符串中各个字符的数量
	(3)如：
		用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java"
		程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)u(4)v(1)w(1)y(3)~(6)
		答：参考答案
				package com.heima.tests;
				import java.util.Map;
				import java.util.Scanner;
				import java.util.TreeMap;
				public class Test02 {
					public static void main(String[] args) {
						//1.定义键盘录入对象输入字符串
						Scanner sc = new Scanner(System.in);
						System.out.println("请输入字符串：");
						String str = sc.nextLine();
						//2.调用getCharNum方法统计每个字符出现的次数,并返回一个新的字符串a(2)b(1)k(2)...
						String newStr = getCharNums(str);
						//3.打印字符串
						System.out.println(newStr);
					}

					private static String getCharNums(String str) {
						//1.将字符串变成字符数组
						char[] chars = str.toCharArray();
						//2.定义集合TreeMap
						TreeMap<Character,Integer> map = new TreeMap<>();
						//3.遍历字符数组,将对应的字符和次数存入map集合中
						for (char c : chars) {
							map.put(c, map.get(c)!=null?map.get(c)+1:1);//三元运算符统计每个字符的个数
						}
						//4.定义StringBuilder
						StringBuilder sb = new StringBuilder();
						//5.遍历map集合,利用StringBuilder将key-value转成a(2)b(1)...格式
						for(Map.Entry<Character,Integer> entry:map.entrySet()) {
							sb.append(entry.getKey()).append("(").append(entry.getValue()).append(")");
						}
						//6.返回StringBuilder的字符串表现形式
						return sb.toString();
					}
				}

3.分析以下需求，并用代码实现：
	(1)统计每个单词出现的次数
	(2)有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
	(3)打印格式：
		to=3
  		think=1
  		you=2
  		//........
		答：参考答案
				package com.heima.tests;
				import java.util.HashMap;
				import java.util.Iterator;
				import java.util.Map;
				import java.util.Set;
				public class Test03 {
					public static void main(String[] args) {
						//1.分割字符串
						String[] arr = "If you want to change your fate I think you must come to the dark horse to learn java".split(" ");
						//2.分拣存储
						Map<String,Integer> map = new HashMap<String,Integer>();
						for(String key:arr){
							//System.out.println(key);每个单词
							/*if(!map.containsKey(key)){//查看是否存在该单词
								map.put(key, 1);
							} else {//存在
								map.put(key, map.get(key)+1);
							}*/
							Integer value = map.get(key);
							if(null == value) {
								map.put(key, 1);
							} else {
								map.put(key, value+1);
							}
						}
						//3.查看每个单词出现的次数
						Set<String> keySet = map.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()){
							String key = it.next();
							Integer value = map.get(key);
							System.out.println(key+"="+value);
						}
					}
				}

		
4.分析以下需求，并用代码实现：
	(1)定义一个学生类Student，属性：姓名(String name)、班级班号(String no)、成绩(double score)
	(2)将若干Student对象存入List集合，并统计每个班级的总分和平均分
		思路：
			a.采用面向对象的思想
			b.不推荐使用Map<String,List<Student>> 操作不方便
			c.推荐使用Map<String，ClassRoom>
			答：参考答案
					package com.heima.tests;
					import java.util.ArrayList;
					import java.util.HashMap;
					import java.util.Iterator;
					import java.util.List;
					import java.util.Map;
					import java.util.Set;
					public class Test04 {
						public static void main(String[] args) {
							//1.考试
							List<Student> stuList = exam();
							//2.分析成绩
							Map<String,ClassRoom> map = count(stuList);
							//3.查看成绩(总分,平均分)
							view(map);
						}
						/**
						 * 查看每个班的总分和平局分
						 */
						public static void view(Map<String,ClassRoom> map){
							Set<String> keys = map.keySet();
							//获取迭代器
							Iterator<String> keysIt = keys.iterator();
							//先判断
							while(keysIt.hasNext()){
								//再获取
								String no = keysIt.next();
								ClassRoom room = map.get(no);
								//查看总分 计算平均分
								double total = room.getTotal();
								double avg = total/room.getStuList().size();
								System.out.println(no+"-->"+total+"-->"+avg);
							}
							
						}
						/**
						 * 统计分析
						 */
						public static Map<String,ClassRoom> count(List<Student> list){
							Map<String,ClassRoom> map = new HashMap<String,ClassRoom>();
							//1.遍历List
							for(Student stu:list){
								//分拣 查看是否存在该编号的班级
								String no = stu.getNo();//班级编号
								double score = stu.getScore();//成绩
								//如果不存在,创建班级
								ClassRoom room = map.get(no);
								if(null == room){
									room = new ClassRoom(no);
									map.put(no, room);
								}
								//存在,放入学生
								room.getStuList().add(stu);//放入学生
								room.setTotal(room.getTotal()+score);//计算总分
								
							}
							return map;
							
						}
						/**
						 * 模拟考试 测试数据放到List中
						 */
						public static List<Student> exam(){
							List<Student> list = new ArrayList<Student>();
							//存放学生成绩
							list.add(new Student("灭绝师太","Android",80));
							list.add(new Student("刘德华","Android",70));
							list.add(new Student("张惠妹","Android",60));
							list.add(new Student("黄健翔","Android",90));
							list.add(new Student("刘翔","JavaEE",85));
							list.add(new Student("周星驰","JavaEE",65));
							list.add(new Student("马云","JavaEE",70));
							list.add(new Student("马化腾","JavaEE",50));
							return list;
							
						}
					}
					//定义学生类
					class Student {
						private String name;//姓名
						private String no;//班级编号
						private double score;//成绩
						public Student() {
							
						}
						public Student(String name, String no, double score) {
							super();
							this.name = name;
							this.no = no;
							this.score = score;
						}
						public String getName() {
							return name;
						}
						public void setName(String name) {
							this.name = name;
						}
						public String getNo() {
							return no;
						}
						public void setNo(String no) {
							this.no = no;
						}
						public double getScore() {
							return score;
						}
						public void setScore(double score) {
							this.score = score;
						}	
					}
					//定义班级类(一个班级有多个学生)
					class ClassRoom {
						private String no;//班级
						private List<Student> stuList;//班级列表
						private double total;//总分
						public ClassRoom() {
							stuList = new ArrayList<Student>();
						}
						public ClassRoom(String no) {
							this();
							this.no = no;
						}
						public ClassRoom(String no, List<Student> stuList, double total) {
							super();
							this.no = no;
							this.stuList = stuList;
							this.total = total;
						}
						public String getNo() {
							return no;
						}
						public void setNo(String no) {
							this.no = no;
						}
						public List<Student> getStuList() {
							return stuList;
						}
						public void setStuList(List<Student> stuList) {
							this.stuList = stuList;
						}
						public double getTotal() {
							return total;
						}
						public void setTotal(double total) {
							this.total = total;
						}	
					}
			
5.练习今天的课堂代码
