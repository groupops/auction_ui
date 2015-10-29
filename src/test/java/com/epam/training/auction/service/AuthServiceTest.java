package com.epam.training.auction.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        assertEquals(bCryptPasswordEncoder.encode("NotBreakablePassword"), userService.getUserByName("Mateusz").getPassword());
    }
}
