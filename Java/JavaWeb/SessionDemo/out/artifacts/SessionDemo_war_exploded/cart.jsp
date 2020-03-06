<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.10
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>购物车商品列表</h2>

    <%
        Map<String,Integer>cartMap = (Map<String, Integer>) request.getSession().getAttribute("cart");
        if(cartMap!=null){
            for(String item : cartMap.keySet()){
                int value = cartMap.get(item);
     %>
            <h2>商品:<%=item  %>数量:<%=value%></h2>
    <%
            }
        }
    %>
</body>
</html>
