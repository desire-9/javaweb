package Controller;

import UserBean.UserBean;
import UserBean.BookBeanCl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BookClServlet",urlPatterns = "/BookClServlet")
public class BookClServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获得标识符
        String flag = request.getParameter("flag");
        // 调用UserBeanCl的方法
        BookBeanCl userbeancl = new BookBeanCl();

        if (flag.equals("paging")) {
            // 得到用户希望显示的pageNow
            String s_pageNow = request.getParameter("pageNow");
            try {
                int pageNow = Integer.parseInt(s_pageNow);

                // 在跳转到welcome.jsp页面时，准备好welcome.jsp需要显示的数据
                ArrayList<UserBean> al = userbeancl.getUserByPage(pageNow);
                int pageCount = userbeancl.getPageCount();
                // 将al,pageCount,pageNow放入request中
                request.setAttribute("result", al);
                request.setAttribute("pageCount", pageCount);
                request.setAttribute("pageNow", pageNow);

                // 重新跳转回welcome.jsp
                request.getRequestDispatcher("bwelcome.jsp").forward(request,
                        response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 删除用户
        else if (flag.equals("delete")) {

            String user_id = request.getParameter("user_id");
            if (userbeancl.deleteUser(user_id)) {
                // 删除成功
                request.getRequestDispatcher("bsuccess.jsp").forward(request,
                        response);
            } else {
                // 删除失败
                request.getRequestDispatcher("error.jsp").forward(request,
                        response);
            }

        }
        // 添加用户
        else if (flag.equals("addUser")) {
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(userbeancl.addUser(username, password)){
                //添加成功
                request.getRequestDispatcher("bsuccess.jsp").forward(request, response);
            }else{
                //添加失败
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

        //修改用户
        else if(flag.equals("updateUser")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String id = request.getParameter("id");

            if(userbeancl.updateUser(username, password,id)){
                //修改成功
                request.getRequestDispatcher("bsuccess.jsp").forward(request,response);
            }else{
                //添加失败
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }

        //查询用户
        else if(flag.equals("searchUser")){
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(userbeancl.searchUser(id, username, password).size() > 0){
                //显示查询结果
                request.setAttribute("result", userbeancl.searchUser(id, username, password));
                request.getRequestDispatcher("bsearchResult.jsp").forward(request,response);
            }else{
                //查询失败
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
        }

        //注销用户
        else if(flag.equals("cancelUser")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(userbeancl.cancelUser(username,password)){
                //注销成功
                request.getRequestDispatcher("bsuccess.jsp").forward(request, response);
            }else{
                //注销失败
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request, response);
    }
}
