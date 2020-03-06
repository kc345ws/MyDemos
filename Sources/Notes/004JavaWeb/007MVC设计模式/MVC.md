# MVC设计模式
## JSP开发模式

1. JavaBean + JSP

![imag](https://github.com/com.kc345ws/MyDemos/blob/master/Sources/Imgs/MarkDown/Java/004JavaWeb/007MVC%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/img01.png?raw=true)

2. Servlet + JavaBean + JSP

![imag](https://github.com/com.kc345ws/MyDemos/blob/master/Sources/Imgs/MarkDown/Java/004JavaWeb/007MVC%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/img02.png?raw=true)

## 学生信息管理系统

    数据库
    CREATE TABLE t_stu(
    	id INT PRIMARY KEY AUTO_INCREMENT,
    	NAME VARCHAR(20),
    	sex VARCHAR(5),
    	telnum INT,
    	birthday DATE,
    	hoby VARCHAR(50),
    	info VARCHAR(200)
    )
    
![](https://raw.githubusercontent.com/com.kc345ws/MyDemos/master/imgs/20191014210459.png)

### 查询
    
    ------------------Servlet------------------
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
    
    --------------JSP---------------------
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
    
        <script type="text/javascript">
    
            function doDelete(id) {
                var flag = window.confirm("是否删除?");
                if(flag){
                    //如果确定删除
                    window.location.href("DeleteStudentServlet?id="+id);
                }
            }
    
        </script>
    
        <title>信息列表</title>
    </head>
    <body>
    
    <table border="1px solid">
        <tr>
            <td colspan="8">
                <a href="add.jsp">添加</a>
            </td>
        </tr>
    
    
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>性别</td>
            <td>手机</td>
            <td>生日</td>
            <td>爱好</td>
            <td>介绍</td>
            <td>操作</td>
        </tr>
    
        <jstl:forEach items="${list}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.sex}</td>
                <td>${stu.telnum}</td>
                <td>${stu.birthday}</td>
                <td>${stu.hoby}</td>
                <td>${stu.info}</td>
                <td><a href="#">修改</a><a href="#" onclick="doDelete(${stu.id})"> 删除</a></td>
            </tr>
        </jstl:forEach>
    
    </table>
    
    </body>
    </html>
    

### 添加

    ------------------Servlet------------------
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
    
    ------------JSP---------------------
    <form action="AddStudentServlet" method="post">
    <table border="1px solid">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td>手机号</td>
            <td>
                <input type="tel" name="telnum">
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="date" name="birthday">
            </td>
        </tr>
        <tr>
            <td>兴趣</td>
            <td>
                <input type="checkbox" name="hobby" value="LOL">LOL
                <input type="checkbox" name="hobby" value="Dota2">Dota2
                <input type="checkbox" name="hobby" value="300英雄">300英雄
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea name="info" rows="30" cols="100"></textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="添加">
            </td>
        </tr>

    </table>
    </form>
    

### 删除

    -------------Servlet-----------------
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        //System.out.println(id);
        StudentService studentService = new StudentServiceImpl();
        boolean flag = false;
        try {
            flag = studentService.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(flag){
            req.getRequestDispatcher("ShowStudentServlet").forward(req,resp);
        }else{
            resp.getWriter().write("删除失败");
        }
    }
    
   
### 修改

    --------------------Servlet---------
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
    
    
    -------JSP-----------------
    <form action="UpdateStudentServlet?id=${student.id}" method="post">
    <table border="1px solid">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${student.name}"></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男" <c:if test="${student.sex == '男'}">checked</c:if>>男
                <input type="radio" name="sex" value="女" <c:if test="${student.sex == '女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>手机号</td>
            <td>
                <input type="tel" name="telnum" value="${student.telnum}">
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td>
                <input type="date" name="birthday" value="${student.birthday}">
            </td>
        </tr>
        <tr>
            <td>兴趣</td>
            <td>
                <input type="checkbox" name="hobby" value="LOL" <c:if test="${fn:contains(student.hoby,'LOL' )}">checked</c:if> >LOL
                <input type="checkbox" name="hobby" value="Dota2" <c:if test="${fn:contains(student.hoby,'Dota2' )}">checked</c:if>>Dota2
                <input type="checkbox" name="hobby" value="300英雄" <c:if test="${fn:contains(student.hoby,'300英雄' )}">checked</c:if>>300英雄
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea name="info" rows="30" cols="100">${student.info}</textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="修改">
            </td>
        </tr>

    </table>
    </form>
    

### 模糊查询
    
    <div align="center">模糊查询</div>
            <div align="center">
                <form action="SearchStudentServlet" method="post">
                姓名:<input type="text" name="name">
                &nbsp;&nbsp;&nbsp;

                    性别:<select name="sex">
                    <option value="">全部</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                <input type="submit" value="查询">
                </form>
                &nbsp;&nbsp;&nbsp;
                <a href="add.jsp">添加</a>

            </div>
            
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
    
    public List<Student> search(String name, String sex) throws SQLException {
        Connection connection = JDBCUtil02.getConn();
        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

        List<String> paramters = new ArrayList<>();


        String sql = "select * from t_stu";


        if(!StringUtil.isEmpty(name)){
            //姓名不空
            sql += " where name like ?";
            paramters.add("%"+name+"%");
        }

        if(!StringUtil.isEmpty(sex) && !StringUtil.isEmpty(name)) {
            //如果性别不空且姓名不空
            sql += " and sex = ?";
            paramters.add(sex);
        }else if(!StringUtil.isEmpty(sex) && StringUtil.isEmpty(name))
        {
            //如果性别不空且姓名为空
            sql += " where sex = ?";
            paramters.add(sex);
        }

        List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class), paramters.toArray());

        return students;
    }


### 分页
* 物理分页
    >数据库只查一页，
    内存中的数据不会太大，对数据库操作频繁
* 逻辑分页
    >存在内存中，速度快，内存可能溢出

		<table border="1px solid">
		<tr>
			<td colspan="8">

				<div align="center">模糊查询</div>
				<div align="center">
					<form action="SearchStudentServlet" method="post">
						姓名:<input type="text" name="name">
						&nbsp;&nbsp;&nbsp;

						性别:<select name="sex">
						<option value="">全部</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
						<input type="submit" value="查询">
					</form>
					&nbsp;&nbsp;&nbsp;
					<a href="add.jsp">添加</a>

				</div>

			</td>
		</tr>


		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>性别</td>
			<td>手机</td>
			<td>生日</td>
			<td>爱好</td>
			<td>介绍</td>
			<td>操作</td>
		</tr>

		<jstl:forEach items="${page.students}" var="stu">
			<tr>
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.sex}</td>
				<td>${stu.telnum}</td>
				<td>${stu.birthday}</td>
				<td>${stu.hoby}</td>
				<td>${stu.info}</td>
				<td><a href="EditStudentServlet?id=${stu.id}">修改</a><a href="" onclick="doDelete(${stu.id})"> 删除</a></td>
			</tr>
		</jstl:forEach>

		<tr>
			<td colspan="8">
				第${page.currentPage}/${page.totalPage}页
				&nbsp;&nbsp;&nbsp;
				每页显示${page.dataCount}条
				&nbsp;&nbsp;&nbsp;
				总记录数${page.totalData}条
				&nbsp;&nbsp;&nbsp;
				<a href="ShowPageStudentServlet?currentPage=1">[首页]</a>
				&nbsp;&nbsp;&nbsp;
				<jstl:if test="${page.currentPage != 1}">
					<a href="ShowPageStudentServlet?currentPage=${page.currentPage - 1}">|上一页</a>
				</jstl:if>
				&nbsp;&nbsp;&nbsp;

				<jstl:forEach begin="1" end="${page.totalPage}" var="i">
					<jstl:if test="${page.currentPage == i}">
						${i}
					</jstl:if>
					<jstl:if test="${page.currentPage != i}">
						<a href="ShowPageStudentServlet?currentPage=${i}">${i}</a>
					</jstl:if>
					&nbsp;
				</jstl:forEach>
				&nbsp;&nbsp;&nbsp;
				<jstl:if test="${page.currentPage != page.totalPage}">
					<a href="ShowPageStudentServlet?currentPage=${page.currentPage + 1}">下一页|</a>
				</jstl:if>
				&nbsp;&nbsp;&nbsp;
				<a href="ShowPageStudentServlet?currentPage=${page.totalPage}">[尾页]</a>
			</td>
		</tr>

		</table>
    
		-----------------Servlet-----------
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
    
		----------------Bean----------------
		public class PageBean {
		private List<Student> students;//数据
		private int currentPage;//当前页数
		private int totalPage;//总页数
		private int dataCount;//每页数据数量
		private int totalData;//总数据数

		public  PageBean(){}
		public PageBean(List<Student> students,int currentPage,int totalPage,int dataCount,int totalData){
			this.students = students;
			this.currentPage =currentPage;
			this.totalPage = totalPage;
			this.dataCount = dataCount;
			this.totalData = totalData;
		}
    
		----------------DAO-----------------
		@Override
		public List<Student> getByPage(int currentPage) throws SQLException {
			Connection connection = JDBCUtil02.getConn();
			QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

			//limit a offset b = b , a
			List<Student> students = queryRunner.query("select * from t_stu limit ? offset ?", new BeanListHandler<Student>(Student.class), PAGE_SIZE, (currentPage - 1) * 5);

			return students;
		}

		@Override
		public int getCount() throws SQLException {
			//SELECT COUNT(*) FROM t_stu;
			Connection connection = JDBCUtil02.getConn();
			QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getComboPooledDataSource());

			Long query = (Long) queryRunner.query("select count(*) from t_stu", new ScalarHandler());
			return query.intValue();
		}



    

    





