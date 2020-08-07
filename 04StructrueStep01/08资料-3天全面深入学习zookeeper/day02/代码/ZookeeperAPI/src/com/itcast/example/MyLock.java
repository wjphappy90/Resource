package com.itcast.example;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MyLock {
    //  zk的连接串
    String IP = "192.168.60.130:2181";
    //  计数器对象
    CountDownLatch countDownLatch = new CountDownLatch(1);
    //ZooKeeper配置信息
    ZooKeeper zooKeeper;
    private static final String LOCK_ROOT_PATH = "/Locks";
    private static final String LOCK_NODE_NAME = "Lock_";
    private String lockPath;

    // 打开zookeeper连接
    public MyLock() {
        try {
            zooKeeper = new ZooKeeper(IP, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getType() == Event.EventType.None) {
                        if (event.getState() == Event.KeeperState.SyncConnected) {
                            System.out.println("连接成功!");
                            countDownLatch.countDown();
                        }
                    }
                }
            });
            countDownLatch.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //获取锁
    public void acquireLock() throws Exception {
        //创建锁节点
        createLock();
        //尝试获取锁
        attemptLock();
    }

    //创建锁节点
    private void createLock() throws Exception {
        //判断Locks是否存在，不存在创建
        Stat stat = zooKeeper.exists(LOCK_ROOT_PATH, false);
        if (stat == null) {
            zooKeeper.create(LOCK_ROOT_PATH, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        // 创建临时有序节点
        lockPath = zooKeeper.create(LOCK_ROOT_PATH + "/" + LOCK_NODE_NAME, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("节点创建成功:" + lockPath);
    }

    //监视器对象，监视上一个节点是否被删除
    Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            if (event.getType() == Event.EventType.NodeDeleted) {
                synchronized (this) {
                    notifyAll();
                }
            }
        }
    };

    //尝试获取锁
    private void attemptLock() throws Exception {
        // 获取Locks节点下的所有子节点
        List<String> list = zooKeeper.getChildren(LOCK_ROOT_PATH, false);
        // 对子节点进行排序
        Collections.sort(list);
        // /Locks/Lock_000000001
        int index = list.indexOf(lockPath.substring(LOCK_ROOT_PATH.length() + 1));
        if (index == 0) {
            System.out.println("获取锁成功!");
            return;
        } else {
            // 上一个节点的路径
            String path = list.get(index - 1);
            Stat stat = zooKeeper.exists(LOCK_ROOT_PATH + "/" + path, watcher);
            if (stat == null) {
                attemptLock();
            } else {
                synchronized (watcher) {
                    watcher.wait();
                }
                attemptLock();
            }
        }

    }

    //释放锁
    public void releaseLock() throws Exception {
            //删除临时有序节点
            zooKeeper.delete(this.lockPath,-1);
            zooKeeper.close();
            System.out.println("锁已经释放:"+this.lockPath);
    }

    public static void main(String[] args) {
        try {
            MyLock myLock = new MyLock();
            myLock.createLock();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}