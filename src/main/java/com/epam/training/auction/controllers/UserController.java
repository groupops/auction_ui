package com.epam.training.auction.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Dmytro_Ulanovych on 10/27/2015.
 */
@Controller
public class UserController {
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "auctions";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register(){
        return "register";
    }
}