# day04【常用API、正则表达式，泛型、Collection集合API】

## 主要内容

* Date类
  * Java是面向对象的思想，会用一个类来代表一个事物。
  * Date代表了系统当前此刻日期对象！年月日时分秒。
* DateFormat类
  * 日期格式化类，认为日期对象拿到的时间是不好看的！
  * 日期格式化类可以把时间格式化成我们喜欢的格式。
  * 日期格式化类可以把字符串时间解析成日期对象!!  "2019-10-01 09:28:00"
* Calendar类  
  * 日历类，代表了此刻日期对象对应的日历对象。日历的信息更加的丰富。
* System类
  * 代表了当前JVM虚拟机对应的操作系统对象。
  * 可以拿系统时间。
  * 可以让程序退出JVM虚拟机，让程序立即死亡！！
  * 可以做数组拷贝。
* StringBuilder类
  * String类不适合做字符串的拼接，增删等运算。不可变字符串，增删性能较差！
  * StringBuillder非常适合做字符串的增删改查操作，性能更好！！
* 包装类
  * 一切皆对象。   
  * int Integer   int age = 21;    Integer age1 = 21; 
  * float Float 
  * double Double
* 泛型
  * ArrayLIst<Integer> lists = new ArrayList<>();
* **Collection集合：List , Map , Set** 
  * 三天的集合框架（重点内容，开发必用的！！）

## 教学目标

- [ ] 能够使用日期类输出当前日期

  - [ ] **Date d = new Date();**
  - [ ] **System.out.println(d);**

- [ ] 能够使用将日期格式化为字符串的方法

  - [ ] **SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");**
  - [ ] **String rs = sdf.format(“日期对象”)**
  - [ ] **String rs = sdf.format("时间毫秒值")**

- [ ] 能够使用将字符串转换成日期的方法

  - [ ] **SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");**
  - [ ] **String str = "2019-11-11 11:11:11";**
  - [ ] **Data d = sdf.parse(str );**
  - [ ] System.out.println(d);

- [ ] 能够使用System类的数组复制方法

  ```java
  // 3.数组拷贝：
  int[] arrs1 = {10 , 20 , 30 , 40 , 50 , 60 , 70 , 80};
  // arrs2 = [ 0 , 0 , 0 , 0 , 0 , 0]
  // arrs2 = [0 , 0 , 30 , 40 , 50 , 0]
  // 希望把第一个数组的 30 , 40 , 50赋值到第二个数组！
  int[] arrs2 = new int[6];
  
  /**
   arraycopy(Object src,  int  srcPos,
   Object dest, int destPos,
   int length)
   参数一：原数组。
   参数二：从原数组哪个位置开始复制
   参数三：目标数组
   参数四：复制到目标数组的哪个位置开始。
   参数五：复制多少个！
   */
  System.arraycopy(arrs1, 2 ,arrs2 , 2 , 3);
  System.out.println(Arrays.toString(arrs2));
  ```

- [ ] 能够使用System类获取当前毫秒时刻值

  - [ ] ```java
    long time = System.currentTimeMillis();
    ```

- [ ] 能够说出使用StringBuilder类可以解决的问题

  - [ ] 可以做字符串的运算（拼接，增删，反转）

- [ ] 能够使用StringBuilder进行字符串拼接操作

  - [ ] append

- [ ] 能够说出8种基本类型对应的包装类名称

  - [ ] int Integer

  - [ ] char Character

  - [ ] ```properties
    基本数据类型              包装类
        byte                 Byte
        short                Short
        int                  Integer(特殊)
        long                 Long
        float                Float
        double               Double
        char                 Character(特殊)
        boolean              Boolean
    ```

- [ ] 能够说出自动装箱、自动拆箱的概念

  - [ ] ```properties
  自动装箱：可以直接把基本数据类型的变量或者值赋值给对应的包装类对象。
    自动拆箱：可以把包装类的对象赋值给基本数据类型的变量。
    ```
  
- [ ] 能够将字符串转换为对应的基本类型

  ```properties
  功能3: 把字符串类型的数字转化成对应的基本数据类型的值！！（真的有用，而且挺重要）
            Xxxx.parseXxxx("字符串类型的数字")
            Xxxx.valueOf("字符串类型的数字")：推荐使用的！
  ```

- [ ] 能够将基本类型转换为对应的字符串

  ```java
  // 功能2: 包装类可以把基本数据类型的值转换成字符串。
  // 1.把基本数据类型的值转换成字符串:toString()
  Integer num = 23 ;
  String numStr1 = num.toString();
  System.out.println(numStr1+1); // 231
  
  // 2.把基本数据类型的值转换成字符串:
  Integer num1 = 23 ;
  String num1Str1 = Integer.toString(num1);
  System.out.println(num1Str1+1); // 231
  
  // 3.把基本数据类型的值转换成字符串:
  Integer num2 = 23 ;
  String num2Str1 = num2 + "" ; //常见做法！
  System.out.println(num2Str1+1); // 231
  ```

