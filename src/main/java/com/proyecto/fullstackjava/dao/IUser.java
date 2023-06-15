package com.proyecto.fullstackjava.dao;

import com.proyecto.fullstackjava.model.User;

import java.util.List;

public interface IUser{

    List<User> listarTodosUsuarios();

    void borrarUsuario(int id);

    void registrarUsuario(User user);
}
