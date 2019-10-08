package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST设置请求体解码方式
        //GET通过地址栏获取
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String adress = req.getParameter("password");
        System.out.println("username="+username+" adress="+adress);
        //GET请求被编码了，所以乱码
        //使用ISO-8859-1解码

        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        //System.out.println(username);
        //String adressencode = new String(adress.getBytes("ISO-8859-1"),"UTF-8");
        //System.out.println(adressencode);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
