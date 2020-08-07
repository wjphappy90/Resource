package com.itheima.test07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima
 * @date 2018/5/4  下午6:35
 */
public class TCPServer {
    public static void main(String[] args)throws IOException {
        // 创建服务器socket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        // 死循环保证服务器不退出
        while(true) {
            // 获得socket对象
            Socket socket = serverSocket.accept();
            // 创建线程
            Thread t = new Thread(new UploadThread(socket));
            t.start();
        }
    }
}
