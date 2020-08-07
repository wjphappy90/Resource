package com.itheima.producer;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 演示SpringBoot与ActiveMQ整合- 消息生产者
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class SpringBootProducer {

    //JmsMessagingTemplate: 用于工具类发送消息
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${activemq.name}")
    private String name;

    /**
     * 没有加入事务
     */
    @Test
    public void testMessage(){

        for(int i=1;i<=10;i++) {
            //模拟异常
            if(i==4){
                int a = 10/0;
            }

            jmsMessagingTemplate.convertAndSend(name, "消息---"+i);
        }

    }


    /**
     * 事务性发送--方案一
     */
    @Test
    public void sendMessageTx(){
        //获取连接工厂
        ConnectionFactory connectionFactory = jmsMessagingTemplate.getConnectionFactory();

        Session session = null;
        try {
            //创建连接
            Connection connection = connectionFactory.createConnection();

            /**
             * 参数一：是否开启消息事务
             */
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            //创建生产者
            MessageProducer producer = session.createProducer(session.createQueue(name));

            for(int i=1;i<=10;i++){
                //模拟异常
               /* if(i==4){
                    int a = 10/0;
                }*/

                TextMessage textMessage = session.createTextMessage("消息--" + i);
                producer.send(textMessage);
            }

            //注意：一旦开启事务发送，那么就必须使用commit方法进行事务提交，否则消息无法到达MQ服务器
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
            //消息事务回滚
            try {
                session.rollback();
            } catch (JMSException e1) {
                e1.printStackTrace();
            }
        }


    }

    @Autowired
    private MessageService messageService;

    /**
     * 事务性发送--方案二： Spring的JmsTransactionManager功能
     */
    @Test
    public void sendMessageTx2(){
        messageService.sendMessage();
    }


    @Test
    public void testMessage2(){
            jmsMessagingTemplate.convertAndSend(name, "测试消息");
    }
}
