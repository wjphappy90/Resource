package com.itheima.test03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test03
 * @date 2018/5/4  下午6:24
 */
public class UDPReceive {
    public static void main(String[] args) throws Exception {
        // 创建字节数组:用来存储接收到的数据
        byte[] buf = new byte[1024];
        // 创建数据包对象
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        // 创建Socket对象：用来接收数据包
        DatagramSocket ds = new DatagramSocket(6666);
        // 调用方法接收数据包
        ds.receive(dp);

        // 获得实际接收到的内容长度
        int length = dp.getLength();
        System.out.println(length);

        // 获得发送端的ip地址
        String sendIp = dp.getAddress().getHostAddress();
        // 获得发送端的端口号
        int port = dp.getPort();
        System.out.println(sendIp);
        System.out.println(port);

        // 将接收到的数据转出字符串输出
        String message = new String(buf,0,length);
        System.out.println(message);
        System.out.println("come here");
        // 关闭资源：释放端口号
        ds.close();
    }
}
