package com.itheima.test;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

public class RocketMQSendMessageTest {


    //发送消息
    public static void main(String[] args) throws Exception {
        //1.创建消息生产者,并且设置生产组名
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");

        //2 为生产者设置NameServer的地址
        producer.setNamesrvAddr("192.168.109.131:9876");

        //3 启动生产者
        producer.start();

        //4 构建消息对象,主要是设置消息的主题 标签 内容
        Message message = new Message("myTopic", "myTag", ("Test RocketMQ Message").getBytes());

        //5 发送消息 第二个参数代表超时时间
        SendResult result = producer.send(message, 10000);
        System.out.println(result);

        //6 关闭生产者
        producer.shutdown();

    }
}
