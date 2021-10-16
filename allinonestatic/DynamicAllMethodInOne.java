package com.jdbcproject.allinonestatic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicAllMethodInOne {
	public static void insert() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the ID");
		int id=scanner.nextInt();
		System.out.println("Enter the name");
		String name=scanner.next();
		System.out.println("Enter the percentage");
		double perc=scanner.nextDouble();
		System.out.println("Enter the Year of passout");
		int yop=scanner.nextInt();
		Connection connection =null;
		Statement statement = null;
		PreparedStatement prepareStatement =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3306/student?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			String qry="insert into rcbteam values(?,?,?,?)";
			prepareStatement = connection.prepareStatement(qry);
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, name);
			prepareStatement.setDouble(3, perc);
			prepareStatement.setInt(4, yop);
			prepareStatement.executeUpdate();
			System.out.println("Data inserted successfully");
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
	public static void update() {
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
	public static void delete() {
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
	public static void fetch() {
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
	public static void main(String[] args) {
		DynamicAllMethodInOne.insert();
		DynamicAllMethodInOne.update();
		DynamicAllMethodInOne.delete();
		DynamicAllMethodInOne.fetch();
	}
}
