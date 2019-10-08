package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //字符流
//        resp.getWriter().write("<h1>hello</h1>");
//
//        //以字节流方式：文件
//        resp.getOutputStream().write("<h1>hello</h1>".getBytes());
//
//        //设置状态码
//        resp.setStatus(302);
//        //设置头
//        resp.setHeader("as","sd");
//
//        //设置响应内容编码
//        resp.setContentType("UTF-8");

        //1.用UTF8编码
         resp.setCharacterEncoding("UTF-8");
         //2.规定浏览器用UTF-8解析
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
         resp.getWriter().write("阿斯顿马丁");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

