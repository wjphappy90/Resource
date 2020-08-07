package com.itcast.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CuratorTransaction {

    String IP = "192.168.60.130:2181,192.168.60.130:2182,192.168.60.130:2183";
    CuratorFramework client;

    @Before
    public void before() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString(IP)
                .sessionTimeoutMs(10000).retryPolicy(retryPolicy)
                .namespace("create").build();
        client.start();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void tra1() throws Exception {
        // 开启事务
        client.inTransaction()
                .create().forPath("/node1","node1".getBytes())
                .and()
                .create().forPath("/node2","node2".getBytes())
                .and()
                //事务提交
                .commit();
    }
}