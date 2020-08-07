package com.itheima.zkDemo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class zkApiTest {


    private static final String connectString = "127.0.0.1:2181";
    private static final int sessionTimeout = 2000;

    private static ZooKeeper zk = null;

    @Before
    public void init() throws IOException {
        // //创建zookeeper的连接
        zk =  new ZooKeeper(connectString,sessionTimeout,(e)->{
            System.out.println("触发了"+e.getType()+"事件");
        });
    }

    @Test
    public void testZkApi() throws KeeperException, InterruptedException {

        //完成zk 的操作
        // 1.1 创建一个节点
//        String path = zk.create("/itheima", "itheima01".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(path);


        //判断节点是否存在 如果指定路径的节点存在返回节点的状态，如果节点不存在返回null
//        Stat exists = zk.exists("/itheima01", true);
//        System.out.println(exists);


        //获取指定路径下的所有子节点的名称
//        List<String> children = zk.getChildren("/itheima", true);
//        for (int i = 0; i < children.size(); i++) {
//            String node =  children.get(i);
//            System.out.println(node);
//        }


        //设置节点的数据
//        Stat stat1 = zk.setData("/itheima", "itheima01update".getBytes(), -1);
//        System.out.println(stat1);

        //获取节点的数据
//        byte[] data = zk.getData("/itheima", true, new Stat());
//        System.out.println(new String(data));

        zk.delete("/itheima/heima02",-1);



    }


}
