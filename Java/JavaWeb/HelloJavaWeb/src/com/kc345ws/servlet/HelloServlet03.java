package com.kc345ws.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

//演示servlet的生命周期
public class HelloServlet03 implements Servlet {

    //1.在创建Servlet实例时就执行该方法
//    默认是初次访问该servlet初始化
//    只会执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

//   2. 访问一次执行一次
//    可以执行多次，一次访问执行一次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

//    3.销毁执行
//    从tomcat移除托管
//    正常关闭服务器
    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
