
# day02 抽象类题目
## 第一题：需求实现
* 语法点：封装，继承，抽象方法，抽象类
* 请使用代码描述:
  ```java
  2岁的红色的公鸡会吃饭(啄米)和打鸣 
  1岁的黑色的鸭子会吃饭(吃鱼)和游泳
  ```

* 按步骤编写代码，效果如图所示：
  ![](img\16.jpg)

* 开发提示：
  * 把公鸡和鸭子的共性内容(年龄属性,颜色属性,吃饭方法)抽取到家禽类中
  * 家禽类中定义抽象的吃饭方法
  * 公鸡继承家禽,重写吃饭方法,添加特有方法打鸣
  * 鸭子继承家禽,重写吃饭方法,添加特有方法游泳

* 参考答案：
  ```java
  public class Test6 {
      public static void main(String[] args) {
          // 创建公鸡对象
          Cock c = new Cock(2, "红色");
          // 调用公鸡的吃饭和打鸣方法
          c.eat();
          c.call();

          // 创建鸭子类
          Duck d = new Duck(1, "黑色");
          // 调用鸭子的吃饭和游泳方法
          d.eat();
          d.swimming();
      }
  }

  abstract class Poultry {
      // 年龄属性,颜色属性,吃饭方法
      private int age;
      private String color;
      public abstract void eat();

      public Poultry() {
      }

      public Poultry(int age, String color) {
          this.age = age;
          this.color = color;
      }

      public int getAge() {
          return age;
      }

      public void setAge(int age) {
          this.age = age;
      }

      public String getColor() {
          return color;
      }

      public void setColor(String color) {
          this.color = color;
      }
  }

  // 公鸡类
  class Cock extends Poultry {
      public Cock() {
      }

      public Cock(int age, String color) {
          super(age, color);
      }

      // 重写吃饭方法
      public void eat() {
          System.out.println(getAge() + "岁的" + getColor() + "的公鸡在啄米");
      }

      // 特有方法打鸣
      public void call() {
          System.out.println(getAge() + "岁的" + getColor() + "的公鸡在打鸣");
      }
  }

  // 鸭子类
  class Duck extends Poultry {
      public Duck() {
      }

      public Duck(int age, String color) {
          super(age, color);
      }

      // 重写吃饭方法
      public void eat() {
          System.out.println(getAge() + "岁的" + getColor() + "的鸭子在吃饭");
      }

      // 特有方法游泳
      public void swimming() {
          System.out.println(getAge() + "岁的" + getColor() + "的鸭子在游泳");
      }
  }
  ```



## 第二题：需求实现
* 语法点：封装，继承，抽象方法，抽象类

* 请使用代码描述:
  ```java
  1. 经理
    成员变量:工号,姓名,工资
    成员方法:工作(管理其他人),吃饭(吃鱼)
  2. 厨师
    成员变量:工号,姓名,工资
    成员方法:工作(炒菜),吃饭(吃肉)
  ```

* 按步骤编写代码，效果如图所示：
  ![](img\17.jpg)

* 开发提示：
  * 把经理和厨师的共性内容(工号属性,姓名属性,工资属性,工作方法,吃饭方法)抽取到员工类中
  * 员工类中定义抽象的工作方法和抽象的吃饭方法
  * 经理继承员工,重写工作方法,和吃饭方法
  * 厨师继承员工,重写工作方法,和吃饭方法

* 参考答案：
  ```java
  public class Test7 {
      public static void main(String[] args) {
          // 创建Manager对象
          Manager m = new Manager("m110", "老王", 10000);
          // 调用Manager对象的eat方法
          m.eat();
          // 调用Manager对象的work方法
          m.work();

          // 创建Cook对象
          Cook c = new Cook("c110", "小王", 6000);
          // 调用Cook对象的eat方法
          c.eat();
          // 调用Cook对象的work方法
          c.work();
      }
  }

  // 员工类
  abstract class Employee {
      // 工号属性,姓名属性,工资属性
      private String id;
      private String name;
      private double salary;

      public Employee() {
      }

      public Employee(String id, String name, double salary) {
          this.id = id;
          this.name = name;
          this.salary = salary;
      }

      // 抽象的工作方法
      public abstract void work();

      // 抽象的吃饭方法
      public abstract void eat();

      public String getId() {
          return id;
      }

      public void setId(String id) {
          this.id = id;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public double getSalary() {
          return salary;
      }

      public void setSalary(double salary) {
          this.salary = salary;
      }
  }

  // 经理继承员工,重写工作方法,和吃饭方法
  class Manager extends Employee {
      public Manager() {
      }

      public Manager(String id, String name, double salary) {
          super(id, name, salary);
      }

      @Override
      public void work() {
          System.out.println("工号为:" + getId() + ",姓名为:" + getName() + "工资为:" + getSalary() + "的经理在工作,管理其他人");
      }

      @Override
      public void eat() {
          System.out.println("工号为:" + getId() + ",姓名为:" + getName() + "工资为:" + getSalary() + "的经理在吃鱼");
      }
  }

  class Cook extends Employee {
      public Cook() {
      }

      public Cook(String id, String name, double salary) {
          super(id, name, salary);
      }

      @Override
      public void work() {
          System.out.println("工号为:" + getId() + ",姓名为:" + getName() + "工资为:" + getSalary() + "的厨师在工作,炒菜");
      }

      @Override
      public void eat() {
          System.out.println("工号为:" + getId() + ",姓名为:" + getName() + "工资为:" + getSalary() + "的厨师在吃肉");
      }
  }
  ```


