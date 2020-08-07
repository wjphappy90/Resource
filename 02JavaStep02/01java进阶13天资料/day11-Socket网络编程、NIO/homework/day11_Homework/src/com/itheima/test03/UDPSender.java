package com.itheima.test03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 使用UDP协议实现一个程序(发送端)发送信息给另一个程序(接收端)，
 接收端将接收到的内容打印输出即可。
 */
public class UDPSender {
    public static void main(String[] args) throws Exception {
        // 准备要发送的数据
        byte[] message = "约吗".getBytes();
        // 创建数据包对象
        DatagramPacket dp = new DatagramPacket(message, message.length,
                InetAddress.getLocalHost(), 6666);
        // 创建发送端Socket对象
        DatagramSocket ds = new DatagramSocket();
        // 调用方法发送数据包
        ds.send(dp);
        // 关闭资源:释放端口号
        ds.close();
    }
}