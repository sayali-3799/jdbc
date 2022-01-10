package com.te.assignment;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Multiplayer {
	static int count = 0;

	public void search(String song) {

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement("select songs from songslist where songs=?");
			statement.setString(1, song);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				count = 1;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (count == 1)
			System.out.println(song+" Playing........");
		else
			System.out.println("Song not present");

	}

	public void play(String song,Multiplayer multiplayer) {
		multiplayer.search(song);
		
		

	}

	public void add(String song) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement("insert into songslist (songs) values(?)");
			System.out.println(song+" Added to the list");
			statement.setString(1, song);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(String song) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team", "root",
					"root");
			PreparedStatement statement = connection.prepareStatement("delete from songslist where songs=(?)");
			statement.setString(1, song);
			statement.executeUpdate();
			System.out.println(song+" Deleted from the list");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void dispaly() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team", "root",
					"root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from songslist");
			System.out.println("===========Song List===========");
			while(result.next()) {
				System.out.println(result.getString(2));
				
			}
			System.out.println("=======================");
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}

