package com.tiendavirtual.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	//parametros base datos
	private String bd = "ecoshop";
	private String login = "root";
	private String passw = "admin";
	private String url = "jdbc:mysql://localhost/" + bd;
	
	public Connection getConexionBD() {
		Connection connection = null;//conexion base de datos
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, passw);
			if (connection != null) {
				System.out.println("Conexion a base de datos " + bd + " OK\n");
				
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return connection;
	}
}