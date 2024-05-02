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
		CrudOperations crud=new CrudOperations();
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
					crud.insertProduct(getConnection(),p);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:try {
				crud.viewProducts(getConnection());
			}catch (SQLException e) {
				e.printStackTrace();
			}

			break;
			case 3:
				try {
					crud.retrieveProducts(getConnection());
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					crud.updateProducts(getConnection());
				}catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					crud.deleteProducts(getConnection());
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




	}

