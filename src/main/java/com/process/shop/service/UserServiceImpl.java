package com.process.shop.service;

import com.process.shop.model.User;

import java.util.List;

public class UserServiceImpl extends UserService{
    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return new User();
    }

    @Override
    public User updateUser(User user, Long id) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
