package com.kc345ws.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //1.获取对象
        ServletContext servletContext = getServletContext();

        //Web工程无法使用FileInputStream获取资源
        //相对路径是根据jre确定的
        //Web工程的jre会由Tomcat接管，相对路径是Tmocat的bin目录
//        InputStream inputStream = new FileInputStream("src/config.properties");

        //2.获取绝对路径
//        String rootpath = servletContext.getRealPath("File/config.properties");//根目录
//        System.out.println("根目录绝对路径:"+rootpath);
        //3.转换为流对象
//        InputStream resourceAsStream = servletContext.getResourceAsStream("File/config.properties");
//        Properties properties = new Properties();
//        properties.load(resourceAsStream);
//        System.out.println("name="+properties.getProperty("name"));
        //4.通过classloader获取工程下的资源
        //获取这个Java文件的class，然后获取加载到java虚拟机中的类加载对象
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("../../File/config.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String name = properties.getProperty("name");
        System.out.println("name="+name);

        //properties.load(inputStream);
        //String name = properties.getProperty("name");
        //System.out.println("name="+name);
        resourceAsStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
    }
}
