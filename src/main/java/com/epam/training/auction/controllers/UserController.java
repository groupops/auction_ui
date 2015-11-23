package com.epam.training.auction.controllers;

import com.epam.training.auction.service.UserService;
import com.epam.training.auction.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("userController")
public final class UserController {

    private final UserService usersService;

    @Autowired
    public UserController(UserService usersService) {
        this.usersService = usersService;
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

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String processRegistration(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword) {
        if (verifyPassword(password, confirmPassword)) {
            long id = usersService.save(new User(login, password));
            return "redirect:/user/" + id;
        }
        //// TODO: 11/20/2015 info about invalid data
        return "register";
    }

    private boolean verifyPassword(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginForm(Model model) {
        model.addAttribute(new User());
        return "login";
    }
}
