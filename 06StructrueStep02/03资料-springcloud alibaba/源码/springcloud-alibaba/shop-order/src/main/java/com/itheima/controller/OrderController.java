package com.itheima.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

//@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    //下单--fegin
    @RequestMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);

        //调用商品微服务,查询商品信息
        Product product = productService.findByPid(pid);

        if (product.getPid() == -100) {
            Order order = new Order();
            order.setOid(-100L);
            order.setPname("下单失败");
            return order;
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

        orderService.createOrder(order);

        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));

        //向mq中投递一个下单成功的消息
        //参数一: 指定topic
        //参数二: 指定消息体
        rocketMQTemplate.convertAndSend("order-topic", order);
        return order;
    }

//    //下单--ribbon负载均衡
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        //问题:
//        // 1 代码可读性不好
//        // 2 编程风格不统一
//        Product product =
//                restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
//
//
//
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }

//    //下单--自定义负载均衡
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        //随机选择
//        int index = new Random().nextInt(instances.size());//0 1 2
//        ServiceInstance instance = instances.get(index);
//
//        Product product =
//                restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
//
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }


//    //下单
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        ServiceInstance instance = instances.get(0);
//
//        Product product =
//                restTemplate.getForObject("http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + pid, Product.class);
//
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }

//    //下单
//    @RequestMapping("/order/prod/{pid}")
//    public Order order(@PathVariable("pid") Integer pid) {
//        log.info("接收到{}号商品的下单请求,接下来调用商品微服务查询此商品信息", pid);
//
//        //调用商品微服务,查询商品信息
//        //问题:
//        //1 一旦服务提供者的地址信息变化了,我们就不得不去修改服务调用者的java代码
//        //2 一旦无法提供者做了集群,服务调用者一方无法实现负载均衡的去调用
//        //3 一旦微服务变得越来越多,如何来管理这个服务清单就成了问题
//        Product product =
//                restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);
//
//        log.info("查询到{}号商品的信息,内容是:{}", pid, JSON.toJSONString(product));
//
//        //下单(创建订单)
//        Order order = new Order();
//        order.setUid(1);
//        order.setUsername("测试用户");
//        order.setPid(pid);
//        order.setPname(product.getPname());
//        order.setPprice(product.getPprice());
//        order.setNumber(1);
//
//        orderService.createOrder(order);
//
//        log.info("创建订单成功,订单信息为{}", JSON.toJSONString(order));
//
//        return order;
//    }
}
