package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfig extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
//        可以获取配置信息
        javax.servlet.ServletConfig config = getServletConfig();

        //得到的值xml中配置的名字
        String servletName = config.getServletName();
        System.out.println("servletname:"+servletName);

        System.out.println("adress:"+getInitParameter("adress"));

        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String str = initParameterNames.nextElement();
            String value = config.getInitParameter(str);
            System.out.println(str+":"+value);
        }
    }
}
