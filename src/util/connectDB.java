package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectDB {

	private static Connection connection = null;

	    public static Connection getConnection(){
	        if (connection != null)
	            return connection;
	        else {
	            try {
	    			Class.forName("org.sqlite.JDBC").newInstance();		
	    			connection = DriverManager.getConnection("jdbc:sqlite:./files/OlimpDB.db");
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } catch (InstantiationException e) {					
					e.printStackTrace();
				} catch (IllegalAccessException e) {				
					e.printStackTrace();
				}
	            return connection;
	        }
	    }
}

