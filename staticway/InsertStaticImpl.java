package com.jdbcproject.staticway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStaticImpl {
	public static void main(String[] args) {
		Connection connection =null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			statement = connection.createStatement();
			String qry="insert into rcbteam values(8,'Rohit',45,2021)";
			int update = statement.executeUpdate(qry);
			System.out.println("Data inserted successfully");
			System.out.println("Please check your database");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null && statement != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					statement.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
