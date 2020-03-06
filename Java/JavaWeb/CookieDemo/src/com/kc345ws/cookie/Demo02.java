package com.kc345ws.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("name","zhangsan");
        Cookie cookie2 = new Cookie("adress","beijing");

        //2.cookie有效期 默认关闭浏览器后消失
//        -1关闭浏览器失效 负数表示不会被持久化存储 正数表示多少秒后失效
        cookie.setMaxAge(60 * 60 * 24 * 7);

        resp.addCookie(cookie);
        resp.addCookie(cookie2);
        Cookie[] cookies = req.getCookies();
        if(cookies !=null){
            for (var item : cookies){
                String name = item.getName();
                String value = item.getValue();
                System.out.println("cookiename="+name+"cookievalue="+value);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
