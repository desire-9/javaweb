<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body bgcolor="#fff8dc">
<center>
        <%
        String error = request.getParameter("error");
        if (error != null) {
            if (error.equals("1")) {
                out.println("<font color=red>用户没有正确登陆，请输入正确的用户名密码登陆！");
            }
        }
        %>
    <font color="black">用户登录</font>
    <br>
    <hr>
    <form action="LoginServlet" method="post">
            <font color="black">用户名：</font>
            <input type="text" name="username"/> <br/>
            <font color="black">密码：</font>
            <input type="password" name="password"/><br/>
            <input type="submit" value="登陆"/>
            <input type="reset" value="重置"/><br/>
    </form>
</center>
</body>
</html>
