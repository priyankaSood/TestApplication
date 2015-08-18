package com.infy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper
{
	private String url;
	private static ConnectionHelper instance;

	private ConnectionHelper()
	{
    	String driver = null;
		try {
			/*Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost/directory?user=root&password=Infy123+";
            ResourceBundle bundle = ResourceBundle.getBundle("cellar");
            driver = bundle.getString("jdbc.driver");
            Class.forName(driver);
            url=bundle.getString("jdbc.url");*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		/*if (instance == null) {
			instance = new ConnectionHelper();
		}*/
		
			//return DriverManager.getConnection(instance.url);

			 String url = "jdbc:mysql://localhost:3306/"; 
			          String dbName = "cellar"; 
			          String driver = "com.mysql.jdbc.Driver"; 
			          String userName = "root";  
			          String password = "Infy123+"; 
			          try { 
			          try {
						Class.forName(driver).newInstance();
						
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			          
			          Connection conn = DriverManager.getConnection(url+dbName,userName,password); 
			          return conn;
			
		
		}
		catch (SQLException e) {
			throw e;
		}
					
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}