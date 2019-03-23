package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
	Connection dbconnection=null;
	String Query="select * from tablo1";
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		 Connection connect=null;
		 Statement statement=null;	
		String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String connectionString = "jdbc:jtds:sqlserver://DESKTOP-KOIP0DP\\FATIHBEY;database=deneme;integratedSecurity=true;";
        String USERNAME = "STU\fatihmercan"; 
        String PASSWORD = "";
        
        Class.forName(JDBC_DRIVER);
        connect=DriverManager.getConnection(connectionString,USERNAME,PASSWORD);
        statement=connect.createStatement();
        ResultSet result=statement.executeQuery(Query);
        ResultSetMetaData metaData = result.getMetaData();
        int number = metaData.getColumnCount();
        for(int i=1; i<=number; i++)
        	System.out.printf( "%-8s\t", metaData.getColumnName( i ) );
        System.out.println();
        while(result.next()) {
        	for(int i=1; i<=number; i++) 
        		 System.out.printf("%-8s\t", result.getObject(i));
        	 System.out.println();
       
        }
		return dbconnection;
		}
}
