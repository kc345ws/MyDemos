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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //1.获取客户端发送的数据
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String telnum = req.getParameter("telnum");
        String birthday = req.getParameter("birthday");

        String hobby = "";
        String[] hobbies = req.getParameterValues("hobby");
        for (var item :hobbies){
            hobby += item +" ";
        }

        String info = req.getParameter("info");



        //2.添加数据
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student(name,sex,telnum,date,hobby,info);
        StudentService studentService = new StudentServiceImpl();
        boolean Isinsert = false;
        try {
            Isinsert = studentService.insert(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //3.页面跳转
        if(Isinsert){
            req.getRequestDispatcher("ShowStudentServlet").forward(req,resp);
        }
        else{
            resp.getWriter().write("添加失败");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
