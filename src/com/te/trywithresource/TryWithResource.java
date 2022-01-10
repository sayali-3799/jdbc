package com.te.trywithresource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResource {

	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo?user=root&password=root");
				Statement stmt=con.createStatement();){
			boolean execute=stmt.execute("select * from sweets");
			System.out.println(execute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
