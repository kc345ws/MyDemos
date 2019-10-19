<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019.10.19
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    
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

        function checkUserExist() {
            var username =document.getElementById("username").value;

            var request = ajaxFunction();

            request.open("POST","CheckUserServlet",true);

            request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");


            request.onreadystatechange = function () {
                if(request.readyState == 4 && request.status == 200){
                    var flag = request.responseText;
                    if(flag == 0){
                        document.getElementById("checkuser").innerHTML = "<font color='#adff2f'>可用</font>";
                    }else {
                        document.getElementById("checkuser").innerHTML = "<font color='red'>已被注册</font>";
                    }
                }
            }

            request.send("username="+username);



        }
    </script>
</head>
<body>

<form method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" id="username" onblur="checkUserExist()" onkeyup="">
            <span id="checkuser"></span></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password" id="password" onblur=""></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册">
            </td>
        </tr>
    </table>
</form>

</body>


</body>
</html>
