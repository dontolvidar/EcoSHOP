package com.tiendavirtual.dao;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tiendavirtual.dto.Usuario;

public class UsuarioDAO {
	private Statement sentencia = null; //envia una sentencia
    private ResultSet resultado = null;  //guarda informacion de una busqueda
	private String nombre;
	private String pass;
    
    
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

	public Usuario buscarUsuario(long cedula) {
        Usuario user = new Usuario();
        ConexionBD cnx=new ConexionBD();
        Connection cn = cnx.getConexionBD();
        if (cn != null) {
            try {
            	
                String atributos = "nombre,password,cedula_usuario,email_usuario,nombre_usuario";

                String query = "SELECT " + atributos + " FROM usuarios "
                        + "WHERE cedula_usuario=" + cedula;
                
                Statement sentencia = cn.createStatement();
                ResultSet resultado = sentencia.executeQuery(query);
                resultado.next();
                
            	user.setNombre(resultado.getString(1)); //Desde 0 seria tomar el id
                user.setPassword(resultado.getString(2));
                user.setCedula(resultado.getLong(3));
                user.setEmail(resultado.getString(4));
                user.setNombreusuario(resultado.getString(5));

            } catch (SQLException e) {
            	System.out.println("Mensaje "+e);
            }

        } else {
            System.out.println("Error de conexión");
        }
        return user;
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

	public void eliminarUsuario(long cedula) {
        String response = "";
        ConexionBD cnx=new ConexionBD();
        Connection cn = cnx.getConexionBD();
        if (cn != null) {
            String query = "DELETE FROM usuarios WHERE cedula_usuario=" + cedula;
            try {
                PreparedStatement consultaBD = cn.prepareStatement(query);
                consultaBD.execute();
                consultaBD.close();
                response = "Se eliminó el usuario\n";

            } catch (Exception e) {
                System.out.println("Error...." + e.getMessage());
            }

        } else {
            response = "Error de conexión";
        }
    }

}
