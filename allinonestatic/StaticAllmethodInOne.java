package com.jdbcproject.allinonestatic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticAllmethodInOne {
	public static void insert() {
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
	public static void update() {
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
	public static void delete() {
		Connection connection =null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			statement = connection.createStatement();
			String qry="delete from rcbteam where id=8";
			int update = statement.executeUpdate(qry);
			System.out.println("Data Deleted successfully");
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
	public static void fetch() {
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
	public static void main(String[] args) {
		StaticAllmethodInOne.insert();
	}

}
