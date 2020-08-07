package com.itheima.test05;

import java.io.OutputStream;
import java.net.Socket;

/**
 * 创建TCP 客户端，访问上一题创建的服务器端,服务器端ip：127.0.0.1 端口号：8888
 * 1: 客户端连接服务器,并发送 hello.服务器,我是客户端。
 * 2: 开启上一题服务器,等待客户端连接,客户端连接并发送数据。
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
		//创建 Socket客户端对象
		Socket socket = new Socket("127.0.0.1", 8888);
		//写数据  需要输出流  谁提供 客户端
		OutputStream out = socket.getOutputStream();
		//写数据
		out.write("hello.服务器,我是客户端.".getBytes());
		//释放资源
		out.close();
		socket.close();
	}
}
