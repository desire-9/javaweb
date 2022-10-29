<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateUser Page</title>
</head>
<body bgcolor="silver">
<center>
    <h1>请输入需要修改的用户信息！</h1>
    <form action="UserClServlet?flag=updateUser" method="post">
        <table border="1">
            <tr bgcolor="yellow">
                <td>ID</td>
                <td><input type="text" readonly="readonly" name="id" value="<%=request.getParameter("id")%>"></td>
            </tr>
            <tr bgcolor="#ffc0cb">
                <td>用户名</td>
                <td><input type="text" name="username" value="<%=request.getParameter("username")%>"></td>
            </tr>
            <tr bgcolor="#ffc0cb">
                <td>密 码</td>
                <td><input type="password" name="password" value="<%=request.getParameter("password")%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"/></td>
                <td><input type="reset" value="重置"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
