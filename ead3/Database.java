package ead3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/studentdetail";
	private final String USERNAME = "root";
	private final String PASSWORD = "root";

	private static Database conn;

	private Connection con;
	private Statement stmt;

	public static Database getInstances() {
		if (conn == null) {
			try {
				Database.conn = new Database();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}

	private Database() throws Exception {
		Class.forName(this.DRIVER);
		this.con = DriverManager.getConnection(this.URL, this.USERNAME,
				this.PASSWORD);
		this.stmt = con.createStatement();
	}

	public int setData(String query) throws Exception {
		int n = stmt.executeUpdate(query);
		return n;
	}

	public ResultSet getData(String query) throws Exception {
		ResultSet rs = this.stmt.executeQuery(query);
		return rs;
	}
}