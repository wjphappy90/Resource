/*
* A:定义包的格式
	* package 包名;
	* 多级包用.分开即可
* B:定义包的注意事项
	* A:package语句必须是程序的第一条可执行的代码
	* B:package语句在一个java文件中只能有一个
	* C:如果没有package，默认表示无包名
*/
package com.heima;
import com.baidu.Person;
import com.xxx.Student;
//import java.util.Scanner;		//在开发中我们用的都是导入具体的类
import java.util.*;				//*代表通配符,他会到该包下挨个匹配,匹配上就导入
class Demo1_Package {
	public static void main(String[] args) {
		Person p = new Person("张三",23);
		System.out.println(p.getName() + "..." + p.getAge());
		//p.print();			//在不同包下的无关类,不允许访问,因为是protected修饰的

		/*Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.println(x);*/
		
		Student s = new Student("李四",24);
		System.out.println(s.getName() + "..." + s.getAge());
		s.method();
	}
}
