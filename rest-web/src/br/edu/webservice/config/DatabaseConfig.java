package br.edu.webservice.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	
	private static DatabaseConfig config;
	
	public static DatabaseConfig getInstancia() {
		if(config == null) {
			config = new DatabaseConfig();
		}
		
		return config;
	}
	
	public Connection getConection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/android_devmedia", "root","root");
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(DatabaseConfig.getInstancia().getConection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
