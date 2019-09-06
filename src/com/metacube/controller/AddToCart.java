package com.metacube.controller;

import com.metacube.facade.Facade;


public class AddToCart {
	
	public static void AddProduct(int cartID, int productID,
			int quantity) {
		if (Facade.addProduct(cartID, productID, quantity)) {
			System.out.println("Added Successfully");
		} else {
			System.out.println("Unsuccessfull!!Problem in adding to Cart");
		}
	}
}
