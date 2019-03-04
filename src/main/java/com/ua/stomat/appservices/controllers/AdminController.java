package com.ua.stomat.appservices.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.ua.stomat.appservices.controllers.AdminController.ADMIN_PATH;

@Controller
public class AdminController {

    private static final String ADMIN_PATH = "/admin";

    @GetMapping(ADMIN_PATH)
    public String admin() {
        return "/admin";
    }

    @GetMapping(ADMIN_PATH + "/home")
    public String homeView() {
        return "/admin";
    }

    @GetMapping(ADMIN_PATH + "/customer")
    public String customerView() {
        return "/customer";
    }

    @GetMapping(ADMIN_PATH + "/appointment")
    public String appointmentView() {
        return "/createappointment";
    }

    @GetMapping(ADMIN_PATH + "/editpage")
    public String editPage(){
        return "editpage";
    }

}
