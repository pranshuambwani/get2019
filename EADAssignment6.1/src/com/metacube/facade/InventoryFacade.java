package com.metacube.facade;

import java.util.List;

import com.google.gson.Gson;
import com.metacube.controller.*;
import com.metacube.facade.*;
import com.metacube.model.*;
import com.metacube.DAO.*;

public class InventoryFacade {
	
	InventoryDAO inventoryDao = InventoryDAO.getInstance();
	
	public Status insertInventory(String name,Integer quantity) throws Exception{
		return inventoryDao.insertInventory(name, quantity);
	}
	
	public List<Inventory> getAllInventory() throws Exception{
		return inventoryDao.getAllInventory();
	}
	
	public Inventory getInventoryByName(String name) throws Exception{
		return inventoryDao.getInventoryByName(name);
	}
	
	public Status updateInventory(String name,Integer quantity) throws Exception{
		return inventoryDao.updateInventory(name, quantity);
	}
	
	public Status deleteInventory(String name) throws Exception{
		return inventoryDao.deleteInventory(name);
	}
	
	public Status replaceInventory(String name,Inventory inventory) throws Exception{
		return inventoryDao.replaceInventory(name, inventory);
	}
	
	public Status deleteall() throws Exception{
		return inventoryDao.deleteall();
	}

}
