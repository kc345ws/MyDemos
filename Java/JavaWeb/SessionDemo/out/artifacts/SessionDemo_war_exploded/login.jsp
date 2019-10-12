<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.9
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>请输入内容登陆</h2>
    <!--不是类的名字，而是web.xml的虚拟地址映射-->
    <form action="LoginServlet" method="get">
        帐号:<input type="text" name="username">
        密码:<input type="password" name="password">
        <input type="submit">
    </form>
</body>
</html>
