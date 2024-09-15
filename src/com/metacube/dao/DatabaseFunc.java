package com.metacube.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseFunc {

	public static Connection getConnection() {
		Connection connect = JDBC.getConnection("shoppingcart", "root", "root");
		return connect;
	}

	public static ResultSet checkEntry(String email, String password) {
		ResultSet result = null;
		try {
			Connection connect = getConnection();
			String query = Queries.getPassword();
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			result = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ResultSet returnAllProducts() {
		ResultSet result = null;
		try {
			Connection connect = getConnection();
			String query = Queries.getShowProducts();
			PreparedStatement statement = connect.prepareStatement(query);
			result = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int addProduct(int cartID, int productID, int quantity) {
		int noofrowschanged = 0;
		try {
			Connection connect = getConnection();
			String query = Queries.getAddToCart();
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setInt(1, cartID);
			statement.setInt(2, productID);
			statement.setInt(3, quantity);
			noofrowschanged = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noofrowschanged;
	}

	public static ResultSet getCartID(String email) {
		ResultSet result = null;
		try {
			Connection connect = getConnection();
			String query = Queries.getCartID();
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setString(1, email);
			result = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ResultSet AllItems(int cart_id) {
		ResultSet result = null;
		try {
			Connection connect = getConnection();
			String query = Queries.getShowCart();
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setInt(1, cart_id);
			result = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int removeItem(int cart_id, int proID) {
		int noofrowschanged = 0;
		try {
			Connection connect = getConnection();
			String query = Queries.getRemoveFromCart();
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setInt(1, cart_id);
			statement.setInt(2, proID);
			noofrowschanged = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noofrowschanged;
	}

	public static int updateItem(int cart_id, int proID, int qty) {
		int noofrowschanged = 0;
		try {
			Connection connect = getConnection();
			String query = Queries.getUpdateQuantity();
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setInt(1, qty);
			statement.setInt(2, cart_id);
			statement.setInt(3, proID);
			noofrowschanged = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noofrowschanged;
	}
}
