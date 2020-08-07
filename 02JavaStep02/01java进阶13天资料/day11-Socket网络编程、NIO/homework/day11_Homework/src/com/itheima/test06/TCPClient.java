package com.itheima.test06;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test06
 * @date 2018/5/4  下午6:29
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            // 创建键盘录入对象
            Scanner sc = new Scanner(System.in);
            // 创建Socket对象
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            // 字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 字符输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true) {
                System.out.println("我说：");
                // 接收键盘的输入字符串
                String words = sc.nextLine();
                if ("exit".equals(words)) {
                    break;
                }
                // 发送数据
                bw.write(words);
                // 换行
                bw.newLine();
                // 一定要flush()
                bw.flush();
                // 收取对方的数据
                System.out.println("对方说：" + br.readLine());
            }
            br.close();
            bw.close();
            // 断开连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
