package com.jdbcproject.staticway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStaticImpl {

	public static void main(String[] args) {
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			statement = connection.createStatement();
			String qry="select * from rcbteam";
			resultSet = statement.executeQuery(qry);
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
				System.out.println(resultSet.getInt(4));
				System.out.println();
			}
			System.out.println("Data Fetched successfully");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null && statement != null && resultSet!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					statement.close();
					resultSet.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
