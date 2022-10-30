<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#fff8dc">
<center>
    <form action="BookClServlet?flag=searchUser" method="post">
        ID:
        <input type="text" name="id">
        <br/>
        书名：
        <input type="text" name="username">
        <br/>
        作者：
        <input type="text" name="password">
        <br/>
        <input type="submit" value="查询">
        <input type="reset" value="重置">
        <br>
        <a href="bmain.jsp">返回</a>
    </form>
</center>
</body>
</html>