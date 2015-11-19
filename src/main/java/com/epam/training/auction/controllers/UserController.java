package com.epam.training.auction.controllers;

import com.epam.training.auction.service.UserService;
import com.epam.training.auction.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller("userController")
public final class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String auctions() {
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String homePage() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistration(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }
        // TODO : User returns Id. After user profile view will be implemented the return statement should return something like "redirect:/user/{id}"
        userService.save(user);
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginForm(Model model) {
        model.addAttribute(new User());
        return "login";
    }
}
