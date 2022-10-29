package UserBean;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//这是一个处理类，有些人把它叫做BO，主要是封装去对login表的各种操作
//主要是增、删、修、查......
public class UserBeanCl {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet res = null;
    private PreparedStatement ps = null;

    private int pageSize = 3;
    private int rowCount = 0;// 该值从数据库中查询
    private int pageCount = 0;// 该值是通过pageSize和pageCount

    // 关闭资源
    public void closeSource() {
        // 关闭打开的各种资源，这个很重要！！！
        try {
            if (res != null) {
                res.close();
                res = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
            if(ps != null){
                ps.close();
                ps = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    // 验证用户是否合法
    public boolean checkUser(String u, String p) {

        boolean bool = false;
        try {
            // 查询数据库
            conn = new ConnDB().getConnection();
            stmt =  conn.createStatement();
            res = stmt
                    .executeQuery("select password from user where username = '"
                            + u + "'");

            // 根据结果判断
            if (res.next()) {
                // 用户名存在，判断密码是否正确
                if (res.getString(1).equals(p)) {
                    // 用户名和密码合法
                    bool = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeSource();
        }
        return bool;
    }

    // 返回pageCount的值
    public int getPageCount() {
        try {
            // 得到连接
            conn = new ConnDB().getConnection();
            // 创建Statement
            stmt =  conn.createStatement();
            // 查询数据库
            res = stmt.executeQuery("select count(*) from login");

            if (res.next()) {
                rowCount = res.getInt(1);
            }

            // 计算pageCount,这里的算法很多，可以自己设计
            if (rowCount % pageSize == 0) {
                pageCount = rowCount / pageSize;
            } else {
                pageCount = rowCount / pageSize + 1;
            }
            // 计算pageCount

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSource();
        }
        return pageCount;
    }

    // 得到用户需要显示的用户信息（分页）
    public ArrayList<UserBean> getUserByPage(int pageNow) {
        ArrayList<UserBean> al = new ArrayList<UserBean>();

        try {
            // 得到连接
            conn = new ConnDB().getConnection();
            // 创建Statement
            stmt = (Statement) conn.createStatement();

            // 显示要查询的记录
            // where not in(select * from login limit "+pageSize*(pageNow-1)+")
            System.out.println(pageNow);
            res = stmt.executeQuery("select * from user limit "
                    + ((pageNow - 1) * pageSize) + "," + pageSize + "; ");

            // 开始将res封装到ArrayList
            while (res.next()) {
                UserBean userbean = new UserBean();

                userbean.setId(res.getInt(1));
                userbean.setUsername(res.getString(2));
                userbean.setPassword(res.getString(3));

                // 将userbean放到al
                al.add(userbean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSource();
        }
        return al;
    }

    // 删除用户
    public boolean deleteUser(String user_id) {
        boolean bool = false;
        try {
            conn = new ConnDB().getConnection();
            ps = conn.prepareStatement("delete from user where id = "
                    + user_id + "");
            int a = ps.executeUpdate();
            if (a == 1) {
                // 删除成功
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeSource();
        }
        return bool;
    }

    // 添加用户
    public boolean addUser(String username, String password) {
        boolean bool = false;
        try {
            conn = new ConnDB().getConnection();
            ps = conn
                    .prepareStatement("insert into user(username,password) values('"
                            + username + "','" + password + "')");
            int i = ps.executeUpdate();
            if (i == 1) {
                bool = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSource();
        }
        return bool;
    }

    // 修改用户
    public boolean updateUser(String username, String password, String id) {
        boolean bool = false;
        try {
            conn = new ConnDB().getConnection();
            ps = conn.prepareStatement("update user set username='" + username
                    + "',password='" + password + "' where id = '" + id + "'");
            int i = ps.executeUpdate();
            if (i == 1) {
                bool = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSource();
        }
        return bool;
    }

    // 查询用户
    public ArrayList searchUser(String id, String username, String password) {
        ArrayList al = new ArrayList();
        UserBean userbean = new UserBean();
        try {

            conn = new ConnDB().getConnection();
            ps = conn.prepareStatement("select * from user where id like'%" + id
                    + "%' and username like'%" + username
                    + "%' and password like'%" + password + "%'");
            res = ps.executeQuery();
            while (res.next()) {
                userbean.setId(res.getInt(1));
                userbean.setUsername(res.getString(2));
                userbean.setPassword(res.getString(3));
                al.add(userbean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeSource();
        }
        return al;
    }

    //注销用户
    public boolean cancleUser(String username,String password){
        boolean bool = false;
        try {
            conn = new ConnDB().getConnection();
            ps = conn.prepareStatement("delete from user where username = '"+username+"' and password = '"+password+"'");
            int i = ps.executeUpdate();
            if(i == 1){
                bool = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.closeSource();
        }
        return bool;
    }
}
