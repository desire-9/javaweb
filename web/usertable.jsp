<%@ page import= "java.util.ArrayList" %>
<%@ page import= "UserBean.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
<%
  //要显示的数据从request取
  ArrayList al =(ArrayList)request.getAttribute("result");
%>
<table  align="center" boder="1" style="border-collapse:collapse" >
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
</body>
</html>
