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
        //防止非法登陆
        String u =(String) session.getAttribute("username");
        //如果没登陆
        if(u==null){
            //返回登陆界面
            response.sendRedirect("login.jsp?error=1");
            return;
        }
    %>
    <h1>
        图书信息表
    </h1>
    <br>
    <%
        //要显示的数据从request取
        ArrayList al =(ArrayList)request.getAttribute("result");
    %>
    <table border="1" style="border-collapse:collapse">
        <tr bgcolor="orange">
            <td width="30">ID</td>
            <td>书名</td>
            <td>作者</td>
            <td><a>修改信息</a></td>
            <td><a>删除图书</a></td>
        </tr>
        <%
            String[] color= {"green", "pink"};
            for (int i = 0 ; i <al.size();i++){
                UserBean userbean=(UserBean) al.get(i);
        %>
        <tr bgcolor="<%=color[i % 2]%>">
            <td><%=userbean.getId()%></td>
            <td><%=userbean.getUsername()%></td>
            <td><%=userbean.getPassword()%></td>
            <td>
                <center>
                    <a href="updateBook.jsp?id=<%=userbean.getId() %>&username=<%=userbean.getUsername() %>&password=<%=userbean.getPassword()%>">修改图书</a>
                </center>
            </td>
            <td>
                <center>
                    <a href="BookClServlet?flag=delete&user_id=<%=userbean.getId()%>">删除</a>
                </center>
            </td>
        </tr>
        <%}%>
    </table>
    <br>
    <a href="login.jsp">返回登录页</a>
    <a href="bmain.jsp" >返回管理页</a>
</center>
</body>
</html>
