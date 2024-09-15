package com.metacube.controller;

import com.metacube.facade.Facade;


public class ShowCart {
	
	public static void ShowCartReq(int cart_id) {
		Facade.showAllCart(cart_id);
	}
}