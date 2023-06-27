package com.proyecto.fullstackjava.controller;


import com.proyecto.fullstackjava.dao.IUser;
import com.proyecto.fullstackjava.model.User;
import com.proyecto.fullstackjava.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CtrlAuth {

    @Autowired
    private IUser iUser;


    @Autowired
    JWTUtil jwtUtil;

    @PostMapping(value="/login")
    public String validarLogin(@RequestBody User user){

        User userLogeado=iUser.verificarEmailPassword(user);
        if(userLogeado!=null){
            String tokenJWT=jwtUtil.create(String.valueOf(userLogeado.getId()),userLogeado.getCorreo());
            return tokenJWT;
        }
        else {
            return "Error en inicio de sesion";
        }

    }
}
