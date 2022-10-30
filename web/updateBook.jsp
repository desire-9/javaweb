<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateBook Page</title>
</head>
<body bgcolor="#fff8dc">
<center>
    <h1>请输入需要修改的用户信息！</h1>
    <form action="BookClServlet?flag=updateUser" method="post">
        <table border="1">
            <tr bgcolor="#fa8072">
                <td>ID</td>
                <td><input type="text" readonly="readonly" name="id" value="<%=request.getParameter("id")%>"></td>
            </tr>
            <tr bgcolor="#ffc0cb">
                <td>书名</td>
                <td><input type="text" name="username" value="<%=request.getParameter("username")%>"></td>
            </tr>
            <tr bgcolor="#ffc0cb">
                <td>作者</td>
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
