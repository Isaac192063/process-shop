package com.process.shop.service;

import com.process.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User updateUser(User user, Long id);
    List<User> findAllUsers();
}
