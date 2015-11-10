package com.epam.training.auction.controllers;

import com.epam.training.auction.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public final class AuthController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String auctions() {
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String index() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ModelAndView register(@RequestParam String username, @RequestParam String password) {
        ModelAndView model = new ModelAndView();

        model.addObject("msg", "Success! You can login now.");
        model.setViewName("login");
        registrationService.registerUser(username, password);

        return model;
    }
}