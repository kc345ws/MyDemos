package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//请求转发和重定向
public class RequestRedirectionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //resp.setHeader("Content-Type","text/html;charset=UTF-8");

        if(req.getParameter("username").equals("admin")
        &&req.getParameter("password").equals("123")){
            System.out.println("登陆成功");

            //重定向跳转页面:重定向方向
            //resp.sendRedirect("login_success.html");

            //请求转发:参数为跳转的位置
            req.getRequestDispatcher("login_success.html").forward(req,resp);
        }else{
            resp.getWriter().write("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