## 第三题：需求实现
* 语法点：封装，继承，抽象方法，抽象类
* 请使用代码描述
  ```java
  1. 在传智播客有很多员工(Employee),按照工作内容不同分教研部员工(Teacher)和行政部员工(AdminStaff)
  2. 教研部根据教学的方式不同又分为讲师(Lecturer)和助教(Tutor)
  3. 行政部根据负责事项不同,又分为维护专员(Maintainer),采购专员(Buyer)
  4. 公司的每一个员工都编号,姓名和其负责的工作
  5. 每个员工都有工作的功能,但是具体的工作内容又不一样,在向上抽取的时候定义为抽象方法
  ```
* 按步骤编写代码，效果如图所示：
  ![](img\18.jpg)

* 开发提示：
  ![](img\181.jpg)

编写步骤：
    1. 定义抽象类员工类(Employee)
      a)成员变量: 工号(id),姓名(name)
      b)抽象方法: void work();
      c)提供无参和带参的构造方法以及setters和getters
    2. 定义抽象类教研部员工（Teacher）类继承员工类(Employee)
      a)提供无参和带参的构造方法
    3. 定义抽象类行政部员工(AdminStaff)类继承员工类(Employee)
      a)提供无参和带参的构造方法
    4. 定义讲师(Lecturer)类继承研部员工（Teacher）类
      a)提供无参和带参的构造方法
      b)实现抽象方法: void work();
      输出格式: 工号为 666 的讲师 傅红雪 在讲课
    5. 定义助教(Tutor)类继承研部员工（Teacher）类
      a)提供无参和带参的构造方法
      b)实现抽象方法: void work();
      输出格式: 工号为 668 的助教 顾棋 在帮助学生解决问题
    6. 定义维护专员(Maintainer)类继承行政部员工(AdminStaff)类
      a)提供无参和带参的构造方法
      b)实现抽象方法: void work();
      输出格式: 工号为 686 的维护专员 庖丁 在解决不能共享屏幕问题
    7. 定义采购专员(Buyer) 类继承行政部员工(AdminStaff)类
      a)提供无参和带参的构造方法
      b)实现抽象方法: void work();
      输出格式:  工号为 888 的采购专员 景甜 在采购音响设备
    8. 定义测试类Test8
      a)创建讲师对象 l, 把工号赋值为666,姓名赋值为”傅红雪”
      b)调用讲师对象l的工作方法
      c)创建助教对象 t, 把工号赋值为668,姓名赋值为”顾棋”
      d)调用助教对象t的工作方法
      e)创建维护专员对象 m, 把工号赋值为686,姓名赋值为”庖丁”
      f)调用维护专员对象m的工作方法
      g)创建采购专员对象 b, 把工号赋值为888,姓名赋值为”景甜”
      h)调用采购专员对象b的工作方法


