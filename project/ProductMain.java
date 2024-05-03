package com.chainsys.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.ProductDbConnection;

public class ProductMain {
	

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in); 
		UserRegister ur=new UserRegister();
		ProductDbConnection db=new ProductDbConnection();
		Product p = null; 
		Validation v1=new Validation();
		CrudOperations crud=new CrudOperations();
		while(true) {
			System.out.println("Do you have any Account in our Store: \n(Yes or No)");
			String choose=sc.nextLine().toLowerCase();
			while(!choose.equals("yes") && !choose.equals("no")) {
				System.err.println("Please Re-enter Valid Input:");
				choose=sc.nextLine().toLowerCase();
			}
			if(choose.equals("no")) {
				System.out.println("Please Sign Up");	
				System.out.println("Enter UserName:");
				String userName = sc.nextLine();
				ur.setName(userName);
				System.out.println("Enter PassWord:");
				String passWord = sc.nextLine();
				ur.setPassword(passWord);
				Connection connection = db.getConnection();
				crud.insertUser(connection,ur);
				System.out.println("Signed Successfully!");
				
				
				System.out.println("Please Log In!");
				boolean validName = false;
				String name = "";
				while (!validName) {
				    System.out.println("Enter The Name: ");
				    name = sc.next();
				    crud.getUserPassword(connection, ur);
				    if (name.equals(ur.getName())) {
				        validName = true;
				    } else {
				        System.out.println("Invalid name. Please re-enter.");
				    }
				}

				System.out.println("Enter The Password: ");
				String pass = sc.next();
				if (pass.equals(ur.getPassword())) {
				    System.out.println("Login successful!");
				} else {
				    System.out.println("Invalid password.");
				}
			}


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
			if(!v1.isNumerics(choice)) {
				System.out.println("Please Re-Enter your Choice:");
				choice = sc.nextInt();
			}
			sc.nextLine(); 

			switch (choice){
			case 1:
				try {
					crud.insertProduct(db.getConnection(),p);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:try {
				crud.viewProducts(db.getConnection());
			}catch (SQLException e) {
				e.printStackTrace();
			}

			break;
			case 3:
				try {
					crud.retrieveProducts(db.getConnection());
				} catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					crud.updateProducts(db.getConnection());
				}catch(SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					crud.deleteProducts(db.getConnection());
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

