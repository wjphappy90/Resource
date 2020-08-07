package com.itcast.skywalking_alarm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlarmController {

    //每次调用睡眠1.5秒，模拟超时的报警
    @GetMapping("/timeout")
    public String timeout(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "timeout";
    }
}
