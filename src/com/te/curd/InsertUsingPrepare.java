
package com.te.curd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.DriverManager;

public class InsertUsingPrepare {
	
	public static void main(String[] args) {
	    Connection connection=null;
	    PreparedStatement statement=null;
	    try {
	    	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","root");
	    	statement=connection.prepareStatement("Insert into sweets values(?,?,?,?)");
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("Enter the id of sweets");
	    	int id=sc.nextInt();
	    	System.out.println("Enter the name of sweets");
	    	String sweetname=sc.next();
	    	statement.setInt(1, id);
	    	statement.setString(2, sweetname);
	    	
	    	statement.setDouble(3, 50);
	    	statement.setInt(4, 1);
	    	int executeUpdate = statement.executeUpdate();
	    	System.out.println(executeUpdate);
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	}

}