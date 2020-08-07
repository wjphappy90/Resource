package com.itheima.test06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test06
 * @date 2018/5/4  下午6:28
 */
public class TCPServer {
    public static void main(String[] args) {
        System.out.println("服务端启动。。。");
        try {
            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            //创建服务端socket
            ServerSocket serverSocket = new ServerSocket(8888);
            //得到客户端对应的对象
            Socket socket = serverSocket.accept();
            // 字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 字符输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true) {
                //接收对方的数据
                System.out.println("客户端说：" + br.readLine()); // 你好
                System.out.println("我说：");
                String words = sc.nextLine();
                if ("exit".equals(words)) {  //只要说了exit，结束循环

                    break;
                }
                //发送给对方
                bw.write(words);

                bw.newLine();
                bw.flush();
            }
            br.close();
            bw.close();
            // 断开与客户端的连接
            socket.close();
            // 关闭服务器
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
