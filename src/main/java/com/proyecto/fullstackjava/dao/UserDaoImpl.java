package com.proyecto.fullstackjava.dao;

import com.proyecto.fullstackjava.model.User;
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
}
