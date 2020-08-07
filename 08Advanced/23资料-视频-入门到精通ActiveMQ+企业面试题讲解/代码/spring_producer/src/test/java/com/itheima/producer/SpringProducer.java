package com.itheima.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * 演示Spring与ActiveMQ整合
 */
@RunWith(SpringJUnit4ClassRunner.class) // junit与spring整合
@ContextConfiguration("classpath:applicationContext-producer.xml") // 加载spring配置文件
public class SpringProducer {

    //点对点模式
    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    //发布订阅模式
    @Autowired
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;


    /**
     * 点对点发送
     */
    @Test
    public void ptpSender(){
        /**
         * 参数一：指定队列的名称
         * 参数二：MessageCreator接口，我们需要提供该接口的匿名内部实现
         */
        jmsQueueTemplate.send("spring_queue", new MessageCreator() {
            //我们只需要返回发送的消息内容即可
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建文本消息
                TextMessage textMessage = session.createTextMessage("spring test message");
                return textMessage;
            }
        });
        System.out.println("消息发送已完成");
    }

    /**
     * 发布订阅发送
     */
    @Test
    public void psSender(){
        jmsTopicTemplate.send("spring_topic", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建文本消息
                TextMessage textMessage = session.createTextMessage("spring test message--topic");
                return textMessage;
            }
        });
        System.out.println("消息发送已完成");
    }
}
