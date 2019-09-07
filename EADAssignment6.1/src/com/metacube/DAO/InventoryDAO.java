package com.metacube.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.metacube.controller.*;
import com.metacube.facade.*;
import com.metacube.model.*;
import com.metacube.DAO.*;
import com.sun.scenario.effect.InvertMask;

public class InventoryDAO {
	
	static InventoryDAO inventoryDao;
	
	public static InventoryDAO getInstance(){
		if(inventoryDao==null){
			return new InventoryDAO();
		}
		return inventoryDao;
	}

	public Status insertInventory(String name,Integer quantity) throws Exception{
		
		DatabaseConnection db = DatabaseConnection.getInstances();
		PreparedStatement pstmt = (PreparedStatement) db.con.prepareStatement(Queries.INSERTINVENTORY);
		pstmt.setString(1, name);
		pstmt.setInt(2, quantity);
		if(pstmt.executeUpdate()>0){
			return Status.INSERTED;
		}
		return Status.FAILED;
	}
	
	public List<Inventory> getAllInventory() throws Exception{
		DatabaseConnection db = DatabaseConnection.getInstances();
		PreparedStatement pstmt = (PreparedStatement) db.con.prepareStatement(Queries.GETALLINVENTORY);
		ResultSet rs = pstmt.executeQuery();
		List<Inventory> list = new ArrayList<Inventory>();
		while(rs.next()){
			Inventory inventory = new Inventory();
			inventory.setName(rs.getString(1));
			inventory.setQuantity(rs.getInt(2));
			list.add(inventory);
		}
		return list;
	}
	
	public Inventory getInventoryByName(String name) throws Exception{
		DatabaseConnection db = DatabaseConnection.getInstances();
		PreparedStatement pstmt = (PreparedStatement) db.con.prepareStatement(Queries.GETINVENTORYBYNAME);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();
		Inventory inventory = new Inventory();
		if(rs.next()){
			inventory.setName(rs.getString(1));
			inventory.setQuantity(rs.getInt(2));
		}
		return inventory;
	}
	
	public Status updateInventory(String name,Integer quantity) throws Exception{
		DatabaseConnection db = DatabaseConnection.getInstances();
		PreparedStatement pstmt = (PreparedStatement) db.con.prepareStatement(Queries.UPDATEINVENTORY);
		pstmt.setInt(1, quantity);
		pstmt.setString(2, name);
		if(pstmt.executeUpdate()>0){
			return Status.UPDATED;
		}
		return Status.FAILED;
	}
	
	public Status deleteInventory(String name) throws Exception{
		DatabaseConnection db = DatabaseConnection.getInstances();
		PreparedStatement pstmt = (PreparedStatement) db.con.prepareStatement(Queries.DELETEINVENTORY);
		pstmt.setString(1, name);
		if(pstmt.executeUpdate()>0){
			return Status.DELETED;
		}
		return Status.FAILED;
	}
	
	public Status replaceInventory(String name,Inventory inventory) throws Exception{
		DatabaseConnection db = DatabaseConnection.getInstances();
		PreparedStatement pstmt = (PreparedStatement) db.con.prepareStatement(Queries.REPLACEINVENTORY);
		pstmt.setString(1, inventory.getName());
		pstmt.setInt(2, inventory.getQuantity());
		pstmt.setString(3, name);
		if(pstmt.executeUpdate()>0){
			return Status.UPDATED;
		}
		return Status.FAILED;
	}
	
	public Status deleteall()throws Exception{
		DatabaseConnection db = DatabaseConnection.getInstances();
		Statement stmt = db.con.createStatement();
		stmt.execute(Queries.DELETEALL);
		return Status.DELETED;
	}
	
	
}
