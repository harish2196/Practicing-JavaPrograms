package com.chainsys.jdbc1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrudOperations {

	public static void insertProduct(Connection connection, Product p) throws SQLException {
	    String insertion = "INSERT INTO products (id, Name, Model, price) VALUES (?, ?, ?, ?)";
	    Scanner sc = new Scanner(System.in);
	    Validation v1 = new Validation();
	    PreparedStatement preparedStatement = connection.prepareStatement(insertion);
	    System.out.println("Enter ID:");
	    int id = sc.nextInt();
	    if (!v1.isNumerics(id)) {
	        System.out.println("Please Re-Enter your ID:");
	        id = sc.nextInt();
	    }
	    if (isExists(connection, id)) {
	        System.out.println("ID already exists. Please choose a different ID.");
	        return;
	    }
	    preparedStatement.setInt(1, id);

	    System.out.println("Enter Name:");
	    String name = sc.next();
	    if (!v1.validateString(name)) {
	        System.out.println("Please Re-Enter your Name:");
	        name = sc.next();
	    }
	    preparedStatement.setString(2, name);

	    System.out.println("Enter Model:");
	    String model = sc.next();
	    if (!v1.validateString(model)) {
	        System.out.println("Please Re-Enter your Model:");
	        model = sc.next();
	    }
	    preparedStatement.setString(3, model);

	    System.out.println("Enter Price:");
	    double price = sc.nextDouble();
	    if (!v1.isDle(price)) {
	        System.out.println("Please Re-Enter your Price:");
	        price = sc.nextDouble();
	    }
	    preparedStatement.setDouble(4, price);
	    int executeUpdate = preparedStatement.executeUpdate();
	    System.out.println(executeUpdate);
	    System.out.println("Data inserted successfully.");
	    System.out.println(p);
	}

	public static boolean isExists(Connection connection, int id) throws SQLException {
	    String countID = "SELECT COUNT(*) FROM products WHERE id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(countID);
	    preparedStatement.setInt(1, id);
	    ResultSet resultSet = preparedStatement.executeQuery();
	    resultSet.next();
	    int count = resultSet.getInt(1);
	    return count > 0;
	}

	public static void viewProducts(Connection connection) throws SQLException {
		String viewing ="Select id,name,model,price FROM products";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(viewing);
		while(resultSet.next()) {
			int id=resultSet.getInt(1);
			String name=resultSet.getString(2);
			String model=resultSet.getString(3);
			double price=resultSet.getDouble(4);	
			System.out.println("ID:" + id + " Name:" + name + " Model:" + model  + " Price:" + price);
		}

	}

	public static void retrieveProducts(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the Product to be retrieve:");
		int id = sc.nextInt();
		String retrieve= "SELECT id, name, model, price FROM products WHERE id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(retrieve);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			String name=resultSet.getString("name");
			String model=resultSet.getString("model");
			double price=resultSet.getDouble("price");
			System.out.println("ID:" + id + " Name:" + name + " Model:" + model  + " Price:" + price);
		} 
		else {
			System.out.println("ID: " + id + " Not Found");
		}

	}
	public static void updateProducts(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Validation v1=new Validation();
		System.out.println("Enter the ID of the Product to update:");
		int id = sc.nextInt();
		if(!v1.isNumerics(id)){
			System.out.println("Please Re-Enter your ID:");
			id = sc.nextInt();
		}
		System.out.println("Enter New Name:");
		String name = sc.next();
		if(!v1.validateString(name)){
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		System.out.println("Enter New Model:");
		String model = sc.next(); 
		if(!v1.validateString(model)){
			System.out.println("Please Re-Enter your Model:");
			model = sc.next();
		}
		System.out.println("Enter new Price:");
		double price = sc.nextDouble();
		if(!v1.isDle(price)){
			System.out.println("Please Re-Enter your ID:");
			price = sc.nextDouble();
		}	    
		String updating = "UPDATE Products SET Name=?, Model=?, Price=? WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(updating);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, model);
		preparedStatement.setDouble(3, price);
		preparedStatement.setInt(4, id);	    
		int rows = preparedStatement.executeUpdate(); 
		if (rows > 0) {
			System.out.println("Product with ID " + id + " updated successfully.");
		} else {
			System.out.println("Failed to update product with ID " + id);
		}
	}
	public static void deleteProducts(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the Products to delete:");
		int id = sc.nextInt();
		String query = "DELETE FROM products WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		if (rows > 0) {
			System.out.println("Products with ID " + id + " deleted successfully.");
		} else {
			System.out.println("No Products found with ID " + id);
		}
	}
}
