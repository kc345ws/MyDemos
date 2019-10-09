package com.kc345ws.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //cookie的简单使用
        //服务器发送给客户端，并且保存在客户端的小数据


        /*
        * 创建对象的几种手法
        * 1.直接new
        * 2.单例模式 | 提供静态方法
        * 3.工厂模式 stu
        * StuFactory StuBuilder
        *
        *
        * */

        //发送cookie
        Cookie cookie = new Cookie("aa","bb");
        resp.addCookie(cookie);
        resp.getWriter().write("请求成功");

        //获取cookie
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for(var item : cookies){
                String itemName = item.getName();
                String itemValue = item.getValue();
                System.out.println("cookieName="+itemName+" cookieValue="+itemValue);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
