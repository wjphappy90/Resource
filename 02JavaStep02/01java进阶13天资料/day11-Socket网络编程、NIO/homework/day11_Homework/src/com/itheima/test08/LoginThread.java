package com.itheima.test08;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 定义枚举类，用来标识错误
 */
enum ErrorCode {
    PASSWORD_ERROR,USERNAME_NOT_EXIST,RIGHT
}

public class LoginThread extends Thread{
    // 客户端socket对象
    private Socket socket;
    // 构造方法
    public LoginThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 根据字节输入流对象创建字符缓冲输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
            // 读取客户端发送过来的用户名和密码
            String content = br.readLine();
            System.out.println(content); // jack=123456
            // 根据字节输出流对象创建字符缓冲输出流
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 执行登录操作并获得返回值
            // ErrorCode status = login(content);

            int status = login(content);
            if(status == 0) { // 用户名和密码正确
                bw.write("登录成功");
            } else if(status == 1){ // 用户名正确，密码错误
                bw.write("密码错误");
            } else { // 用户名不存在，使用用户名和密码注册一个账号
                if(register(content)){
                    bw.write("注册成功");
                } else {
                    bw.write("注册失败");
                }
            }
            // 关闭流
            bw.close();
            br.close();
            // 关闭socket对象
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册用户方法
     */
    public boolean register(String content){ // zhangsan=123456
        // 声明一个字符输出缓冲流对象
        BufferedWriter bw = null;
        try {
            // 创建字符缓冲输出流并关联目标文件，追加形式
            bw = new BufferedWriter(new FileWriter("user.txt",true));
            // 将用户名和密码输出到目标文件中
            bw.write(content);
            // 换行
            bw.newLine();
            // 返回true表示注册成功
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            // 有异常，则返回false，表示注册失败。
            return false;
        } finally {
            try {
                if(bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     *  登录方法：判断用户名和密码是否存在，存在则登录成功，否则登录失败
     */
    public int login(String content) throws IOException{ //zhangsan=123456
        // 根据目标文件名创建文件对象
        File file = new File("user.txt");
        // 判断文件是否存在，如果不存在，则创建
        if(!file.exists()) {
            // 创建目标文件
            file.createNewFile();
            // 用户名不存在
            return 2;
        }
        // 使用=号切割字符串content
        String[] strArr = content.split("=");
        // 创建字符串输入缓冲流对象
        BufferedReader br = new BufferedReader(new FileReader(file));
        // 定义字符串用来接收读取到每一行内容:用户名=密码
        String line = null;
        // 循环读取文件内容
        while((line = br.readLine())!= null) {  // zhangsan=123
            // 使用=号分割字符串
            String[] strs = line.split("=");
            // 判断用户名是否相同
            if(strs[0].equals(strArr[0])){
                // 关闭流
                br.close();
                // 判断密码是否相同
                if(strs[1].equals(strArr[1])) {
                    // 密码正确
                    return 0;
                } else {
                    // 密码不正确
                    return 1;
                }
            }
        }
        // 来到这里说明用户名不存在
        br.close();
        return 2;
    }
}
