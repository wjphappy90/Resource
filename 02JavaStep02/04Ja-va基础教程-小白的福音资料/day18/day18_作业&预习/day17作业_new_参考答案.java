1.分析以下需求，并用代码实现：
	(1)定义一个员工类Employee，包含三个属性：姓名(String name)、年龄(int age)、工资(int salary)
	(2)创建5个对象装入TreeSet，按照工资从高到底排序输出结果(工资相同，按照年龄从低到高，工资和年龄都相同，
		按照姓名字典顺序排列，但是不能去重(姓名、年龄、工资都相同))
		答：参考答案
			//员工类
			public class Employee implements Comparable<Employee>{
				private String name;
				private int age;
				private int salary;
				public Employee() {

				}
				public Employee(String name, int age, int salary) {
					this.name = name;
					this.age = age;
					this.salary = salary;
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
				public int getSalary() {
					return salary;
				}
				public void setSalary(int salary) {
					this.salary = salary;
				}
				@Override
				public String toString() {
					return "Employee [name=" + name + ", age=" + age + ", salary=" + salary
							+ "]";
				}
				@Override
				public int compareTo(Employee o) {
					int num = o.salary-this.salary;
					num = (num==0?this.age-o.age:num);
					num = (num==0?this.name.compareTo(o.name):num);
					num = (num==0?1:num);
					return num;
				}
				
				
			}
			
			//完成功能的代码
			package com.heima.tests;
			import java.util.Comparator;
			import java.util.Iterator;
			import java.util.TreeSet;

			import com.heima.domain.Employee;
			public class Test01 {
				public static void main(String[] args) {
					TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {

						@Override
						public int compare(Employee o1, Employee o2) {
							int num = o2.getSalary()-o1.getSalary();
							num = (num==0?o1.getAge()-o2.getAge():num);
							num = (num==0?o1.getName().compareTo(o2.getName()):num);
							num = (num==0?1:num);
							return num;
						}
						
					});
					set.add(new Employee("张三",30,8000));
					set.add(new Employee("李四",20,9000));
					set.add(new Employee("王五",10,7000));
					set.add(new Employee("王五",10,7000));
					set.add(new Employee("赵六",40,9000));
					set.add(new Employee("刘七",60,6000));
					set.add(new Employee("水清",30,6000));
					//利用迭代器显示set集合的内容
					Iterator<Employee> it = set.iterator();
					while(it.hasNext()) {
						Employee employee = it.next();
						System.out.println(employee);
					}
				}
			}

2.分析以下需求，并用代码实现：	
	(1)定义一个TreeSet集合，然后存入6个Double类型的数据，分别是[1.1,5.2,6.3,2.5,5.2,3.3]
	(2)不去重，然后遍历输出(从大到小)
		答：参考答案
			public class Test02 {
				public static void main(String[] args) {
					TreeSet<Double> ts = new TreeSet<>(new Comparator<Double>() {
						@Override
						public int compare(Double o1, Double o2) {	
							int num = o2.compareTo(o1);
							return num==0?1:num;
						}			
					});
					//[1.1,5.2,6.3,2.5,5.2,3.3]
					ts.add(1.1);
					ts.add(5.2);
					ts.add(6.3);
					ts.add(2.5);
					ts.add(5.2);
					ts.add(3.3);
					Iterator<Double> it = ts.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
				}
			}
			
3.练习今天的课堂代码		
