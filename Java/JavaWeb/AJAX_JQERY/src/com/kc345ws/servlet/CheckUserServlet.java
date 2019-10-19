package com.kc345ws.servlet;

import com.kc345ws.dao.UserDao;
import com.kc345ws.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        final String username = req.getParameter("username");

        UserDao userDao = new UserDaoImpl();

        System.out.println(username);
        boolean flag = false;
        try {
            flag = userDao.checkUserExist(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(flag){
            resp.getWriter().println(1);
        }else{
            resp.getWriter().println(0);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
