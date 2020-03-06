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
import java.util.List;

public class ShowStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();

        try {
            //最后必须有捕获异常的类
            List<Student> studentList = studentService.getall();

            //在域中存入数据
            req.setAttribute("list",studentList);


            //跳转页面
            req.getRequestDispatcher("list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
