package cn.itcast.ej;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MyJobTest
 *
 * @author lee.siu.wah
 * @version 1.0
 * <p>File Created at 2018-05-20<p>
 */
public class MyJobTest {
    public static void main(String[] args){
       new ClassPathXmlApplicationContext("applicationContext-elasticjob.xml");
    }
}
