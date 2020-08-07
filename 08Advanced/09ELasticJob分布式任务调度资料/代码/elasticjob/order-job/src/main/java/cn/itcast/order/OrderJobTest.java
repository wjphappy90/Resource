package cn.itcast.order;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-05-20<p>
 */
public class OrderJobTest {
    public static void main(String[] args){
       new ClassPathXmlApplicationContext("applicationContext*.xml");
    }
}
