1.分析以下需求，并用代码实现：
	(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)
	(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
	(3)利用四种方式遍历Map集合中的内容，格式：key::value
	
2.分析以下需求，并用代码实现：
	(1)利用键盘录入，输入一个字符串
	(2)统计该字符串中各个字符的数量
	(3)如：
		用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java"
		程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)u(4)v(1)w(1)y(3)~(6)
	
3.分析以下需求，并用代码实现：
	(1)统计每个单词出现的次数
	(2)有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
	(3)打印格式：
		to=3
  		think=1
  		you=2
  		//........
		
4.分析以下需求，并用代码实现：
	(1)定义一个学生类Student，属性：姓名(String name)、班级班号(String no)、成绩(double score)
	(2)将若干Student对象存入List集合，并统计每个班级的总分和平均分
		思路：
			a.采用面向对象的思想
			b.不推荐使用Map<String,List<Student>> 操作不方便
			c.推荐使用Map<String，ClassRoom>
			
5.练习今天的课堂代码
