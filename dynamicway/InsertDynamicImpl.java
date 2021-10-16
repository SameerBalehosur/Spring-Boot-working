package com.jdbc.project.dynamicway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDynamicImpl {

	public static void main(String[] args) {
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

}
