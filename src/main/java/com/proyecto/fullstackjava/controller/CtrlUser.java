package com.proyecto.fullstackjava.controller;

import com.proyecto.fullstackjava.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CtrlUser {

    @RequestMapping(value = "/user/{id}")
    public User listarUsuario(@PathVariable int id){
        User user=new User();
        user.setId(id);
        user.setNombre("Diego");
        user.setApellido("Rosero");
        user.setCorreo("diego.rosero01@yahoo.com");
        user.setPassword("12345");
        user.setCelular(Long.parseLong("0995869853"));
        return user;
    }
    public User borrarUsuario(){
        User user=new User();
        user.setNombre("Diego");
        user.setApellido("Rosero");
        user.setCorreo("diego.rosero01@yahoo.com");
        user.setPassword("12345");
        user.setCelular(Long.parseLong("0995869853"));
        return user;
    }

    public User actualizarUsuario(){
        User user=new User();
        user.setNombre("Diego");
        user.setApellido("Rosero");
        user.setCorreo("diego.rosero01@yahoo.com");
        user.setPassword("12345");
        user.setCelular(Long.parseLong("0995869853"));
        return user;
    }

    public User buscarUsuario(){
        User user=new User();
        user.setNombre("Diego");
        user.setApellido("Rosero");
        user.setCorreo("diego.rosero01@yahoo.com");
        user.setPassword("12345");
        user.setCelular(Long.parseLong("0995869853"));
        return user;
    }
}
