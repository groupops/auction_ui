package com.epam.training.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.epam.training.auction.common.UserTransferObject;

@Service
public class AuthServiceImpl implements AuthService{

    UserService userService;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void registerUser(String username, String password) {
        userService.addUser(new UserTransferObject(-1, username, bCryptPasswordEncoder.encode(password)));
    }

}
