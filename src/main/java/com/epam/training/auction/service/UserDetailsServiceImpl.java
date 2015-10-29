package com.epam.training.auction.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.user.CustomUserDetails;
import com.epam.training.auction.user.User;

@Service("userDetailsService")
public final class UserDetailsServiceImpl implements UserDetailsService {

    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserTransferObject transferedUser = userService.getUserByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new CustomUserDetails(new User(transferedUser));
    }

}