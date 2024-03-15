package com.process.shop.service;

import com.process.shop.model.Address;
import com.process.shop.model.User;
import com.process.shop.model.enums.DocumentType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Long id) {

        return User.builder().email("").
                fullName("asa").
                document("123").
                identificationType(DocumentType.CC).
                address(List.of(Address.builder().avenue("avenida 2").
                                neighborhood("2").
                                postalCode("32").
                                street(" calle 4").
                                build()))
                .password("123456")
                .phoneNumber("31060067981")
                .birhtDate(new Date(2004,12,10))
                .email("anonimus@gmail.com")
                .build();
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
