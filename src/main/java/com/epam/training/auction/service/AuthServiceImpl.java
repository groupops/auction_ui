package com.epam.training.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.epam.training.auction.common.UserTransferObject;

@Service
public final class AuthServiceImpl implements AuthService{

    private UserService userService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void registerUser(String username, String password) {
        userService.addUser(new UserTransferObject(-1, username, bCryptPasswordEncoder.encode(password)));
    }

}
