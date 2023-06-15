package com.proyecto.fullstackjava.controller;

import com.proyecto.fullstackjava.dao.IUser;
import com.proyecto.fullstackjava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CtrlUser {

    @Autowired
    private IUser iUser;



    @RequestMapping(value = "/users/{id}")
    public User listarUsuario(@PathVariable int id){
        User user=new User();
        user.setId(id);
        user.setNombre("Diego");
        user.setApellido("Rosero");
        user.setCorreo("diego.rosero01@yahoo.com");
        user.setPassword("12345");
        user.setCelular("0995869853");
        return user;
    }

    @RequestMapping(value = "/users")
    public List<User> listarTodosUsuarios() {
        return iUser.listarTodosUsuarios();
    }

    @DeleteMapping(value="/users/{id}")
    public void borrarUsuario(@PathVariable int id){
        iUser.borrarUsuario(id);
    }

    @PostMapping(value="/users")
    public void registrarUsuario(@RequestBody User user){
        iUser.registrarUsuario(user);
    }


    public User actualizarUsuario(){
        User user=new User();
        user.setNombre("Diego");
        user.setApellido("Rosero");
        user.setCorreo("diego.rosero01@yahoo.com");
        user.setPassword("12345");
        user.setCelular("0995869853");
        return user;
    }

    public User buscarUsuario(){
        User user=new User();
        user.setNombre("Diego");
        user.setApellido("Rosero");
        user.setCorreo("diego.rosero01@yahoo.com");
        user.setPassword("12345");
        user.setCelular("0995869853");
        return user;
    }
}
