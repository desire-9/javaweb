<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cancleUser Page</title>
</head>
<body bgcolor="#fff8dc">
<center>
    <form action="BookClServlet?flag=canaelUser" method="post">
        <h1>输入删除图书！</h1>
        书名：<input type="text" name="username" /><br/>
        作者：<input type="password" name="password" /><br/>
        <input type="submit" value="删除"/>
        <input type="reset" value="重置" />
        <br>
        <a href="bmain.jsp">返回</a>
    </form>
</center>
</body>
</html>
