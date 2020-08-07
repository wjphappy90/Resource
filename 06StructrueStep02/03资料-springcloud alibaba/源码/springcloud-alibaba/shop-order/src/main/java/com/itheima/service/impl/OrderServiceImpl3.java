package com.itheima.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl3 {

    int i = 0;

    //定义一个资源
    //定义当资源内部发生异常的时候的处理逻辑
    //blockHandler  定义当资源内部发生了BlockException应该进入的方法[捕获的是Sentinel定义的异常]
    //fallback      定义当资源内部发生了Throwable应该进入的方法
    @SentinelResource(
            value = "message",
            blockHandlerClass = OrderServiceImpl3BlockHandler.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderServiceImpl3Fallback.class,
            fallback = "fallback"
    )
    public String message(String name) {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "message";
    }
}
