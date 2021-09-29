package com.ecoshop.tiendavirtual;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.dao.ClienteDAO;
import com.tiendavirtual.dao.UsuarioDAO;
import com.tiendavirtual.dto.Cliente;
import com.tiendavirtual.dto.Usuario;

@RestController
public class Controlador {
    
    @RequestMapping("/crearUsuario")
    public String insertarUsuario(Usuario user) {
    	UsuarioDAO dao=new UsuarioDAO();
    	dao.insertarUsuario(user);
    	
        return "Microservicio de insercion de usuario";
    }	
    
    @RequestMapping("/actualizarUsuario")
    public String modificarUsuario(Usuario user) {
    	UsuarioDAO dao=new UsuarioDAO();
    	dao.modificarUsuario(user);
    	
        return "Microservicio para modificar de usuario";
    }
    
}