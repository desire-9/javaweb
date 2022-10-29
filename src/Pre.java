import java.sql.*;
public class Pre {
    public static void  main(String[] args) throws ClassNotFoundException, SQLException{
        PreparedStatement preStmt = null;
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javaweb";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url,username,password);
            String sql = "INSERT INTO USERS(name,password)"+"VALUES(?,?)";
            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,"zh");
            preStmt.setString(2,"123456");
            preStmt.executeUpdate();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }finally{
            if(preStmt!=null){
                try{
                    preStmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                preStmt = null;
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