- [ ] 能够说出Collection集合的常用功能

  - [ ] ```properties
    Collection集合作为集合的根类，它的功能是一切集合都可以直接使用的。
     - public boolean add(E e)：  把给定的对象添加到当前集合中 。
     - public void clear() :清空集合中所有的元素。
     - public boolean remove(E e): 把给定的对象在当前集合中删除。
     - public boolean contains(Object obj): 判断当前集合中是否包含给定的对象。
     - public boolean isEmpty(): 判断当前集合是否为空。
     - public int size(): 返回集合中元素的个数。
     - public Object[] toArray(): 把集合中的元素，存储到数组中
    ```

- [ ] 能够使用泛型创建集合对象

  - [ ] ```java
    ArrayList<String> lists = new ArrayList<>(); // JDK 1.7之后泛型的简化写法！
    ArrayList<Integer> lists1 = new ArrayList<>();// JDK 1.7之后泛型的简化写法！
    ```

- [ ] 能够理解泛型上下限

  - [ ] ? extends Car : ?必须是Car的子类或者本身 。  上限
  - [ ] ? super Car : ?必须是Car的父类或者本身 。  下限   不用的!!

- [ ] 能够阐述泛型通配符的作用

  - [ ] ? 可以在使用泛型的时候，代表接收一切类型

 

# 第一章 DateFormat类

`java.text.DateFormat` 是日期/时间格式化子类的抽象类，我们通过这个类可以帮我们完成日期和文本之间的转换,也就是可以在Date对象与String对象之间进行来回转换。

- **格式化**：按照指定的格式，把Date对象转换为String对象。
- **解析**：按照指定的格式，把String对象转换为Date对象。

## 1.1 构造方法

由于DateFormat为抽象类，不能直接使用，所以需要常用的子类`java.text.SimpleDateFormat`。这个类需要一个模式（格式）来指定格式化或解析的标准。构造方法为：

- `public SimpleDateFormat(String pattern)`：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。参数pattern是一个字符串，代表日期时间的自定义格式。

## 1.2 格式规则

常用的格式规则为：

| 标识字母（区分大小写） | 含义 |
| ---------------------- | ---- |
| y                      | 年   |
| M                      | 月   |
| d                      | 日   |
| H                      | 时   |
| m                      | 分   |
| s                      | 秒   |

> 备注：更详细的格式规则，可以参考SimpleDateFormat类的API文档。

## 1.3 常用方法

DateFormat类的常用方法有：

- `public String format(Date date)`：将Date对象格式化为字符串。

- `public Date parse(String source)`：将字符串解析为Date对象。

  ```java
  public class SimpleDateFormatDemo {
      public static void main(String[] args) throws ParseException {
          //格式化：从 Date 到 String
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
          String s = sdf.format(d);
          System.out.println(s);
          System.out.println("--------");
  
          //从 String 到 Date
          String ss = "2048-08-09 11:11:11";
          //ParseException
          SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          Date dd = sdf2.parse(ss);
          System.out.println(dd);
      }
  }
  ```

> 小结：DateFormat可以将Date对象和字符串相互转换。



# 第二章 Calendar类

## 2.1 概述

- java.util.Calendar类表示一个“日历类”，可以进行日期运算。它是一个抽象类，不能创建对象，我们可以使用它的子类：java.util.GregorianCalendar类。
- 有两种方式可以获取GregorianCalendar对象：
  - 直接创建GregorianCalendar对象；
  - 通过Calendar的静态方法getInstance()方法获取GregorianCalendar对象【本次课使用】

## 2.2 常用方法

| 方法名                                | 说明                                                         |
| ------------------------------------- | ------------------------------------------------------------ |
| public static Calendar getInstance()  | 获取一个它的子类GregorianCalendar对象。                      |
| public int get(int field)             | 获取某个字段的值。field参数表示获取哪个字段的值，<br />可以使用Calender中定义的常量来表示：<br />Calendar.YEAR : 年<br />Calendar.MONTH ：月<br />Calendar.DAY_OF_MONTH：月中的日期<br />Calendar.HOUR：小时<br />Calendar.MINUTE：分钟<br />Calendar.SECOND：秒<br />Calendar.DAY_OF_WEEK：星期 |
| public void set(int field,int value)  | 设置某个字段的值                                             |
| public void add(int field,int amount) | 为某个字段增加/减少指定的值                                  |

## 2.3 get方法示例

