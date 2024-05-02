package com.chainsys.jdbc1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC1 {
	public static final String URL = "jdbc:mysql://localhost:3306/product";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}


	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in); 
		Product p = null; 
		while(true) {
			sc = new Scanner(System.in); 
			System.out.println("Welcome to our store!");
			System.out.println("What product would you like to get?");
			System.out.println("Welcome to Product Manager");
			System.out.println("1. Add Product");
			System.out.println("2. View Products");
			System.out.println("3. Retrieve Product by ID");
			System.out.println("4  Update Products by ID");
			System.out.println("5. Deleting Products by ID");
			System.out.println("6. Exiting...");

			int choice;

			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {
			case 1:
				try {
					insertProduct(getConnection(),p);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:try {
				viewProducts(getConnection());
			}catch (SQLException e) {
				e.printStackTrace();
			}

			break;
			case 3:
				try {
					retrieveProducts(getConnection());
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					updateProducts(getConnection());
				}catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					deleteProducts(getConnection());
				}catch(SQLException e) {
					e.printStackTrace();
				}
			case 6:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice!");
				return;
			}
		}
		//Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

	}


	public static void insertProduct(Connection connection,Product p) throws SQLException {
		String insertion = "INSERT INTO products (id, Name, Model, price) VALUES (?, ?, ?, ?)";
		Scanner sc = new Scanner(System.in);
		PreparedStatement preparedStatement = connection.prepareStatement(insertion);
		System.out.println("Enter ID:");
		int n=sc.nextInt();
		preparedStatement.setInt(1,n);
		System.out.println("Enter Name:");
		String name=sc.next();
		preparedStatement.setString(2, name);
		System.out.println("Enter Model:");
		String model=sc.next();
		preparedStatement.setString(3,model);
		System.out.println("Enter Price:");
		double price=sc.nextDouble();
		preparedStatement.setDouble(4, price); 
		p=new Product(n,name,model,price);
		int executeUpdate = preparedStatement.executeUpdate();
		System.out.println(executeUpdate);
		System.out.println("Data inserted successfully.");   
		System.out.println(p);

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
	    System.out.println("Enter the ID of the Product to update:");
	    int id = sc.nextInt();
	    System.out.println("Enter New Name:");
	    String name = sc.next();
	    System.out.println("Enter New Model:");
	    String model = sc.next(); 
	    System.out.println("Enter new Price:");
	    double price = sc.nextDouble();
	    
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

