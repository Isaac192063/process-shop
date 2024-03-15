package com.process.shop.service;

import com.process.shop.model.User;

import java.util.List;


public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User updateUser(User user, Long id);
    List<User> findAllUsers();
}