```java
public class Demo {
    public static void main(String[] args) {
        //1.获取一个GregorianCalendar对象
        Calendar instance = Calendar.getInstance();//获取子类对象

        //2.打印子类对象
        System.out.println(instance);

        //3.获取属性
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;//Calendar的月份值是0-11
        int day = instance.get(Calendar.DAY_OF_MONTH);

        int hour = instance.get(Calendar.HOUR);
        int minute = instance.get(Calendar.MINUTE);
        int second = instance.get(Calendar.SECOND);

        int week = instance.get(Calendar.DAY_OF_WEEK);//返回值范围：1--7，分别表示："星期日","星期一","星期二",...,"星期六"

        System.out.println(year + "年" + month + "月" + day + "日" + 
                           	hour + ":" + minute + ":" + second);
        System.out.println(getWeek(week));

    }

    //查表法，查询星期几
    public static String getWeek(int w) {//w = 1 --- 7
        //做一个表(数组)
        String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        //            索引      [0]      [1]       [2]      [3]       [4]      [5]      [6]
        //查表
        return weekArray[w - 1];
    }
}

```

## 2.4 set方法示例：

```java
public class Demo {
    public static void main(String[] args) {
        //设置属性——set(int field,int value):
		Calendar c1 = Calendar.getInstance();//获取当前日期

		//计算班长出生那天是星期几(假如班长出生日期为：1998年3月18日)
		c1.set(Calendar.YEAR, 1998);
		c1.set(Calendar.MONTH, 3 - 1);//转换为Calendar内部的月份值
		c1.set(Calendar.DAY_OF_MONTH, 18);

		int w = c1.get(Calendar.DAY_OF_WEEK);
		System.out.println("班长出生那天是：" + getWeek(w));

        
    }
    //查表法，查询星期几
    public static String getWeek(int w) {//w = 1 --- 7
        //做一个表(数组)
        String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        //            索引      [0]      [1]       [2]      [3]       [4]      [5]      [6]
        //查表
        return weekArray[w - 1];
    }
}
```



## 2.5 add方法示例：

```java
public class Demo {
    public static void main(String[] args) {
        //计算200天以后是哪年哪月哪日，星期几？
		Calendar c2 = Calendar.getInstance();//获取当前日期
        c2.add(Calendar.DAY_OF_MONTH, 200);//日期加200

        int y = c2.get(Calendar.YEAR);
        int m = c2.get(Calendar.MONTH) + 1;//转换为实际的月份
        int d = c2.get(Calendar.DAY_OF_MONTH);

        int wk = c2.get(Calendar.DAY_OF_WEEK);
        System.out.println("200天后是：" + y + "年" + m + "月" + d + "日" + getWeek(wk));

    }
    //查表法，查询星期几
    public static String getWeek(int w) {//w = 1 --- 7
        //做一个表(数组)
        String[] weekArray = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        //            索引      [0]      [1]       [2]      [3]       [4]      [5]      [6]
        //查表
        return weekArray[w - 1];
    }
}
```



# 第三章 Math类

## 3.1 概述

- java.lang.Math(类): Math包含执行基本数字运算的方法。
- 它不能创建对象，它的构造方法被“私有”了。因为他内部都是“静态方法”，通过“类名”直接调用即可。

## 3.2 常用方法

| 方法名                                       | 说明                |
| -------------------------------------------- | ------------------- |
| public static int abs(int a)                 | 获取参数a的绝对值： |
| public static double ceil(double a)          | 向上取整            |
| public static double floor(double a)         | 向下取整            |
| public static double pow(double a, double b) | 获取a的b次幂        |
| public static long round(double a)           | 四舍五入取整        |

## 3.3 示例代码

```java
public class Demo {
    public static void main(String[] args) {
        System.out.println("-5的绝对值：" + Math.abs(-5));//5
    	System.out.println("3.4向上取整：" + Math.ceil(3.4));//4.0
    	System.out.println("3.4向下取整：" + Math.floor(3.4));//3.0
    	System.out.println("2的8次幂：" + Math.pow(2, 8));//256.0
    	System.out.println("3.2四舍五入：" + Math.round(3.2));//3
    	System.out.println("3.5四舍五入：" + Math.round(3.5));//4

    }
}
```



# 第四章 System

## 4.1 概述

`java.lang.System`类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作。

## 4.2 常用方法

| 方法名                                   | 说明                                             |
| ---------------------------------------- | ------------------------------------------------ |
| public   static void exit(int status)    | 终止当前运行的   Java   虚拟机，非零表示异常终止 |
| public   static long currentTimeMillis() | 返回当前时间(以毫秒为单位)                       |

## 4.3 练习

在控制台输出1-10000，计算这段代码执行了多少毫秒 

```java
import java.util.Date;
//验证for循环打印数字1-9999所需要使用的时间（毫秒）
public class SystemDemo {
    public static void main(String[] args) {
       	//获取当前时间毫秒值
       System.out.println(System.currentTimeMillis()); 
      //计算程序运行时间
       long start = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时毫秒：" + (end - start));
    }  
}
```

# 第五章 BigDecimal类

## 5.1 引入

浮点数做运算精度问题；

看程序说结果：

```java
public static void main(String[] args) {
    System.out.println(0.09 + 0.01);
    System.out.println(1.0 - 0.32);
    System.out.println(1.015 * 100);
    System.out.println(1.301 / 100);
}
```

## 5.2 概述

