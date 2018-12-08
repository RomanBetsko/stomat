package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.ClientService;
import com.ua.stomat.appservices.validator.AddClientCriteria;
import com.ua.stomat.appservices.validator.CustomersBookCriteria;
import com.ua.stomat.appservices.validator.DeleteBookCriteria;
import com.ua.stomat.appservices.validator.GetBookCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/addNewClient")
    public ResponseEntity<?> addNewClient(@RequestBody @Valid AddClientCriteria request, Errors errors) {
        return clientService.addClient(request, errors);
    }

    @PostMapping("/deleteBook")
    public ResponseEntity<?> deleteBook (@RequestBody DeleteBookCriteria request, Errors errors){
        return clientService.deleteBook(request.getBookId(), request.getCustomerId(), errors);
    }

    @PostMapping("/getBook")
    public ModelAndView getBook (@RequestBody GetBookCriteria request){
        return clientService.getBookPage(request.getBookId());
    }

    @PostMapping("/customer/delete")
    public ModelAndView deleteView(@RequestBody CustomersBookCriteria request) {
        return clientService.getDeleteBookPage(request.getCustomerId());
    }
}
