package com.itheima.pay.controller;

import com.itheima.pay.client.FeignOrderClient;
import com.itheima.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PayController {

    @Resource
    private FeignOrderClient orderService;
    @Autowired
    private PayService payService;

    @RequestMapping(value = "/pay/updateOrder", method = RequestMethod.POST)
    public String payOrder(@RequestParam("payid") int id, @RequestParam("ispay") int ispay) {
        //标识
        Integer payStatus = 0;

        payStatus = payService.updatePayTable(id, ispay);
        return payStatus == 0 ? "更新失败" : "更新成功";
    }

}
