package com.epam.training.auction.service;

import com.epam.training.auction.AuctionWebApplication;
import com.epam.training.auction.common.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuctionWebApplication.class)
@WebAppConfiguration
public class RegistrationServiceTest {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UsersService usersService;
    
    @Test
    public void userAppearsInDatabaseAfterRegistration(){
        registrationService.registerUser("Mateusz", "NotBreakablePassword");
        assertNotNull(usersService.getUserByName("Mateusz"));
    }
    
    @Test
    public void passwordHashedCorrectly(){
        registrationService.registerUser("Mateusz", "NotBreakablePassword");
        assertEquals(bCryptPasswordEncoder.encode("NotBreakablePassword"), usersService.getUserByName("Mateusz").getPassword());
    }
}
