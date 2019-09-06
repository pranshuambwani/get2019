package com.metacube.controller;

import com.metacube.facade.Facade;


public class ShowProducts {
	/**
	 * This method handles the request of showing all the products
	 */
	public static void ShowProducts() {
		Facade.printAllProducts();
	}
}