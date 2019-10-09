package com.kc345ws.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.module.FindException;
import java.util.Date;

import com.kc345ws.util.CookieUtil;

//回显上次登录时间
public class Demo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        if(req.getParameter("username").equals("admin")
        &&req.getParameter("password").equals("123")){
            Cookie findCookie = CookieUtil.FindCookie(req.getCookies(), "last");
            if(findCookie !=null){
                long lasttime = Long.parseLong(findCookie.getValue());
                resp.getWriter().write("登录成功,上次登录时间:"+ new Date(lasttime));
                //重新设置时间
                findCookie.setValue(System.currentTimeMillis()+"");
                findCookie.setMaxAge(60*60);
                resp.addCookie(findCookie);
            }else{
                resp.getWriter().write("登录成功");
                Cookie cookie = new Cookie("last",System.currentTimeMillis()+"");
                cookie.setMaxAge(60*60);
                resp.addCookie(cookie);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
