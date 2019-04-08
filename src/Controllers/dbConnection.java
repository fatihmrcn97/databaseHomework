package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    public static Connection conn;
    public static Connection getConnection(){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=JavaProject;integratedSecurity=true;");

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
