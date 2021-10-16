package com.jdbc.project.dynamicway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDynamicImpl {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the ID Which you would like to delete record");
		int id=scanner.nextInt();
		Connection connection =null;
		Statement statement = null;
		PreparedStatement prepareStatement =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			String qry="delete from rcbteam where id=?";
			prepareStatement = connection.prepareStatement(qry);
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
			System.out.println("Data Deleted successfully");
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
