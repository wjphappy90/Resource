# day02【抽象类，接口、代码块、final、单例、枚举】

## 今日内容(记住语法) 

- 抽象类
  - 拥有抽象方法的类就是抽象类。
  - 抽象方法：是只有方法签名没有方法体，必须用abstract修饰。
  - 抽象类本身也要用abstract修饰的，作用是让子类继承，子类一定要重写抽象方法。
  - 模板思想，设计模板模式。
- 接口
  * 更加彻底的抽象，接口中全部是抽象方法和常量（JDK1.8之后）
  * 接口体现的是规范思想，实现接口的类必须重写完接口的全部抽象方法，否则这个类必须是抽象类。 
  * JDK 1.8之后的接口新增了三个方法。接口不再纯洁。
- 代码块（成员变量，方法，构造器，代码块，内部类）
- final关键字
  * final是最终的意思。可以修饰类，变量，和方法。
  * 修饰类：类不能被继承。类绝育了。
  * 修饰方法：方法不能被重写。
  * 修饰变量：变量有且仅能被赋值一次。
- 单例设计模式
  - 设计模式，面试必考，经典模式。
- 枚举
  - 面向对象的一种特殊类型，做信息分类和信息标志的。


## 教学目标

- [x] 能够写出抽象类的格式
  - [ ] **abstract** class Animal{
  - [ ] }
  
- [x] 能够写出抽象方法的格式
  - [ ] **public abstract void run();**
  - [ ] 只有方法签名，没有方法体，必须用abstract修饰。
  
- [ ] 父类抽象方法的意义

  - [ ] 被子类继承

- [x] 写出定义接口的格式
  - [ ] public **interface** SportMan{
  
    ​		
  
  - [ ] }
  
- [x] 写出实现接口的格式
  - [ ] 修饰符 class 实现类  **implements**  接口1 , 接口2{
  - [ ] }
  
- [x] 说出接口中成员的特点
  - [ ] JDK 1.8之前全部是抽象方法和常量，其他都没有。
  - [ ] JDK 1.8之后，有了静态方法，默认方法，JDK 1.9之后有了私有方法。
  
- [x] 描述final修饰的类的特点
  
  - [ ] 类不能被继承
  
- [x] 描述final修饰的方法的特点
  
  - [ ] 方法不能被重写了
  
- [x] 描述final修饰的变量的特点
  
  - [ ] 变量有且仅能被赋值一次
  
- [x] 能够写出静态代码块的
  - [ ] static{ 
  - [ ] }

# 第一章 抽象类

## 1.1 概述

### 1.1.1 抽象类引入

父类中的方法，被它的子类们重写，子类各自的实现都不尽相同。那么父类的方法声明和方法主体，只有声明还有意义，而方法主体则没有存在的意义了(因为子类对象会调用自己重写的方法)。换句话说，父类可能知道子类应该有哪个功能，但是功能具体怎么实现父类是不清楚的（由子类自己决定），父类完全只需要提供一个没有方法体的方法签名即可，具体实现交给子类自己去实现。**我们把没有方法体的方法称为抽象方法。Java语法规定，包含抽象方法的类就是抽象类**。

- **抽象方法** ： 没有方法体的方法。
- **抽象类**：包含抽象方法的类。

## 1.2 abstract使用格式

**abstract是抽象的意思，用于修饰方法方法和类，修饰的方法是抽象方法，修饰的类是抽象类。**

### 1.2.1 抽象方法

使用`abstract` 关键字修饰方法，该方法就成了抽象方法，抽象方法只包含一个方法名，而没有方法体。

定义格式：

```java
修饰符 abstract 返回值类型 方法名 (参数列表)；
```

代码举例：

```java
public abstract void run()；
```

### 1.2.2 抽象类

如果一个类包含抽象方法，那么该类必须是抽象类。**注意：抽象类不一定有抽象方法，但是有抽象方法的类必须定义成抽象类。**

定义格式：

```java
abstract class 类名字 { 
  
}

```

代码举例：

```java
public abstract class Animal {
    public abstract void run()；
}
```

### 1.2.3 抽象类的使用

**要求**：继承抽象类的子类**必须重写父类所有的抽象方法**。否则，该子类也必须声明为抽象类。

