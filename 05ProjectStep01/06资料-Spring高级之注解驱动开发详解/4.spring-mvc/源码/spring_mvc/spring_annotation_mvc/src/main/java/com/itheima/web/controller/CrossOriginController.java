package com.itheima.web.controller;

import com.itheima.domain.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域访问的讲解：
 * 何为跨域：
 *   当一个域名请求另一个域名的资源时，即是跨域
 *   协议，主机，端口任何一个不同即为跨域
 * 如何模拟域名：
 *    C:/Windows/System32/drivers/ect/hosts（文件）
 *    修改此文件，建立Ip和域名的对应关系
 * 如何刷新域名不重启计算机
 *      cmd命令行输入：
 *          ipconfig /displaydns
 *          ipconfig /flushdns
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
public class CrossOriginController {

    /**
     * 跨域访问的方法
     * @param user
     * @return
     */
    @RequestMapping("/useCrossOrigin")
    @ResponseBody
//    @CrossOrigin
    public String useCrossOrigin(@RequestBody(required = false) User user){
        System.out.println("user is "+user);
        return "success";
    }


    @RequestMapping("/getImage")
    public void getImage(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //1.获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        //2.获取图片的磁盘绝对路径
        String path = servletContext.getRealPath("/images/6.jpg");
        //3.获取spring提供的文件系统资源对象
        Resource resource = new FileSystemResource(path);
        //4.使用spring的工具类把resource中的文件转换成一个字节数组
        byte[] images = FileCopyUtils.copyToByteArray(resource.getFile());
        //5.使用response设置响应消息头
        response.setContentType("application/octet-stream");
        //6.输出字节数组
        response.getOutputStream().write(images,0,images.length);
    }

    @RequestMapping("/getCss")
    public void getCss(HttpServletRequest request, HttpServletResponse response)throws Exception{
        //1.获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        //2.获取图片的磁盘绝对路径
        String path = servletContext.getRealPath("/css/demo.css");
        //3.获取spring提供的文件系统资源对象
        Resource resource = new FileSystemResource(path);
        //4.使用spring的工具类把resource中的文件转换成一个字节数组
        byte[] images = FileCopyUtils.copyToByteArray(resource.getFile());
        //5.使用response设置响应消息头
        response.setContentType("text/css");
        //6.输出字节数组
        response.getOutputStream().write(images,0,images.length);
    }
}
