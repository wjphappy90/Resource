package com.itcast.dynamic;



import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LInkedListThread {
    public static void main(String[] args) {

       /* LinkedList<String> linkedList = new LinkedList();
        Collection  ts = Collections.synchronizedCollection(linkedList);*/
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(); // cas 无锁化机制  volatile 关键字来解决的

        for (int i = 0; i < 4; i++) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      concurrentLinkedQueue.add(UUID.randomUUID().toString().substring(0,10));
                      System.out.println(concurrentLinkedQueue);
                  }
              }).start();
        }
    }
}
