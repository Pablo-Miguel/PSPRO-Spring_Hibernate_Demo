/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo_spring.controllers;

import com.example.demo_spring.model.User;
import com.example.demo_spring.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nitro
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/User")
public class UserController {
    
    @Autowired
    UserService service;
    
    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User u){
        try {
            service.addUser(u);
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User u){
        try {
            return ResponseEntity.ok().body(service.updateUser(id, u));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/listUsers")
    public ResponseEntity<List<User>> listUsers(){
        try {
            List<User> list = service.listUsers();
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok().body(service.getUserById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok().body(service.removeUser(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
