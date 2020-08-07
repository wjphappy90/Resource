package com.itheima.test08;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer{

    public static void main(String[] args) throws IOException {
        // 创建服务器端socket，相当于开启服务器
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){
            // 等待并接收客户端连接
            Socket socket = serverSocket.accept();
            // 创建线程处理客户端的请求
            new LoginThread(socket).start();
        }
    }
}
