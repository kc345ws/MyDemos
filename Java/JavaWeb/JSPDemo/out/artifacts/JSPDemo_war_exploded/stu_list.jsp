<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.10
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息管理系统</title>
</head>
<body>
    <h2>信息列表</h2>
    <table border="1px solid" WIDTH="700px">
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>住址</td>
        </tr>

        <%--循环遍历--%>
        <jstl:forEach items="${list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.adress}</td>
            </tr>
        </jstl:forEach>
    </table>
</body>
</html>
