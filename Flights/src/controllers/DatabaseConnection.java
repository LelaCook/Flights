package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {

	public static void main(String[] args) 
		throws SQLException, ClassNotFoundException {
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection
				("jdbc:sqlserver://javaflightdb.database.windows.net:1433;database=javaflightdb;user=javaflightdb@javaflightdb;password=CISproject22!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		System.out.println("Database connected");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery
				("select firstname, mi, lastname from Student where lastname "
						+ "= 'Smith'");
		
		while(resultSet.next())
			System.out.println(resultSet.getString(1) + "\t"
					+ resultSet.getString(2) + "\t" + resultSet.getString(3));
		
		connection.close();
				
		}
}
