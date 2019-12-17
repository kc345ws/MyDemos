package com.supermarket.chc.supermarket.controller;

import com.supermarket.chc.supermarket.biz.UsersBiz;
import com.supermarket.chc.supermarket.biz.impl.UsersBizImpl;
import com.supermarket.chc.supermarket.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Controller继承了javax.servlet.http.HttpServlet类
 * 它的doGet和doPost方法都调用process方法，这是Servlet控制器的核心
 * 
 * @author cxp
 * @date 2016-11-05
 * 
 */

public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1579L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		process(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		process(request, response);

	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		/*
		 * // 处理中文乱码，一定要写在获得PrintWriter前
		 * response.setHeader("content-type","text/html;charset=UTF-8");
		 * response.setCharacterEncoding("UTF-8"); PrintWriter
		 * out=response.getWriter();
		 */
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		/**
		 * 完整的uri应该是：/app/product_input 但事件中有默认的应用程序名，所以应用名可以为空:/product_input
		 */

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		HttpSession session = request.getSession();
		// ///////////////////执行动作/////////////////////////////
		if (action.equals("login.do")) {
			//登陆
			// 获得请求参数
			String name = request.getParameter("username");
			String pwd = request.getParameter("password");
			
			if (session.getAttribute("name") != null
					&& session.getAttribute("name").equals(name)) {
				response.sendRedirect("security/welcome.jsp");
			} else {
				UsersBiz userBiz = new UsersBizImpl();
				Users user = new Users(name, pwd);

				Users myuser = userBiz.findByAcc(name);

				int count = userBiz.login(user);
				if (count > 0) {
					// 设置会话属性
					session.setAttribute("name", name);
					session.setAttribute("pwd", pwd);
					session.setAttribute("utype",myuser.getUtype());//设置账户类型
					session.setMaxInactiveInterval(60*60*24*7);// 设置会话过期时长为7天
					// 不写斜杠表示相对路径
					response.sendRedirect("security/welcome.jsp");
				} else {
					request.setAttribute("errmsg", "用户名或密码错误");
					// 返回登录页
					request.getRequestDispatcher("login.jsp").forward(request,
							response);

				}
			}
		} else if (action.equals("modifyPassword.do")) {
			// 从session获得用户名
			 session = request.getSession();
			String name = (String) session.getAttribute("name");
			// 获得表单请求参数
			String pwd = request.getParameter("oldPassword");
			String newPwd = request.getParameter("newPassword");
			// 根据用户名密码查找用户
			UsersBiz userImpl = new UsersBizImpl();
			Users user = new Users(name, pwd);
			int count = userImpl.modifypwd(user, newPwd);
			if (count > 0) {
				//覆盖掉原来保存在session的密码
				session.setAttribute("pwd", newPwd);
				response.sendRedirect("security/welcome.jsp");
			}
		} else if (action.equals("loginOut.do")) {
		    //设置会话失效
		      session.invalidate();
		      //重定向到登录界面
		      response.sendRedirect("login.html");
		} else if (action.equals("Users.do")) {
			int utype = (int)session.getAttribute("utype");
			if(printWaring("用户管理",request,response,session)){
				//
			}
			//System.out.println("转发给UsersServlet进行处理");
			// 转发给UsersServlet进行处理
			else if(utype == 2){
				//经理
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("UTF-8");

				PrintWriter out = response.getWriter();
				out.print("<script>alert('经理没有权限访问用户管理'); window.location='security/welcome.jsp' </script>");
				out.flush();
				out.close();

			}
			else {
				request.getRequestDispatcher("/servlet/UsersServlet").forward(
						request, response);
			}
		} else if (action.equals("Goods.do")) {
			if(printWaring("商品管理",request,response,session)){
				//
			}
			// 转发给GoodsServlet进行处理
			else{
				request.getRequestDispatcher("/servlet/GoodsServlet").forward(
						request, response);
			}

		} else if (action.equals("Suppliers.do")) {
			if(printWaring("供货商管理",request,response,session)){
				//
			}
			// 转发给SuppliersServlet进行处理
			else {
				request.getRequestDispatcher("/servlet/SuppliersServlet").forward(
						request, response);
			}
		} else if (action.equals("Orders.do")) {
			request.getRequestDispatcher("/servlet/OrdersServlet").forward(
						request, response);
		}
	}

	private boolean printWaring(String waring,HttpServletRequest request,
							 HttpServletResponse response,HttpSession session) throws IOException {
		int utype = (int)session.getAttribute("utype");
		if(utype == 3){
			//普通用户
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			out.print("<script>alert('普通用户没有权限访问"+waring+"'); window.location='security/welcome.jsp' </script>");
			out.flush();
			out.close();
			//request.getRequestDispatcher("security/welcome.jsp").forward(
			//request, response);
			return true;
		}
		return false;
	}
}
