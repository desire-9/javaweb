package UserBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnDB {
    private Connection conn = null;
        public Connection getConnection(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb","root","123456");
                System.out.println("数据库连接成功！");
            }catch(Exception e){
                e.printStackTrace();
            }
            return conn;
    }
}
