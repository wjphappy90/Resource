package com.itheima.demo01var;


import java.util.ArrayList;

public class Demo01 {
    // var m = 10;
    public static void main(String[] args) {

    }

    /*
        了解局部变量类型推断的注意事项
            1.var不是关键字,只是一个保留字,意味着var可以作为类名,方法名...但是不建议
            2.var定义变量时必须立马赋值
            3.var不能同时定义多个变量
     */
    public static void test05() {
        int a;
        a = 10;

        // var b;
        // b = 10;
        var b = 10;

        int m = 10, n = 20;
        // var x = 10, y = 20;
    }

    /*
        局部变量类型推断不能使用场景
            1.成员变量不行
            2.方法的参数不行
            3.返回值类型不行
     */
    public static void test04(/*var k*/) {

    }

    /*
        局部变量类型推断使用场景
            1.局部变量
            2.循环中的变量
     */
    public static void test03() {
        var i = 3;

        for (var x = 0; x < 5; x++) {
            var str = "abc";
        }
    }

    // JDK10局部变量类型推断的使用
    public static void test02() {
        // 使用var就可以进行局部变量类型推断
        // 只要将变量名左边的类型替换为var即可,语法很精简
        // 局部变量类型推断会根据变量右边的具体值推断左边的类型
        var str = "hello";
        var i = 3;
        var d = 3.14;
        var list = new ArrayList<String>();
    }

    // JDK10之前定义变量存在的问题
    public static void test01() {
        // 每次定义变量都需要在变量名的左边声明类型,这是很麻烦的,真的有必要么?
        // 其实左边的类型就是右边值的类型
        String str = "Hello";
        int i = 3;
        double d = 3.14;
        ArrayList<String> list = new ArrayList<>();
    }
}
