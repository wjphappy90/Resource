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


public class CuratorCreate {

    String IP = "192.168.60.130:2181,192.168.60.130:2182,192.168.60.130:2183";
    CuratorFramework client;

    @Before
    public void before() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.builder()
                .connectString(IP)
                .sessionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .namespace("create")
                .build();
        client.start();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void create1() throws Exception {
        // 新增节点
        client.create()
                // 节点的类型
                .withMode(CreateMode.PERSISTENT)
                // 节点的权限列表 world:anyone:cdrwa
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                // arg1:节点的路径
                // arg2:节点的数据
                .forPath("/node1", "node1".getBytes());
        System.out.println("结束");
    }


    @Test
    public void create2() throws Exception {
        // 自定义权限列表
        // 权限列表
        List<ACL> list = new ArrayList<ACL>();
        // 授权模式和授权对象
        Id id = new Id("ip", "192.168.60.130");
        list.add(new ACL(ZooDefs.Perms.ALL, id));
        client.create().withMode(CreateMode.PERSISTENT).withACL(list).forPath("/node2", "node2".getBytes());
        System.out.println("结束");
    }

    @Test
    public void create3() throws Exception {
        // 递归创建节点树
        client.create()
                // 递归节点的创建
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                .forPath("/node3/node31", "node31".getBytes());
        System.out.println("结束");
    }


    @Test
    public void create4() throws Exception {
        // 异步方式创建节点
        client.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                // 异步回调接口
                .inBackground(new BackgroundCallback() {
                     public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                         // 节点的路径
                         System.out.println(curatorEvent.getPath());
                         // 时间类型
                         System.out.println(curatorEvent.getType());
                     }
        })
                .forPath("/node4","node4".getBytes());
        Thread.sleep(5000);
        System.out.println("结束");
    }
}