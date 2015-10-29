package com.epam.training.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.common.UsersService;

@Service
public final class AuthServiceImpl implements AuthService{

    private UsersService usersService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void registerUser(String username, String password) {
        usersService.addUser(new UserTransferObject(-1, username, bCryptPasswordEncoder.encode(password)));
    }

}
