package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.取出请求中的所有头
        Enumeration<String> reqHeaders = req.getHeaderNames();
        while(reqHeaders.hasMoreElements()){
            String name = reqHeaders.nextElement();
            String value = req.getHeader(name);
            System.out.println(name+"="+value);
        }

        System.out.println("---------------------");
        //2.获取客户端提交上来的数据
        String name = req.getParameter("name");
        String adress = req.getParameter("adress");
        System.out.println("name="+name);
        System.out.println("adress="+adress);
        System.out.println("----------------------");
        //3.获取所有数据
        Map<String, String[]> reqParameterMap = req.getParameterMap();
        Set<String> keySet = reqParameterMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            String[] value = reqParameterMap.get(key);
            System.out.println("key="+key+" value="+value[0]);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
