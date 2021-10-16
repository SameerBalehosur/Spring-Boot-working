package com.jdbc.project.dynamicway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FetchDynamicImpl {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Connection connection =null;
		Statement statement = null;
		PreparedStatement prepareStatement =null;
		ResultSet resultSet =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			String qry="select * from rcbteam";
			prepareStatement = connection.prepareStatement(qry);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
			}
			System.out.println("Data Fetched successfully");
			System.out.println("Please check your database");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null && statement != null && prepareStatement!=null && resultSet!=null) {
				try {
					connection.close();
					statement.close();
					prepareStatement.close();
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
