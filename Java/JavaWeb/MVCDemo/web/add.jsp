<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.15
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息页面</title>
</head>
<body>

<h2>添加信息</h2>


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

</body>
</html>
