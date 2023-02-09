/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo_spring.dao;

import com.example.demo_spring.model.User;
import java.io.File;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nitro
 */
@Repository
public class UserDAOImpl implements UserDAO {
    
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public void addUser(User u) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        session.persist(u);
        
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User updateUser(Integer id, User u) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        User user = session.get(User.class, id);
        
        //Por cada una de las propiedades hacemos un if
        if(u.getName() != null){
            user.setName(u.getName());
        }
        
        session.getTransaction().commit();
        session.close();
        return user;
    }
    
    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        Query<User> querys = session.createQuery("from User");
        List<User> users = querys.getResultList();
        
        session.getTransaction().commit();
        session.close();
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        User u = session.get(User.class, id);
        
        session.getTransaction().commit();
        session.close();
        return u;
    }

    @Override
    public User removeUser(Integer id) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        
        User u = session.get(User.class, id);
        if(null != u){
            session.delete(u);
        }
        
        session.getTransaction().commit();
        session.close();
        return u;
    }
    
}
