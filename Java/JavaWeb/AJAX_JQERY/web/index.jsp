<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.18
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

      <script type="text/javascript">
          function ajaxFunction(){
              var xmlHttp;
              try {//FIREFOX
                  xmlHttp = new XMLHttpRequest();
              }catch (e) {
                  try {//IE
                      xmlHttp = new ActiveXObject("MsXml2.XMLHTTP");
                  }catch (e) {
                      xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                  }
              }
              return xmlHttp;
          }

          function get() {
              //1.创建xmlhttprequest对象
              var ajax = ajaxFunction();

              //2.发送请求
            //请求方式 路径 是否异步
              ajax.open("GET","DemoServlet01?name=zhangsan&age=18",true);

              ajax.onreadystatechange =  function() {
                  if(ajax.readyState === 4 && ajax.status === 200){
                    alert(ajax.responseText);
                  }
                  //ajax不会刷新页面所以不会被getwrite.write覆盖
              }

              ajax.send();
          }

          function post() {
            var ajax = ajaxFunction();

            ajax.open("POST","DemoServlet01",true);


            //设置头，说明是一个经过url编码的form表单
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.send("name=zhangsan&age=18");
          }

      </script>
  </head>
  <body>

  <a href="#" onclick="get()">使用AJAX发送GET数据请求</a>
  <a href="#" onclick="post()">使用AJAX发送POST数据请求</a>

  </body>
</html>
