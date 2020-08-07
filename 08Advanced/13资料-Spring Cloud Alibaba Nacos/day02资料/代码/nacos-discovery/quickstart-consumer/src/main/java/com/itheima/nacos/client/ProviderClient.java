package com.itheima.nacos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator.
 */
@FeignClient(value = "quickstart-provider")
public interface ProviderClient {

    @GetMapping("/service")
    public String service();
}
