package com.kc345ws.servlet;

import com.kc345ws.domain.PageBean;
import com.kc345ws.service.StudentService;
import com.kc345ws.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//分页显示
public class ShowPageStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int currentPage = Integer.parseInt(req.getParameter("currentPage"));


        StudentService studentService = new StudentServiceImpl();
        PageBean page =null;
        try {
            page = studentService.getByPage(currentPage);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("page",page);

        req.getRequestDispatcher("pagelist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