代码举例：

```java
// 父类,抽象类
abstract class Employee {
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
	
	// 抽象方法
	// 抽象方法必须要放在抽象类中
	abstract public void work();
}

// 定义一个子类继承抽象类
class Manager extends Employee {
	public Manager() {
	}
	public Manager(String id, String name, double salary) {
		super(id, name, salary);
	}
	// 2.重写父类的抽象方法
	@Override
	public void work() {
		System.out.println("管理其他人");
	}
}

// 定义一个子类继承抽象类
class Cook extends Employee {
	public Cook() {
	}
	public Cook(String id, String name, double salary) {
		super(id, name, salary);
	}
	@Override
	public void work() {
		System.out.println("厨师炒菜多加点盐...");
	}
}

// 测试类
public class Demo10 {
	public static void main(String[] args) {
		// 创建抽象类,抽象类不能创建对象
		// 假设抽象类让我们创建对象,里面的抽象方法没有方法体,无法执行.所以不让我们创建对象
//		Employee e = new Employee();
//		e.work();
		
		// 3.创建子类
		Manager m = new Manager();
		m.work();
		
		Cook c = new Cook("ap002", "库克", 1);
		c.work();
	}
}
```

此时的方法重写，是子类对父类抽象方法的完成实现，我们将这种方法重写的操作，也叫做**实现方法**。

## 1.3 抽象类的特征

抽象类的特征总结起来可以说是 **有得有失**

**有得：抽象类得到了拥有抽象方法的能力。**

**有失：抽象类失去了创建对象的能力。**

其他成员（构造器，实例方法，静态方法等）抽象类都是具备的。

## 1.4 抽象类的注意事项

关于抽象类的使用，以下为语法上要注意的细节，虽然条目较多，但若理解了抽象的本质，无需死记硬背。

1. 抽象类**不能创建对象**，如果创建，编译无法通过而报错。只能创建其非抽象子类的对象。

   > 理解：假设创建了抽象类的对象，调用抽象的方法，而抽象方法没有具体的方法体，没有意义。

2. 抽象类中，可以有构造器，是供子类创建对象时，初始化父类成员使用的。

   > 理解：子类的构造方法中，有默认的super()，需要访问父类构造方法。

3. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。

   > 理解：未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设计。

4. 抽象类的子类，必须重写抽象父类中**所有的**抽象方法，否则子类也必须定义成抽象类，编译无法通过而报错。 

   > 理解：假设不重写所有抽象方法，则类中可能包含抽象方法。那么创建对象后，调用抽象的方法，没有意义。

5. 抽象类存在的意义是为了被子类继承，抽象类体现的是模板思想。

   > 理解：抽象类中已经实现的是模板中确定的成员，抽象类不确定如何实现的定义成抽象方法，交给具体的子类去实现。

## 1.5 抽象类存在的意义

抽象类存在的意义是为了被子类继承，否则抽象类将毫无意义，**抽象类体现的是模板思想**，模板是通用的东西抽象类中已经是具体的实现（抽象类中可以有成员变量和实现方法），而模板中不能决定的东西定义成抽象方法，让使用模板（继承抽象类的类）的类去重写抽象方法实现需求，这是典型的模板思想。

## 1.6 第一个设计模式：模板模式

我们现在使用抽象类设计一个模板模式的应用，例如在小学的时候，我们经常写作文，通常都是有模板可以套用的。假如我现在需要定义新司机和老司机类，新司机和老司机都有开车功能，开车的步骤都一样，只是驾驶时的姿势有点不同，`新司机:开门,点火,双手紧握方向盘,刹车,熄火`，`老司机:开门,点火,右手握方向盘左手抽烟,刹车,熄火`。我们可以将固定流程写到父类中，不同的地方就定义成抽象方法，让不同的子类去重写，代码如下:

```java
// 司机开车的模板类
public abstract class Driver {
    public void go() {
        System.out.println("开门");
        System.out.println("点火");
        // 开车姿势不确定?定义为抽象方法
        ziShi();
        System.out.println("刹车");
        System.out.println("熄火");
    }

    public abstract void ziShi();
}
```

现在定义两个使用模板的司机：