| 相关内容 | 具体描述                                                     |
| -------- | :----------------------------------------------------------- |
| 包       | java.math                                                                  使用时需要导包 |
| 类声明   | public class BigDecimal extends Number implements Comparable<BigDecimal> |
| 描述     | BigDecimal类提供了算术，缩放操作，舍入，比较，散列和格式转换的操作。提供了更加精准的数据计算方式 |

## 5.3 构造方法

| 构造方法名             | 描述                                            |
| ---------------------- | ----------------------------------------------- |
| BigDecimal(double val) | 将double类型的数据封装为BigDecimal对象          |
| BigDecimal(String val) | 将 BigDecimal 的字符串表示形式转换为 BigDecimal |

注意：推荐使用第二种方式，第一种存在精度问题；

## 5.4 常用方法

BigDecimal类中使用最多的还是提供的进行四则运算的方法，如下：

| 方法声明                                     | 描述     |
| -------------------------------------------- | -------- |
| public BigDecimal add(BigDecimal value)      | 加法运算 |
| public BigDecimal subtract(BigDecimal value) | 减法运算 |
| public BigDecimal multiply(BigDecimal value) | 乘法运算 |
| public BigDecimal divide(BigDecimal value)   | 触发运算 |

注意：对于divide方法来说，如果除不尽的话，就会出现java.lang.ArithmeticException异常。此时可以使用divide方法的另一个重载方法；

> BigDecimal divide(BigDecimal divisor, int scale, int roundingMode): divisor：除数对应的BigDecimal对象；scale:精确的位数；roundingMode取舍模式

> 小结：Java中小数运算有可能会有精度问题，如果要解决这种精度问题，可以使用BigDecimal

# 第六章 正则表达式

## 6.1 正则表达式的概念及演示

- 在Java中，我们经常需要验证一些字符串，例如：年龄必须是2位的数字、用户名必须是8位长度而且只能包含大小写字母、数字等。正则表达式就是用来验证各种字符串的规则。它内部描述了一些规则，我们可以验证用户输入的字符串是否匹配这个规则。
- 先看一个不使用正则表达式验证的例子：下面的程序让用户输入一个QQ号码，我们要验证：
  - QQ号码必须是5--15位长度
  - 而且必须全部是数字
  - 而且首位不能为0

```java
public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入你的QQ号码：");
		String qq = sc.next();
		
		System.out.println(checkQQ(qq));
	}
	//我们自己编写代码，验证QQ号码
	private static boolean checkQQ(String qq) {
		//1.验证5--15位
		if(qq.length() < 5 || qq.length() > 15){
			return false;
		}
		//2.必须都是数字；
		for(int i = 0;i < qq.length() ; i++){
			char c = qq.charAt(i);
			if(c < '0' || c > '9'){
				return false;
			}
		}
		//3.首位不能是0；
		char c = qq.charAt(0);
		if(c == '0'){
			return false;
		}
		return true;//验证通过
	}
	
}
```

- 使用正则表达式验证：

```java
public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入你的QQ号码：");
		String qq = sc.next();
		
		System.out.println(checkQQ2(qq));
	}
	//使用正则表达式验证
	private static boolean checkQQ2(String qq){
		String regex = "[1-9]\\d{4,14}";//正则表达式
		return qq.matches(regex);
	}
}
```

上面程序checkQQ2()方法中String类型的变量regex就存储了一个"正则表达式 "，而这个正则表达式就描述了我们需要的三个规则。matches()方法是String类的一个方法，用于接收一个正则表达式，并将"本对象"与参数"正则表达式"进行匹配，如果本对象符合正则表达式的规则，则返回true，否则返回false。

**我们接下来就重点学习怎样写正则表达式**

## 6.2 正则表达式-字符类

- 语法示例：

