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

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String sex = req.getParameter("sex");

        StudentService studentService = new StudentServiceImpl();
        List<Student> students = null;
        try {
            students = studentService.search(name, sex);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("list",students);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
