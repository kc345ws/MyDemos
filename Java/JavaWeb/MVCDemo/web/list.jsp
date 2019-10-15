<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.14
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>

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
            <td><a href="EditStudentServlet?id=${stu.id}">修改</a><a href="" onclick="doDelete(${stu.id})"> 删除</a></td>
        </tr>
    </jstl:forEach>

</table>

</body>
</html>
