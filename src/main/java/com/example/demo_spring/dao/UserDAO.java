/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo_spring.dao;

import com.example.demo_spring.model.User;
import java.util.List;

/**
 *
 * @author Nitro
 */
public interface UserDAO {
    public void addUser(User u);
    public User updateUser(Integer id, User u);
    public List<User> listUsers();
    public User getUserById(Integer id);
    public User removeUser(Integer id);
}
