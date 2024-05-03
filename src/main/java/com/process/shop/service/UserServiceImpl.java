package com.process.shop.service;

import com.process.shop.exceptions.AlreadyExistException;
import com.process.shop.exceptions.NotFoundException;
import com.process.shop.model.User;
import com.process.shop.model.enums.ErrorMessage;
import com.process.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        Optional<User> userFindByEmail = userRepository.findByEmail(user.getEmail());
        if(userFindByEmail.isPresent()){
            throw new AlreadyExistException(ErrorMessage.USER_EMAIL_EXIST.getMessage());
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {

        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        return user.get();
    }

    @Override
    public  User updateUser(User user, Long id) {
        Optional<User> userBD = userRepository.findById(id);
        if (userBD.isEmpty()){
            throw new NotFoundException(ErrorMessage.USER_NOT_FOUND.getMessage());
        }
        Optional<User> userEmail = userRepository.findByEmailAndIdNot(user.getEmail(), id);

        if(userEmail.isPresent()){
            throw new AlreadyExistException(ErrorMessage.USER_EMAIL_EXIST.getMessage());
        }

        userBD.get().setFullName(user.getFullName());
        userBD.get().setPhoneNumber(user.getPhoneNumber());
        userBD.get().setEmail(user.getEmail());
        return userRepository.save(userBD.get());
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }
}