* 参考答案：
  * Employee类
  ```java
  /*
   1.定义抽象类员工类(Employee)
  	a)成员变量: 工号(id),姓名(name)
  	b)抽象方法: void work();
  	c)提供无参和带参的构造方法以及setters和getters
   */
  public abstract class Employee {
      //	a)成员变量: 工号(id),姓名(name)
      private String id;
      private String name;

      //	b)抽象方法: void work();
      public abstract void work();

      //	c)提供无参和带参的构造方法以及setters和getters
      public Employee() {
          super();
      }

      public Employee(String id, String name) {
          super();
          this.id = id;
          this.name = name;
      }

      public String getId() {
          return id;
      }

      public void setId(String id) {
          this.id = id;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }
  }
  ```
  * Teacher类
  ```java
  /*
   2.定义抽象类教研部员工（Teacher）类继承员工类(Employee)
   */
  public abstract class Teacher extends Employee{
  //  a)提供无参和带参的构造方法
  	public Teacher() {
  		super();
  	}

  	public Teacher(String id, String name) {
  		super(id, name);
  	}
  }
  ```
  * AdminStaff类
  ```java
  /*
   3.定义抽象类行政部员工(AdminStaff)类继承员工类(Employee)
   */
  public abstract class AdminStaff extends Employee {
  //	a)提供无参和带参的构造方法
  	public AdminStaff() {
  		super();
  	}

  	public AdminStaff(String id, String name) {
  		super(id, name);
  	}
  }  
  ```
  * Lecturer类
  ```java
  /*
   4.定义讲师(Lecturer)类继承研部员工（Teacher）类
   */
  public class Lecturer extends Teacher {
  //	a)提供无参和带参的构造方法
  	public Lecturer() {
  		super();
  	}
  	public Lecturer(String id, String name) {
  		super(id, name);
  	}
  	
  //	b)实现抽象方法: void work();
  //		输出格式: 工号为 666 的讲师 傅红雪 在讲课
  	public void work() {
  		System.out.println("工号为 "+getId()+" 的讲师 "+getName()+" 在讲课");
  	}
  }
  ```
  * Tutor类
  ```java
  /*
   5.定义助教(Tutor)类继承研部员工（Teacher）类
   */
  public class Tutor extends Teacher{
  //	a)提供无参和带参的构造方法
  	public Tutor() {
  		super();
  	}

  	public Tutor(String id, String name) {
  		super(id, name);
  	}
  //	b)实现抽象方法: void work();
  //		i.输出格式: 工号为 668的助教 顾棋 在帮助学生解决问题
  	public void work() {
  		System.out.println("工号为 "+getId()+"的助教 "+getName()+" 在帮助学生解决问题");
  	}
  }
  ```
  * Maintainer类
  ```java
  /*
   6.定义维护专员(Maintainer)类继承行政部员工(AdminStaff)类
   */
  public class Maintainer extends AdminStaff {
  //	a)提供无参和带参的构造方法
  	public Maintainer() {
  		super();
  	}

  	public Maintainer(String id, String name) {
  		super(id, name);
  	}
  //	b)实现抽象方法: void work();
  //	i.输出格式: 工号为 686 的维护专员 庖丁 在解决不能共享屏幕问题
  	public void work() {
  		System.out.println("工号为 "+getId()+" 的维护专员 "+getName()+" 在解决不能共享屏幕问题");
  	}
  }
  ```
  * Buyer类
  ```java
  /*
   7.定义采购专员(Buyer) 类继承行政部员工(AdminStaff)类
   */
  public class Buyer extends AdminStaff {
  //	a)提供无参和带参的构造方法
  	public Buyer() {
  		super();
  	}

  	public Buyer(String id, String name) {
  		super(id, name);
  	}
  //	b)实现抽象方法: void work();
  //	输出格式:  工号为 888 的采购专员 景甜 在采购音响设备
  	public void work() {
  		System.out.println("工号为 "+getId()+" 的采购专员 "+getName()+" 在采购音响设备");
  	}
  }
  ```
  * Test8测试类
  ```java
  /*
  8.定义测试类Test
   */
  public class Test8 {
  	public static void main(String[] args) {
  //		a)创建讲师对象l, 把工号赋值为666,姓名赋值为”傅红雪”
  		Lecturer l = new Lecturer("666", "傅红雪");
  //		b)调用讲师对象l的工作方法
  		l.work();

  //		c)创建助教对象 t, 把工号赋值为668,姓名赋值为”顾棋”
  		Tutor t = new Tutor("668", "顾棋");
  //		d)调用助教对象t的工作方法
  		t.work();

  //		e)创建维护专员对象 m, 把工号赋值为686,姓名赋值为”庖丁”
  		Maintainer m = new Maintainer("686", "庖丁");
  //		f)调用维护专员对象m的工作方法
  		m.work();

  //		g)创建采购专员对象 b, 把工号赋值为888,姓名赋值为”景甜”
  		Buyer b = new Buyer("888", "景甜");
  //		h)调用采购专员对象b的工作方法
  		b.work();
  	}
  }
  ```
