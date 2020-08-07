package com.itheima.consumer.listener;

import com.itheima.pojo.User;
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
    /*@JmsListener(destination = "${activemq.name}")
    public void receiveMessage(Message message){
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;

            try {
                System.out.println("接收消息："+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }*/

    /*@JmsListener(destination = "${activemq.name}")
    public void receiveMessage(Message message){
        if(message instanceof MapMessage){
            MapMessage mapMessage = (MapMessage)message;

            try {
                System.out.println("名称："+mapMessage.getString("name"));
                System.out.println("年龄："+mapMessage.getString("age"));
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }*/

   /* @JmsListener(destination = "${activemq.name}")
    public void receiveMessage(Message message){
        if(message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage)message;

            try {
                User user = (User)objectMessage.getObject();
                System.out.println(user.getUsername());
                System.out.println(user.getPassword());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }*/


    /*@JmsListener(destination = "${activemq.name}")
    public void receiveBytesMessage(Message message){
        if(message instanceof BytesMessage){


            BytesMessage bytesMessage = (BytesMessage)message;

            try {
                System.out.println("接收消息内容："+bytesMessage.getBodyLength());
                //1.设计缓存数组
                byte[] buffer = new byte[(int)bytesMessage.getBodyLength()];

                //2.把字节消息的内容写入到缓存数组
                bytesMessage.readBytes(buffer);

                //3.构建文件输出流
                FileOutputStream outputStream = new FileOutputStream("d:/activemq/test.jpg");

                //4.把数据写出本地硬盘
                outputStream.write(buffer);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }*/


    @JmsListener(destination = "${activemq.name}")
    public void receiveStreamMessage(Message message){
        if(message instanceof StreamMessage){


            StreamMessage streamMessage = (StreamMessage)message;


            try {
                //接收消息属性
                System.out.println(streamMessage.getStringProperty("订单"));

                System.out.println(streamMessage.readString());
                System.out.println(streamMessage.readInt());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
