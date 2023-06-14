package com.proyecto.fullstackjava.controller;

import com.proyecto.fullstackjava.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping(value = "/users")
    public List<User> listarTodosUsuarios() {
        List<User> listaUsuarios = new ArrayList<>();
        User user1=new User();
        user1.setId(1);
        user1.setNombre("Diego");
        user1.setApellido("Rosero");
        user1.setCorreo("diego.rosero01@yahoo.com");
        user1.setPassword("12345");
        user1.setCelular(Long.parseLong("0995869853"));

        User user2=new User();
        user2.setId(2);
        user2.setNombre("Javier");
        user2.setApellido("Negrete");
        user2.setCorreo("diego.rosero1@outlook.com");
        user2.setPassword("65789");
        user2.setCelular(Long.parseLong("0995869853"));

        listaUsuarios.add(user1);
        listaUsuarios.add(user2);
        return listaUsuarios;
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
