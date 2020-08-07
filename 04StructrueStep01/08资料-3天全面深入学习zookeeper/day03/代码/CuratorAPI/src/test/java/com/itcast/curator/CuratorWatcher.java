package com.itcast.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CuratorWatcher {

    String IP = "192.168.60.130:2181,192.168.60.130:2182,192.168.60.130:2183";
    CuratorFramework client;

    @Before
    public void before() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory
                .builder()
                .connectString(IP)
                .sessionTimeoutMs(10000)
                .retryPolicy(retryPolicy)
                .build();
        client.start();
    }

    @After
    public void after() {
        client.close();
    }


    @Test
    public void watcher1() throws Exception {
        // 监视某个节点的数据变化
        // arg1:连接对象
        // arg2:监视的节点路径
       final NodeCache nodeCache=new NodeCache(client,"/watcher1");
        // 启动监视器对象
        nodeCache.start();
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            // 节点变化时回调的方法
            public void nodeChanged() throws Exception {
                System.out.println(nodeCache.getCurrentData().getPath());
                System.out.println(new String(nodeCache.getCurrentData().getData()));
            }
        });
        Thread.sleep(100000);
        System.out.println("结束");
        //关闭监视器对象
        nodeCache.close();
    }

    @Test
    public void watcher2() throws Exception {
         // 监视子节点的变化
        // arg1:连接对象
        // arg2:监视的节点路径
        // arg3:事件中是否可以获取节点的数据
        PathChildrenCache pathChildrenCache=new PathChildrenCache(client,"/watcher1",true);
        // 启动监听
        pathChildrenCache.start();
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            // 当子节点方法变化时回调的方法
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                // 节点的事件类型
                System.out.println(pathChildrenCacheEvent.getType());
                // 节点的路径
                System.out.println(pathChildrenCacheEvent.getData().getPath());
                // 节点数据
                System.out.println(new String(pathChildrenCacheEvent.getData().getData()));
            }
        });
        Thread.sleep(100000);
        System.out.println("结束");
        // 关闭监听
        pathChildrenCache.close();

    }
}