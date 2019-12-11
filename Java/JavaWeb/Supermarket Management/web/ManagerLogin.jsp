<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.12.10
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h2>管理者登录</h2>
    <form action="LoginServlet" method="get">
        <span>账号：</span><input type="number" name="id">
        <br><br>
        <span>密码：</span><input type="text" name="pwd">
        <input type="hidden" name="identity" value="1">
        <br><br>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
