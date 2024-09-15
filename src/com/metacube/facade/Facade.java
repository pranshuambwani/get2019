package com.metacube.facade;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.dao.*;


public class Facade {

	
	public static int getLogin(String email, String password) {
		int size = 0;
		ResultSet result = DatabaseFunc.checkEntry(email, password);
		if (result != null) {
			try {
				result.last();
				size = result.getRow();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return size;
	}

	
	public static void printAllProducts() {
		ResultSet result = DatabaseFunc.returnAllProducts();
		try {
			System.out
					.println("Product ID\tProduct Name\tProduct Type\tProduct Price\tProduct Code");
			while (result.next()) {
				System.out.print("\t" + result.getString("product.productID")
						+ "\t");
				System.out
						.print(result.getString("product.productName") + "\t");
				System.out
						.print(result.getString("product.productType") + "\t");
				System.out.print(result.getString("product.productPrice")
						+ "\t");
				System.out.println(result.getString("product.productCode")+ "\t");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static boolean addProduct(int cartID, int productID,
			int quantity) {
		boolean isAdded = false;
		int changes = DatabaseFunc.addProduct(cartID, productID, quantity);
		if (changes == 1)
			isAdded = true;
		return isAdded;
	}


	public static int returnID(String email) {
		ResultSet result = DatabaseFunc.getCartID(email);
		int userID = 0;
		try {
			result.next();
			userID = Integer.parseInt(result.getString("userTable.userID"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userID;
	}

	public static void showAllCart(int cart_id) {
		ResultSet result = DatabaseFunc.AllItems(cart_id);
		try {
			System.out
					.println("Product ID\tProduct Name\t Product Price\tProduct Code\t Quantity\t");
			while (result.next()) {
				System.out.print("\t" + result.getString("product.productID")
						+ "\t");
				System.out
						.print(result.getString("product.productName") + "\t");
				System.out.print(result.getString("product.productPrice")
						+ "\t");
				System.out
						.print(result.getString("product.productCode") + "\t");
				System.out.println(result.getString("cart.quantity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean removeItem(int cart_id, int proID) {
		boolean Removed = false;
		int changes = DatabaseFunc.removeItem(cart_id, proID);
		if (changes == 1)
			Removed = true;
		return Removed;
	}

	
	public static boolean updateItem(int cart_id, int proID, int qty) {
		boolean Updated = false;
		int changes = DatabaseFunc.updateItem(cart_id, proID,
				qty);
		if (changes == 1)
			Updated = true;
		return Updated;
	}
}