```java
public class NewDriver extends Driver {

    @Override
    public void ziShi() {
        System.out.println("新司机双手紧握方向盘");
    }
}

public class OldDriver extends Driver {
    @Override
    public void ziShi() {
        System.out.println("老司机右手握方向盘左手抽烟...");
    }
}
```

编写测试类

```java
public class Demo02 {
    public static void main(String[] args) {
        NewDriver nd = new NewDriver();
        nd.go();

        OldDriver od = new OldDriver();
        od.go();
    }
}
```

运行效果

![1560747035458](assets/1560747035458.png)

**可以看出，模板模式的优势是，模板已经定义了通用架构，使用者只需要关心自己需要实现的功能即可！非常的强大！**

# 第二章 接口

## 2.1 概述
我们已经学完了抽象类，抽象类中可以用抽象方法，也可以有普通方法，已经构造器，成员变量等。那么什么是接口呢？**接口是更加彻底的抽象，接口中全部是抽象方法。（JDK8之前），接口同样是不能创建对象的**。

## 2.2 定义格式

```java
//接口的定义格式：
修饰符 interface 接口名称{
    // 抽象方法
}

// 修饰符：public|缺省
// 接口的声明：interface
// 接口名称：首字母大写，满足“驼峰模式”
```

## 2.3 接口成分的特点

  在JDK8之前，接口中的成分包含：抽象方法和常量

### 2.3.1.抽象方法

​       注意：接口中的抽象方法默认会自动加上public abstract修饰程序员无需自己手写！！
​       按照规范：以后接口中的抽象方法建议不要写上public abstract。因为没有必要啊，默认会加上。

### 2.3.2 常量

 在接口中定义的成员变量默认会加上： public static final修饰。也就是说在接口中定义的成员变量实际上是一个常量。这里是使用public static final修饰后，变量值就不可被修改，并且是静态化的变量可以直接用接口名访问，所以也叫常量。常量必须要给初始值。常量命名规范建议字母全部大写，多个单词用下划线连接。

###  2.3.3 案例演示

``` java
public interface InterF {
    // 抽象方法！
    //    public abstract void run();
    void run();

    //    public abstract String getName();
    String getName();

    //    public abstract int add(int a , int b);
    int add(int a , int b);


    // 它的最终写法是：
    // public static final int AGE = 12 ;
    int AGE  = 12; //常量
    String SCHOOL_NAME = "黑马程序员";

}
```

## 2.4 基本的实现

### 2.4.1 实现接口的概述

类与接口的关系为实现关系，即**类实现接口**，该类可以称为接口的实现类，也可以称为接口的子类。实现的动作类似继承，格式相仿，只是关键字不同，实现使用 ` implements`关键字。

### 2.4.2 实现接口的格式

```java
/**接口的实现：
    在Java中接口是被实现的，实现接口的类称为实现类。
    实现类的格式:*/
[修饰符] class 类名 implements 接口1,接口2,接口3...{


}
```

从上面格式可以看出，接口是可以被多实现的。大家可以想一想为什么呢？

### 2.4.3 类实现接口的要求和意义

1. 必须重写实现的全部接口中所有抽象方法。
2. 如果一个类实现了接口，但是没有重写完全部接口的全部抽象方法，这个类也必须定义成抽象类。
3. **意义：接口体现的是一种规范，接口对实现类是一种强制性的约束，要么全部完成接口申明的功能，要么自己也定义成抽象类。这正是一种强制性的规范。**

### 2.4.4  类与接口基本实现案例

假如我们定义一个运动员的**接口**（规范），代码如下：

``` java
/**
   接口：接口体现的是规范。
 * */
public interface SportMan {
    void run(); // 抽象方法，跑步。
    void law(); // 抽象方法，遵守法律。
    String compittion(String project);  // 抽象方法，比赛。
}
```

接下来定义一个乒乓球运动员类，实现接口，实现接口的**实现类**代码如下：

