package com.proyecto.fullstackjava.dao;

import com.proyecto.fullstackjava.model.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements IUser{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> listarTodosUsuarios() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void borrarUsuario(int id) {
        User user=entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    public void registrarUsuario(User user) {
        entityManager.persist(user);
    }

    @Override
    public void actualizarUsuario(User userActualizar, int id) {
        User user=entityManager.find(User.class,id);
        user=userActualizar;
        entityManager.merge(user);
    }

    @Override
    public User verificarEmailPassword(User user) {
        List<User> listaUsuario= entityManager.createQuery("from User WHERE correo=:correo").setParameter("correo",user.getCorreo()).getResultList();
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(listaUsuario.isEmpty()){
            return null;
        }
        String hashPasswordGuardada=listaUsuario.get(0).getPassword();


        if(argon2.verify(hashPasswordGuardada,user.getPassword())){
            return listaUsuario.get(0);
        }
        else{
            return null;
        }

    }

}
