package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
    public static Connection conn;
    public static Connection getConnection(){

        try{

            conn= DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KOIP0DP\\FATIHBEY:1433;database=JavaFXhome;user=sa;password=fatkan123");

        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
