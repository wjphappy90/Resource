package com.itheima.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Slf4j
public class OrderController2 {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    //下单
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);

        //调用商品微服务,查询商品信息
        Product product = productService.findByPid(pid);

        //模拟调用商品微服务需要2s的时间
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));

        //下单(创建订单)
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        //为了不产生大量的额垃圾数据,暂时不保存订单入库
        //orderService.createOrder(order);

        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return order;
    }

    //测试高并发
    @RequestMapping("/order/message")
    public String message() {
        return "测试高并发";
    }
}
