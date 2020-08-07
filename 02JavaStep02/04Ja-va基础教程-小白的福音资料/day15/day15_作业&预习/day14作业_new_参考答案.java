1.分析以下需求，并用代码实现：
	(1)定义一个存放手机号码的数字字符串数组{"16210626656","18601066888","13912387666","13156166693","15115888028"}
	(2)利用正则表达式过滤出符合条件的手机号码，
		规则：第1位是1，第二位可以是数字358其中之一，后面6位任意数字，最后3位为任意相同的数字。
	(3)如：18601066888 13912387666
		答：参考答案
				package com.heima.tests;
				public class Test01 {
					public static void main(String[] args) {
						String regex = "[1][358]\\d{6}(\\d)\\1{2}";
						String phone1 = "18601088888";
						String phone2 = "13912366666";
						String[] numbers = {"16210626656","18601066888","13912387666","13156166693","15115888028"};
						System.out.println("有以下号码符合要求：");
						for(int i = 0;i<numbers.length;i++) {
							boolean flag = numbers[i].matches(regex);
							if(flag) {
								System.out.println(numbers[i]);
							}
						}		
					}
				}


2.正则表达式练习(只要求写出正则表达式)
	(1)邮箱
	(2)手机号
	(3)qq号(5-15位数字、0不能开头、必须都是数字)
	(4)叠词(快快乐乐,高高兴兴)
	(5)叠词(死啦死啦,高兴高兴)
	(6)密码(以字母开头，长度在6-18之间,只能包含数字、字母和下划线)
		答：略
	
3.分析以下需求，并用代码实现：
	(1)通过键盘录入日期字符串，格式(2015-10-20)
	(2)输出该日期是星期几及这一年的第几天
	(3)如输入：2015-10-20，输出"2015年-10月-20日 是 星期二，是  2015年的第 293 天"
		答：参考答案
				package com.heima.tests;
				import java.text.SimpleDateFormat;
				import java.util.Calendar;
				import java.util.Date;
				import java.util.Scanner;
				public class Test02 {
					public static void main(String[] args) throws Exception {
						//1.创建键盘录入对象
						Scanner sc = new Scanner(System.in);
						System.out.println("请输入数字日期字符串(格式:2015-10-20):");
						//2.获取键盘录入的字符串日期
						String dateStr = sc.nextLine();
						//3.定义格式化和解析日期的对象
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年-MM月-dd日");
						//4.将输入的字符串日期转换成日期对象
						Date date = sdf.parse(dateStr);
						//5.将日期对象转换成Calendar对象
						Calendar c = Calendar.getInstance();
						c.setTime(date);
						//6.获取该日期对象是一周的第几天
						int week = c.get(Calendar.DAY_OF_WEEK);
						//7.获取该日期对象是一年中的第几天
						int day = c.get(Calendar.DAY_OF_YEAR);
						//8.格式化date对象用于打印
						String dateStr2 = sdf2.format(date);
						System.out.println(dateStr2+" 是 "+getWeek(week)+"，是  "+c.get(Calendar.YEAR)+"年的第 "+day+" 天");
					}
					
					/*
					 * 将星期存储表中进行查表
					 * 1,返回值类型String
					 * 2,参数列表int week
					 */	
					public static String getWeek(int week) {
						String[] arr = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
						
						return arr[week];
					}
				}

4.练习今天课堂代码
	

	
