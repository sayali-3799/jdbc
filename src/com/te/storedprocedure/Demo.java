package com.te.storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		Connection connection=null;
		CallableStatement callableStatement=null;
		try {
			connection=DriverManager.getConnection(url, "root", "root");
			callableStatement=connection.prepareCall("call put(?,?,?,?)");
			Scanner scanner = new Scanner(System.in);
			while(true) {
				System.out.println("eneter the value of sweet");
				int id=scanner.nextInt();
				if(id==0) {
					break;
				}
				System.out.println("enter the name of the sweet");
				String name=scanner.next();
				System.out.println("enter the cost of the sweet");
				double cost=scanner.nextDouble();
				System.out.println("enter the quantity ");
				int kg=scanner.nextInt();
				callableStatement.setInt(1, id);
				callableStatement.setString(2, name);
				callableStatement.setDouble(3, cost);
				callableStatement.setInt(4, kg);
				callableStatement.execute();
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}


