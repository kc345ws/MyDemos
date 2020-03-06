<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.10
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
    pageContext.setAttribute("name","pagecontent");
    request.setAttribute("name","request");
    session.setAttribute("name","session");
    application.setAttribute("name","application");
    %>

    <div>普通方法取值</div>
    <%=pageContext.getAttribute("name")%>
    <%=request.getAttribute("name")%>
    <%=session.getAttribute("name")%>
    <%=application.getAttribute("name")%>

    <div>EL取值</div>
    ${pageScope.get("name")}
    ${requestScope.get("name")}
    ${sessionScope.get("name")}
    ${applicationScope.get("name")};
</body>
</html>
