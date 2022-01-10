package com.te.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveData {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement;
	
		try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","root");
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from sweets");
			while (result.next()) {
				System.out.print(result.getInt(1)+",");
				System.out.print(result.getString(2)+",");
				System.out.print(result.getDouble(3)+",");
				System.out.println(result.getInt(4)+",");
			}
				
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		

	}

}
