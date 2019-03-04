package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import com.ua.stomat.appservices.validator.DeleteClientCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ClientController {

    private static final String ADMIN_PATH = "/admin";

    @Autowired
    private ClientService clientService;

    @PostMapping(ADMIN_PATH + "/addNewClient")
    public ResponseEntity<?> addNewClient(@RequestBody @Valid AddClientCriteria request, Errors errors) {
        return clientService.addClient(request, errors);
    }

    @GetMapping(ADMIN_PATH + "/client")
    public ModelAndView getClient(@RequestParam(name = "id") Integer id) {
        return clientService.getClientPage(id);
    }

    @GetMapping(ADMIN_PATH + "/clients")
    public ModelAndView getClientsView() {
        return clientService.getClientsData();
    }

    @PostMapping(ADMIN_PATH + "/delete/client")
    public ResponseEntity<?> deleteClient(@RequestBody @Valid DeleteClientCriteria request, Errors errors) {
        return clientService.deleteClient(request.getId(), errors);
    }
}
