package com.store.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectToMysql
{
	private static String url = "jdbc:mysql://localhost:3306/store?autoReconnect=true&useSSL=false";
	private static String username = "root";
	private static String password = "";
	static Connection conn;
	static PreparedStatement prepstat;

	public static PreparedStatement connectToMysql(String sql)
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = (Connection) DriverManager.getConnection(url,username,password);
			prepstat = conn.prepareStatement(sql);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepstat;
	}

	public static void closeConnection() throws SQLException
	{
		prepstat.close();
		conn.close();
	}
}
