package com.metacube.controller;

import com.metacube.facade.Facade;

public class UpdateCart {

	public static void UpdateCartReq(int cart_id, int proID, int qty) {
		boolean finalResult = Facade.updateItem(cart_id, proID, qty);
		if (finalResult)
			System.out.println("Successfully Updated");
		else
			System.out.println("Unable To Update Data!!Please try again later");
	}
}