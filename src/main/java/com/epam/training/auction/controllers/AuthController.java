package com.epam.training.auction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.epam.training.auction.service.AuthService;

/**
 * Created by Dmytro_Ulanovych on 10/27/2015.
 */
@Controller
public class AuthController {
    
    @Autowired
    private AuthService authService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String auctions() {
        return "auctions";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String index() {
        return "home";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register(){
        return "register";
    }
        
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ModelAndView register(@RequestParam String username,
                                 @RequestParam String password) {
        ModelAndView model = new ModelAndView();
        model.addObject("msg", "Success! You can login now.");
        model.setViewName("login");
        authService.registerUser(username, password);
      
        return model;
    }
}