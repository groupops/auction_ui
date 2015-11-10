package com.epam.training.auction.service;

import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.common.UsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class RegistrationServiceImpl implements RegistrationService {
    private static final Logger LOG = Logger.getLogger(RegistrationServiceImpl.class);

    private final BCryptPasswordEncoder passwordEncoder;
    private final UsersService usersService;

    @Autowired
    public RegistrationServiceImpl(BCryptPasswordEncoder passwordEncoder, UsersService usersService) {
        this.passwordEncoder = passwordEncoder;
        this.usersService = usersService;
    }


    @Override
    public boolean registerUser(String username, String password) {
        UserTransferObject userTransferObject = new UserTransferObject(username, passwordEncoder.encode(password));
        long id = usersService.addUser(userTransferObject);
        LOG.debug("Created a user with id " + id);
        return id > 0;
    }

}
