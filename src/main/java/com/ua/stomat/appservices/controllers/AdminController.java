package com.ua.stomat.appservices.controllers;


import com.ua.stomat.appservices.service.MainService;
import com.ua.stomat.appservices.validator.DeleteClientCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return mainService.getClientsToInform();
        //todo getClientsToInform
    }

    @GetMapping(ADMIN_PATH + "/calendar")
    public String getCalendar() {
        return "/calendar";
    }

    @PostMapping(ADMIN_PATH + "/deleteClientFromInform")
    public ResponseEntity<?> deleteClientFromInform(@RequestBody @Valid DeleteClientCriteria request, Errors errors) {
        return mainService.deleteClientFromInform(request.getId(), errors);
    }

}
