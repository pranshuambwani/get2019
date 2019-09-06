package com.metacube.controller;

import com.metacube.facade.Facade;


public class CartID {
	
	public static int CartIDReq(String email) {
		int cart_id = Facade.returnID(email);
		return cart_id;
	}
}