package com.kc345ws.servlet;

import com.kc345ws.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtil.FindCookie(cookies, "history");
        if(cookie!=null){
            //不是第一次访问


            String ids = cookie.getValue();
            //增加现在浏览的商品序号
            cookie.setValue(id+"#"+ids);
            cookie.setMaxAge(60*60*24*7);
            //访问这个工程时，才带cookie过来
            cookie.setPath("/CookieDemo");
            resp.addCookie(cookie);
        }else{
            //第一次访问
            cookie = new Cookie("history",id);
            cookie.setMaxAge(60*60*24*7);
            cookie.setPath("/CookieDemo");
            resp.addCookie(cookie);
        }

        //跳转页面
        resp.sendRedirect("MyWeb/product_info.htm");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
