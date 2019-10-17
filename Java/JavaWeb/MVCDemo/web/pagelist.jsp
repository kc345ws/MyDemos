<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.17
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>分页显示</title>
</head>
<body>

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

</body>
</html>
