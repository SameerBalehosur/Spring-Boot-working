package com.jdbc.project.dynamicway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDynamicImpl {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the name Which you would like to update");
		String name=scanner.next();
		System.out.println("Enter the ID");
		int id=scanner.nextInt();
		Connection connection =null;
		Statement statement = null;
		PreparedStatement prepareStatement =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			String qry="update rcbteam set name=? where id=?";
			prepareStatement = connection.prepareStatement(qry);
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, id);
			prepareStatement.executeUpdate();
			System.out.println("Data Updated successfully");
			System.out.println("Please check your database");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null && statement != null && prepareStatement!=null) {
				try {
					connection.close();
					statement.close();
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}