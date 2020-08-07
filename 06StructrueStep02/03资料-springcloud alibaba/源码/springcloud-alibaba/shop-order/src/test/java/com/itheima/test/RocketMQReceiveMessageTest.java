package com.itheima.test;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class RocketMQReceiveMessageTest {

    //接收消息
    public static void main(String[] args) throws Exception {

        //1 创建消费者,并且为其指定消费者组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myconsumer-group");

        //2 为消费者设置NameServer的地址
        consumer.setNamesrvAddr("192.168.109.131:9876");

        //3 指定消费者订阅的主题和标签
        consumer.subscribe("myTopic", "*");

        //4 设置一个回调函数,并在函数中编写接收到消息之后的处理方法
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            //处理获取到的消息
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                //消费逻辑
                System.out.println("Message===>" + list);

                //返回消费成功状态
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        //5 启动消费者
        consumer.start();
        System.out.println("启动消费者成功了");
    }
}
