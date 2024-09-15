package com.metacube.dao;

public class Queries {

	public static String getPassword() {
		String query = "select * from userTable where userName=? and userPwd=?";
		return query;
	}

	public static String getShowProducts() {
		String query = "select * from product";
		return query;
	}

	public static String getAddToCart() {
		String query = "insert into cart(cartID,productID,quantity) values(?,?,?)";
		return query;
	}

	public static String getCartID() {
		String query = "select userID from userTable where userEmail=?";
		return query;
	}

	public static String getShowCart() {
		String query = "select product.productID,product.productName,product.productPrice,product.productCode,cart.quantity from product inner join cart on cart.productID = product.productId where cartID=? ";
		return query;
	}

	public static String getRemoveFromCart() {
		String query = "delete from cart where cart.cartID=? and cart.productID=?";
		return query;
	}

	public static String getUpdateQuantity() {
		String query = "update cart set cart.quantity=? where cart.cartID=? and cart.productID=?";
		return query;
	}
}