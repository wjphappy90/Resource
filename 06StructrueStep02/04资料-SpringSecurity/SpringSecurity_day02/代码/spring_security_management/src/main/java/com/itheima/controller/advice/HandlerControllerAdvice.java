package com.itheima.controller.advice;//package com.itheima.controller.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerControllerAdvice{

    @ExceptionHandler(AccessDeniedException.class)
    public String handlerException(){
        return "redirect:/403.jsp";
    }

    @ExceptionHandler(RuntimeException.class)
    public String runtimeHandlerException(){
        return "redirect:/500.jsp";
    }

}
