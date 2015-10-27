package com.epam.training.auction.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Dmytro_Ulanovych on 10/27/2015.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(ModelAndView modelAndView) {
        return "index";
    }
}