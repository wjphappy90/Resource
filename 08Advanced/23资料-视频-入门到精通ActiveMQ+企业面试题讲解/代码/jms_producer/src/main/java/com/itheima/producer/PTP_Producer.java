package com.itheima.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 演示点对点模式 -- 消息生产者
 */
public class PTP_Producer {

    public static void main(String[] args) throws JMSException {

        //1.创建连接工厂
        ConnectionFactory factory
                 = new ActiveMQConnectionFactory("tcp://192.168.66.133:61616");

        //2.创建连接
        Connection connection = factory.createConnection();

        //3.打开连接
        connection.start();

        //4.创建session
        /**
         * 参数一：是否开启事务操作
         * 参数二：消息确认机制
         */
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5.创建目标地址（Queue:点对点消息，Topic：发布订阅消息）
        Queue queue = session.createQueue("queue01");

        //6.创建消息生产者
        MessageProducer producer = session.createProducer(queue);

        //7.创建消息
        //createTextMessage: 文本类型
        TextMessage textMessage = session.createTextMessage("test message");

        //8.发送消息
        producer.send(textMessage);

        System.out.println("消息发送完成");

        //9.释放资源
        session.close();
        connection.close();
    }

}
