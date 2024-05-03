package com.chainsys.project;

import java.sql.Connection;
import java.sql.SQLException;

public interface ProductDAO {
	void updateProducts(Connection connection) throws SQLException ;
	public  void insertProduct(Connection connection, Product p) throws SQLException;
	public void insertUser(Connection connection,UserRegister ur)throws SQLException;
	public void getUserPassword(Connection connection,UserRegister ur) throws SQLException;
	public boolean isExistsId(Connection connection, int id) throws SQLException;
	public  boolean isExistsName(Connection connection, String name)throws SQLException;
	void  viewProducts(Connection connection)throws SQLException;
	void retrieveProducts(Connection connection)throws SQLException;
	void deleteProducts(Connection connection)throws SQLException;
	
}
