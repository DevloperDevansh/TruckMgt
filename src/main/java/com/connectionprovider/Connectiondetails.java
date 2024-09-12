package com.connectionprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondetails {
	
	private static final String  URL = "jdbc:mysql://localhost:3306/TruckManagement";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Ayush@321";
	
	public static Connection getconnection() throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}

}
