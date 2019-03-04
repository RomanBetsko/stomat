package com.ua.stomat.appservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UnloginZoneController {

    @GetMapping("/ua")
    public String ukrIndex() {
        return "/ukr";
    }

    @GetMapping("/ru")
    public String rusIndex() {
        return "/rus";
    }

    @GetMapping("/eng")
    public String engIndex() {
        return "/eng";
    }

    @GetMapping("/pl")
    public String plnIndex() {
        return "/pln";
    }

    @GetMapping("/login")
    public String loginView() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "security/403";
    }
}
