package com.itheima.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class ProviderController {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderController.class);

    @GetMapping("/service")
    public String service(){
        LOG.info("provider invoke");
        return "provider invoke";
    }

}
