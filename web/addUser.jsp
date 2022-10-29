<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser Page</title>
</head>
<body bgcolor="silver">
<center>
    <h1>请输入用户信息</h1>
    <form action="UserClServlet?flag=addUser" method="post">

        <table border="1">
            <tr bgcolor="yellow">
                <td>用户名</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr bgcolor="#ffc0cb">
                <td>密 码</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交" /></td>
                <td><input type="reset" value="重置" /></td>
            </tr>
            <tr>
                <td><a href="main.jsp" >返回</a></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
