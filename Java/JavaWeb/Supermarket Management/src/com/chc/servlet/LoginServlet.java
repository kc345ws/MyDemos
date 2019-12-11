package com.chc.servlet;

import com.chc.domain.User;
import com.chc.service.impl.UserService;
import com.chc.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String identity = req.getParameter("identity");

        UserService service = new UserService();
        try {
            service.check(Integer.parseInt(id),pwd,Integer.parseInt(identity));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //User user = new User(id,name,identity);
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtil.FindCookie(cookies, "logincookie");

        if(cookie!=null){
            //不是第一次访问


            /*String ids = cookie.getValue();
            //增加现在浏览的商品序号
            cookie.setValue(id+"#"+ids);
            cookie.setMaxAge(60*60*24*7);
            //访问这个工程时，才带cookie过来
            cookie.setPath("/CookieDemo");
            resp.addCookie(cookie);*/
        }else{
            //第一次访问
            cookie = new Cookie("logincookie",id);
            cookie.setValue(id+"#"+identity);
            cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
        }

        //跳转页面
        //resp.sendRedirect("MyWeb/product_info.htm");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
