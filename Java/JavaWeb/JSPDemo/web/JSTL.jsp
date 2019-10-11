<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.10
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--声明一个变量存入域种，默认page--%>
   <c:set var="name" value="zhangsan" scope="session"></c:set>
   ${ sessionScope.get("name")}

    <%--<c:forEach></c:forEach>--%>
-------------------------------------<br>
    <c:set var="age" value="18"></c:set>
    <c:if test="${age > 16}">
        年龄大于16...
    </c:if>
</body>
</html>
