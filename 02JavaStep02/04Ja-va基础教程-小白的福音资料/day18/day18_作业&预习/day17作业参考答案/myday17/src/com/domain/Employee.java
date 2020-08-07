package com.itheima.domain;
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