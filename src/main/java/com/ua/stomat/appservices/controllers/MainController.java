package com.ua.stomat.appservices.controllers;


import com.ua.stomat.appservices.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/home")
    public String homeView() {
        return "/home";
    }

    @GetMapping("/customer")
    public String customerView() {
        return "/customer";
    }

    @GetMapping("/login")
    public String loginView() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "security/403";
    }

    @GetMapping("/index")
    public String string() {
        return "index";
    }
}
