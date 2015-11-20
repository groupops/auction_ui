package com.epam.training.auction.service;

import com.epam.training.auction.AuctionWebApplication;
import com.epam.training.auction.common.UsersService;
import com.epam.training.auction.user.User;
import org.junit.Ignore;
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
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UsersService usersService;
    
    @Test @Ignore
    public void userAppearsInDatabaseAfterRegistration(){
        User user = createUser("Mateusz", "NotBreakablePassword");
        userService.save(user);
        assertNotNull(usersService.getUserByName("Mateusz"));
    }
    
    @Test @Ignore
    public void passwordHashedCorrectly(){
        User user = createUser("Mateusz", "NotBreakablePassword");
        userService.save(user);
        assertEquals(bCryptPasswordEncoder.encode("NotBreakablePassword"), usersService.getUserByName("Mateusz").getPassword());
    }

    private User createUser(String name, String password) {
        return new User(name, password);
    }
}
