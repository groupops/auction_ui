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

@Controller
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
    public String index() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String register() {
        return "register";
    }

/*    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public ModelAndView register(@RequestParam String username, @RequestParam String password) {
        ModelAndView model = new ModelAndView();

        model.addObject("msg", "Success! You can login now.");
        model.setViewName("login");
        userService.save();

        return model;
    }*/

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String processRegistration(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:/home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage(Model model) {
        model.addAttribute(new User());
        return "login";
    }

/*    @RequestMapping(value="/register", method=POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }*/
}

