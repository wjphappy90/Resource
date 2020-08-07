package com.itcast.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CuratorExists {

    String IP = "192.168.60.130:2181,192.168.60.130:2182,192.168.60.130:2183";
    CuratorFramework client;

    @Before
    public void before() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString(IP)
                .sessionTimeoutMs(10000).retryPolicy(retryPolicy)
                .namespace("get").build();
        client.start();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void exists1() throws Exception {
        // 判断节点是否存在
       Stat stat= client.checkExists()
                 // 节点路径
                .forPath("/node2");
        System.out.println(stat.getVersion());
    }

    @Test
    public void exists2() throws Exception {
        // 异步方式判断节点是否存在
        client.checkExists()
                 .inBackground(new BackgroundCallback() {
                     public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                         // 节点路径
                         System.out.println(curatorEvent.getPath());
                         // 事件类型
                         System.out.println(curatorEvent.getType());
                         System.out.println(curatorEvent.getStat().getVersion());
                     }
                 })
                .forPath("/node2");
        Thread.sleep(5000);
        System.out.println("结束");
    }
}