<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.10
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div>
        <form action="LoginServlet" method="post">
        <div><h3>账户:</h3><input type="text" name="username"></div>
        <div><h3>密码:</h3><input type="password" name="password"></div>
            <div><input type="submit"></div>
        </form>
    </div>
</body>
</html>
