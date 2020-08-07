package com.itheima.test07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test07
 * @date 2018/5/4  下午6:36
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 创建客户的socket
        Socket socket = new Socket("127.0.0.1", 8888);
        // 获得socket输出流
        OutputStream out = socket.getOutputStream();
        // 创建文件字节输入流
        FileInputStream fis = new FileInputStream("c:\\java\\bbb.png");
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf))!= -1) {
            // 通过out向服务器端输出文件数据
            out.write(buf, 0, len);
        }
        // 客户端发送数据完毕，结束Socket输出流的写入操作，告知服务器端
        socket.shutdownOutput();

        System.out.println(out);

        // 获得socket输入流对象，读取服务器返回的内容：上传成功
        InputStream in = socket.getInputStream();
        len = in.read(buf);
        System.out.println(new String(buf,0,len));
        // 关闭资源
        socket.close();
        fis.close();
    }
}
