package com.itheima.test07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test07
 * @date 2018/5/4  下午6:36
 */

public class UploadThread implements Runnable {
    private Socket socket;

    public UploadThread(Socket socket) {
        this.socket = socket;
    }

    public UploadThread() {

    }

    @Override
    public void run() {
        try {
            // 创建目标文件对象，用来保存上传的文件
            File dir = new File("c:\\java\\uploads");
            dir.mkdirs();
            // 文件名：域名+当前时间毫秒值+6位随机数.png
            String filename = "com.itheima" + System.currentTimeMillis()+".png";
            FileOutputStream fos = new FileOutputStream(new File(dir, filename));
            // 通过socket对象获得字节输入流对象
            InputStream in = socket.getInputStream();
            // 读取客户端上传的图片数据
            int len = 0;
            byte[] buf = new byte[1024];
            while((len = in.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
            // 向客户端写出：上传成功
            socket.getOutputStream().write("上传成功".getBytes());
            // 关闭资源
            socket.close();
            fos.close();
        } catch (Exception e) {

        }
    }
}

