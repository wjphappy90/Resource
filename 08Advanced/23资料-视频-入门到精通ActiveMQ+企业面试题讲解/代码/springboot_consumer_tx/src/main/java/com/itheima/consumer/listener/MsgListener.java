package com.itheima.consumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.io.FileOutputStream;

/**
 * 用于监听消息类（既可以用于队列的监听，也可以用于主题监听）
 */
@Component // 放入IOC容器
public class MsgListener {

    /**
     * 接收TextMessage的方法
     */
    @JmsListener(destination = "${activemq.name}")
    public void receiveMessage(Message message,Session session){
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;

            try {
                System.out.println("接收消息："+textMessage.getText());


                int i=10/0;

                //提交事务
                session.commit();
            } catch (JMSException e) {
                e.printStackTrace();
                //回滚事务
                try {
                    session.rollback();//一旦事务回滚，MQ会重发消息，一共重发6次
                } catch (JMSException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

}
