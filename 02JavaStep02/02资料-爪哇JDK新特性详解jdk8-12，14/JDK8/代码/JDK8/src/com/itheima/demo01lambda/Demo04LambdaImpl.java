package com.itheima.demo01lambda;

public class Demo04LambdaImpl {
    public static void main(String[] args) {
        // 匿名内部类在编译后会形成一个新的类.$
        /*goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("使用匿名内部类实现游泳");
            }
        });*/

        goSwimming(() -> {
            System.out.println("Lambda表达式中的游泳");
        });
    }

    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}

