package com.tiendavirtual.dao;

import java.sql.SQLException;
import java.sql.Statement;

import com.tiendavirtual.dto.Cliente;

public class ClienteDAO {

	public void insertarCliente(Cliente client) {
		ConexionBD connection= new ConexionBD();
		try {
			Statement stmt = connection.getConexionBD().createStatement(); //nuevo getConexionBD
			stmt.executeUpdate("INSERT INTO clientes(cedula_cliente,nombre_cliente,direccion_cliente,telefono_cliente,email_cliente) VALUES ("  
			 + client.getCedula() + ","+ 
					"'"+client.getNombre()+"'" +","+ 
						"'"+client.getDireccion()+"'"+","+ 
							"'"+client.getTelefono()+"'"+","+ 
								"'"+client.getEmail()+"'"
			+ ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void buscarCliente() {
	}

	public void actualizarCliente() {
	}

	public void borrarCliente() {
	}
}
