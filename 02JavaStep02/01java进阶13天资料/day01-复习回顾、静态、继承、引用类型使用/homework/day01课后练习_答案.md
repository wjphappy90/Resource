# day01课后练习答案

# 基础题目
## 第一题：概念题
1. 什么叫做类与类的继承，作用是什么？
  ```java
继承:是指在现有类的基础上定义一个新的类,现有类称为父类,新的类称为子类
继承的作用:子类会自动拥有父类的可继承的内容
  ```
2. 请写出继承的格式
  ```java
class 子类 extends 父类 {
	// 代码
}
  ```

3. 请写出继承的特点
  ```java
1.Java只支持单继承
2.一个类可以有多个子类
3.Java支持多层继承
  ```

## 第二题：语法练习
* 语法点：继承
* 请使用继承定义以下类:
  ```java
  程序员(Coder)
    成员变量: 姓名,年龄
    成员方法: 吃饭,睡觉,敲代码

  老师(Teacher)
    成员变量: 姓名,年龄
    成员方法: 吃饭,睡觉,上课
  ```
  将程序员和老师中相同的内容(姓名,年龄,吃饭,睡觉)抽取到父类Person中

* 按步骤编写代码，效果如图所示：
  ![](img\11.jpg)

* 编写步骤：
  1. 定义父类Person类,添加姓名,年龄成员变量,添加吃饭,睡觉方法
  2. 定义Coder类继承Person类,添加敲代码方法
  3. 定义Teacher类继承Person类,添加上课方法
  4. 在测试类中，创建Code对象,并设置成员变量的值,调用Coder对象的eat,sleep,coding方法.创建Teacher对象,并设置成员变量的值,调用Teacher对象的eat,sleep,teach方法

* 参考答案：
* Person类
  ```java
  public class Person {
  	String name;
  	int age;
  	
  	public void eat() {
  		System.out.println(name + "吃饭");
  	}
  	
  	public void sleep() {
  		System.out.println(name + "睡觉");
  	}
  }
  ```
* Coder类
  ```java
  public class Coder extends Person {

  	// 敲代码
  	public void coding() {
  		System.out.println(name + "敲代码");
  	}
  }
  ```
* Teacher类
  ```java
  public class Teacher extends Person {
  	
  	public void teach() {
  		System.out.println(name + "上课");
  	}
  }
  ```
* Test2测试类
```java
public class Test2 {
    public static void main(String[] args) {
        // 创建Code对象,并设置成员变量的值
        Coder c = new Coder();
        c.name = "马化腾";
        c.age = 45;
        // 调用Coder对象的eat()方法
        c.eat();
        // 调用Coder对象的sleep()方法
        c.sleep();
        // 调用Coder对象的coding()方法
        c.coding();

        System.out.println("-----------");
        // 创建Teacher对象,并设置成员变量的值
        Teacher t = new Teacher();
        t.name = "马云";
        t.age = 50;
        // 调用Teacher对象的eat()方法
        t.eat();
        // 调用Teacher对象的sleep()方法
        t.sleep();
        // 调用Teacher对象的teach()方法
        t.teach();
    }
}
```


## 第三题：语法练习
* 语法点：继承
* 请使用继承定义以下类:
  ```java
  狗(Dog)
    成员变量: 姓名,颜色,价格
    成员方法: 吃饭,看家

  猫(Cat)
    成员变量: 姓名,颜色,价格
    成员方法: 吃饭,抓老鼠
  ```
  将狗和猫相同的内容(姓名,颜色,价格,吃饭)抽取到父类Animal中

* 按步骤编写代码，效果如图所示：
  ![](img\12.jpg)

* 编写步骤：
  1. 定义父类Animal类,添加姓名,年龄,价格成员变量,添加吃饭方法
  2. 定义Dog类继承Animal类,添加看家方法
  3. 定义Cat类继承Animal类,添加抓老鼠方法
  4. 在测试类中，创建Dog对象,并设置成员变量的值,调用Dog对象的eat,lookHome方法.创建Cat对象,并设置成员变量的值,调用Cat对象的eat,catchMouse方法

* 参考答案：
* Animal类
  ```java
  public class Animal {
      // 姓名,颜色,价格,吃饭
      String name;
      String color;
      double price;

      public void eat() {
          System.out.println(name + "在吃饭");
      }
  }
  ```
* Dog类
  ```java
  public class Dog extends Animal {
      // 看家
      public void lookHome() {
          System.out.println(name + "狗看家");
      }
  }
  ```
* Cat类
  ```java
  public class Cat extends Animal {
      // 抓老鼠
      public void catchMouse() {
          System.out.println(name + "猫抓老鼠");
      }
  }
  ```
