package com.itheima.test08;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test08
 * @date 2018/5/4  下午6:37
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(),8080);

        // 获得字节输入输出流对象
        OutputStream os =  socket.getOutputStream();
        InputStream in = socket.getInputStream();

        // 创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        // 接收用户名和密码
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        // 按指定的格式拼接字符串
        String content = username+"="+password; //jack=123456


        // 发送数据给服务器
        os.write(content.getBytes());
        // 关闭输出流，向服务器写出结束符
        socket.shutdownOutput();

        // 创建字节输出用来存储服务器返回的数据
        byte[] buffer = new byte[1024];
        // 读取服务器返回的数据
        int len = in.read(buffer);
        System.out.println(new String(buffer,0,len));
        // 关闭socket对象，断开服务器连接
        socket.close();
    }
}
