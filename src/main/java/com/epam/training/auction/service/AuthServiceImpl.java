package com.epam.training.auction.service;

import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.common.UsersService;
import org.apache.camel.util.IOHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class AuthServiceImpl implements AuthService {
    private static final Logger LOG = Logger.getLogger(AuthServiceImpl.class);
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void registerUser(String username, String password) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("camel-client-remoting.xml");
        UsersService usersService = context.getBean("usersServiceImpl", UsersService.class);

        LOG.debug("Invoking the logging");
        UserTransferObject userTransferObject = new UserTransferObject(username, bCryptPasswordEncoder.encode(password));
        usersService.addUser(userTransferObject);
        LOG.debug("User is logged");

        IOHelper.close(context);
    }

}
