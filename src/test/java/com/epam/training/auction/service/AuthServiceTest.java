package com.epam.training.auction.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.epam.training.auction.AuctionWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuctionWebApplication.class)
@WebAppConfiguration
public class AuthServiceTest {

    @Autowired
    private AuthService authService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    private UserService userService;
    
    @Test
    public void userAppearsInDatabaseAfterRegistration(){
        authService.registerUser("Mateusz", "NotBreakablePassword");
        assertNotNull(userService.getUserByName("Mateusz"));
    }
    
    @Test
    public void passwordHashedCorrectly(){
        authService.registerUser("Mateusz", "NotBreakablePassword");
        assertEquals(bCryptPasswordEncoder.encode("NotBreakablePassword"), userService.getUserByName("Mateusz").get().getPassword());
    }
}
