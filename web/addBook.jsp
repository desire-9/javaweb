<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
</head>
<body bgcolor="#fff8dc">
<center>
    <h1>请输入图书信息</h1>
    <form action="BookClServlet?flag=addUser" method="post">

        <table border="1" style="border-collapse:collapse">
            <tr bgcolor="yellow">
                <td>书名:</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr bgcolor="#ffc0cb">
                <td>作者:</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交" /></td>
                <td><input type="reset" value="重置" /></td>
            </tr>
            <tr>
                <td colspan="2"><a href="bmain.jsp" >返回</a></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
