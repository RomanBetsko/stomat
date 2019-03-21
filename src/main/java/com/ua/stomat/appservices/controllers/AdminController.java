package com.ua.stomat.appservices.controllers;


import com.ua.stomat.appservices.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private MainService mainService;

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

    @GetMapping(ADMIN_PATH + "/editpage")
    public String editPage(){
        return "/editpage";
    }

    @GetMapping(ADMIN_PATH + "/informSize")
    public ResponseEntity<?> informSize() {
        return mainService.informSize();
    }

    @GetMapping(ADMIN_PATH + "/getClientsToInform")
    public ModelAndView getClientsToInform() {

        //todo getClientsToInform
        return null;
    }

}
