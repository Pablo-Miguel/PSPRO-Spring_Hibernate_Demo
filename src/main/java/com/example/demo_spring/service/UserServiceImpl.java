/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo_spring.service;

import com.example.demo_spring.dao.UserDAO;
import com.example.demo_spring.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nitro
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    @Transactional
    public void addUser(User u) {
        this.userDAO.addUser(u);
    }

    @Override
    @Transactional
    public User updateUser(Integer id, User u) {
        return this.userDAO.updateUser(id, u);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDAO.listUsers();
    }

    @Override
    @Transactional
    public User getUserById(Integer id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public User removeUser(Integer id) {
        return this.userDAO.removeUser(id);
    }
    
}
