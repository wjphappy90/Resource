package com.itheima.test09;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test09
 * @date 2018/5/4  下午6:41
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 创建客户端socket
        Socket socket = new Socket("10.211.55.3", 9090);
        // 创建文件输出流对象
        FileOutputStream fos = new FileOutputStream("c:/java/bbb.png");
        // 获得输入流对象
        InputStream in = socket.getInputStream();
        // 使用循环读取服务器返回的数据
        byte[] buf = new byte[1024];
        int len = -1;
        while((len = in.read(buf)) != -1) {
            fos.write(buf,0,len);
        }
        // 关闭资源
        socket.close();
        fos.close();
    }
}
