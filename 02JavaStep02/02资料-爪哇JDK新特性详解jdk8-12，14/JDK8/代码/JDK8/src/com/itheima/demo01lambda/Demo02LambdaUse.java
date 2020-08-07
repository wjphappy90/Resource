package com.itheima.demo01lambda;

/*
    Lambda的标准格式:
        (int a) -> {
            要执行的代码
        }
 */
public class Demo02LambdaUse {
    public static void main(String[] args) {
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("凤姐 自由泳.");
            }
        });

        // 小结:Lambda表达式相当于是对接口抽象方法的重写
        goSwimming(() -> {
            System.out.println("如花 蛙泳");
        });
    }

    // 练习无参数无返回值的Lambda
    public static void goSwimming(Swimmable s) {
        s.swimming();
    }

    public static void test(int a) {

    }
}
