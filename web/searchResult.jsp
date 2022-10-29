<%@ page import="java.util.ArrayList" %>
<%@ page import="UserBean.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#fff8dc">
<center>
    <%
        ArrayList al =(ArrayList) request.getAttribute("result");
        for(int i = 0; i < al.size(); i++){
            UserBean userbean =(UserBean) al.get(i);
    %>
    ID:
    <input type="text" name="id" value="<%=userbean.getId()%>" /><br />
    用户名：
    <input type="text" name="username" value="<%=userbean.getUsername()%>" /><br />
    密码：
    <input type="text" name="password" value="<%=userbean.getPassword()%>" /><br />
    <%
        }
    %>
    <a href="searchUser.jsp"><font color="pink">返回查询页</font></a>
</center>

</body>
</html>
