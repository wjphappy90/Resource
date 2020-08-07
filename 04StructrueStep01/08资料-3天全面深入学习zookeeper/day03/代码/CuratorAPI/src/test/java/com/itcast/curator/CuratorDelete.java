package com.itcast.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class CuratorDelete {

    String IP = "192.168.60.130:2181,192.168.60.130:2182,192.168.60.130:2183";
    CuratorFramework client;

    @Before
    public void before() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
            .connectString(IP)
                .sessionTimeoutMs(10000)
                .retryPolicy(retryPolicy)
                .namespace("delete").build();
        client.start();
}

    @After
    public void after() {
        client.close();
    }

    @Test
    public void delete1() throws Exception {
       // 删除节点
        client.delete()
                // 节点的路径
                .forPath("/node1");
        System.out.println("结束");
    }


    @Test
    public void delete2() throws Exception {
        client.delete()
                // 版本号
                .withVersion(0)
                .forPath("/node1");
        System.out.println("结束");
    }

    @Test
    public void delete3() throws Exception {
        //删除包含字节点的节点
        client.delete()
                .deletingChildrenIfNeeded()
                .withVersion(-1)
                .forPath("/node1");
        System.out.println("结束");
    }

    @Test
    public void delete4() throws Exception {
        // 异步方式删除节点
        client.delete()
                .deletingChildrenIfNeeded()
                .withVersion(-1)
                .inBackground(new BackgroundCallback() {
                    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                        // 节点路径
                        System.out.println(curatorEvent.getPath());
                        // 事件类型
                        System.out.println(curatorEvent.getType());
                    }
                })
                .forPath("/node1");
        Thread.sleep(5000);
        System.out.println("结束");
    }
}