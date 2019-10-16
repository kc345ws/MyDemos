<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.15
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>修改信息页面</title>
</head>
<body>

<h2>修改信息</h2>


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

</body>
</html>
