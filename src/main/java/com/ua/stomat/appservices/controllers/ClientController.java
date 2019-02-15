package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addNewClient")
    public ResponseEntity<?> addNewClient(@RequestBody @Valid AddClientCriteria request, Errors errors) {
        return clientService.addClient(request, errors);
    }

    @GetMapping("/client")
    public ModelAndView getClient(@RequestParam(name="id") Integer id) {
        return clientService.getClientPage(id);
    }

    @GetMapping("/clients")
    public ModelAndView getClientsView() {
        return clientService.getClientsData();
    }
}
