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

public class CuratorGet {

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
    public void get1() throws Exception {
        // 读取节点数据
        byte [] bys=client.getData()
                 // 节点的路径
                .forPath("/node1");
        System.out.println(new String(bys));
    }

    @Test
    public void get2() throws Exception {
        // 读取数据时读取节点的属性
        Stat stat=new Stat();
        byte [] bys=client.getData()
                // 读取属性
                .storingStatIn(stat)
                .forPath("/node1");
        System.out.println(new String(bys));
        System.out.println(stat.getVersion());
    }

    @Test
    public void get3() throws Exception {
        // 异步方式读取节点的数据
        client.getData()
                 .inBackground(new BackgroundCallback() {
                     public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                         // 节点的路径
                         System.out.println(curatorEvent.getPath());
                         // 事件类型
                         System.out.println(curatorEvent.getType());
                         // 数据
                         System.out.println(new String(curatorEvent.getData()));
                     }
                 })
                .forPath("/node1");
        Thread.sleep(5000);
        System.out.println("结束");
    }
}