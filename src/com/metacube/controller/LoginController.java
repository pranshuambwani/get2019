package com.metacube.controller;

import com.metacube.facade.Facade;


public class LoginController {

	
	public static boolean User(String email, String password) {
		boolean result = false;
		int number = Facade.getLogin(email, password);
		if (number == 1)
			result = true;
		return result;
	}
}