* Test3测试类
  ```java
  public class Test3 {
      public static void main(String[] args) {
          // 创建Dog对象,并设置成员变量的值
          Dog d = new Dog();
          d.name = "旺财";
          d.color = "黄色";
          d.price = 200;
          // 调用Dog对象的eat()方法
          d.eat();
          // 调用Dog对象的lookHome()方
          d.lookHome();

          System.out.println("-----------");
          // 创建Cat对象,并设置成员变量的值
          Cat c = new Cat();
          c.name = "波斯猫";
          c.color = "黑色";
          c.price = 300;
          // 调用Dog对象的eat()方法
          c.eat();
          // 调用Dog对象的catchMouse()方法
          c.catchMouse();
      }
  }
  ```

## 第四题：语法练习
* 语法点：static

* 按步骤编写代码，效果如下：
  

![1560519783454](img/1560519783454.png)

* 编写步骤：
  1. 写一个标准的华为手机类(HWPhone)
  2. 手机属性有: 型号(type),价格(price),颜色(color) ,及静态的品牌(brand)
  3. 手机行为有: 打电话(call)
  4. 写手机测试类(PhoneTest)
  5. 创建手机对象,并设置手机的属性
6. 打印手机对象的品牌,型号,价格和颜色
  7. 调用手机打电话方法

* 参考答案：

测试类：

```java
public class PhoneTest {
    public static void main(String[] args) {
        HWPhone.brand = "华为";
        HWPhone hw = new HWPhone("p30", 3999, "奶奶灰");

        System.out.println(HWPhone.brand + "," + hw.getType() + "," + hw.getPrice() + "," + hw.getColor());
    }
}
```

HWPhone.java

```java
public class HWPhone {
    public static String brand;
    private String type;
    private double price;
    private String color;

    public HWPhone() {
    }

    public HWPhone(String type, double price, String color) {
        this.type = type;
        this.price = price;
        this.color = color;
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        HWPhone.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
```

## 第五题：语法练习

* 语法点：继承

* 按步骤编写代码，效果如图所示：
  ![](img\4.jpg)

* 编写步骤：
  1. 模拟教学管理系统师生信息
  2. 定义Person类
     1. 属性：姓名(私有)、年龄(私有)
     2. 构造方法：无参构造方法，有参构造方法
     3. 成员方法：getXxx方法，setXxx方法
  3. 定义Teacher类，继承Person
     1. 属性：学科(私有)
     2. 构造方法：无参构造方法，有参构造方法
     3. 成员方法：getXxx方法，setXxx方法，讲课方法
  4. 定义Student类，继承Person
     1. 属性：分数(私有)
     2. 构造方法：无参构造方法，有参构造方法
     3. 成员方法：getXxx方法，setXxx方法，考试方法


* 参考答案：
```java
  public class Test5 {
      public static void main(String[] args) {
          // 1.创建老师对象t,并把名称赋值为”王小平”,年龄赋值为30,工资赋值为8000
          Teacher t = new Teacher("王小平", 30, "Java");
          // 2.调用老师对象t的讲课方法
          t.teach();
  
          // 3.创建学生对象 s,并把名称赋值为”李小乐”,年龄赋值为14,成绩赋值为90分.
          Student s = new Student("李小乐", 14, 90);
          // 4.调用学生对象 s 的考试方法
          s.exam();
      }
  }

   class Person {
      // 名称(name)
      private String name;
      //	年龄(age)
      private int age;

      //	空参构造
      public Person() {
      }
      //  带参构造
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
      // setXxx和getXxx方法
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
  }
  /*
   2.定义老师类(Teacher),继承Person类
   */
   class Teacher extends Person {
      //    course(科目)
      private String course;
      //	空参构造
      public Teacher() {
      }
      //	带参构造方法
      public Teacher(String name,int age, String course) {
          super(name,age);
          this.course = course;
      }

      //	提供setXxx和getXxx方法
      public String getCourse() {
          return course;
      }
      public void setCourse(String course) {
          this.course = course;
      }

      public void teach() {
          System.out.println(getName() +"老师,讲授"+course +"课");
      }
  }
  /*
   3.定义学生类(Student),继承Person类
   */
   class Student extends Person {
      //	score(成绩)
      private int score;
      //	无参构造
      public Student() {
          super();
      }
      //	带参构造
      public Student(String name, int age,int score) {
          super(name, age);
          this.score = score;
      }

      //	提供setXxx和getXxx方法
      public int getScore() {
          return score;
      }
      public void setScore(int score) {
          this.score = score;
      }

      public void exam(){
          System.out.println(getName()+"同学,考试得了:"+ score +"分");
      }
  }
```

