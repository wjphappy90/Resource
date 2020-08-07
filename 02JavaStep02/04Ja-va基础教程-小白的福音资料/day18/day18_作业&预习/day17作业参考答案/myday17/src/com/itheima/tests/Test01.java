package com.itheima.tests;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
/*

1.分析以下需求，并用代码实现：
	(1)定义一个员工类Employee，包含三个属性：姓名(String name)、年龄(int age)、工资(int salary)
	(2)创建5个对象装入TreeSet，按照工资从高到底排序输出结果(工资相同，按照年龄从低到高，工资和年龄都相同，
		按照姓名字典顺序排列，但是不能去重(姓名、年龄、工资都相同))


*/
import com.itheima.domain.Employee;
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