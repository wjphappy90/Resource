###10.01_面向对象(package关键字的概述及作用)(了解)
* A:为什么要有包
	* 将字节码(.class)进行分类存放 
	* 包其实就是文件夹
* B:包的概述
* 
	举例：
		学生：增加，删除，修改，查询
		老师：增加，删除，修改，查询
		...
		
		方案1：按照功能分
			com.heima.add
				AddStudent
				AddTeacher
			com.heima.delete
				DeleteStudent
				DeleteTeacher
			com.heima.update
				UpdateStudent
				UpdateTeacher
			com.heima.find
				FindStudent
				FindTeacher
		
		方案2：按照模块分
			com.heima.teacher
				AddTeacher
				DeleteTeacher
				UpdateTeacher
				FindTeacher
			com.heima.student
				AddStudent
				DeleteStudent
				UpdateStudent
				FindStudent
###10.02_面向对象(包的定义及注意事项)(掌握)
* A:定义包的格式
	* package 包名;
	* 多级包用.分开即可
* B:定义包的注意事项
	* A:package语句必须是程序的第一条可执行的代码
	* B:package语句在一个java文件中只能有一个
	* C:如果没有package，默认表示无包名
* C:案例演示
	* 包的定义及注意事项
	
###10.03_面向对象(带包的类编译和运行)(掌握)
* A:如何编译运行带包的类
	* a:javac编译的时候带上-d即可
		* javac -d . HelloWorld.java
	* b:通过java命令执行。
		* java 包名.HellWord
###10.04_面向对象(不同包下类之间的访问)(掌握)
* A:案例演示
	* 不同包下类之间的访问

###10.05_面向对象(import关键字的概述和使用)(掌握)
* A:案例演示
	* 为什么要有import
		* 其实就是让有包的类对调用者可见,不用写全类名了 
* B:导包格式
	* import 包名;
	* 注意：
	* 这种方式导入是到类的名称。
	* 虽然可以最后写*，但是不建议。
* C:package,import,class有没有顺序关系(面试题)

###10.06_面向对象(四种权限修饰符的测试)(掌握)
* A:案例演示
	* 四种权限修饰符
* B:结论
* 
					本类	 同一个包下(子类和无关类)	不同包下(子类)	不同包下(无关类)
		private 	Y		
		默认			Y		Y
		protected	Y		Y							Y
		public		Y		Y							Y				Y

###10.07_面向对象(类及其组成所使用的常见修饰符)(掌握)
* A:修饰符：
	* 权限修饰符：private，默认的，protected，public
	* 状态修饰符：static，final
	* 抽象修饰符：abstract
* B:类：
	* 权限修饰符：默认修饰符，public
	* 状态修饰符：final
	* 抽象修饰符：abstract
	
	* 用的最多的就是：public
	
* C:成员变量：
	* 权限修饰符：private，默认的，protected，public
	* 状态修饰符：static，final
	
	* 用的最多的就是：private
	
* D:构造方法：
	* 权限修饰符：private，默认的，protected，public
	
	* 用的最多的就是：public
	
* E:成员方法：
	* 权限修饰符：private，默认的，protected，public
	* 状态修饰符：static，final
	* 抽象修饰符：abstract
	
	* 用的最多的就是：public
	
* F:除此以外的组合规则：
	* 成员变量：public static final
	* 成员方法：
		* public static 
	    * public abstract
		* public final

###10.08_面向对象(内部类概述和访问特点)(了解)
* A:内部类概述
* B:内部类访问特点
	* a:内部类可以直接访问外部类的成员，包括私有。
	* b:外部类要访问内部类的成员，必须创建对象。
	* 外部类名.内部类名 对象名 = 外部类对象.内部类对象;
* C:案例演示
	* 内部类极其访问特点
	
###10.09_面向对象(成员内部类私有使用)(了解)
* private

###10.10_面向对象(静态成员内部类)(了解)
* static
* B:成员内部类被静态修饰后的访问方式是:
	* 外部类名.内部类名 对象名 = 外部类名.内部类对象;

###10.11_面向对象(成员内部类的面试题)(掌握)
* A:面试题
* 
		要求：使用已知的变量，在控制台输出30，20，10。
		
		class Outer {
			public int num = 10;
			class Inner {
				public int num = 20;
				public void show() {
					int num = 30;
					System.out.println(?);
					System.out.println(??);
					System.out.println(???);
				}
			}
		}
		class InnerClassTest {
			public static void main(String[] args) {
				Outer.Inner oi = new Outer().new Inner();
				oi.show();
			}	
		}

###10.12_面向对象(局部内部类访问局部变量的问题)(掌握)
* A:案例演示
	* 局部内部类访问局部变量必须用final修饰
	* 局部内部类在访问他所在方法中的局部变量必须用final修饰,为什么?
		因为当调用这个方法时,局部变量如果没有用final修饰,他的生命周期和方法的生命周期是一样的,当方法弹栈,这个局部变量也会消失,那么如果局部内部类对象还没有马上消失想用这个局部变量,就没有了,如果用final修饰会在类加载的时候进入常量池,即使方法弹栈,常量池的常量还在,也可以继续使用

		但是jdk1.8取消了这个事情,所以我认为这是个bug

###10.13_面向对象(匿名内部类的格式和理解)
* A:匿名内部类
	* 就是内部类的简化写法。
* B:前提：存在一个类或者接口
	* 这里的类可以是具体类也可以是抽象类。
* C:格式：
* 
		new 类名或者接口名(){
			重写方法;
		}
* D:本质是什么呢?
	* 是一个继承了该类或者实现了该接口的子类匿名对象。
* E:案例演示
	* 按照要求来一个匿名内部类
		
###10.14_面向对象(匿名内部类重写多个方法调用)
* A:案例演示
	* 匿名内部类的方法调用

###10.15_面向对象(匿名内部类在开发中的应用)

* A:代码如下
* 
		//这里写抽象类，接口都行
		abstract class Person {
			public abstract void show();
		}
	
		class PersonDemo {
			public void method(Person p) {
				p.show();
			}
		}
	
		class PersonTest {
			public static void main(String[] args) {
				//如何调用PersonDemo中的method方法呢?
				PersonDemo pd = new PersonDemo ();
				
			}
		}

###10.16_面向对象(匿名内部类的面试题)
* A:面试题
* 
		按照要求，补齐代码
		interface Inter { void show(); }
		class Outer { //补齐代码 }
		class OuterDemo {
			public static void main(String[] args) {
				  Outer.method().show();
			  }
		}
		要求在控制台输出”HelloWorld”

###10.17_day10总结
* 把今天的知识点总结一遍。