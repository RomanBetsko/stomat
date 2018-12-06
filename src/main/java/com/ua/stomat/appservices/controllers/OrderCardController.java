package com.ua.stomat.appservices.controllers;

import com.ua.stomat.appservices.service.OrderCardService;
import com.ua.stomat.appservices.validator.AddBookToCardCriteria;
import com.ua.stomat.appservices.validator.CustomersBookCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderCardController {

    @Autowired
    private OrderCardService orderCardService;

    @PostMapping("/addBookToCard")
    public ResponseEntity<?> addBookToCard (@RequestBody AddBookToCardCriteria request, Errors errors){
        return orderCardService.addBookToCard(request.getBookId(), request.getReaderId(), errors);
    }

    @PostMapping("/getOrderCard")
    public ModelAndView getOrderCardView (@RequestBody CustomersBookCriteria request){
        return orderCardService.getOrderCard(request.getCustomerId());
    }
}
