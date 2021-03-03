
package login_ragister_design;

//when we make our datebase we make a connection and place it here below.
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


//THIS ENTIRE PAGE IS GOING TO BE BASE ON OUR DATA BASE CONNECTION!!!


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class My_Connect {

    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname  = "users_db";
    private static Integer portnumber  = 3306;
    private static String password = "";
    
    public static Connection getConnection()
    {
        Connection APP = null;
        
       // MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            APP = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get Connection -> " + My_Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return APP;
    }
    
}
