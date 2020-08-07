package com.itheima.demo08annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;

public class Demo02 <@TypeParam T> {
    private @NotNull int a = 10;

    public void test(@NotNull String str, @NotNull int a) {
        @NotNull double d = 10.1;
    }

    public <@TypeParam E extends Integer> void test01() {
    }
}

@Target(ElementType.TYPE_USE)
@interface NotNull {
}

@Target(ElementType.TYPE_PARAMETER)
@interface TypeParam {
}
