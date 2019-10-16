package com.kc345ws.servlet;

import com.kc345ws.domain.Student;
import com.kc345ws.service.StudentService;
import com.kc345ws.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//更新信息
public class UpdateStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");


        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String telnum = req.getParameter("telnum");

        String birthday = req.getParameter("birthday");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] hobies = req.getParameterValues("hobby");
        String hoby = "";
        for(var item : hobies){
            hoby += item+" ";
        }



        String info = req.getParameter("info");

        //1.封装数据
        Student student = new Student(id,name,sex,telnum,date,hoby,info);

        //2.业务逻辑修改
        StudentService studentService = new StudentServiceImpl();
        boolean flag = false;
        try {
            flag = studentService.update(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(flag){
            //3.请求转发跳转页面
            req.getRequestDispatcher("ShowStudentServlet").forward(req,resp);
        }else{
            resp.getWriter().write("修改失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
