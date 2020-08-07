package com.itheima.test06;

/**
 在下面的代码中，请分别使用Lambda的标准格式及省略格式调用
 invokeDirect 方法，打印输出：导演拍电影啦!
 */
public class TestInvokeDirect {
    public static void main(String[] args) {
        // TODO 请分别使用Lambda【标准格式】及【省略格式】调用invokeDirect方法 


        // 【标准格式】
        invokeDirect(()-> {
            System.out.println("导演拍电影啦！");
        });

        // 【省略格式】
        invokeDirect(()-> System.out.println("导演拍电影啦！"));

    }
    private static void invokeDirect(Director director) {
        director.makeMovie();
    }
}
