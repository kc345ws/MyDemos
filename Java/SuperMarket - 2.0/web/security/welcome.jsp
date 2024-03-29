<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>超市管理系统</title>
<link rel="stylesheet" href="css/public.css" type="text/css"></link>
<link rel="stylesheet" href="css/style.css" type="text/css"></link>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>超市管理系统</h1>

	<div class="publicHeaderR">
		<p>
			<span>你好！</span><span style="color: #fff21b">${sessionScope.name}
			</span> , 欢迎使用！
		</p>
		<a href="loginOut.do">退出</a>
	</div>
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2019年1月1日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用谷歌或Edge浏览器</a> </section>
	<!--主体内容-->
	<section class="publicMian">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
		<nav>
		<ul class="list">
			<li><a href="Orders.do">账单管理</a>
			</li>
			<li><a href="Suppliers.do">供应商管理</a>
			</li>
			<li><a href="Goods.do">商品管理</a>
			</li>
			<li><a href="Users.do">用户管理</a>
			</li>
			<li><a href="security/password.jsp">密码修改</a>
			</li>
			<li><a href="loginOut.do">退出系统</a>
			</li>
		</ul>
		</nav>
	</div>
	<div class="right">
		<img class="wColck" src="img/clock.jpg" alt="" />
		<div class="wFont">
			<h2>${sessionScope.name}</h2>
			<p>
				欢迎来到超市管理系统!
			</p>
			<p>
				你是
				<c:choose>
					<c:when test="${sessionScope.utype==1}">
						管理员,可以进行所有操作
					</c:when>
					<c:when test="${sessionScope.utype==2}">
						经理，可以进行除了用户管理外的其他所有操作
					</c:when>
					<c:when test="${sessionScope.utype==3}">
						普通用户，只能进行常规操作
					</c:when>
				</c:choose>
			</p>
		</div>
	</div>
	</section>
	<footer class="footer"> CopyRight@陈鸿超-55170933 1998-2019 </footer>
	<script src="js/time.js"></script>
</body>
</html>