``` java
package com.itheima._03接口的实现;
/**
 * 接口的实现：
 *    在Java中接口是被实现的，实现接口的类称为实现类。
 *    实现类的格式:
 *      [修饰符] class 类名 implements 接口1,接口2,接口3...{
 *
 *
 *      }
 * */
public class PingPongMan  implements SportMan {
    @Override
    public void run() {
        System.out.println("乒乓球运动员稍微跑一下！！");
    }

    @Override
    public void law() {
        System.out.println("乒乓球运动员守法！");
    }

    @Override
    public String compittion(String project) {
        return "参加"+project+"得金牌！";
    }
}
```

**测试代码**：

``` java

public class TestMain {
    public static void main(String[] args) {
        // 创建实现类对象。
        PingPongMan zjk = new PingPongMan();
        zjk.run();
        zjk.law();
        System.out.println(zjk.compittion("全球乒乓球比赛"));

    }
}
```

### 1.4.5 类与接口的多实现案例

**类与接口之间的关系是多实现的，一个类可以同时实现多个接口。**

首先我们先定义两个接口，代码如下：

``` java
/** 法律规范：接口*/
public interface Law {
    void rule();
}

/** 这一个运动员的规范：接口*/
public interface SportMan {
    void run();
}

```

然后定义一个实现类：

``` java
/**
 * Java中接口是可以被多实现的：
 *    一个类可以实现多个接口: Law ,SportMan
 *
 * */
public class JumpMan implements Law ,SportMan {
    @Override
    public void rule() {
        System.out.println("尊长守法");
    }

    @Override
    public void run() {
        System.out.println("训练跑步！");
    }
}

```

从上面可以看出类与接口之间是可以多实现的，我们可以理解成实现多个规范，这是合理的。

## 2.5 接口与接口的多继承

Java中，接口与接口之间是可以多继承的：也就是一个接口可以同时继承多个接口。大家一定要注意：

**类与接口是实现关系**

**接口与接口是继承关系**

接口继承接口就是把其他接口的抽象方法与本接口进行了合并。

案例演示：

```java 
public interface Abc {
    void go();
    void test();
}

/** 法律规范：接口*/
public interface Law {
    void rule();
    void test();
}

 *
 *  总结：
 *     接口与类之间是多实现的。
 *     接口与接口之间是多继承的。
 * */
public interface SportMan extends Law , Abc {
    void run();
}

```

## 2.6 JDK 8之后的接口新增方法

从JDK 8开始之后，接口不再纯洁了，接口中不再只是抽象方法，接口还可以有**默认方法**（也就是实例方法），和**静态方法**了，还包含了私有实例方法和私有静态方法

### 2.6.1 含有默认方法和静态方法

**默认方法：使用 `default` 修饰，不可省略，供子类调用或者子类重写。**

**静态方法：使用 `static` 修饰，供接口直接调用。**

代码如下：

```java
public interface InterFaceName {
    public default void method() {
        // 执行语句
    }
    public static void method2() {
        // 执行语句    
    }
}
```

### 2.6.2 含有私有方法和私有静态方法

私有方法：使用 `private` 修饰，供接口中的默认方法或者静态方法调用。

代码如下：

```java
public interface InterFaceName {
    private void method() {
        // 执行语句
    }
}
```

### 2.6.3 新增方法的使用

**默认方法和静态方法以及私有方法和私有静态方法**，**遵循面向对象的继承关系使用原则，实现类依然可以访问接口的非私有方法，对于接口中的非私有静态方法，可以直接通过接口名进行访问。**

重写默认方法注意（了解）:

* 子接口重写默认方法时，default关键字可以保留。

* 实现类重写默认方法时，default关键字不可以保留。

## 2.7 实现多个接口使用注意事项

### 2.7.1 多个接口同名静态方法

如果实现了多个接口，多个接口中存在同名的静态方法并不会冲突，原因是只能通过各自接口名访问静态方法。

```java
public interface A {
  public static void test(){

  }
}

 interface B {
    public static void test(){

    }
}

class C implements  A , B{
    public static void main(String[] args) {
        People.test();
        B.test();
       // C.test(); // 编译出错
    }
}
```

### 2.7.2 优先级的问题

当一个类，既继承一个父类，又实现若干个接口时，父类中的成员方法与接口中的默认方法重名，子类就近选择执行父类的成员方法。代码如下：

定义接口：

```java
interface A {
    public default void methodA(){
        System.out.println("AAAAAAAAAAAA");
    }
}
```

