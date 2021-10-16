package com.jdbcproject.staticway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStaticImpl {

	public static void main(String[] args) {
		Connection connection =null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			statement = connection.createStatement();
			String qry="update rcbteam set name='Team David' where id=1";
			int update = statement.executeUpdate(qry);
			System.out.println("Data Updated successfully");
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
