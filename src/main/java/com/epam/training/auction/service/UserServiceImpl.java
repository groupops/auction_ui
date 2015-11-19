package com.epam.training.auction.service;

import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.common.UsersService;
import com.epam.training.auction.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class UserServiceImpl implements UserService {
    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    private final BCryptPasswordEncoder passwordEncoder;
    private final UsersService usersService;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, UsersService usersService) {
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
    }


    @Override
    public Long save(User user) {
        UserTransferObject userTransferObject = new UserTransferObject(
                user.getUsername(),
                passwordEncoder.encode(user.getPassword()));
        long id = usersService.addUser(userTransferObject);
        LOG.debug("Created a user with id " + id);
        return id;
    }

}
