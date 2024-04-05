package com.process.shop.controller;


import com.process.shop.model.User;
import com.process.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping()
    public User createUser(@RequestBody User user){
       return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserByIda(@PathVariable Long id){
        System.out.println(id);
        return  userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.updateUser(user,id);
    }
    @GetMapping()
    public List<User> allUsers(){
        return userService.findAllUsers();
    }
}

