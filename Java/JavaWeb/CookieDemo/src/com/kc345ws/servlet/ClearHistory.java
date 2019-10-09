package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearHistory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //清除cookie

        Cookie cookie = new Cookie("history", "");
        cookie.setMaxAge(0);
        cookie.setPath("/CookieDemo");
        resp.addCookie(cookie);

        resp.sendRedirect("MyWeb/product_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
