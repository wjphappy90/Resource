package com.itheima.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//自定义异常返回页面
@Component
public class ExceptionHandlerPage implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");

        ResponseData responseData = null;
        //BlockException  异常接口,包含Sentinel的五个异常
        //  FlowException  限流异常
        //  DegradeException  降级异常
        //  ParamFlowException  参数限流异常
        //  AuthorityException  授权异常
        //  SystemBlockException  系统负载异常
        if (e instanceof FlowException) {
            responseData = new ResponseData(-1, "接口被限流了...");
        } else if (e instanceof DegradeException) {
            responseData = new ResponseData(-2, "接口被降级了...");
        }
        response.getWriter().write(JSON.toJSONString(responseData));
    }
}

@Data
@AllArgsConstructor//全参构造
@NoArgsConstructor
//无参构造
class ResponseData {
    private int code;
    private String message;
}
