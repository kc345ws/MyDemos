# MVC设计模式
## JSP开发模式

1. JavaBean + JSP

![imag](https://github.com/kc345ws/MyDemos/blob/master/Sources/Imgs/MarkDown/Java/004JavaWeb/007MVC%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/img01.png?raw=true)

2. Servlet + JavaBean + JSP

![imag](https://github.com/kc345ws/MyDemos/blob/master/Sources/Imgs/MarkDown/Java/004JavaWeb/007MVC%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/img02.png?raw=true)

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
    
![](https://raw.githubusercontent.com/kc345ws/MyDemos/master/imgs/20191014210459.png)

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

    





