<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cancleUser Page</title>
</head>
<body bgcolor="#fff8dc">
<center>
    <form action="UserClServlet?flag=cancleUser" method="post">
        <h1>请输入需要取消的用户名和密码！</h1>
        用户名：<input type="text" name="username" /><br/>
        密 码：<input type="password" name="password" /><br/>
        <input type="submit" value="注销"/>
        <input type="reset" value="重置" />
    </form>
</center>
</body>
</html>
