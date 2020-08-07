package com.itheima.web.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * PathVariable注解的讲解
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
@Controller
@ResponseBody
@RequestMapping("/user")
public class PathVariableController {

    /**
     * 保存方法
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody User user){
        System.out.println("user is "+user);
        return "success";
    }

    /**
     * 更新方法
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public String update(@PathVariable Integer id, User user){
        //1.给user的id赋值
        user.setId(id);
        //2.输出
        System.out.println("user is "+user);
        return "success";
    }

    /**
     * 删除方法
     * @param id
     * @return
     */
    @RequestMapping(method  = RequestMethod.DELETE,value = "/{userId}")
    public String delete(@PathVariable("userId") Integer id){
        System.out.println("删除用户的Id是："+id);
        return "success";
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public String findById(Integer id){
        System.out.println("查询用户的Id是："+id);
        return "success";
    }
}
