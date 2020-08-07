package com.itheima.test09;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test09
 * @date 2018/5/4  下午6:41
 */
public class TCPServer {
    public static void main(String[] args)throws Exception {
        // 创建服务器端socket
        ServerSocket serverSocket = new ServerSocket(9090);
        boolean flag = true;
        // 不断的接受客户端的连接
        while(flag) {
            // 接收客户连接并获得客户端socket
            Socket socket = serverSocket.accept();
            // 创建下载线程
            new DownloadThread(socket).start();
        }
        // 关闭服务器
        serverSocket.close();
    }
}
