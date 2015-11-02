package com.epam.training.auction.service;

import org.apache.camel.CamelContext;
import org.apache.camel.util.IOHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.epam.training.auction.common.UserTransferObject;
import com.epam.training.auction.common.UsersService;

@Service
public final class AuthServiceImpl implements AuthService {

    private UsersService usersService;
    
//    @Autowired
//    private CamelContext camelContext;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void registerUser(String username, String password) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("camel-client-remoting.xml");
        UsersService usersService = context.getBean("usersServiceImpl", UsersService.class);

        System.out.println("Invoking the logging");
        UserTransferObject userTransferObject = new UserTransferObject("user", "pass");
        usersService.addUser(userTransferObject);
        System.out.println("User is logged");

        IOHelper.close(context);

        // usersService.addUser(new UserTransferObject(-1, username,
        // bCryptPasswordEncoder.encode(password)));
    }

}
