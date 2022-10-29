import java.sql.*;
public class Main {
    public static void  main(String[] args) throws ClassNotFoundException, SQLException{
        Statement stmt  = null;
        ResultSet rs = null;
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javaweb";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url,username,password);
            stmt = conn.createStatement();
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            System.out.println("id | username | password");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String psw = rs.getString("password");

                System.out.println(id + " | " + name + " | " + password);
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                rs = null;
            }
            if(stmt!=null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                stmt = null;
            }
            if(conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                conn = null;
            }
        }
    }
}
