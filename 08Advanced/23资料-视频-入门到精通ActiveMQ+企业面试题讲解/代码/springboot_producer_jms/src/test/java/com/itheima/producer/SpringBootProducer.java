package com.itheima.producer;

import com.itheima.pojo.User;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
     * 发送TextMessage消息
     */
    @Test
    public void testMessage(){

        jmsTemplate.send(name, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("文本消息");

                return textMessage;
            }
        });

    }


    /**
     * 发送MapMessage消息
     */
    @Test
    public void mapMessage(){

        jmsTemplate.send(name, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("name","张三");
                mapMessage.setInt("age",20);

                return mapMessage;
            }
        });

    }


    /**
     * 发送ObjectMessage消息
     *//*
    @Test
    public void objectMessage(){

        jmsTemplate.send(name, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                User user = new User("小明","123456");

                ObjectMessage objectMessage = session.createObjectMessage(user);

                return objectMessage;
            }
        });

    }
*/
    /**
     * 发送BytesMessage消息
     */
    @Test
    public void bytesMessage(){

        jmsTemplate.send(name, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                BytesMessage bytesMessage = session.createBytesMessage();


                //1.读取文件
                File file = new File("d:/activemq/spring.jpg");

                //2.构建文件输入流
                try {
                    FileInputStream inputStream = new FileInputStream(file);

                    //3.把文件流写入到缓存数组中
                    byte[] buffer = new byte[(int)file.length()];
                    inputStream.read(buffer);

                    //4.把缓存数组写入到BytesMessage中
                    bytesMessage.writeBytes(buffer);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return bytesMessage;
            }
        });

    }



    /**
     * 发送StreamMessage消息
     */
    @Test
    public void streamMessage(){

        jmsTemplate.send(name, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                StreamMessage streamMessage = session.createStreamMessage();
                streamMessage.writeString("你好，ActiveMQ");
                streamMessage.writeInt(20);

                //设置消息属性：标记、过滤
                streamMessage.setStringProperty("订单","order");

                return streamMessage;
            }
        });

    }
}
