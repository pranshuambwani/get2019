package com.metacube.DAO;

public class Queries {
	
	public final static String INSERTINVENTORY = "INSERT INTO INVENTORY(NAME,QUANTITY) VALUES(?,?);";
	
	public final static String GETALLINVENTORY = "SELECT * FROM INVENTORY;";
	
	public final static String GETINVENTORYBYNAME = "SELECT * FROM INVENTORY WHERE NAME=?;";
	
	public final static String UPDATEINVENTORY = "UPDATE INVENTORY SET QUANTITY=? WHERE NAME=?;";
	
	public final static String DELETEINVENTORY = "DELETE FROM INVENTORY WHERE NAME=?";
	
	public final static String REPLACEINVENTORY = "UPDATE INVENTORY QUANTITY=? WHERE NAME=?";
	
	public final static String DELETEALL = "DELETE FROM INVENTORY;";
}
