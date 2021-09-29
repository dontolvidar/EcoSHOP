package com.tiendavirtual.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.tiendavirtual.dto.Usuario;

public class UsuarioDAO {
	public void insertarUsuario(Usuario user) {
		ConexionBD connection= new ConexionBD();
		try {
			Statement stmt = connection.getConexionBD().createStatement(); //nuevo getConexionBD
			stmt.executeUpdate("INSERT INTO usuarios(`nombre`,`password`,`cedula_usuario`,`email_usuario`,`nombre_usuario`) VALUES (" + "'" + user.getNombre() + "'" + ","+ "'"+user.getPassword()+ "'" + ","+user.getCedula() +","+"'"+user.getEmail()+"'"+","+"'"+user.getNombreusuario()+"'"+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarUsuario() {
	}

	public void modificarUsuario(Usuario user) {
        String response = "";
        ConexionBD cnx=new ConexionBD();
        Connection cn = cnx.getConexionBD();
        if (cn != null) {
        	String modificarR = "nombre='" + user.getNombre() + "',password='" + user.getPassword() + "',cedula_usuario=" + user.getCedula() + ",email_usuario='" + user.getEmail() + "',nombre_usuario='" + user.getNombreusuario() + "'";
            String query = "UPDATE usuarios"
                    + " SET " + modificarR
                    + " WHERE cedula_usuario=" + user.getCedula();
            try {
                PreparedStatement consultaDB = cn.prepareStatement(query);
                consultaDB.execute();
                consultaDB.close();
                response = "Usuario modificado\n";
            } catch (SQLException e) {
                response = "Error---" + e;
            }
        } else {
            response = "Error de conexión";
        }

    }

	public void borrarUsuario() {
	}

}
