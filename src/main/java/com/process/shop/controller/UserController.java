package com.process.shop.controller;


import com.process.shop.model.User;
import com.process.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("user/{id}")
    public User getUserByIda(){
        return  userService.getUserById(1L);
    }
}