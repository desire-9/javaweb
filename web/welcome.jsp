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
    登陆成功 欢迎你  <%=u%> !<br>
    <br>
    <a href="login.jsp">返回登陆页面</a>

    <br>
    <a href="umain.jsp">返回主页面</a>

    <h1>
        用户信息列表
    </h1><br>
    <br>
    <%
        //要显示的数据从request取
        ArrayList al =(ArrayList)request.getAttribute("result");
    %>
    <table border="1" style="border-collapse:collapse">
        <tr bgcolor="orange">
            <td width="30">ID</td>
            <td>用户名</td>
            <td>密码</td>
            <td><a>修改用户</a></td>
            <td><a>删除用户</a></td>
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
                    <a href="updateUser.jsp?username=<%=userbean.getId() %>&password=<%=userbean.getUsername()%>&id=<%=userbean.getPassword()%>">修改用户</a>
                </center>
            </td>
            <td>
                <center>
                    <a href="UserClServlet?flag=delete&user_id=<%=userbean.getId()%>">删除</a>
                </center>
            </td>
        </tr>
        <%}%>
    </table>
</center>
</body>
</html>
