package com.itheima._test02.level02_01;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 自定义学生类:包含姓名,年龄,成绩属性.私有成员变量,生成无参,有参构造方法,生成get/set方法.
 * 创建5个学生放到ArrayList中.使用迭代器获取每个学生信息.统计总分,平均分,最高分,最低分并输出
 */
public class Test01 {

	public static void main(String[] args) {
		// 2.定义ArrayList
		ArrayList<Student> students = new ArrayList<>();

		// 3.添加5个学生
		students.add(new Student("张三", 20, 99));
		students.add(new Student("王昭君", 21, 88));
		students.add(new Student("西施", 20, 80));
		students.add(new Student("杨玉环", 20, 70));
		students.add(new Student("凤姐", 22, 30));

		// 4.获取迭代器
		Iterator<Student> itr = students.iterator();

		// 5.定义总分
		double totalScore = 0;
		// 6.定义最高分
		double maxScore = students.get(0).getScore();
		// 7.定义最低分
		double minScore = students.get(0).getScore();

		// 8.循环判断是否有下一个学生
		while (itr.hasNext()) {
			// 9.使用next方法获取学生对象
			Student student = itr.next();

			// 10.将这个学生对象的分数添加到总分
			totalScore += student.getScore();

			// 11.判断这个学生的分数是否大于最大分数
			if (maxScore < student.getScore()) {
				// 12.这个学生的分数大于最大分数.最大分数等于这个学生的分数
				maxScore = student.getScore();
			} else if (minScore > student.getScore()) {
				// 13.判断这个学生的分数是否大低最大分数
				// 14.这个学生的分数小于最小分数.最小分数等于这个学生的分数
				minScore = student.getScore();
			}
		}

		// 15.计算平均分(平均分 = 总分/人数)
		double avgScore = totalScore / students.size();
		// 16.打印总分,最高分,最低分
		System.out.println("总分 = " + totalScore + " ,平均分 = " + avgScore + " ,最高分 = " + maxScore + ",最低 = " + minScore);
	}
}
