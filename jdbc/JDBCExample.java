package com.chainsys.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample {
	public static final String URL = "jdbc:mysql://localhost:3306/StudentDetails";
	public static final String USER = "root";
	public static final String PASSWORD = "root";

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			insertStudent(connection);
			viewStudents(connection);
			updateStudent(connection);
			deleteStudent(connection);
			retrieveStudent(connection);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertStudent(Connection connection) throws SQLException {
		String query = "INSERT INTO students (id, Name, age, Department) VALUES (?, ?, ?, ?)";
		Scanner sc = new Scanner(System.in);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		System.out.println("Enter ID:");
		preparedStatement.setInt(1, sc.nextInt());
		preparedStatement.setString(2, "Kumar");
		preparedStatement.setInt(3, 28);
		preparedStatement.setString(4, "IIT");
		preparedStatement.executeUpdate();
		System.out.println("Data inserted successfully.");
	}

	public static void viewStudents(Connection connection) throws SQLException {
		String query = "SELECT id, name, age, department FROM students";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("Name");
			int age = resultSet.getInt("age");
			String department = resultSet.getString("Department");
			System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department);
		}
	}

	public static void updateStudent(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the student to update:");
		int id = sc.nextInt();
		System.out.println("Enter new name:");
		String newName = sc.next();
		System.out.println("Enter new age:");
		int newAge = sc.nextInt();
		System.out.println("Enter new department:");
		String newDepartment = sc.next();

		String query = "UPDATE students SET Name=?, age=?, Department=? WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, newAge);
		preparedStatement.setString(3, newDepartment);
		preparedStatement.setInt(4, id);
		int rows = preparedStatement.executeUpdate();
		if (rows > 0) {
			System.out.println("Student with ID " + id + " updated successfully.");
		} else {
			System.out.println("Failed to update student with ID " + id);
		}
	}

	public static void deleteStudent(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the student to delete:");
		int id = sc.nextInt();
		String query = "DELETE FROM students WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		if (rows > 0) {
			System.out.println("Student with ID " + id + " deleted successfully.");
		} else {
			System.out.println("No student found with ID " + id);
		}
	}

	public static void retrieveStudent(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the student to retrieve:");
		int id = sc.nextInt();
		String query = "SELECT id, Name, age, Department FROM students WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			int retrievedId = resultSet.getInt("id");
			String name = resultSet.getString("Name");
			int age = resultSet.getInt("age");
			String department = resultSet.getString("Department");
			System.out.println("ID: " + retrievedId + ", Name: " + name + ", Age: " + age + ", Department: " + department);
		} else {
			System.out.println("No student found with ID " + id);
		}
	}
}
