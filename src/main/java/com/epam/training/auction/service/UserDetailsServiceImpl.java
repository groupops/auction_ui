package com.epam.training.auction.service;

import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.common.UsersService;
import com.epam.training.auction.user.CustomUserDetails;
import com.epam.training.auction.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public final class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails userDetails = null;
        try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml")) {
            UsersService usersService = context.getBean("userServiceProxy", UsersService.class);
            UserTransferObject user = usersService.getUserByName(username);
            userDetails = new CustomUserDetails(new User(user));
        }
        return userDetails;
    }

}