1. \[abc\]：代表a或者b，或者c字符中的一个。
2. \[^abc\]：代表除a,b,c以外的任何字符。
3. [a-z]：代表a-z的所有小写字符中的一个。
4. [A-Z]：代表A-Z的所有大写字符中的一个。
5. [0-9]：代表0-9之间的某一个数字字符。
6. [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
7. [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符。 

- 代码示例：

```java
public class Demo {
	public static void main(String[] args) {
		String str = "ead";
		
		//1.验证str是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
		String regex = "h[aeiou]d";
		System.out.println("1." + str.matches(regex));
		
		//2.验证str是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
		regex = "h[^aeiou]d";
		System.out.println("2." +  str.matches(regex));
		
		//3.验证str是否a-z的任何一个小写字符开头，后跟ad
		regex = "[a-z]ad";
		System.out.println("3." + str.matches(regex));
		
		//4.验证str是否以a-d或者m-p之间某个字符开头，后跟ad
		regex = "[[a-d][m-p]]ad";
		System.out.println("4." + str.matches(regex));
	}
}

```

## 6.3 正则表达式-逻辑运算符

- 语法示例：
  1. &&：并且
  2. |    ：或者
- 代码示例：

```java
public class Demo {
	public static void main(String[] args) {
		String str = "had";
		
		//1.要求字符串是小写辅音字符开头，后跟ad
		String regex = "[a-z&&[^aeiou]]ad";
		System.out.println("1." + str.matches(regex));
		
		//2.要求字符串是aeiou中的某个字符开头，后跟ad
		regex = "[a|e|i|o|u]ad";//这种写法相当于：regex = "[aeiou]ad";
		System.out.println("2." + str.matches(regex));
	}
}

```



## 6.4 正则表达式-预定义字符

- 语法示例：
  1. "." ： 匹配任何字符。
  2. "\d"：任何数字[0-9]的简写；
  3. "\D"：任何非数字\[^0-9\]的简写；
  4. "\s"： 空白字符：[ \t\n\x0B\f\r] 的简写
  5. "\S"： 非空白字符：\[^\s\] 的简写
  6. "\w"：单词字符：[a-zA-Z_0-9]的简写
  7. "\W"：非单词字符：\[^\w\]
- 代码示例：

```java
public class Demo {
	public static void main(String[] args) {
		String str = "258";
		
		//1.验证str是否3位数字
		String regex = "\\d\\d\\d";
		System.out.println("1." + str.matches(regex));
		
		//2.验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字
        str = "13513153355";//要验证的字符串
		regex = "1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d";//正则表达式
		System.out.println("2." + str.matches(regex));
		
		//3.验证字符串是否以h开头，以d结尾，中间是任何字符
		str = "had";//要验证的字符串
		regex = "h.d";//正则表达式
		System.out.println("3." + str.matches(regex));
		
		//4.验证str是否是：had.
        str = "had.";//要验证的字符串
		regex = "had\\.";//\\.代表'.'符号，因为.在正则中被预定义为"任意字符"，不能直接使用
		System.out.println("4." + str.matches(regex));
		
	}
}
```

## 6.5 正则表达式-数量词

- 语法示例：
  1. X? : 0次或1次
  2. X* : 0次到多次
  3. X+ : 1次或多次
  4. X{n} : 恰好n次
  5. X{n,} : 至少n次
  6. X{n,m}: n到m次(n和m都是包含的)
- 代码示例：

```java
public class Demo {
	public static void main(String[] args) {
		String str = "";
		
		//1.验证str是否是三位数字
        str = "012";
		String regex = "\\d{3}";
		System.out.println("1." + str.matches(regex));
		
		//2.验证str是否是多位数字
        str = "88932054782342";
		regex = "\\d+";
		System.out.println("2." + str.matches(regex));
		
		//3.验证str是否是手机号：
        str = "13813183388";
		regex = "1[358]\\d{9}";
		System.out.println("3." + str.matches(regex));
		
		//4.验证小数:必须出现小数点，但是只能出现1次
		String s2 = "3.1";
		regex = "\\d*\\.{1}\\d+";
		System.out.println("4." + s2.matches(regex));
		
		//5.验证小数：小数点可以不出现，也可以出现1次
		regex = "\\d+\\.?\\d+";
		System.out.println("5." + s2.matches(regex));
		
		//6.验证小数：要求匹配：3、3.、3.14、+3.14、-3.
        s2 = "-3.";
		regex = "[+-]\\d+\\.?\\d*";
		System.out.println("6." + s2.matches(regex));
		
		//7.验证qq号码：1).5--15位；2).全部是数字;3).第一位不是0
        s2 = "1695827736";
		regex = "[1-9]\\d{4,14}";
		System.out.println("7." + s2.matches(regex));
	}
}

```

## 6.6 正则表达式-分组括号( )

```java
public class Demo {
	public static void main(String[] args) {
		String str = "DG8FV-B9TKY-FRT9J-99899-XPQ4G";
		
		//验证这个序列号：分为5组，每组之间使用-隔开，每组由5位A-Z或者0-9的字符组成
		String regex = "([A-Z0-9]{5}-){4}[A-Z0-9]{5}";
		System.out.println(str.matches(regex));
	}
}

```

## 6.7 String的split方法中使用正则表达式

- String类的split()方法原型：

  ```java
  public String[] split(String regex)//参数regex就是一个正则表达式。可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
  ```

- 代码示例：

```java
public class Demo {
	public static void main(String[] args) {
		String str = "18  4 567       99     56";
		String[] strArray = str.split(" +");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
	}
}

```

## 6.8 String类的replaceAll方法中使用正则表达式

- String类的replaceAll()方法原型：

```java
public String replaceAll(String regex,String newStr)//参数regex就是一个正则表达式。可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。
```

- 代码示例：

```java
public class Demo {
    public static void main(String[] args) {
        //将下面字符串中的"数字"替换为"*"
        String str = "jfdk432jfdk2jk24354j47jk5l31324";
        System.out.println(str.replaceAll("\\d+", "*"));
    }
}
```



# 第七章  包装类

## 7.1 概述

Java提供了两个类型系统，基本类型与引用类型，使用基本类型在于效率，然而很多情况，会创建对象使用，因为对象可以做更多的功能，如果想要我们的基本类型像对象一样操作，就可以使用基本类型对应的包装类，如下：

| 基本类型 | 对应的包装类（位于java.lang包中） |
| -------- | --------------------------------- |
| byte     | Byte                              |
| short    | Short                             |
| int      | **Integer**                       |
| long     | Long                              |
| float    | Float                             |
| double   | Double                            |
| char     | **Character**                     |
| boolean  | Boolean                           |

## 7.2 Integer类

- Integer类概述

  包装一个对象中的原始类型 int 的值

- Integer类构造方法及静态方法

| 方法名                                  | 说明                                   |
| --------------------------------------- | -------------------------------------- |
| public Integer(int   value)             | 根据 int 值创建 Integer 对象(过时)     |
| public Integer(String s)                | 根据 String 值创建 Integer 对象(过时)  |
| public static Integer valueOf(int i)    | 返回表示指定的 int 值的 Integer   实例 |
| public static Integer valueOf(String s) | 返回保存指定String值的 Integer 对象    |

- 示例代码

```java
public class IntegerDemo {
    public static void main(String[] args) {
        //public Integer(int value)：根据 int 值创建 Integer 对象(过时)
        Integer i1 = new Integer(100);
        System.out.println(i1);

        //public Integer(String s)：根据 String 值创建 Integer 对象(过时)
        Integer i2 = new Integer("100");
		//Integer i2 = new Integer("abc"); //NumberFormatException
        System.out.println(i2);
        System.out.println("--------");

        //public static Integer valueOf(int i)：返回表示指定的 int 值的 Integer 实例
        Integer i3 = Integer.valueOf(100);
        System.out.println(i3);

        //public static Integer valueOf(String s)：返回保存指定String值的Integer对象 
        Integer i4 = Integer.valueOf("100");
        System.out.println(i4);
    }
}
```

## 7.3 装箱与拆箱

基本类型与对应的包装类对象之间，来回转换的过程称为”装箱“与”拆箱“：

- **装箱**：从基本类型转换为对应的包装类对象。
- **拆箱**：从包装类对象转换为对应的基本类型。

用Integer与 int为例：（看懂代码即可）

基本数值---->包装对象

```java
Integer i = new Integer(4);//使用构造函数函数
Integer iii = Integer.valueOf(4);//使用包装类中的valueOf方法
```

包装对象---->基本数值

```java
int num = i.intValue();
```

## 7.4 自动装箱与自动拆箱

由于我们经常要做基本类型与包装类之间的转换，从Java 5（JDK 1.5）开始，基本类型与包装类的装箱、拆箱动作可以自动完成。例如：

```java
Integer i = 4;//自动装箱。相当于Integer i = Integer.valueOf(4);
i = i + 5;//等号右边：将i对象转成基本数值(自动拆箱) i.intValue() + 5;
//加法运算完成后，再次装箱，把基本数值转成对象。
```

## 7.5 基本类型与字符串之间的转换

### 基本类型转换为String

- 转换方式
- 方式一：直接在数字后加一个空字符串
- 方式二：通过String类静态方法valueOf()
- 示例代码

```java
public class IntegerDemo {
    public static void main(String[] args) {
        //int --- String
        int number = 100;
        //方式1
        String s1 = number + "";
        System.out.println(s1);
        //方式2
        //public static String valueOf(int i)
        String s2 = String.valueOf(number);
        System.out.println(s2);
        System.out.println("--------");
    }
}
```

### String转换成基本类型 

除了Character类之外，其他所有包装类都具有parseXxx静态方法可以将字符串参数转换为对应的基本类型：

- `public static byte parseByte(String s)`：将字符串参数转换为对应的byte基本类型。
- `public static short parseShort(String s)`：将字符串参数转换为对应的short基本类型。
- **`public static int parseInt(String s)`：将字符串参数转换为对应的int基本类型。**
- **`public static long parseLong(String s)`：将字符串参数转换为对应的long基本类型。**
- `public static float parseFloat(String s)`：将字符串参数转换为对应的float基本类型。
- `public static double parseDouble(String s)`：将字符串参数转换为对应的double基本类型。
- `public static boolean parseBoolean(String s)`：将字符串参数转换为对应的boolean基本类型。

代码使用（仅以Integer类的静态方法parseXxx为例）如：

- 转换方式
  - 方式一：先将字符串数字转成Integer，再调用valueOf()方法
  - 方式二：通过Integer静态方法parseInt()进行转换
- 示例代码

```java
public class IntegerDemo {
    public static void main(String[] args) {
        //String --- int
        String s = "100";
        //方式1：String --- Integer --- int
        Integer i = Integer.valueOf(s);
        //public int intValue()
        int x = i.intValue();
        System.out.println(x);
        //方式2
        //public static int parseInt(String s)
        int y = Integer.parseInt(s);
        System.out.println(y);
    }
}
```

> 注意:如果字符串参数的内容无法正确转换为对应的基本类型，则会抛出`java.lang.NumberFormatException`异常。





# 第八章 泛型（难点）

## 8.1  泛型概述

在前面学习集合时，我们都知道集合中是可以存放任意对象的，只要把对象存储集合后，那么这时他们都会被提升成Object类型。当我们在取出每一个对象，并且进行相应的操作，这时必须采用类型转换。

大家观察下面代码：

~~~java
public class GenericDemo {
	public static void main(String[] args) {
		Collection coll = new ArrayList();
		coll.add("abc");
		coll.add("itcast");
		coll.add(5);//由于集合没有做任何限定，任何类型都可以给其中存放
		Iterator it = coll.iterator();
		while(it.hasNext()){
			//需要打印每个字符串的长度,就要把迭代出来的对象转成String类型
			String str = (String) it.next();
			System.out.println(str.length());
		}
	}
}
~~~

程序在运行时发生了问题**java.lang.ClassCastException**。                                                                                             为什么会发生类型转换异常呢？                                                                                                                                       我们来分析下：由于集合中什么类型的元素都可以存储。导致取出时强转引发运行时 ClassCastException。                                                                                                                                                       怎么来解决这个问题呢？                                                                                                                                                           Collection虽然可以存储各种对象，但实际上通常Collection只存储同一类型对象。例如都是存储字符串对象。因此在JDK5之后，新增了**泛型**(**Generic**)语法，让你在设计API时可以指定类或方法支持泛型，这样我们使用API的时候也变得更为简洁，并得到了编译时期的语法检查。

* **泛型**：可以在类或方法中预支地使用未知的类型。

> tips:一般在创建对象时，将未知的类型确定具体的类型。当没有指定泛型时，默认类型为Object类型。

## 8.2  使用泛型的好处

上一节只是讲解了泛型的引入，那么泛型带来了哪些好处呢？

* 将运行时期的ClassCastException，转移到了编译时期变成了编译失败。
* 避免了类型强转的麻烦。

通过我们如下代码体验一下：

~~~java
public class GenericDemo2 {
	public static void main(String[] args) {
        Collection<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("itcast");
        // list.add(5);//当集合明确类型后，存放类型不一致就会编译报错
        // 集合已经明确具体存放的元素类型，那么在使用迭代器的时候，迭代器也同样会知道具体遍历元素类型
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = it.next();
            //当使用Iterator<String>控制元素类型后，就不需要强转了。获取到的元素直接就是String类型
            System.out.println(str.length());
        }
	}
}
~~~

> tips:泛型是数据类型的一部分，我们将类名与泛型合并一起看做数据类型。

## 8.3  泛型的定义与使用

我们在集合中会大量使用到泛型，这里来完整地学习泛型知识。

泛型，用来灵活地将数据类型应用到不同的类、方法、接口当中。将数据类型作为参数进行传递。

### 定义和使用含有泛型的类

定义格式：

~~~
修饰符 class 类名<代表泛型的变量> {  }
~~~

例如，API中的ArrayList集合：

泛型在定义的时候不具体，使用的时候才变得具体。在使用的时候确定泛型的具体数据类型。

~~~java
class ArrayList<E>{ 
    public boolean add(E e){ }

    public E get(int index){ }
   	....
}
~~~

使用泛型： 即什么时候确定泛型。

**在创建对象的时候确定泛型**

 例如，`ArrayList<String> list = new ArrayList<String>();`

此时，变量E的值就是String类型,那么我们的类型就可以理解为：

~~~java 
class ArrayList<String>{ 
     public boolean add(String e){ }

     public String get(int index){  }
     ...
}
~~~

再例如，`ArrayList<Integer> list = new ArrayList<Integer>();`

此时，变量E的值就是Integer类型,那么我们的类型就可以理解为：

~~~java
class ArrayList<Integer> { 
     public boolean add(Integer e) { }

     public Integer get(int index) {  }
     ...
}
~~~

###  含有泛型的方法

定义格式：

~~~
修饰符 <代表泛型的变量> 返回值类型 方法名(参数){  }
~~~

例如，

~~~java
public class MyGenericMethod {	  
    public <MVP> void show(MVP mvp) {
    	System.out.println(mvp.getClass());
    }
    
    public <MVP> MVP show2(MVP mvp) {	
    	return mvp;
    }
}
~~~

**调用方法时，确定泛型的类型**

~~~java
public class GenericMethodDemo {
    public static void main(String[] args) {
        // 创建对象
        MyGenericMethod mm = new MyGenericMethod();
        // 演示看方法提示
        mm.show("aaa");
        mm.show(123);
        mm.show(12.45);
    }
}
~~~

### 含有泛型的接口

定义格式：

~~~
修饰符 interface接口名<代表泛型的变量> {  }
~~~

例如，

~~~java
public interface MyGenericInterface<E>{
	public abstract void add(E e);
	
	public abstract E getE();  
}
~~~

使用格式：

**1、定义类时确定泛型的类型**

例如

~~~java
public class MyImp1 implements MyGenericInterface<String> {
	@Override
    public void add(String e) {
        // 省略...
    }

	@Override
	public String getE() {
		return null;
	}
}
~~~

此时，泛型E的值就是String类型。

 **2、始终不确定泛型的类型，直到创建对象时，确定泛型的类型**

 例如

~~~java
public class MyImp2<E> implements MyGenericInterface<E> {
	@Override
	public void add(E e) {
       	 // 省略...
	}

	@Override
	public E getE() {
		return null;
	}
}
~~~

确定泛型：

~~~java
/*
 * 使用
 */
public class GenericInterface {
    public static void main(String[] args) {
        MyImp2<String>  my = new MyImp2<String>();  
        my.add("aa");
    }
}
~~~

## 8.4  泛型通配符

当使用泛型类或者接口时，传递的数据中，泛型类型不确定，可以通过通配符<?>表示。但是一旦使用泛型的通配符后，只能使用Object类中的共性方法，集合中元素自身方法无法使用。

### 通配符基本使用

泛型的通配符:**不知道使用什么类型来接收的时候,此时可以使用?,?表示未知通配符。**

此时只能接受数据,不能往该集合中存储数据。

举个例子大家理解使用即可：
```java
public static void main(String[] args) {
    Collection<Intger> list1 = new ArrayList<Integer>();
    getElement(list1);
    Collection<String> list2 = new ArrayList<String>();
    getElement(list2);
}
public static void getElement(Collection<?> coll){}
// ？代表可以接收任意类型
泛型不存在继承关系 Collection<Object> list = new ArrayList<String>();这种是错误的
```

### 通配符高级使用

之前设置泛型的时候，实际上是可以任意设置的，只要是类就可以设置。但是在JAVA的泛型中可以指定一个泛型的**上限**和**下限**。

**泛型的上限**：

* **格式**： `类型名称 <? extends 类 > 对象名称`
* **意义**： `只能接收该类型及其子类`

**泛型的下限**：

- **格式**： `类型名称 <? super 类 > 对象名称`
- **意义**： `只能接收该类型及其父类型`

比如：现已知Object类，String 类，Number类，Integer类，其中Number是Integer的父类

~~~java
public static void main(String[] args) {
    Collection<Integer> list1 = new ArrayList<Integer>();
    Collection<String> list2 = new ArrayList<String>();
    Collection<Number> list3 = new ArrayList<Number>();
    Collection<Object> list4 = new ArrayList<Object>();
    
    getElement(list1);
    getElement(list2);//报错
    getElement(list3);
    getElement(list4);//报错
  
    getElement2(list1);//报错
    getElement2(list2);//报错
    getElement2(list3);
    getElement2(list4);
  
}
// 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
public static void getElement1(Collection<? extends Number> coll){}
// 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
public static void getElement2(Collection<? super Number> coll){}
~~~



# 第九章 Collection集合

## 9.1 集合概述

在前面基础班我们已经学习过并使用过集合ArrayList<E> ,那么集合到底是什么呢?

* **集合**：集合是java中提供的一种容器，可以用来存储多个数据。

集合和数组既然都是容器，它们有什么区别呢？

* 数组的长度是固定的。集合的长度是可变的。
* 数组中存储的是同一类型的元素，可以存储任意类型数据。集合存储的都是引用数据类型。如果想存储基本类型数据需要存储对应的包装类型。

## 9.2  集合常用类的继承体系

Collection：单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，分别是`java.util.List`和`java.util.Set`。其中，`List`的特点是元素有序、元素可重复。`Set`的特点是元素不可重复。`List`接口的主要实现类有`java.util.ArrayList`和`java.util.LinkedList`，`Set`接口的主要实现类有`java.util.HashSet`和`java.util.LinkedHashSet`。

从上面的描述可以看出JDK中提供了丰富的集合类库，为了便于初学者进行系统地学习，接下来通过一张图来描述集合常用类的继承体系

![](imgs\Collection集合体系图.jpg)

注意:这张图只是我们常用的集合有这些，不是说就只有这些集合。

集合本身是一个工具，它存放在java.util包中。在`Collection`接口定义着单列集合框架中最最共性的内容。

## 9.3 Collection 常用API

Collection是所有单列集合的父接口，因此在Collection中定义了单列集合(List和Set)通用的一些方法，这些方法可用于操作所有的单列集合。方法如下：

* `public boolean add(E e)`：  把给定的对象添加到当前集合中 。
* `public void clear()` :清空集合中所有的元素。
* `public boolean remove(E e)`: 把给定的对象在当前集合中删除。
* `public boolean contains(Object obj)`: 判断当前集合中是否包含给定的对象。
* `public boolean isEmpty()`: 判断当前集合是否为空。
* `public int size()`: 返回集合中元素的个数。
* `public Object[] toArray()`: 把集合中的元素，存储到数组中

> tips: 有关Collection中的方法可不止上面这些，其他方法可以自行查看API学习。
