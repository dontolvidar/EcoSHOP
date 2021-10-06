package com.ecoshop.tiendavirtual;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.dao.ClienteDAO;
import com.tiendavirtual.dao.ProveedorDAO;
import com.tiendavirtual.dao.UsuarioDAO;
import com.tiendavirtual.dto.Cliente;
import com.tiendavirtual.dto.Proveedor;
import com.tiendavirtual.dto.Usuario;

@RestController
public class Controlador {
    //usuario
	
    @RequestMapping("/crearUsuario")
    public String insertarUsuario(Usuario user) {
    	UsuarioDAO dao=new UsuarioDAO();
    	dao.insertarUsuario(user);
    	
        return "Microservicio de insercion de usuario";//esto al final es un response
    }	
    
    @RequestMapping("/actualizarUsuario")
    public String modificarUsuario(Usuario user) {
    	UsuarioDAO dao=new UsuarioDAO();
    	dao.modificarUsuario(user);
    	
        return "Microservicio para modificar de usuario";//esto al final es un response
    }
    
    @RequestMapping("/buscarUsuario")
    public ArrayList<Usuario> buscarUsuario(long cedula) {
    	
    	UsuarioDAO dao=new UsuarioDAO();
    	ArrayList<Usuario> usuarios=dao.buscarUsuario(cedula);
        return usuarios;//esto al final es un response
    }
    
    @RequestMapping("/eliminarUsuario")
    public String borrarUsuario(long cedula) {
    	UsuarioDAO dao=new UsuarioDAO();
    	dao.eliminarUsuario(cedula);
    	return "Microservicio para borrar el usuario";//esto al final es un response
    }
    
    
    
    //cliente
    @RequestMapping("/crearCliente")
    public String insertarCliente(Cliente client) {
    	ClienteDAO dao=new ClienteDAO();
    	dao.insertarCliente(client);
    	
        return "Microservicio de insercion de cliente";//esto al final es un response
    }
    
    
    
    
    //proveedor
    @RequestMapping("/registrarProveedor")
	public String registrarProveedor(Proveedor p) {		
		ProveedorDAO dao = new ProveedorDAO();
		dao.insertProveedor(p);
		return "Proveedor Registrado";		
	}
	
	@RequestMapping("/consultarProveedores")
	public ArrayList<Proveedor> consultarProveedores(String nit) {		
		ProveedorDAO dao = new ProveedorDAO();
		return dao.consultarProveedores(nit);		
	}
}