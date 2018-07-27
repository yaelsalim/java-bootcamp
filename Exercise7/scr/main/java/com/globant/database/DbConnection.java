package com.globant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	String USER = "root";
	String PASS = "admin";
	String DB_URL = "jdbc:mysql://localhost/high-school?serverTimezone=UTC";
	private Connection connect = null;

	private static DbConnection getConnection = null;

	private DbConnection() {
	}

	public static DbConnection getInstance() {
		if (getConnection == null)
			getConnection = new DbConnection();

		return getConnection;

	}

	/**
	 * This method connects to a specified database.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection(DB_URL, USER, PASS);
		return connect;
	}

}
