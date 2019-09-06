package com.metacube.dao;

import java.sql.Connection;	
import java.sql.DriverManager;

/**
 * Class JDBC
 * 
 * @author Vatsal
 *
 */
public class JDBC {
	
	public static Connection getConnection(String database, String userName,
			String password) {
		Connection connect = null;
		try {
			// JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Getting Connection
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + database, userName,
					password);
			//System.out.println("Remote DB connection established");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage().toString());
		}
		// Returning the connection object
		return connect;
	}
}
