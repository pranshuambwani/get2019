package com.metacube.controller;

import com.metacube.facade.Facade;


public class RemoveFromCart {
	
	public static void RemoveFromCartReq(int cart_id,int proID){
		boolean ItemRemoved = Facade.removeItem(cart_id, proID);
		if(ItemRemoved)
			System.out.println("Item Removed Successfully");
		else
			System.out.println("Unable to remove item!!Please try again");
	}
}
