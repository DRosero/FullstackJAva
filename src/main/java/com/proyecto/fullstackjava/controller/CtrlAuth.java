package com.proyecto.fullstackjava.controller;


import com.proyecto.fullstackjava.dao.IUser;
import com.proyecto.fullstackjava.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CtrlAuth {

    @Autowired
    IUser iUser;

    @PostMapping(value="/login")
    public String validarLogin(@RequestBody User user){
        if(iUser.verificarEmailPassword(user)){
            return "Correcto";
        }
        else {
            return "Error";
        }

    }
}
