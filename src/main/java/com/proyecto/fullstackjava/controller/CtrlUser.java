package com.proyecto.fullstackjava.controller;

import com.proyecto.fullstackjava.dao.IUser;
import com.proyecto.fullstackjava.model.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hashPassword=argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hashPassword);
        iUser.registrarUsuario(user);
    }


    @PutMapping(value ="users/{id}" )
    public void actualizarUsuario(@RequestBody User user, int id){
        iUser.actualizarUsuario(user,id);
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
