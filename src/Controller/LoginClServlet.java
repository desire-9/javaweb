package Controller;
//控制器本身不会执行逻辑业务，它主要去调用模型，完成对数据的处理
import UserBean.Tools;
import UserBean.UserBean;
import UserBean.UserBeanCl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginClServlet",urlPatterns = "/LoginServlet")
public class LoginClServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到用户名和密码
        String u = request.getParameter("username");
        u = Tools.getNewString(u);
        String p = request.getParameter("password");
        // 使用模型（UserBeanCl）,完成对用户的验证
        // 1.创建一个UserBeanCl对象
        UserBeanCl userbeancl = new UserBeanCl();
        // 2.调用方法
        if (userbeancl.checkUser(u, p)) {
            //在跳转到welcome.jsp页面时，准备好welcome.jsp需要显示的数据
            ArrayList<UserBean> al = userbeancl.getUserByPage(1);
            int pageCount = userbeancl.getPageCount();
            //将al,pageCount,pageNow放入request中
            request.setAttribute("result",al);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("pageNow", "1");

            //将用户名放入session，以备后用
            request.getSession().setAttribute("username", u);
            // 合法用户
            // 转向跳转，效率不高
            //response.sendRedirect("welcome.jsp");
            // 转发跳转，软件公司常使用
            // 同时request对象还可以在下一页使用
            request.getRequestDispatcher("main.jsp").forward(request,response);

        } else {
            // 不合法用户
            // response.sendRedirect("login.jsp?error=1");
            request.getRequestDispatcher("login.jsp?error=1").forward(request, response);
        }
    }
}