定义父类：

```java
class D {
    public void methodA(){
        System.out.println("DDDDDDDDDDDD");
    }
}
```

定义子类：

```java
class C extends D implements A {
  	// 未重写methodA方法
}
```

定义测试类：

```java
public class Test {
    public static void main(String[] args) {
        C c = new C();
        c.methodA(); 
    }
}
输出结果:
DDDDDDDDDDDD
```

## 2.8 接口小结

- 接口中，无法定义成员变量，但是可以定义常量，其值不可以改变，默认使用public static final修饰。
- 接口中的方法全是抽象方法，默认会自动加上public abstract修饰
- JDK 8开始，接口不再纯洁，支持静态方法，默认方法，私有方法。
- 接口中，没有构造器，**不能创建对象**。
- 类与接口是多实现的
- 接口与接口是多继承的
- 接口体现的规范。

# 第三章 代码块

## 3.1 引入

类的成分：
​    1.成员变量
​    2.构造器
​    3.成员方法
​    4.代码块
​    5.内部类

我们已经学完了成员变量，构造器，成员方法，接下来我们来介绍以下代码快，代码块按照有无static可以分为静态代码块和实例代码块。

## 3.2 静态代码块

**静态代码块**
​         必须有static修饰，必须放在类下。与类一起加载执行。

**格式**

```java
static{
     // 执行代码
}
```

**特点**：

- 每次执行类，加载类的时候都会先执行静态代码块一次。
- 静态代码块是自动触发执行的，只要程序启动静态代码块就会先执行一次。
- 作用：在启动程序之前可以做资源的初始化，一般用于初始化静态资源。

**案例演示**

```java
public class DaimaKuaiDemo01 {
    public static String sc_name ;

    // 1.静态代码块
    static {
        // 初始化静态资源
        sc_name = "黑马程序员！";
        System.out.println("静态代码块执行！");
    }

    public static void main(String[] args) {
        System.out.println("main方法执行");
        System.out.println(sc_name);
    }
}

```

## 3.3 实例代码块

**实例代码块**
​         没有static修饰，必须放在类下。与对象初始化一起加载。

**格式**

```java
{
     // 执行代码
}
```

**特点**：

- 无static修饰。属于对象，与对象的创建一起执行的。
- 每次调用构造器初始化对象，实例代码块都要自动触发执行一次。
- 实例代码块实际上是提取到每一个构造器中去执行的。
- 作用：实例代码块用于初始化对象的资源。

**案例演示**

```java
public class DaimaKuaiDemo02 {
   
    private String name ;

    // 实例代码块。 无static修饰。
    {
        System.out.println("实例代码块执行");
        name = "dl";
    }

    // 构造器
    public DaimaKuaiDemo02(){
        //System.out.println("实例代码块执行");
    }

    // 有参数构造器
    public DaimaKuaiDemo02(String name){
        //System.out.println("实例代码块执行");
    }

    public static void main(String[] args) {
        // 匿名对象，创建出来没有给变量。
        new DaimaKuaiDemo02();
        new DaimaKuaiDemo02();
        new DaimaKuaiDemo02("xulei");
    }
}
// 输出三次：实例代码块执行
```

常用API

# 第四章 final关键字  

## 4.1 概述

学习了继承后，我们知道，子类可以在父类的基础上改写父类内容，比如，方法重写。那么我们能不能随意的继承API中提供的类，改写其内容呢？显然这是不合适的。为了避免这种随意改写的情况，Java提供了`final` 关键字，用于修饰**不可改变**内容。

- **final**：  不可改变，最终的含义。可以用于修饰类、方法和变量。
  - 类：被修饰的类，不能被继承。
  - 方法：被修饰的方法，不能被重写。
  - 变量：被修饰的变量，有且仅能被赋值一次。

## 4.2 使用方式

### 4.2.1 修饰类

final修饰的类，不能被继承。

格式如下：

```java
final class 类名 {
}
```

代码:

```java
final class Fu {
}
// class Zi extends Fu {} // 报错,不能继承final的类
```

查询API发现像 `public final class String` 、`public final class Math` 、`public final class Scanner` 等，很多我们学习过的类，都是被final修饰的，目的就是供我们使用，而不让我们所以改变其内容。

