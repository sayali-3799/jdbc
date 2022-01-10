package com.te.propinfo;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
			FileReader fileReader = new FileReader("C:\\Users\\hp\\Desktop\\jdbcfile.txt");
			Properties properties = new Properties();
			properties.load(fileReader);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", properties);
			statement=connection.createStatement();
			statement.execute("delete from sweets where id=1");
			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(connection!=null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}				}
				if(statement!=null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}				}
				
			}
		
				
				

	}

}
