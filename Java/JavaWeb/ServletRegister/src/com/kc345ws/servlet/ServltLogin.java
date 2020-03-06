package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServltLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username="+username+" password="+password);

        //向客户端输出内容
        PrintWriter respWriter = resp.getWriter();
        if(username.equals("admin") && password.equals("123")){
            System.out.println("登陆成功");

            //成功的次数累加
            //获取以前的值
            Object obj = getServletContext().getAttribute("count");
            int totalCount = 0;
            if(obj!=null){
                //如果不是第一次访问
                totalCount = (int)getServletContext().getAttribute("count");
            }
            //通过设置属性值保存登陆次数
            getServletContext().setAttribute("count",++totalCount);
            System.out.println("成功登陆的次数:"+totalCount);

            //设置状态码 重新定位状态码
            resp.setStatus(302);
            //设置跳转到哪一个页面
            resp.setHeader("Location","login_success.html");
        }else{
            System.out.println("登陆失败");
            respWriter.println("login failed");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