### 4.2.2 修饰方法

final修饰的方法，不能被重写。
格式如下：

```java
修饰符 final 返回值类型 方法名(参数列表){
    //方法体
}
```

代码: 

```java
class Fu2 {
	final public void show1() {
		System.out.println("Fu2 show1");
	}
	public void show2() {
		System.out.println("Fu2 show2");
	}
}

class Zi2 extends Fu2 {
//	@Override
//	public void show1() {
//		System.out.println("Zi2 show1");
//	}
	@Override
	public void show2() {
		System.out.println("Zi2 show2");
	}
}
```

### 4.2.3 修饰变量-局部变量

1. **局部变量——基本类型**
   基本类型的局部变量，被final修饰后，只能赋值一次，不能再更改。代码如下：

```java
public class FinalDemo1 {
    public static void main(String[] args) {
        // 声明变量，使用final修饰
        final int a;
        // 第一次赋值 
        a = 10;
        // 第二次赋值
        a = 20; // 报错,不可重新赋值

        // 声明变量，直接赋值，使用final修饰
        final int b = 10;
        // 第二次赋值
        b = 20; // 报错,不可重新赋值
    }
}
```

思考，如下两种写法，哪种可以通过编译？

写法1：

```java
final int c = 0;
for (int i = 0; i < 10; i++) {
    c = i;
    System.out.println(c);
}
```

写法2：

```java
for (int i = 0; i < 10; i++) {
    final int c = i;
    System.out.println(c);
}
```

根据 `final` 的定义，写法1报错！写法2，为什么通过编译呢？因为每次循环，都是一次新的变量c。这也是大家需要注意的地方。

### 4.2.4 修饰变量-实例成员变量

成员变量涉及到初始化的问题，初始化方式有显示初始化和构造器初始化，只能选择其中一个：

- 显示初始化(在定义成员变量的时候立马赋值)；

```java
public class Student {
    final int num = 10;
}
```

- 构造器初始化(在构造器中赋值一次)。

  **注意：每个构造器中都要赋值一次！**

```java
public class Student {
    final int num = 10;
    final int num2;

    public Student() {
        this.num2 = 20;
//     this.num2 = 20;
    }
    
     public Student(String name) {
        this.num2 = 20;
//     this.num2 = 20;
    }
}
```

> 被final修饰的常量名称，一般都有书写规范，所有字母都**大写**。

# 第五章 单例设计模式

正常情况下一个类可以创建多个对象

```java
public static void main(String[] args) {
	// 正常情况下一个类可以创建多个对象
	Person p1 = new Person();
	Person p2 = new Person();
	Person p3 = new Person();
}
```

## 5.1 单例设计模式的作用

单例模式，是一种常用的软件设计模式。通过单例模式可以保证系统中，应用该模式的这个类只有一个实例。即一个类只有一个对象实例。

## 5.2 单例设计模式实现步骤

1. 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。

2. 在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。

3. 定义一个静态方法返回这个唯一对象。


## 5.3 单例设计模式的类型

根据实例化对象的时机单例设计模式又分为以下两种:

1. 饿汉单例设计模式

2. 懒汉单例设计模式

## 5.4 饿汉单例设计模式

饿汉单例设计模式就是使用类的时候已经将对象创建完毕，不管以后会不会使用到该实例化对象，先创建了再说。很着急的样子，故被称为“饿汉模式”。

代码如下：

```java
public class Singleton {
    // 1.将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
    private Singleton() {}

    // 2.在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
    private static final Singleton instance = new Singleton();
    
    // 3.定义一个静态方法返回这个唯一对象。
    public static Singleton getInstance() {
        return instance;
    }
}
```

## 5.5 懒汉单例设计模式

懒汉单例设计模式就是调用getInstance()方法时实例才被创建，先不急着实例化出对象，等要用的时候才例化出对象。不着急，故称为“懒汉模式”。

代码如下：

