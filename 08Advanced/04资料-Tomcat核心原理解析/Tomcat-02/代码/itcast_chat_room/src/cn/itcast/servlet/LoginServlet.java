package cn.itcast.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String PASSWORD = "123456";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        //1. 接收页面传递的参数 , 用户名/密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map resultMap = new HashMap();
        //2. 判定用户名密码是否正确
        //3. 如果正确, 响应登录成功的信息
        if(PASSWORD.equals(password)){
            resultMap.put("success",true);
            resultMap.put("message","登录成功");

            req.getSession().setAttribute("username",username);
        }else{//4. 如果不正确, 响应登录失败的信息
            resultMap.put("success",false);
            resultMap.put("message","用户名或密码错误");
        }

        //5. 响应数据
        resp.getWriter().write(JSON.toJSONString(resultMap));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
