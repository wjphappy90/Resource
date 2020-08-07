package com.itheima.demo06optional;

import org.junit.Test;

import java.util.Optional;

public class Demo01 {

    @Test
    public void test05() {
        User u = new User("Hello", 18);
        // getUpperUserName1(u);
        Optional<User> op = Optional.of(u);
        System.out.println(getUpperUserName2(op));
    }

    // 定义一个方法将User中的用户名转成大写并返回
    // 使用Optional方式
    public String getUpperUserName2(Optional<User> op) {
        /*String upperName = op.map(u -> u.getUserName())
                .map(s -> s.toUpperCase())
                .orElse("null");*/
        String upperName = op.map(User::getUserName)
                .map(String::toUpperCase)
                .orElse("null");
        return upperName;
    }

    // 定义一个方法将User中的用户名转成大写并返回
    // 使用传统方式
    public String getUpperUserName1(User u) {
        if (u != null) {
            String userName = u.getUserName();
            if (userName != null) {
                return userName.toUpperCase();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    @Test
    public void test04() {
        Optional<String> userNameO = Optional.of("凤姐");
        // Optional<String> userNameO = Optional.empty();

        // 存在做的什么
        // ifPresent: 如果有值就调用参数
        /*userNameO.ifPresent(s -> {
            System.out.println("有值: " + s);
        });*/

        // ifPresentOrElse: 存在做的什么,不存在做点什么
        userNameO.ifPresentOrElse(s -> {
            System.out.println("有值: " + s);
        }, () -> {
            System.out.println("没有值");
        });
    }

    @Test
    public void test03() {
        // Optional<String> userNameO = Optional.of("凤姐");
        Optional<String> userNameO = Optional.empty();

        // orElse: 如果Optional中有值,就取出这个值,如果没有值就使用参数指定的值
        String name = userNameO.orElse("如花吗?");
        System.out.println("name = " + name);
    }

    // Optional类的基本使用
    @Test
    public void test02() {
        // 1.创建Optional对象
        // of:只能传入一个具体值,不能传入null
        // ofNullable: 既可以传入具体值,也可以传入null
        // empty: 存入的是null
        Optional<String> op1 = Optional.of("凤姐");
        // Optional<String> op1 = Optional.of(null);
        // Optional<String> op2 = Optional.ofNullable("如花");
        // Optional<String> op2 = Optional.ofNullable("如花");
        Optional<Object> op3 = Optional.empty();

        // 2.isPresent: 判断Optional中是否有具体值, 有值返回true,没有值返回false
        // boolean present = op1.isPresent();
        // System.out.println("present = " + present);

        // 3.get: 获取Optional中的值,如果有值就返回值具体值,没有值就报错
        // System.out.println(op3.get());

        if (op1.isPresent()) {
            System.out.println(op1.get());
        } else {
            System.out.println("没有值");
        }
    }

    // 以前对null的处理方式
    @Test
    public void test01() {
        String userName = "凤姐";

        if (userName != null) {
            System.out.println("姓名为: " + userName);
        } else {
            System.out.println("姓名不存在");
        }
    }
}