```java
public class Singleton {

    // 2.在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
    private static Singleton instance;
    
    // 1.将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
    private Singleton() {}
    
    // 3.定义一个静态方法返回这个唯一对象。要用的时候才例化出对象
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

> 注意：懒汉单例设计模式在多线程环境下可能会实例化出多个对象，不能保证单例的状态。我们在学习完多线程的时候还会再讲解如何解决这个问题。

## 5.6 小结

单例模式可以保证系统中一个类只有一个对象实例。

实现单例模式的步骤：

1. 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
2. 在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
3. 定义一个静态方法返回这个唯一对象。

# 第六章 枚举

## 6.1 不使用枚举存在的问题

假设我们要定义一个人类，人类中包含姓名和性别。通常会将性别定义成字符串类型，效果如下：

```java
public class Person {
    private String name;
    private String sex;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
	
    // 省略get/set/toString方法
}
```

```java
public class Demo01 {
    public static void main(String[] args) {
        Person p1 = new Person("张三", "男");
        Person p2 = new Person("张三", "abc"); // 因为性别是字符串,所以我们可以传入任意字符串
    }
}
```

不使用枚举存在的问题：可以给性别传入任意的字符串，导致性别是非法的数据，不安全。

## 6.2 枚举的作用与应用场景

枚举的作用：一个方法接收的参数是固定范围之内的时候，那么即可使用枚举。

## 6.3 枚举的基本语法

### 6.3.1 枚举的概念

枚举是一种特殊类。枚举是有固定实例个数的类型，我们可以把枚举理解成有固定个数实例的多例模式。

### 6.3.2 定义枚举的格式

```java
enum 枚举名 {
    第一行都是罗列枚举实例,这些枚举实例直接写大写名字即可。
}
```

### 6.3.3 入门案例

1. 定义枚举：BOY表示男，GIRL表示女

```java
enum Sex {
    BOY, GIRL; // 男，女
}
```

2. Perosn中的性别有String类型改为Sex枚举类型

```java
public class Person {
    private String name;
    private Sex sex;

    public Person() {
    }

    public Person(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }
    // 省略get/set/toString方法
}
```

3. 使用是只能传入枚举中的固定值

```java
public class Demo02 {
    public static void main(String[] args) {
        Person p1 = new Person("张三", Sex.BOY);
        Person p2 = new Person("张三", Sex.GIRL);
        Person p3 = new Person("张三", "abc");
    }
}
```

### 5.3.4 枚举的其他内容

枚举的本质是一个类，我们刚才定义的Sex枚举最终效果如下：

```java
enum Sex {
    BOY, GIRL; // 男，女
}

// 枚举的本质是一个类，我们刚才定义的Sex枚举相当于下面的类
final class SEX extends java.lang.Enum<SEX> {
    public static final SEX BOY = new SEX();
    public static final SEX GIRL = new SEX();
    public static SEX[] values();
    public static SEX valueOf(java.lang.String);
    static {};
}
```

枚举的本质是一个类，所以枚举中还可以有成员变量，成员方法等。

```java
public enum Sex {
    BOY(18), GIRL(16);

    public int age;

    Sex(int age) {
        this.age = age;
    }

    public void showAge() {
        System.out.println("年龄是: " + age);
    }
}
```

```java
public class Demo03 {
    public static void main(String[] args) {
        Person p1 = new Person("张三", Sex.BOY);
        Person p2 = new Person("张三", Sex.GIRL);

        Sex.BOY.showAge();
        Sex.GIRL.showAge();
    }
}
```

运行效果：

![1560502240126](C:\Users\13666\AppData\Roaming\Typora\typora-user-images\1560502240126.png)

## 6.4 应用场景

## 6.5 枚举的应用

**枚举的作用：枚举通常可以用于做信息的分类，如性别，方向，季度等。**

枚举表示性别：

```java
public enum Sex {
    MAIL, FEMAIL;
}
```

枚举表示方向：

```java
public enum Orientation {
    UP, RIGHT, DOWN, LEFT;
}
```

枚举表示季度

```java
public enum Season {
    SPRING, SUMMER, AUTUMN, WINTER;
}
```

## 6.6 小结

- 枚举类在第一行罗列若干个枚举对象。（多例）
- 第一行都是常量，存储的是枚举类的对象。
- 枚举是不能在外部创建对象的，枚举的构造器默认是私有的。
- 枚举通常用于做信息的标志和分类。