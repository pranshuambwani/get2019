package com.metacube.view;

import java.util.*;
import com.metacube.controller.*;

public class Main {
	public static void main(String args[]) {
		int cart_id, proID, qty;
		System.out.println("Welcome to Metacube Store");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your Credentials");
		System.out.println("Enter ID");
		String id = sc.next();
		System.out.println("Enter Password");
		String pwd = sc.next();

		if (LoginController.User(id, pwd)) {
			boolean flag = true;
			while (flag) {

				System.out.println("Select an operation to perform");
				System.out.println("1. Add an item to the cart");
				System.out.println("2. Remove the item from the cart");
				System.out
						.println("3. Update the quantity of a product in the cart");
				System.out.println("4. Show all items in the cart");
				System.out.println("0. Exit");
				int option = sc.nextInt();
				switch (option) {
				case 0:
					flag = false;
					break;
				case 1:

					ShowProducts.ShowProducts();
					System.out
							.println("Enter the product id you want to add to your cart");
					proID = sc.nextInt();
					System.out.println("Enter the Quantity you want to add");
					qty = sc.nextInt();

					cart_id = CartID.CartIDReq(id);

					AddToCart.AddProduct(cart_id, proID, qty);
					break;
				case 2:

					cart_id = CartID.CartIDReq(id);

					ShowCart.ShowCartReq(cart_id);
					System.out
							.println("Enter the product id you want to remove from your cart");
					proID = sc.nextInt();

					RemoveFromCart.RemoveFromCartReq(cart_id, proID);
					break;
				case 3:

					cart_id = CartID.CartIDReq(id);
					ShowCart.ShowCartReq(cart_id);
					System.out
							.println("Enter the product id whose quantity you want to update");
					proID = sc.nextInt();
					System.out.println("Enter the updated Quantity");
					qty = sc.nextInt();

					if (qty == 0)
						RemoveFromCart.RemoveFromCartReq(cart_id,
								proID);
					else {
						UpdateCart. UpdateCartReq(cart_id, proID, qty);
					}
					break;
				case 4:

					cart_id = CartID.CartIDReq(id);

					ShowCart.ShowCartReq(cart_id);
					break;
				default:
					System.out.println("Enter a valid option");
				}
			}
		} else {
			System.out.println("Incorrect Username or Password");
		}
	}
}