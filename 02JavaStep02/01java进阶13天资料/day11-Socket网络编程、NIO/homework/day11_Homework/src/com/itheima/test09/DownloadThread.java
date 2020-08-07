package com.itheima.test09;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashSet;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test09
 * @date 2018/5/4  下午6:41
 */
public class DownloadThread extends Thread{
    // 创建集合存放ip地址
    HashSet<String> ips = new HashSet<String>();
    // 客户端socket对象
    private Socket socket;

    public DownloadThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // 获得输出流对象
            OutputStream os = socket.getOutputStream();
            // 创建输入流对象
            FileInputStream fis = new FileInputStream("c:/java/aaa.png");

            // 循环读取文件数据
            int len = -1;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) != -1) {
                // 向客户端写出图片数据
                os.write(buf,0,len);
            }

            // 获得客户端的ip地址
            String ip = socket.getInetAddress().getHostAddress();
            if(ips.add(ip)){
                System.out.println("恭喜"+ip+"同学，下载成功！！ 当前下载的人数是："+ips.size());
            }
            // 释放资源
            fis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
