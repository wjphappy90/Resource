package com.itheima.test;

import com.itheima.OrderApplication;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class MessageTypeTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    //同步消息
    @Test
    public void testSyncSend() {
        //参数一: topic:tag
        //参数二: 消息体
        //参数三: 超时时间
        SendResult result =
                rocketMQTemplate.syncSend("test-topic-1:tag", "这是一条同步消息", 10000);
        System.out.println(result);
    }

    //异步消息
    @Test
    public void testAsyncSend() throws InterruptedException {
        //参数一: topic:tag
        //参数二: 消息体
        //参数三: 回调
        rocketMQTemplate.asyncSend("test-topic-1", "这是一条异步消息", new SendCallback() {
            //成功响应的回调
            @Override
            public void onSuccess(SendResult result) {
                System.out.println(result);
            }

            //异常响应的回调
            @Override
            public void onException(Throwable throwable) {
                System.out.println(throwable);
            }
        });
        System.out.println("==================");
        Thread.sleep(300000000);
    }

    //单向消息
    @Test
    public void testOneWay() {
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.sendOneWay("test-topic-1", "这是一条单向消息");
        }
    }


    //单向顺序消息
    @Test
    public void testOneWayOrderly() {
        for (int i = 0; i < 10; i++) {
            //第三个参数的作用是用来决定这些消息发送到哪个队列的上的
            rocketMQTemplate.sendOneWayOrderly("test-topic-1", "这是一条单向消息","xx");
        }
    }
}
