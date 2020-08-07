package com.itheima.producer;

import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.ScheduledMessage;
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


    @Test
    public void testMessage(){
            jmsMessagingTemplate.convertAndSend(name, "消息");
    }

    /**
     * 延迟投递
     */
    @Test
    public void sendMessage(){

        Connection connection = null;
        Session session = null;
        ActiveMQMessageProducer producer = null;
        // 获取连接工厂
        ConnectionFactory connectionFactory = jmsMessagingTemplate.getConnectionFactory();

        try {
            connection = connectionFactory.createConnection();

            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(name);
            int count = 10;

            producer = (ActiveMQMessageProducer) session.createProducer(queue);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //创建需要发送的消息
            TextMessage textMessage = session.createTextMessage("Hello");

            //设置延时时长(延时10秒)
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 10000);

            producer.send(textMessage);

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
