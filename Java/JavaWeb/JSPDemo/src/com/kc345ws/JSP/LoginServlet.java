package com.kc345ws.JSP;

import com.kc345ws.JSP.dao.impl.StuDaoImpl;
import com.kc345ws.JSP.dao.impl.UserDaoImpl;
import com.kc345ws.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //只解决POST,GET方式使用服务器的编码规则,或通过ISO-8851-1解析为UTF8格式
        req.setCharacterEncoding("UTF-8");
        //设置浏览器的解码规则
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username="+username+" password="+password);

        boolean issuccess = new UserDaoImpl().Login(username, password);

        if(issuccess){
            //resp.getWriter().write("登陆成功");

            //1.获取学生信息
            List<Student> studentList = new StuDaoImpl().FindAll();

            //2.存放信息到域中
            req.getSession().setAttribute("list",studentList);

            //2.重定向
            resp.sendRedirect("stu_list.jsp");
        }else {
            resp.getWriter().write("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
