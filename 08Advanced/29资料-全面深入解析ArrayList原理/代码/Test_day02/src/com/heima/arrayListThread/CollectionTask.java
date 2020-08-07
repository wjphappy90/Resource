package com.heima.arrayListThread;

import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
//线程任务类
public class CollectionTask implements Runnable {
    //通过构造方法共享一个集合
    private List<String> list;

    public CollectionTask(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        //synchronized (this) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //把当前线程名字加入到集合
            list.add(Thread.currentThread().getName());
        //}
    }
}
