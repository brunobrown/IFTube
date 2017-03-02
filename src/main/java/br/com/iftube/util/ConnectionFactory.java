package br.com.iftube.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {

		try {
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/iftube", "root", "");
			
			/*return DriverManager.getConnection("jdbc:mysql://localhost:3306/iftube?"
					+ "useTimezone=true&serverTimezone=UTC&autoReconnect=false&useSSL=false", "root", "");*/

		} catch (SQLException e) {
			// relancando a exeception
			throw new RuntimeException(e);
		}

	}
}
