package com.kc345ws.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownLoadDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取文件名
        String filename = req.getParameter("filename");

        //1.1解决中文乱码
        //filename = new String(filename.getBytes("ISO-8859-1"),"UTF-8");


        System.out.println(filename);

        //2.读取文件,通过servletcontext获取文件真实位置
        String realPath = getServletContext().getRealPath("Download/" + filename);
        InputStream inputStream = new FileInputStream(realPath);

        //3.设置响应头
        //让浏览器收到响应时，让浏览器以下载方式提醒客户，而不是直接显示
        //中文乱码
        String ClientType = req.getHeader("User-Agent");
        System.out.println(ClientType);
        if(ClientType.contains("Firefox")){
            //如果是火狐浏览器使用Base64解码
        }else{
            //Edge IE 谷歌使用UTF-8
            filename = URLEncoder.encode(filename,"UTF-8");
        }
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        
        //4.以字节流形式传输文件
        int read = -1;
        byte[] bytes = new byte[1024];
        while((read = inputStream.read(bytes)) !=-1){
            //如果不是-1则没有读到文件尾部
            resp.getOutputStream().write(bytes);
        }

        //5.关闭输入输出流
        inputStream.close();
        resp.getOutputStream().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
