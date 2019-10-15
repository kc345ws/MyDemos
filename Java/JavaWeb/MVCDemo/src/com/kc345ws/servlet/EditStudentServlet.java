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

public class EditStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        StudentService studentService = new StudentServiceImpl();
        Student student = null;
        try {
            student = studentService.findByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(student != null){
            req.setAttribute("student",student);
            req.getRequestDispatcher("edit.jsp").forward(req,resp);
        }
        else{
            resp.getWriter().write("没有此人");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
